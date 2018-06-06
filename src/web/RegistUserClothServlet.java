package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//持ち服登録
/**
 * Servlet implementation class RegistUserClothServlet
 */
@WebServlet("/RegistUserClothServlet")
public class RegistUserClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistUserClothServlet()
    {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //値の取り出し
        request.getAttribute("color");
        request.getAttribute("pattern");
        request.getAttribute("category");
        request.getAttribute("size");
        System.out.print(request.getAttribute("color"));
        RequestDispatcher disp = request.getRequestDispatcher( "/listoutusercloth.jsp" );
        disp.forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
