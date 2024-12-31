package Solicitudes_API;

import static Solicitudes_API.SolicitudesGet.urlApiActual;

public class ConfiguracionApi {

    public void cambiarMonedaBase(String nuevaMonedaBase) {
        try {
            if ( (urlApiActual == null) || (urlApiActual.isEmpty())) {
                throw new RuntimeException("URL base no encontrada");
            }

            urlApiActual = urlApiActual.replaceAll("/latest/\\w+", "/latest/" + nuevaMonedaBase);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
