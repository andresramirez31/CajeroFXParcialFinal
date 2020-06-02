package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class Controller {

    @FXML
    private BorderPane marco;

    public void btCrear_accion(){
        try {

            AnchorPane crearCuenta = FXMLLoader
                    .load(getClass().getResource("crear-Cuenta.fxml"));
            this.marco.setCenter(crearCuenta);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void btConsigna_accion(){
        try {
            AnchorPane consigna = FXMLLoader
                    .load(getClass().getResource("consignaciones.fxml"));
            this.marco.setCenter(consigna);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void btRetiro_accion(){
        try {
            AnchorPane retiro = FXMLLoader
                    .load(getClass().getResource("retiros.fxml"));
            this.marco.setCenter(retiro);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void btTransaccion_accion(){
        try {
            AnchorPane transaccion = FXMLLoader
                    .load(getClass().getResource("transacciones.fxml"));
            this.marco.setCenter(transaccion);

        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
