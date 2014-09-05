package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import domain.HomeMaterias;
import domain.Materia;

public class NuevaMateriaView extends Dialog<Materia> {

  public NuevaMateriaView(WindowOwner owner) {
    super(owner, new Materia());
  }

  @Override
  protected void createFormPanel(Panel mainPanel) {
	  setTitle("Nueva Materia");
	  mainPanel.setLayout(new VerticalLayout());
	  
	  Panel formulario = new Panel(mainPanel).setLayout(new ColumnLayout(2));
	  	  new Label(formulario).setText("Nombre:");
	  new TextBox(mainPanel).setWidth(130).bindValueToProperty("nombre");	
	  new Button(mainPanel).setCaption("Aceptar").onClick(()->accept()).setAsDefault();
  }
  
  @Override
  protected void executeTask(){
	  HomeMaterias.getInstancia().agregarMateria(getModelObject());
	  super.executeTask();
  }


}

