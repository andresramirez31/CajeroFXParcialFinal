package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;


public class Retiros {
    private BaseCuentas bsc = new BaseCuentas();
    List<cuenta> cuentas = bsc.getCuentas();

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtMonto;

    @FXML
    public void initialize(){
        txtMonto.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?") && change.getControlNewText().length() <= 12) {
                return change;
            }
            return null;
        }));
    }

    public void btVerificar_accion(){
      String id = txtId.getText().trim();
        for (cuenta cnt:cuentas) {
            if(id.equals(cnt.getIdentificacion())){
                int saldoInfo = cnt.getSaldoInicial();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Saldo de la cuenta");
                alert.setContentText("El saldo disponible en la cuenta es de: " + saldoInfo + " pesos");
                alert.showAndWait();
            } else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Saldo de la cuenta");
                alert.setContentText("La cuenta con la identificacion ingresada no existe, por favor ingrese correctamente la identificacion");
            }
        }
    }


    public void btGuardar_accion(){

        String id = txtId.getText().trim();
        int monto = Integer.parseInt(txtMonto.getText());

        retiro(id,monto);
        limpiarCampos();
    }

    private boolean validarCampos(String... campos) {
        for (int i = 0; i < campos.length; i++) {
            if (campos[i] == null || "".equals(campos[i])) {
                return false;
            }
        }
        return true;
    }

    public void retiro(String id, int monto){
        for (cuenta cnt:cuentas) {
            if(id.equals(cnt.getIdentificacion())){
                cuenta cnta = cnt;
                if(cnta.getSaldoInicial() >= monto){
                  int saldo = cnta.getSaldoInicial();
                  int saldoNuevo = saldo - monto;
                  cnta.setSaldoInicial(saldoNuevo);
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Retiro de Saldo");
                  alert.setContentText("El retiro ha sido exitoso!!");
                  alert.showAndWait();
                } else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Operacion Fallida");
                    alert.setContentText("No se ha podido realizar el retiro por no poseer suficientes fondos, por favor intente con una menor cantidad.");
                    alert.showAndWait();
                }

            }
        }
    }

    public void limpiarCampos(){
        txtId.clear();
        txtMonto.clear();
    }
}
