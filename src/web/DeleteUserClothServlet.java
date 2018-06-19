package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClothService;

/**
 * Servlet implementation class DeleteUserClothServlet
 */
@WebServlet("/DeleteUserClothServlet")
public class DeleteUserClothServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserClothServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    //作成者：中村
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clothid = Integer.parseInt(request.getParameter("clothid"));
        System.out.println(clothid);
        ClothService cs = new ClothService();
        cs.deleteUserCloth(clothid);
        RequestDispatcher disp = request.getRequestDispatcher( "ListOutUserClotheServlet" );
        disp.forward( request, response );
    }

}
