package presentacion;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.beans.property.ReadOnlyObjectWrapper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.*;

public class ControladorListarSucursales extends ControladorCasoDeUso { 
	@FXML 
	private TableView<Sucursal> sucursales; 
	@FXML 
	private TableColumn<Sucursal, Integer> id; 
	@FXML 
	private TableColumn<Sucursal, String> direccion; 
	@FXML 
	private Button aceptar; 
	/**
	 * Inicializa los campos de la ventana listar-sucursales y comprueba los campos de la misma al finalizar el dialogo.
	 * @param arg0 El path a el archivo FXML a cargar
	 * @param arg1 Propiedades de internacionalizacion de la interfaz grafica.
	 */
	@Override 
	public void initialize(URL location, ResourceBundle resources) { 
		stage = new Stage(StageStyle.DECORATED); 
		stage.setTitle("LISTADO DE SUCURSALES"); 
		aceptar.setOnAction(event -> stage.close()); 
		id.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId())); 
		direccion.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getDireccion())); 
		this.sucursales.getItems().addAll(AlquilerVehiculos.getAlquilerVehiculos().listarSucursales()); 
		} 
	}