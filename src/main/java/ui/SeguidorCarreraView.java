package ui;


import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.lacar.ui.model.Action;

import domain.Evaluacion;
import domain.FinalAprobadoTransformer;
import domain.Materia;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
public class SeguidorCarreraView extends MainWindow<SeguidorCarreraViewModel> {

  public SeguidorCarreraView() {
    super(new SeguidorCarreraViewModel());
  }

  @Override
  public void createContents(Panel mainPanel) {
	  setTitle("Seguidor de Carrera");
	  mainPanel.setLayout(new VerticalLayout());
	  
	  Panel panelTitulo = new Panel(mainPanel).setLayout(new ColumnLayout(2));
	  	Label titulo = new Label(panelTitulo);
	  	titulo.setText("Seguidor de carrera");
	  	titulo.setFontSize(16);
	  
	  Panel seguidorCarrera = new Panel(mainPanel).setLayout(new HorizontalLayout());
	  	 createSubjectsList(seguidorCarrera);	 
		 Panel materia = new Panel(seguidorCarrera).setLayout(new VerticalLayout());
		 createSubjectForm(materia);
		 createMarksTable(materia);
		 
  }
  
  private void createSubjectsList(Panel container){
	  Panel listadoMaterias = new Panel(container).setLayout(new VerticalLayout());
	  	new Label(listadoMaterias).setText("Materias:");
	  	List<Materia> materias = new List<>(listadoMaterias);
	  	materias.setHeigth(235).setWidth(150);
	  	materias.bindItemsToProperty("materias").setAdapter(new PropertyAdapter(Materia.class, "nombre"));
	  	materias.bindValueToProperty("materiaSeleccionada");
	  	new Button(listadoMaterias).setCaption("Nueva Materia").onClick(()-> openAcceptDialog(new NuevaMateriaView(this),()->ObservableUtils.firePropertyChanged(getModelObject(), "materias", getModelObject().getMaterias())));
  }
  
  protected void createSubjectForm(Panel container){
	  	Label nombreMateria = new Label(container);
	  	nombreMateria.bindValueToProperty("materiaSeleccionada.nombre");
	  	nombreMateria.setFontSize(12);
	  	Panel datosMateria = new Panel(container).setLayout(new ColumnLayout(2));
	  		NotNullObservable materiaSeleccionada = new NotNullObservable("materiaSeleccionada");
		  	Panel anioCursada = new Panel(datosMateria).setLayout(new HorizontalLayout());
		  		new Label(anioCursada).setText("Año cursada:");
		  		newEnableableControl(new TextBox(anioCursada), materiaSeleccionada).bindValueToProperty("materiaSeleccionada.anio");
		  	Panel finalAprobado = new Panel(datosMateria).setLayout(new HorizontalLayout());
		  		newEnableableControl(new CheckBox(finalAprobado), materiaSeleccionada).bindValueToProperty("materiaSeleccionada.finalAprobado");
		  		new Label(finalAprobado).setText("Final aprobado");
		  	new Label(datosMateria).setText("Profesor de cursada:");
		  	newEnableableControl(new TextBox(datosMateria), materiaSeleccionada).setWidth(165).bindValueToProperty("materiaSeleccionada.profesor");
		  	new Label(datosMateria).setText("Tipo de cursada:");
		  	Selector<String> cursadas = new Selector<>(datosMateria);
		  	cursadas.bindEnabled(materiaSeleccionada);
		  	cursadas.bindItemsToProperty("tiposCursada");
		  	cursadas.bindValueToProperty("materiaSeleccionada.cursada");
		  	new Label(datosMateria).setText("Notas de cursada:");
  }

  protected void createMarksTable(Panel container){
	  NotNullObservable materiaSeleccionada = new NotNullObservable("materiaSeleccionada");
	  NotNullObservable evaluacionSeleccionada = new NotNullObservable("evaluacionSeleccionada");
      Table<Evaluacion> notas = new Table<>(container,Evaluacion.class);
      notas.setHeigth(100).setWidth(300);
      notas.bindItemsToProperty("materiaSeleccionada.evaluaciones");
      notas.bindValueToProperty("evaluacionSeleccionada");
      new Column<Evaluacion>(notas).setTitle("Fecha").setFixedSize(100).bindContentsToProperty("fecha");
      new Column<Evaluacion>(notas).setTitle("Descripción").setFixedSize(100).bindContentsToProperty("descripcion");
      new Column<Evaluacion>(notas).setTitle("Aprobada").setFixedSize(100).bindContentsToTransformer(new FinalAprobadoTransformer());
      Panel acciones = new Panel(container).setLayout(new HorizontalLayout());
      nuevaAccionTabla(acciones, "+", ()->openVentanaAdicionNota(), materiaSeleccionada);
      nuevaAccionTabla(acciones, "Editar", () -> openVentanaEdicionNota(), evaluacionSeleccionada);
      nuevaAccionTabla(acciones, "-", ()->getModelObject().removerEvaluacionSeleccionada(), evaluacionSeleccionada); 
  }
  
  private void openVentanaAdicionNota() {
	EditarNotaView ventanaEdicion = new EditarNotaView(this, new Evaluacion());
	openAcceptDialog(ventanaEdicion, ()-> getModelObject().agregarEvaluacion(ventanaEdicion.getEvaluacion()));
  }

  private void openVentanaEdicionNota() {
	  EditarNotaView ventanaEdicion = new EditarNotaView(this, getModelObject().getClonedEvaluacionSeleccionada());
		openAcceptDialog(ventanaEdicion, ()-> getModelObject().sobrescribirEvaluacionSeleccionada(ventanaEdicion.getEvaluacion()));
  }
  
/* Fumata (?):

  private void openEditarNota(EditarNotaView ventanaEdicion, Function<EditarNotaView,Action> accion) {
		openAcceptDialog(ventanaEdicion, accion.apply(ventanaEdicion));
  }

  	agregarEvaluacion.onClick(()-> openEditarNota(new EditarNotaView(this, new Evaluacion()),((ventana)->()-> getModelObject().agregarEvaluacion(ventana.getEvaluacion())))); 
	editarEvaluacion.onClick(()-> openEditarNota(new EditarNotaView(this, getModelObject().getClonedEvaluacionSeleccionada(),((ventana)->()->getModelObject().sobrescribirEvaluacionSeleccionada(ventanaEdicion.getEvaluacion())))); 

*/

  private Button nuevaAccionTabla(Panel container,String caption, Action onClickAction, NotNullObservable enablingProperty){
	  Button boton = new Button(container).setCaption(caption);
      boton.bindEnabled(enablingProperty);
      boton.onClick(onClickAction);  
      return boton;
  }
  
  private Control newEnableableControl(Control widget, NotNullObservable enabligProperty){
	  widget.bindEnabled(enabligProperty);
	  return widget;
  }
  
  private void openAcceptDialog(Dialog<?> dialog, Action onAcceptAction) {
	  dialog.onAccept(onAcceptAction);
	  dialog.open();
  }  
  
}

