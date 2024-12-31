package Solicitudes_API;

import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class SolicitudesGet {

    private Properties properties;
    protected static String urlApiActual;

    public SolicitudesGet() {
        this.properties = cargarPropiedades();
        urlApiActual = obtenerUrlApi();
    }

    public JSONObject obtenerDivisas() {
        try {
            URL url = new URL(urlApiActual);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.connect();

            JSONObject jsonObject = obtenerJson(conexion);
            return jsonObject.getJSONObject("conversion_rates");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al conectar con la API",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject obtenerJson(HttpURLConnection conexion) throws IOException {
        if (conexion.getResponseCode() != 200) {
            throw new RuntimeException("Error HTTP: " + conexion.getResponseCode());
        }

        BufferedReader input = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder respuesta = new StringBuilder();
        String linea;
        while ((linea = input.readLine()) != null) {
            respuesta.append(linea);
        }
        input.close();

        return new JSONObject(respuesta.toString());
    }

    private String obtenerUrlApi() {
        try {
            return this.properties.getProperty("api.url");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Properties cargarPropiedades() {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
