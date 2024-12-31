<h1 align="center">Conversor de monedas</h1>

Este proyecto tiene como objetivo poder transformar divisas utilizando el lenguaje java y usando JOptionPane como menú grafico

## Requisitos
El convertidor de moneda debe: 

      - Convertir de la moneda de tu país a Dólar
      - Convertir de la moneda de tu país  a Euros
      - Convertir de la moneda de tu país  a Libras Esterlinas
      - Convertir de la moneda de tu país  a Yen Japonés
      - Convertir de la moneda de tu país  a Won sul-coreano
      
  Recordando que también debe ser posible convertir inversamente, es decir:
  
        - Convertir de Dólar a la moneda de tu país
        - Convertir de Euros a la moneda de tu país
        - Convertir de Libras Esterlinas a la moneda de tu país
        - Convertir de Yen Japonés a la moneda de tu país
        - Convertir de Won sul-coreano a la moneda de tu país

## Características del proyecto
  -Conversión a mas de 100 monedas  
  -Interfaz gráfica  
  -Actualización automatica de tasas de cambio  
  -Uso de [ISO 4217](https://es.wikipedia.org/wiki/ISO_4217)

## Como usarlo
1. En el menú principal, selecciona una de las opciones  
   ![Menú principal](https://github.com/user-attachments/assets/cdaa273f-1440-4290-93b9-5f4c2f08d94c)
   
2. Selecciona una de las monedas en el menu de selección de divisa base  
   ![Menu de selección de divisa base](https://github.com/user-attachments/assets/8c9279fe-400c-4db4-b7df-c75d893086e4)

3. Ingresa la cantidad de dinero que deseas convertir  
   ![Interfaz para ingresar la cantidad de dinero](https://github.com/user-attachments/assets/643f1aed-54da-4f26-a8e0-dea2a79d60d7)

4. Selecciona la moneda a la que deseas convertir  
  ![Interfaz para elegir la moneda de destino](https://github.com/user-attachments/assets/37e9cbb5-d678-41dc-a58f-a38b792068e5)

5. Obtén el resultado de la conversión  
   ![Resultado de la conversión](https://github.com/user-attachments/assets/ca10850a-6a3e-4c5a-9b0f-e6f1ca99a819)

6. Elige si deseas continuar  
   ![Menu para elegir si continuar](https://github.com/user-attachments/assets/fe25f120-7346-43ea-8215-ee61c0d6c4fa)

Si elegiste que si deseas continuar, el proceso se repetira. podras cambiar la divisa base, la divisa objetivo y también la cantidad de dinero.  

Si elegiste que no deseas continuar se mostrará el siguiente mensaje y terminará la ejecución del programa:  
![Mensaje de finalización del programa](https://github.com/user-attachments/assets/b8400ed6-5e90-46be-bb7e-fb52518828f6)

## Instalación
     1. Clona este repositorio.
     
     2. Dentro de la carpeta "conversor-monedas" crea un archivo .properties llamado "config.properties".
     
     3. Dentro del archivo "config.properties" crea una propiedad con el nombre de "api.url" y asignale lo siguiente: https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD
       reemplaza YOUR-API-KEY con una api key que deberas obtener de ExchangeRate-api.

## Tecnologías utilizadas
Java 17  
JOptionPane como interfaz gráfica  
API de [ExchangeRate-API](https://www.exchangerate-api.com/) para convertir la monedas.  
