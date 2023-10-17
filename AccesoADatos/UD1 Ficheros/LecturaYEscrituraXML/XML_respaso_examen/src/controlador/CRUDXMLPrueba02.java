package controlador;

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

import modelo.Alumno;
import modelo.Asignatura;
import modelo.Clases;
import modelo.Modulo;
import modelo.Profesores;
import modelo.xmlDAM;

public class CRUDXMLPrueba02 {

private Path path;
	
	public CRUDXMLPrueba02(Path path) {
		this.path = path;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
	
	// metodo para leer el xml
	public xmlDAM leer() {
		xmlDAM dam = null;
		
		try {
			InputStream contenidoXML = Files.newInputStream(this.path);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(contenidoXML);
			
			String introduccion = doc.getElementsByTagName("introduccion").item(0).getTextContent();
			
			// lista del nodo alumno
			ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
			NodeList nodoAlumnos = doc.getElementsByTagName("alumno");
			
			for (int i = 0; i < nodoAlumnos.getLength(); i++) {
				Node nodo = nodoAlumnos.item(i);
				Element e = (Element)nodo;
				String id = e.getAttribute("id");
				String nombreAlumno = e.getElementsByTagName("nombre").item(0).getTextContent();
				String cursoAlumno = e.getElementsByTagName("curso").item(0).getTextContent();
				
				// lista del nodo modulos
				ArrayList<Modulo> modulos = new ArrayList<Modulo>();
				NodeList nodoModulos = doc.getElementsByTagName("modulo");
				
				for (int j = 0; j < nodoModulos.getLength(); j++) {
					Node nodo1 = nodoModulos.item(j);
					Element e1 = (Element)nodo1;
					String idm = e.getAttribute("id");
					String nombreModulo = e1.getElementsByTagName("nombre").item(0).getTextContent();
					String notaModulo = e1.getElementsByTagName("nota").item(0).getTextContent();
					
					// añadir los datos segun el contructor de la clase
					Modulo m = new Modulo(idm, nombreModulo, notaModulo);
					modulos.add(m); // añadimos los datos en el arrayList
				}
				
				// hacemos lo mismo para la clase alumno
				Alumno a1 = new Alumno(id, nombreAlumno, cursoAlumno, modulos);
				alumnos.add(a1);
			}
			
			// lista del nodo profesores
			ArrayList<Profesores> profesores = new ArrayList<Profesores>();
			NodeList nodoProfesores = doc.getElementsByTagName("profesores");
			
			for (int h = 0; h < nodoProfesores.getLength(); h++) {
				Node nodo = nodoProfesores.item(h);
				Element e = (Element)nodo;
				String id = e.getAttribute("id");
				String nombreProfesor = e.getElementsByTagName("nombre").item(0).getTextContent();
				
				// lista del nodo clase
				ArrayList<Clases> clase = new ArrayList<Clases>();
				NodeList nodoClase = doc.getElementsByTagName("clase");
				
				for (int p = 0; p < nodoClase.getLength(); p++) {
					Node nodo1 = nodoClase.item(p);
					Element e1 = (Element)nodo1;
					String idc = e1.getAttribute("id");
					String nombreClase = e1.getElementsByTagName("nombre").item(0).getTextContent();
					String numeroPlanta = e1.getElementsByTagName("planta").item(0).getTextContent();
					
					// añadimos los datos al contructor de la clase
					Clases c = new Clases(Integer.parseInt(idc), nombreClase, numeroPlanta);
					clase.add(c);
				}
				
				// lista del nodo asignatura
				ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
				NodeList nodoAsignaturas = doc.getElementsByTagName("asignatura");
				
				for (int m = 0; m < nodoAsignaturas.getLength(); m++) {
					Node nodo1 = nodoAsignaturas.item(m);
					Element e1 = (Element)nodo1;
					String ida = e1.getAttribute("id");
					String nombreAsignatura = e1.getElementsByTagName("nombre").item(0).getTextContent();
				
					// añadir los datos segun el contructor de la clase
					Asignatura a = new Asignatura(Integer.parseInt(ida), nombreAsignatura);
					asignaturas.add(a);
				}
				
				// hacemos lo mismo para la clase profesores
				Profesores p = new Profesores(Integer.parseInt(id), nombreProfesor, clase, asignaturas);
				profesores.add(p);
			}
			
			// añadimos a la varible dam todos los nodos principales usando el contructor de la clase correspondiente
			dam = new xmlDAM(introduccion, alumnos, profesores);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return dam;
	}
	
	// metodo para crear el xml
	public void crear(xmlDAM p) {
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			// creamos el elemento raiz
			Document doc = docBuilder.newDocument();
			Element raizElement = doc.createElement("DAM");
			doc.appendChild(raizElement);
			
			// creamos los elementos simples
			Element introduccion = doc.createElement("introduccion");
			introduccion.appendChild(doc.createTextNode(p.getintroduccion()));
			raizElement.appendChild(introduccion);
			
			// creamos los dos crupos del xml (alumnos, profesores)
			Element eHijo1 = doc.createElement("alumnos");
			raizElement.appendChild(eHijo1);
			Element eHijo2 = doc.createElement("profesores");
			raizElement.appendChild(eHijo2);
			
			// creacion de los datos del primer grupo (alumno)
			ArrayList<Alumno> alumnos = p.getAlumnos();
			for (int i = 0; i < alumnos.size(); i++) {
				// creamos los elementos de alumno
				Element e1 = doc.createElement("alumno");
				eHijo1.appendChild(e1);
	
				// establecemos el atributo
				Attr attr = doc.createAttribute("id");
				int ida = i + 1;
				attr.setValue(String.valueOf(ida));
				e1.setAttributeNode(attr);
				
				// añadimos los elementos
				Element nombre = doc.createElement("nombre");
				nombre.appendChild(doc.createTextNode(alumnos.get(i).getNombre()));
				e1.appendChild(nombre);
				Element curso = doc.createElement("curso");
				curso.appendChild(doc.createTextNode(alumnos.get(i).getCurso()));
				e1.appendChild(curso);
				
				// creamos el elemento modulos
				Element em1 = doc.createElement("modulos");
				e1.appendChild(em1);

				ArrayList<Modulo> modulos = alumnos.get(i).getModulos();
				for (int j = 0; j < modulos.size(); j++) {
					
					// creamos el elemento modulo
					Element elm = doc.createElement("modulo");
					em1.appendChild(elm);
					// establecemos el atributo
					Attr attrm = doc.createAttribute("id");
					int idm = j + 1;
					attrm.setValue(String.valueOf(idm));
					elm.setAttributeNode(attrm);
					
					// añadimos los elementos
					Element nombreModulo = doc.createElement("nombre");
					nombreModulo.appendChild(doc.createTextNode(modulos.get(j).getNombre()));
					elm.appendChild(nombreModulo);
					Element notaModulo = doc.createElement("nota");
					notaModulo.appendChild(doc.createTextNode(modulos.get(j).getNota()));
					elm.appendChild(notaModulo);
				}
			}
			
			// creamos los datos de profesores
			ArrayList<Profesores> profesores = p.getProfesores();
			for (int i = 0; i < profesores.size(); i++) {
				// creamos el elemento profesores
				Element ep1 = doc.createElement("profesores");
				eHijo2.appendChild(ep1);
				
				// establecemos el atributo
				Attr attrp = doc.createAttribute("id");
				int idp = i + 1;
				attrp.setValue(String.valueOf(idp));
				ep1.setAttributeNode(attrp);
				
				// añadimos los elementos
				Element nombreProfesor = doc.createElement("nombre");
				nombreProfesor.appendChild(doc.createTextNode(profesores.get(i).getNombre()));
				ep1.appendChild(nombreProfesor);
				
				// creamos el elemento clases
				Element elc = doc.createElement("clases");
				ep1.appendChild(elc);

				ArrayList<Clases> clases = profesores.get(i).getClases();
				for (int s = 0; s < clases.size(); s++) {
					Element els = doc.createElement("clase");
					elc.appendChild(els);
					
					// establecemos el atributo
					Attr attra = doc.createAttribute("id");
					int ida = s + 1;
					attra.setValue(String.valueOf(ida));
					els.setAttributeNode(attra);
					
					// añadimos los elementos
					Element nombreClase = doc.createElement("nombre");
					nombreClase.appendChild(doc.createTextNode(clases.get(s).getNombre()));
					els.appendChild(nombreClase);
					
					Element plantaClase = doc.createElement("planta");
					plantaClase.appendChild(doc.createTextNode(clases.get(s).getPlanta()));
					els.appendChild(plantaClase);
				}
				
				// creamos el elemento asignturas
				Element el1 = doc.createElement("asignaturas");
				ep1.appendChild(el1);

				ArrayList<Asignatura> asignatura = profesores.get(i).getAsignaturas();
				for (int j = 0; j < asignatura.size(); j++) {
					// creamos el elemento asignatura
					Element ela = doc.createElement("asignatura");
					el1.appendChild(ela);
					
					// establecemsos el atributo
					Attr attra = doc.createAttribute("id");
					int ida = j + 1;
					attra.setValue(String.valueOf(ida));
					ela.setAttributeNode(attra);
					
					// añadimos los elementos
					Element nombreAsignatura = doc.createElement("nombre");
					nombreAsignatura.appendChild(doc.createTextNode(asignatura.get(j).getNombre()));
					ela.appendChild(nombreAsignatura);
				}
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(this.path.getFileName().toString()));
			
			transformer.transform(source, result);
			
			System.out.println("Archivo guardado");
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
