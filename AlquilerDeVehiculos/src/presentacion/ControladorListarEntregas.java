package presentacion;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Entrega;

public class ControladorListarEntregas extends ControladorCasoDeUso { 
	  	@FXML
	    private TableColumn<Entrega, Double> kms;

	    @FXML
	    private TableColumn<Entrega, LocalDateTime> fecha;

	    @FXML
	    private TableColumn<Entrega, String> tipoSeguro;

	    @FXML
	    private TableColumn<Entrega, String> empleado;

	    @FXML
	    private Button aceptar;

	    @FXML
	    private TableColumn<Entrega, Integer> id;

	    @FXML
	    private TableView<Entrega> entregas;

	    @FXML
	    private TableColumn<Entrega, Double> combustible;

	    @FXML
	    private TableColumn<Entrega, String> cocheAsignado;
	    
		/**
		 * Inicializa los campos de la ventana listar-entregas y comprueba los campos de la misma al finalizar el dialogo.
		 * @param arg0 El path a el archivo FXML a cargar
		 * @param arg1 Propiedades de internacionalizacion de la interfaz grafica.
		 */
    @Override 
	public void initialize(URL location, ResourceBundle resources) { 
    	stage = new Stage(StageStyle.DECORATED); 
		stage.setTitle("LISTADO DE ENTREGAS"); 
		aceptar.setOnAction(event -> stage.close()); 
		kms.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getKms())); 
		fecha.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFecha())); 
		tipoSeguro.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getTipoSeguro())); 
		empleado.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getEmpleado())); 
		id.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId())); 
		combustible.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCombustible())); 
		cocheAsignado.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCoche())); 
		this.entregas.getItems().addAll(AlquilerVehiculos.getAlquilerVehiculos().listarEntregas());
    	} 
	}