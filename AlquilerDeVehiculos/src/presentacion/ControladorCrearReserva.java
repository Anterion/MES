package presentacion;

import java.util.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import excepciones.DAOExcepcion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Categoria;
import logica.Reserva;
import logica.Sucursal;
import logica.Utility;
import persistencia.ReservaDAOImp;

public class ControladorCrearReserva extends ControladorCasoDeUso{
        private static final Logger LOG = Logger.getLogger(ControladorCrearReserva.class.getName());

        @FXML
        private TextField id;

        @FXML
        private DatePicker fechaRecogida;

        @FXML
        private DatePicker fechaDevolucion;

        @FXML
        private TextField dni;

        @FXML
        private TextField modAl;

        @FXML
        private ComboBox<String> categoriaAsoc;

        @FXML
        private ComboBox<String> lugarRec;

        @FXML
        private ComboBox<String> lugarDev;

        @FXML
        private ComboBox<String> tipoSeg;

        @FXML
        private Button aceptar;

        @FXML
        private Button cancelar;


        private Reserva nuevaReserva;
        String cat="";

        /**
         * Metodo que inicializa el formulario y la verifiaci�n de los diferentes campos del mismo.
         *@param location The location used to resolve relative paths for the root object, or null if the location is not known.
         *@param resources The resources used to localize the root object, or null ifthe root object was not localized.
         */
        @Override
        public void initialize(URL location, ResourceBundle resources) {
        stage = new Stage(StageStyle.DECORATED);
        Stage ventana = new Stage();
        stage.setTitle("CREAR RESERVA");

        List<Sucursal> listaSucursal = null;
		listaSucursal = AlquilerVehiculos.getAlquilerVehiculos().listarSucursales();
        List<Categoria> listaCategoria = null;
		listaCategoria = AlquilerVehiculos.getAlquilerVehiculos().listarCategorias();

        for(Sucursal suc : listaSucursal){
        	lugarRec.getItems().add(suc.getDireccion());
        	lugarDev.getItems().add(suc.getDireccion());
        }

        for(Categoria cat : listaCategoria){
        	categoriaAsoc.getItems().add(cat.getNombre());
        }

        try {
			id.setText(ReservaDAOImp.buscarIdMaxReserva());
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tipoSeg.getItems().add("Seguro a todo riesgo");
        tipoSeg.getItems().add("Seguro a terceros");

        categoriaAsoc.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->cat = newValue);

        cancelar.setOnAction(event -> stage.close());
        aceptar.setOnAction(event -> {
        	String error="";
        	boolean isnull = false;
        	if (fechaRecogida.getValue() == null) {
                error += "Introduce la fecha de recogida\n";
                isnull = true;
            }

            if (fechaDevolucion.getValue() == null) {
            	error += "Introduce la fecha de devoluci�n\n";
            	isnull = true;
            }
            if(!isnull){
            	if((fechaRecogida.getValue().isAfter(fechaDevolucion.getValue()))){
                	error += "La fecha de devoluci�n ha de ser posterior a la de recogida\n";
                }
            }


            if (dni.getText().trim().length() == 0) {
            	error += "Introduce el dni\n";
            }
            if (dni.getText().trim().length()>0 && dni.getText().trim().length() != 9) {
            	error += "Introduce correctamente el DNI: 123456789A\n";
            }
            if (modAl.getText().trim().length() == 0) {
            	error += "Introcuce una modalidad\n";
            }else{
            	if(!Utility.isInteger(modAl.getText())){
            		error += "La modalidad no puede contener letras\n";
            	}
            }

            if (categoriaAsoc.getSelectionModel().getSelectedItem()== null) {
            	error += "Selecciona una categoría\n";
            }

            if (lugarRec.getSelectionModel().getSelectedItem()== null) {
            	error += "Selecciona una lugar de recogida\n";
            }

            if (lugarDev.getSelectionModel().getSelectedItem()== null) {
            	error += "Selecciona una lugar de devoluci�n\n";
            }

            if (tipoSeg.getSelectionModel().getSelectedItem()== null) {
            	error += "Selecciona un tipo de seguro.\n";
            }



        	if(error.length()!=0){
        		Alert alerta = new Alert(AlertType.ERROR);
        		alerta.initStyle(StageStyle.DECORATED);
				alerta.setContentText(error);
				alerta.setHeaderText("Error");
				alerta.showAndWait();
        	} else {
        	if(!dni.getText().isEmpty())
         if(AlquilerVehiculos.getAlquilerVehiculos().buscarCliente(dni.getText())==null){

        	 Alert alerta = new Alert(AlertType.ERROR);
				alerta.initStyle(StageStyle.DECORATED);
				alerta.setContentText("Este DNI no pertenece a ning�n cliente en nuestra base de datos, a continuaci�n se mostrará la ventana para crear un nuevo cliente");
				alerta.setHeaderText("Error DNI");
				alerta.showAndWait();

				FXMLLoader loader = new FXMLLoader(AlquilerVehiculosApp.class.getResource("crear-cliente.fxml"));
	            GridPane ventanaDos = null;
				try {
					ventanaDos = (GridPane) loader.load();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            ventana.setTitle("CREAR CLIENTE");
	            ventana.initOwner(stage);
	            Scene scene = new Scene(ventanaDos);
	            ventana.setScene(scene);
	            ControladorCrearCliente controller = loader.getController();
	            controller.setControladorPrincipal(controladorPrincipal);
	            ventana.show();
	            //ventana.getClass()

	           // aceptar.setOnAction(event1 -> ventana.close());


         }  else{
            String cli = AlquilerVehiculos.getAlquilerVehiculos().buscarCliente(dni.getText()).getDni();
           Categoria categoria = AlquilerVehiculos.getAlquilerVehiculos().buscarCategoria(cat);

			nuevaReserva = new Reserva(

					Integer.parseInt(id.getText()),
					LocalDateTime.of(fechaRecogida.getValue(), LocalTime.MIDNIGHT),
            		LocalDateTime.of(fechaDevolucion.getValue(), LocalTime.MIDNIGHT),
            		Integer.parseInt(modAl.getText()),
            		categoria,
            		cli,
            		lugarRec.getSelectionModel().selectedIndexProperty().getValue()+1,
            	    lugarDev.getSelectionModel().selectedIndexProperty().getValue()+1

                    );
         }  }
            if (nuevaReserva != null) {

				AlquilerVehiculos.getAlquilerVehiculos().crearReserva(nuevaReserva);
				Alert alerta = new Alert(AlertType.CONFIRMATION);
        		alerta.initStyle(StageStyle.DECORATED);
				alerta.setContentText("Reserva creada correctamente");
				alerta.setHeaderText("");
				alerta.showAndWait();
                Stage stage = (Stage) aceptar.getScene().getWindow();
                stage.close();
            } else {
                LOG.log(Level.INFO, "No se ha podido crear una nueva reserva.");
            }



        });
        }
}
