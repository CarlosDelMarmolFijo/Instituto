package pruebasXML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class utilidades {
	
	public static padre leerXML(Path fichero) {
		
		padre padre = null;
		
		try {
			// generamos Stream de entrada para el fichero
			InputStream is = Files.newInputStream(fichero);
			
			// creamos el documento en memoria
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			// parseamos el stream de entrada al documento
			Document doc = dBuilder.parse(is);
			
				// comenzamos la extraccion de la informacion
			
			// nodo simple
			NodeList nodoSimple = doc.getElementsByTagName("curso");
			
			String elementosSimple = nodoSimple.item(0).getTextContent();
			
			// nodos hijos
			NodeList nodosHijos = doc.getElementsByTagName("asignatura");
			ArrayList<hijo> hijos = new ArrayList<>();
			
			for (int i = 0; i < nodosHijos.getLength(); i++) {
				Node nodo = nodosHijos.item(i);
				Element e = (Element)nodo;
				// lectura de un atributo
				int id = Integer.valueOf(e.getAttribute("id"));
				// lectura de caracteristicas o propiedades
				String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
				// creamos un objeto por cada hijo
				hijo h = new hijo(nombre, id);
				// añadimos el objeto al array list
				hijos.add(h);
			}
			
			// creamos el objeto que vamos a devolver con la estructura del xml
			padre = new padre(elementosSimple, hijos);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return padre;
	}
	
	public static void crearXML(padre p, String ruta) {
		
		// creamos el documento en memoria
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			// creamos el nodo raiz y lo asociamos al documento
			Element raiz = doc.createElement("raiz");
			doc.appendChild(raiz);
			
			// creamos los nodos primarios y los asociamos al nodo raiz
			Element curso = doc.createElement("curso");
			curso.appendChild(doc.createTextNode(p.getCurso()));
			raiz.appendChild(curso);
			
			Element eHijos = doc.createElement("asignaturas");
			raiz.appendChild(eHijos);
			
			// si hay nodos con hijos, creamos los nodos hijos y los asociamos al nodo padre
			
			ArrayList<hijo> hijos = p.getHijos();
			
			// este bucle for lo que hace crear dentro del nodo "asignaturas" la estructura que contiene 
			for (int i = 0; i < hijos.size(); i++) {
				// elementos de asignaturas que seria en mi caso asignatura
				Element eHijo = doc.createElement("asignatura");
				eHijos.appendChild(eHijo);
				// establecemos el atributo
				Attr attr = doc.createAttribute("id");
				int idh = i + 1;
				attr.setValue(String.valueOf(idh));
				eHijo.setAttributeNode(attr);
				
				// elemento nombre
				Element eNombre = doc.createElement("nombre");
				eNombre.appendChild(doc.createTextNode(hijos.get(i).getNombre()));
				eHijo.appendChild(eNombre);
			}
			
				// realizacion de transformación del documento y envio al fichero xml final
			
			// escribir el contenido al fichero XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(ruta));
			
			transformer.transform(source, result);
			
			System.out.println("Archivo guardado");
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}

}
