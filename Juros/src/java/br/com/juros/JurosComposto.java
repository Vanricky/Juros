/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juros;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JurosComposto extends HttpServlet {

    // Metodo para arrumar a string para ela não ficar com numeros muito grandes
    public String converter(double d) {
        DecimalFormat df = new DecimalFormat("0.0");
        String a = df.format(d);
        return a;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String montanteconvertido = "";
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<title>Juros - Simples e Composto</title>\n"
                    + "\n"
                    + "<meta name='viewport' content='width=device-width, initial-scale=1'>\n"
                    + "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\n"
                    + "<script type='application/x-javascript'> addEventListener('load', function() { setTimeout(hideURLbar, 0); }, false);\n"
                    + "		function hideURLbar(){ window.scrollTo(0,1); } </script>\n"
                    + "\n"
                    + "<link href='css/style.css' rel='stylesheet' type='text/css' media='all' />\n"
                    + "\n"
                    + "</head>\n"
                    + "<body class='agileits_w3layouts'>\n"
                    + "    <h1 class='agile_head text-center'>Juros Composto e Simples</h1>\n"
                    + "    <div class='w3layouts_main wrap'>\n"
                    + "	  <h3>2º Trabalho de POO: Juros Composto. </h3>\n"
                    + "	    <form action='jsimples.html' method='post' class='agile_form'>\n"
                    + "                  <br/>\n"
                    + "                  <h3>Taxa de Juros: <input type='text'  name='txjuros' required='' /></h3>"
                    + "                  <h3>Capital: <input type='text'  name='capital' required='' /></h3>"
                    + "                  <h3>Periodo: <input type='text'  name='periodo' required='' /></h3>"
                    + "                  <br />\n"
                    + "                  <br />\n"
                    + "                  <input type='submit' value='Calcular' class='agileinfo' />\n"
                    + "                  <br />\n"
                    + "                  <br />\n");
            try {
                double taxajuros = 0;
                double capitalinicial = 0;
                double tempo = 0;
                double result = 0;

                tempo = Double.parseDouble(request.getParameter("periodo"));
                capitalinicial = Double.parseDouble(request.getParameter("capital"));
                taxajuros = Double.parseDouble(request.getParameter("txjuros"));
                tempo = tempo / 12;
                result = capitalinicial * Math.pow((1 + (taxajuros / 100)), tempo);

                montanteconvertido = converter(result);

            } catch (Exception e) {
            }
            out.printf("<h3>Resultado = " + montanteconvertido + " </h3>\n"
                    + "			 \n"
                    + "	  </form>\n"
                    + "	</div>\n"
                    + "	\n"
                    + "</body>\n"
                    + "</html>\n"
                    + "\n"
                    + "");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
