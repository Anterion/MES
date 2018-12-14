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
import logica.Reserva;
import logica.Sucursal;

public class ControladorListarReservasSucursal extends ControladorCasoDeUso{
	@FXML
	private TableView<Sucursal> sucursales;
	@FXML
	private TableColumn<Sucursal,Integer> idSuc;
	@FXML
	private TableColumn<Sucursal,String> direccion;
	@FXML
	private TableView<Reserva> reservas;
	@FXML
	private TableColumn<Reserva, Integer> idRes;
	@FXML
	private TableColumn<Reserva, LocalDateTime> fechaRec;
	@FXML
	private TableColumn<Reserva, LocalDateTime> fechaDev;
	@FXML
	private TableColumn<Reserva, Integer> modalidadAlquiler;
	@FXML
	private TableColumn<Reserva, String> sucDev;
	@FXML
	private TableColumn<Reserva, String> sucRec;
	@FXML
	private TableColumn<Reserva, String> cat;
	@FXML
	private TableColumn<Reserva, String> cliente;
	@FXML
	private Button  aceptar;

	/**
	 * Puebla la tabla de reservas.
	 * @param newValue La sucursal de la que se van a listar las reservas.
	 */
	public void rellenaTabla(Sucursal newValue){
		
		this.reservas.getItems().clear();
		idRes.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
		fechaRec.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaRecogida()));
		fechaDev.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getFechaDevolucion()));
		modalidadAlquiler.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getModalidadAlquiler()));
		cat.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCategoria().getNombre()));
		cliente.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCliente().getNombreyApellidos()));
		sucDev.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getSucursalDevolucion().getDireccion()));
		sucRec.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getSucursalRecogida().getDireccion()));
		this.reservas.getItems().addAll(AlquilerVehiculos.getAlquilerVehiculos().listarReservasSucursal(newValue.getId()));
		
	}
	
	/**
	 * Inicializa los campos de la ventana listar-reservas-sucursales y comprueba los campos de la misma al finalizar el dialogo.
	 * @param arg0 El path a el archivo FXML a cargar
	 * @param arg1 Propiedades de internacionalizacion de la interfaz grafica.
	 */
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		
			stage = new Stage(StageStyle.DECORATED); 
			stage.setTitle("LISTADO DE RESERVAS POR SUCURSAL"); 
			aceptar.setOnAction(event -> stage.close()); 
			
			idSuc.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId())); 
			direccion.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDireccion())); 
			this.sucursales.getItems().addAll(AlquilerVehiculos.getAlquilerVehiculos().listarSucursales()); 
			sucursales.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
				
				rellenaTabla(newValue);
			});
			} 
    }