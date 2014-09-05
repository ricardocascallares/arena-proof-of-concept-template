package domain;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Materia {
	
	private List<Evaluacion> evaluaciones=new ArrayList<Evaluacion>();
	private String nombre;
	private String profesor;
	private String anio;
	private String finalAprobado;
	private String cursada;
	

	public String getCursada() {
		return cursada;
	}

	public void setCursada(String cursada) {
		this.cursada = cursada;
	}

	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
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

	public String getAnio() {
		return anio;
	}

	public void setAnio(String año) {
		this.anio = año;
	}

	public String getFinalAprobado() {
		return finalAprobado;
	}

	public void setFinalAprobado(String finalAprobado) {
		this.finalAprobado = finalAprobado;
	}

	public void agregarEvaluacion(Evaluacion nuevaEvaluacion) {
		getEvaluaciones().add(nuevaEvaluacion);		
	}
	
	public void removerEvaluacion(Evaluacion nuevaEvaluacion) {
		getEvaluaciones().remove(nuevaEvaluacion);		
	}
	
}
