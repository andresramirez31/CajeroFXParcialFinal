package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.CrearCuenta;
import sample.cuenta;
import java.util.List;

public class Consignaciones {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtConsigna;

    private BaseCuentas bsc = new BaseCuentas();
    List<cuenta> cuentas = bsc.getCuentas();

    @FXML
    public void initialize(){
        txtConsigna.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?") && change.getControlNewText().length() <= 12) {
                return change;
            }
            return null;
        }));
    }

    public void btGuard_click(){
        String id = txtId.getText().trim();
        cuenta cuent = null;
        for (cuenta c:cuentas
             ) {
            if(id.equals(c.getIdentificacion())){
                cuent = c;

            }
        }
        int Consigna;
        try{
        Consigna = Integer.parseInt(txtConsigna.getText());
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Creacion de cuenta");
            alert.setContentText("Por favor diligencie correctamente todos los campos");
            alert.showAndWait();
            return;
        }
        boolean comprobacion = validarCampos(Consigna, id);
        if(!comprobacion){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Creacion de cuenta");
            alert.setContentText("Por favor diligencie correctamente todos los campos");
            alert.showAndWait();
            return;
        }
        consigna(cuent,Consigna);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Consignacion en cuenta");
        alert.setContentText("La consignacion ha sido exitosa!!!");
        alert.showAndWait();
        limpiarCampos();
    }

    private boolean validarCampos(int numero, String... campos) {
        for (int i = 0; i < campos.length; i++) {
            if (campos[i] == null || "".equals(campos[i])) {
                return false;
            }
        }
        return true;
    }

    public void limpiarCampos(){
        txtConsigna.clear();
        txtId.clear();
    }

    public void consigna(cuenta Cuenta, int monto){

        for(cuenta Cuent:cuentas){

            if(Cuenta.getIdentificacion().equals(Cuent.getIdentificacion())){
                Cuenta = Cuent;
                int saldo = Cuenta.getSaldoInicial();
                int saldoNuevo = saldo + monto;
                Cuenta.setSaldoInicial(saldoNuevo);
                cuentas.remove(Cuent);
                cuentas.add(Cuenta);
            }
        }

    }
}
