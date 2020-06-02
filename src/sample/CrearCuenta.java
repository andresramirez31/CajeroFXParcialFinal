package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CrearCuenta {


    @FXML
    private TextField txtId;
    @FXML
    private TextField txtMonto;

    private BaseCuentas bsc = new BaseCuentas();

    @FXML
    public void initialize(){
        txtMonto.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?") && change.getControlNewText().length() <= 12) {
                return change;
            }
            return null;
        }));
    }

    private boolean validarCampos(int numero, String... campos) {
        for (int i = 0; i < campos.length; i++) {
            if (campos[i] == null || "".equals(campos[i])) {
                return false;
            }
        }
        return true;
    }

    public void btGuardar_accion(){

        String id = txtId.getText().trim();
        int monto;
        try {
            monto = Integer.parseInt(txtMonto.getText());
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Creacion de cuenta");
            alert.setContentText("Por favor diligencie correctamente todos los campos");
            alert.showAndWait();
            return;
        }
        boolean comprobar = validarCampos(monto,id);
        if(!comprobar){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Creacion de cuenta");
            alert.setContentText("Por favor diligencie correctamente todos los campos");
            alert.showAndWait();
            return;
        }
        cuenta cnt = new cuenta(id, monto);
        bsc.getCuentas().add(cnt);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creacion de cuenta");
        alert.setContentText("La creacion de la cuenta ha sido un exito!!");
        alert.showAndWait();
        limpiarCampos();
    }

    public void limpiarCampos(){
        txtId.clear();
        txtMonto.clear();

    }

}
