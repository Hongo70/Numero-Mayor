package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class ServletJason extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StringBuilder sb = new StringBuilder();
        String linea;
        BufferedReader reader = request.getReader();
        while ((linea = reader.readLine()) != null) {
            sb.append(linea);
        }

        JSONObject entrada = new JSONObject(sb.toString());
        String num1 = entrada.getString("cajaNum1");
        String num2 = entrada.getString("cajaNum2");
        String num3 = entrada.getString("cajaNum3");

        int num1ConvInt = Integer.parseInt(num1);
        int num2ConvInt = Integer.parseInt(num2);
        int num3ConvInt = Integer.parseInt(num3);

        int mayor = 0;

        if (num1ConvInt > num2ConvInt && num1ConvInt > num3ConvInt) {
            mayor = num1ConvInt;
        } else if (num2ConvInt > num1ConvInt && num2ConvInt > num3ConvInt) {
            mayor = num2ConvInt;
        } else if (num3ConvInt > num1ConvInt && num3ConvInt > num2ConvInt) {
            mayor = num3ConvInt;
        } else {
            mayor = num3ConvInt;
        }

        JSONObject salida = new JSONObject();
        salida.put("mensaje", "El número mayor es: " + mayor);

        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print(salida.toString());
        out.flush();
    }
}
