package sample;

import java.util.ArrayList;
import java.util.List;

public class BaseCuentas {
    private static List<cuenta> cuentas = new ArrayList();

    public List<cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
