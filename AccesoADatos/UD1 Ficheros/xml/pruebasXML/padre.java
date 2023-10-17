package pruebasXML;

import java.util.ArrayList;

public class padre {

	private String curso;
	private ArrayList<hijo> hijos;
	
	public padre(String curso, ArrayList<hijo> hijos) {
		this.curso = curso;
		this.hijos = hijos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public ArrayList<hijo> getHijos() {
		return hijos;
	}

	public void setHijos(ArrayList<hijo> hijos) {
		this.hijos = hijos;
	}

	@Override
	public String toString() {
		return "Padre [curso=" + curso + ", hijos=" + hijos + "]";
	}
	
}
