package domain;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import domain.Materia;

@Observable
public class HomeMaterias {
	
	static private HomeMaterias instancia = new HomeMaterias();
	private List<Materia> materias = new ArrayList<>();
	
	public void agregarMateria(Materia materia){
		getMaterias().add(materia);
	}
	
	public void removerMateria(Materia materia){
		getMaterias().remove(materia);
	}

	public static HomeMaterias getInstancia() {
		return instancia;
	}

	public List<Materia> getMaterias() {

		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	

}
