package ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;

import sun.security.provider.VerificationProvider;
import domain.Materia;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
public class NuevaMateriaView extends MainWindow<NuevaMateriaViewModel> {

  public NuevaMateriaView() {
    super(new NuevaMateriaViewModel(new Materia()));
  }

  @Override
  public void createContents(Panel mainPanel) {
	  setTitle("Nueva Materia");
	  mainPanel.setLayout(new VerticalLayout());
	  
 new Label(mainPanel).setText("Nombre:");
 new TextBox(mainPanel).bindValueToProperty("nombre");
 
 new Button(mainPanel).setCaption("Aceptar").onClick(()->getModelObject().aceptar());
  }
  
  

  public static void main(String[] args) {
    new NuevaMateriaView().startApplication();
  }
}

