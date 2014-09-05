package ui;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import java.util.Arrays;

import domain.Evaluacion;
import domain.HomeMaterias;
import domain.Materia;

@Observable
public class SeguidorCarreraViewModel {

	private Materia materiaSeleccionada;
	private Evaluacion evaluacionSeleccionada;
	
	public Evaluacion getEvaluacionSeleccionada() {
		return evaluacionSeleccionada;
	}

	public void setEvaluacionSeleccionada(Evaluacion evaluacionSeleccionada) {
		this.evaluacionSeleccionada = evaluacionSeleccionada;
	}

	public Materia getMateriaSeleccionada() {
		return materiaSeleccionada;
	}

	public void setMateriaSeleccionada(Materia materiaSeleccionada) {
		this.materiaSeleccionada = materiaSeleccionada;
	}

	public List<String> getTiposCursada(){
		return Arrays.asList("Cuatrimestral","Anual");
	}
	
	public SeguidorCarreraViewModel() {
	}

	public List<Materia> getMaterias() {
		return HomeMaterias.getInstancia().getMaterias();
	}

	public void agregarEvaluacion(Evaluacion nuevaEvaluacion) {
		getMateriaSeleccionada().agregarEvaluacion(nuevaEvaluacion);
		actualizarEvaluaciones();
	}
	
	public void removerEvaluacion(Evaluacion evaluacion) {
		getMateriaSeleccionada().removerEvaluacion(evaluacion);
		actualizarEvaluaciones();
	}
	
	public void actualizarEvaluaciones(){
		ObservableUtils.firePropertyChanged(getMateriaSeleccionada(), "evaluaciones" , getMateriaSeleccionada().getEvaluaciones());		
	}
	
	public void removerEvaluacionSeleccionada() {
		removerEvaluacion(getEvaluacionSeleccionada());
	}
	
	public Evaluacion getClonedEvaluacionSeleccionada(){
		Evaluacion clon = new Evaluacion();
		clon.copiarAtributosDe(getEvaluacionSeleccionada());
		return clon;
	}
	
	public void sobrescribirEvaluacionSeleccionada(Evaluacion reemplazante){
		getEvaluacionSeleccionada().copiarAtributosDe(reemplazante);	
		actualizarEvaluaciones();
	}
	

}
