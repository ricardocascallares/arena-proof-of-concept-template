package ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

import domain.Evaluacion;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
public class EditarNotaView extends MainWindow<EditarNotaViewModel> {

  public EditarNotaView() {
    super(new EditarNotaViewModel(new Evaluacion()));
  }

  @Override
  public void createContents(Panel mainPanel) {
	  setTitle("Editar Nota");
	  mainPanel.setLayout(new VerticalLayout());
	  
	 new Label(mainPanel).setText("Fecha");
	 
	 new TextBox(mainPanel).bindValueToProperty("fecha");
	 
	 new Label(mainPanel).setText("Descripcion");
	 
	 new TextBox(mainPanel).bindValueToProperty("descripcion");
	 
	 new Label(mainPanel).setText("Aprobado");
	 
	 new CheckBox(mainPanel).bindValueToProperty("aprobado");
	 
	 new Button(mainPanel).setCaption("Aceptar").onClick(()-> getModelObject().aceptar());
  }
  
  

  public static void main(String[] args) {
    new UnaView().startApplication();
  }
}

