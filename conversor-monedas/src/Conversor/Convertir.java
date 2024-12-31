package Conversor;

import Solicitudes_API.ConfiguracionApi;
import Solicitudes_API.SolicitudesGet;
import org.json.JSONObject;

public class Convertir {

    private final SolicitudesGet solicitudesGet = new SolicitudesGet();
    private final ConfiguracionApi configuracionApi = new ConfiguracionApi();

    public double convertirDivisa(String monedaBase, String monedaObjetivo, double cantidadDinero) {
        configuracionApi.cambiarMonedaBase(monedaBase);
        JSONObject jsonObject = solicitudesGet.obtenerDivisas();
        double tasaConversion = jsonObject.getDouble(monedaObjetivo);

        return (tasaConversion * cantidadDinero);
    }
}
