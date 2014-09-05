package domain;

import org.uqbar.commons.utils.Observable;

@Observable
public class Evaluacion {
	
	private String fecha;
	
	private String descripcion;
	
	private Boolean aprobado=false;

	public String getFecha() {
		return fecha;
	}
	

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getAprobado() {
		return aprobado;
	}

	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}
	
	public void copiarAtributosDe(Evaluacion evaluacion){
		setAprobado(evaluacion.getAprobado());
		setDescripcion(evaluacion.getDescripcion());
		setFecha(evaluacion.getFecha());
	}
	
	

}
