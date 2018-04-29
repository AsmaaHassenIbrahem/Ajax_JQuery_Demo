/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asmaa
 */
@WebServlet(name ="ChatServlet" , urlPatterns = {"/ChatServlet"})
public class ChatServlet extends HttpServlet {

    static Vector<User> messages;
    
    @Override
    public void init() throws ServletException{
        super.init();
        messages = new Vector<User>();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String message =request.getParameter("msg");
        String time =request.getParameter("time");

        User newMsg = new User();
        newMsg.setName(name);
        newMsg.setMsg(message);
        newMsg.setTime(time);
        messages.add(newMsg);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("Test  "+name);
        out.print("done");
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson msgs = new Gson();
        out.print(msgs.toJson(messages));
        System.out.println("********************************Test**************");
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
