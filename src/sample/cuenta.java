package sample;

import java.util.ArrayList;
import java.util.List;

public class cuenta {
    protected String identificacion;
    protected int saldoInicial;


    public cuenta(String identificacion, int saldoInicial) {
        this.identificacion = identificacion;
        this.saldoInicial = saldoInicial;

    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
}
