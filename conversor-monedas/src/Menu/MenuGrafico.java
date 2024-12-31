package Menu;

import Conversor.Convertir;
import Solicitudes_API.SolicitudesGet;
import org.json.JSONObject;

import javax.swing.*;
import java.text.DecimalFormat;

public class MenuGrafico {

    private final SolicitudesGet solicitudAPI = new SolicitudesGet();
    private final Convertir convertir = new Convertir();
    private final DecimalFormat decimalFormat = new DecimalFormat("#,###.########");
    private static String[] monedasIso;
    private static final String[] OPCIONES_MENU_PRINCIPAL = {"Conversor de monedas", "salir"};

    public void iniciarAplicacion() {
        mostrarMensajeBienvenida();
        manejarMenuPrincipal();
    }

    private void manejarMenuPrincipal() {
        switch (elegirOpcionMenuPrincipal()) {
            case 0:
                manejarConversorDeDivisas();
                break;
            case 1:
                salir();
                break;
        }
    }

    private void manejarConversorDeDivisas() {
        while (true) {
            JSONObject divisas = solicitudAPI.obtenerDivisas();
            if (divisas == null) {
                break;
            }
            monedasIso = divisas.keySet().toArray(new String[0]);

            String divisaBase = obtenerDivisaBase();
            if (divisaBase == null) {
                salir();
                break;
            }

            String cantidadDinero = ingresarCantidadDinero();
            if (cantidadDinero == null) {
                break;
            }
            double cantidadDineroParseadaDouble = Double.parseDouble(cantidadDinero);

            String divisaObjetivo = obtenerDivisaObjetivo();
            if (divisaObjetivo == null) {
                salir();
                break;
            }

            procesarConversionDivisa(divisaBase, divisaObjetivo, cantidadDineroParseadaDouble);

            if (!deseaContinuar()) {
                salir();
                break;
            }
        }
    }

    private void procesarConversionDivisa(String divisaBase, String divisaObjetivo, double cantidad) {
        double resultadoConversionDivisa = convertir.convertirDivisa(divisaBase, divisaObjetivo, cantidad);

        mostrarResultadoConversion(divisaBase, divisaObjetivo, cantidad, resultadoConversionDivisa);
    }

    private void mostrarMensajeBienvenida() {
        JOptionPane.showMessageDialog(null,
                "Bienvenido a la aplicación de conversiones",
                "Bienvenida",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private int elegirOpcionMenuPrincipal() {
        return JOptionPane.showOptionDialog(null,
                "Selecciona una opción",
                "Menú",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                OPCIONES_MENU_PRINCIPAL,
                OPCIONES_MENU_PRINCIPAL[0]);
    }

    private String obtenerDivisaBase() {
        Object divisaBase = JOptionPane.showInputDialog(null,
                "Selecciona la moneda con la que deseas convertir a otras monedas",
                "Divisa Base",
                JOptionPane.QUESTION_MESSAGE,
                null,
                monedasIso,
                monedasIso[0]);

        if (divisaBase != null) {
            return divisaBase.toString();
        } else {
            return null;
        }
    }

    private String obtenerDivisaObjetivo() {
        Object divisaObjetivo =
                JOptionPane.showInputDialog(null,
                        "Selecciona la moneda a la que deseas convertir",
                        "Divisa Objetivo",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        monedasIso,
                        monedasIso[0]);

        if (divisaObjetivo != null) {
            return divisaObjetivo.toString();
        } else {
            return null;
        }
    }

    private void mostrarResultadoConversion(String divisaBase, String divisaObjetivo,
                                            double cantidadDinero, double resultadoConversion) {
        JOptionPane.showMessageDialog(null,
                " $ " + decimalFormat.format(cantidadDinero) + " " + divisaBase + " = " +
                        " $ " + decimalFormat.format(resultadoConversion) + " " + divisaObjetivo,
                "Total de la conversión",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean deseaContinuar() {
        String[] opciones = {"Si","No"};
        int opcion = JOptionPane.showOptionDialog(null,
                "Deseas continuar?",
                "Continuar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        return opcion == 0;
    }

    public void salir() {
        JOptionPane.showMessageDialog(null,
                "Programa terminado",
                "Saliendo",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private String ingresarCantidadDinero() {
        do {
            try {
                String input = JOptionPane.showInputDialog(null,
                        """
                                Introduce la cantidad de dinero a convertir
                                debe ser un número positivo, sin letras ni caracteres especiales
                                puede ser decimal, ejemplo: 100.50""",
                        "Conversor de monedas",
                        JOptionPane.QUESTION_MESSAGE);
                if (input.matches("\\d+(\\.\\d+)?")) {
                    return input;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "La cantidad ingresada no es válida",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null,
                        "Operación cancelada",
                        "Adiós",
                        JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        } while (true);
    }
}
