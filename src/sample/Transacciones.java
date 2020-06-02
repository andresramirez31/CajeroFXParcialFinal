package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;


public class Transacciones {

    @FXML
    private TextField txtCuenta;
    @FXML
    private TextField txtCuentaT;
    @FXML
    private TextField txtMonto;

    private BaseCuentas bsc = new BaseCuentas();
    private List<cuenta> cuentas = bsc.getCuentas();
    @FXML
    public void initialize(){
        txtMonto.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("([1-9][0-9]*)?") && change.getControlNewText().length() <= 12) {
                return change;
            }
            return null;
        }));
    }

    public void btGuardar_click(){
        String idCuenta = txtCuenta.getText().trim();
        String idCuentaT = txtCuentaT.getText().trim();
        int monto = Integer.parseInt(txtMonto.getText());
        cuenta cnta = null;
        for (cuenta cnt:cuentas) {
            if(idCuenta.equals(cnt.getIdentificacion())){
                cnta = cnt;
            }
        }
        cuenta cnta2 = null;
        for (cuenta cnt2:cuentas) {
            if(idCuentaT.equals(cnt2.getIdentificacion())){
                cnta2 = cnt2;
            }
        }
        if(cnta != null && cnta2 != null) {
            int Saldo1 = cnta.getSaldoInicial();
            int Saldo2 = cnta2.getSaldoInicial();
            int SaldoNuevo1 = Saldo1 - monto;
            int SaldoNuevo2 = Saldo2 + monto;
            cnta.setSaldoInicial(SaldoNuevo1);
            cnta2.setSaldoInicial(SaldoNuevo2);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Transaccion de dinero");
            alert.setContentText("La transaccion ha sido exitosa!!!");
            alert.showAndWait();
            limpiarCampos();
        }
    }

    public void limpiarCampos(){
        txtCuenta.clear();
        txtCuentaT.clear();
        txtMonto.clear();
    }
}
