package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import domain.Evaluacion;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
public class EditarNotaView extends Dialog<Evaluacion> {

  public EditarNotaView(WindowOwner owner,Evaluacion evaluacion) {
    super(owner, evaluacion);
  }

  @Override
  public void createFormPanel(Panel mainPanel) {
	 setTitle("Editar Nota");
	 mainPanel.setLayout(new VerticalLayout());
	 Panel formulario = new Panel(mainPanel).setLayout(new ColumnLayout(2));
	 	new Label(formulario).setText("Fecha:"); 
	 	TextBox fecha = new TextBox(formulario);
	 	fecha.setWidth(80);
	 	fecha.bindValueToProperty("fecha"); 
	 	new Label(formulario).setText("Descripción:"); 
	 	TextBox campoDescripcion = new TextBox(formulario);
	 	campoDescripcion.setWidth(100);
	 	campoDescripcion.bindValueToProperty("descripcion");
	 	new Label(formulario).setText("Aprobado");
	 	new CheckBox(formulario).bindValueToProperty("aprobado");
  }  

	public Evaluacion getEvaluacion(){
		return getModelObject();
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(()->accept())
			.setAsDefault()
			.disableOnError();
	}
}
