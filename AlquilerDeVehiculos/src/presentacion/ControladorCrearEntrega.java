package presentacion;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Entrega;


public class ControladorCrearEntrega extends ControladorCasoDeUso {
	@FXML
	public TextField kms;
    @FXML
	public DatePicker fechaEntrega;
    @FXML
	public ComboBox<String> tipoSeg;
	@FXML
	private Button cancelar;
	@FXML
	private TextField empleado;
	@FXML
	private Button aceptar;
	@FXML
	private TextField id;
	@FXML
	private TextField combustible;
	private Entrega nuevaEntrega;
	String matricula;

	public Entrega getNuevaEntrega(){
		return nuevaEntrega;
	}
//<TextField fx:id="tipoSeguro" GridPane.columnIndex="2" GridPane.rowIndex="3" />
	/**
	 * Inicializa los campos de la ventana crear-entrega y comprueba los campos de la misma al finalizar el dialogo.
	 * @param arg0 El path a el archivo FXML a cargar
	 * @param arg1 Propiedades de internacionalizacion de la interfaz grafica.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


		fechaEntrega.setValue(LocalDate.now());
		matricula=ControladorListarReservas.getMat().trim();
		id.setText(ControladorListarReservas.getIdReserva());

		stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("CREAR CATEGORIA");
        tipoSeg.getItems().add("0");
        tipoSeg.getItems().add("1");
        tipoSeg.getItems().add("2");
        cancelar.setOnAction(event -> {
        	Stage miStage = (Stage) cancelar.getScene().getWindow();
			miStage.close();
        	stage.close();
        });
        aceptar.setOnAction(event -> {
        	Stage miStage = (Stage) aceptar.getScene().getWindow();

        	String error="";
        	if (kms.getText().trim().length() == 0) {
            	error += "Introduce los kilometros\n";
            }
        	if (tipoSeg.getSelectionModel().getSelectedItem()== null) {
            	error += "Selecciona un tipo de seguro.\n";
            }
        	if (empleado.getText().trim().length() == 0) {
            	error += "Introduce el empleado\n";
            }
        	if (combustible.getText().trim().length() == 0) {
            	error += "Introduce el combustible\n";
            }
        	if(error.length()!=0){
        		Alert alerta = new Alert(AlertType.ERROR);
        		alerta.initStyle(StageStyle.DECORATED);
				alerta.setContentText(error);
				alerta.setHeaderText("Error");
				alerta.showAndWait();
        	} else {

    			nuevaEntrega = new Entrega(Integer.parseInt(id.getText()),LocalDateTime.of(fechaEntrega.getValue(), LocalTime.MIDNIGHT), tipoSeg.getSelectionModel().getSelectedItem(), Double.parseDouble(kms.getText()), Double.parseDouble(combustible.getText()), matricula,empleado.getText());
    			if (nuevaEntrega != null) {

    			AlquilerVehiculos.getAlquilerVehiculos().crearEntrega(nuevaEntrega);
    			Alert alerta = new Alert(AlertType.CONFIRMATION);
        		alerta.initStyle(StageStyle.DECORATED);
				alerta.setContentText("Entrega creada correctamente");
				alerta.setHeaderText("");
				alerta.showAndWait();
                Stage stage = (Stage) aceptar.getScene().getWindow();

                stage.close();

            } else {

            }
        	}
        	miStage.close();
        });
	}
}