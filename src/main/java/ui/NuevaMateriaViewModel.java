package ui;

import org.uqbar.commons.utils.Observable;

import domain.Materia;

@Observable
public class NuevaMateriaViewModel {

  private Materia materia;
  
  private String nombre;

  public Materia getMateria() {
	return materia;
}

public void setMateria(Materia materia) {
	this.materia = materia;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public NuevaMateriaViewModel(Materia unaMateria) {
    this.materia = unaMateria;
  }

public void aceptar(){
	materia.setNombre(nombre);
}

}
