package domain;

import java.util.Collection;

public class Materia {
	
	private Collection<Evaluacion> evaluaciones;
	
	private String nombre;
	private String profesor;
	private String año;
	private String finalAprobado;
	

	public Collection<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(Collection<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getFinalAprobado() {
		return finalAprobado;
	}

	public void setFinalAprobado(String finalAprobado) {
		this.finalAprobado = finalAprobado;
	}
	
	
}
