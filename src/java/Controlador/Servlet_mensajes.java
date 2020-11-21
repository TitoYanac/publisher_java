/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bean.receta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Publisher;

/**
 *
 * @author TITO
 */
public class Servlet_mensajes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        receta nuevo = new receta();
        String fecha = !"".equals(request.getParameter("fecha")) ? request.getParameter("fecha") : "...";
        String med = !"".equals(request.getParameter("med")) ? request.getParameter("med") : "...";
        String nombre = !"".equals(request.getParameter("nombre")) ? request.getParameter("nombre") : "...";
        String apellido = !"".equals(request.getParameter("apellido")) ? request.getParameter("apellido") : "...";
        String dni = !"".equals(request.getParameter("dni")) ? request.getParameter("dni") : "...";
        String medicamento = !"".equals(request.getParameter("medicamento")) ? request.getParameter("medicamento") : "...";
        String cantidad = !"".equals(request.getParameter("cantidad")) ? request.getParameter("cantidad") : "...";
        String indicaciones = !"".equals(request.getParameter("indicaciones")) ? request.getParameter("indicaciones") : "...";
        nuevo.setFecha(fecha); 
        nuevo.setMed(med); 
        nuevo.setNombre(nombre); 
        nuevo.setApellido(apellido); 
        nuevo.setDni(dni); 
        nuevo.setMedicamento(medicamento); 
        nuevo.setCantidad(cantidad); 
        nuevo.setIndicaciones(indicaciones); 
        
        boolean flag = false;
        
        Publisher publicador = Publisher.getpublisher();
        try {
            flag = publicador.EnviarReceta(nuevo);
        } catch (Exception ex) {
            Logger.getLogger(Servlet_mensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if (flag){
            extra(request, response,"salio bien");
        }else{
            extra(request, response,"salio mal");
        }
    }
    void extra(HttpServletRequest request, HttpServletResponse response ,String s1) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_mensajes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>El valor recibido es: " + s1 + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
