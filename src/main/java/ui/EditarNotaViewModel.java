package ui;

import java.time.LocalDateTime;

import org.uqbar.commons.utils.Observable;

import domain.Evaluacion;

@Observable
public class EditarNotaViewModel{
	
private String fecha;
	
	private String descripcion;
	
	private Boolean aprobado;
	
	private Evaluacion evaluacion;

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

   public EditarNotaViewModel(Evaluacion unaEvaluacion) {
    this.setEvaluacion(unaEvaluacion);
  }

 public Evaluacion getEvaluacion() {
	return evaluacion;
 }

  public void setEvaluacion(Evaluacion evaluacion) {
	this.evaluacion = evaluacion;
  }

 public void aceptar(){
	 evaluacion.setFecha(fecha);
	 evaluacion.setDescripcion(descripcion);
	 evaluacion.setAprobado(aprobado);
}

}
