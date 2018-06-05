package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LineRecomClothBean;
import bean.ListOutRecomClothBean;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/ListOutRecomClothServlet")
public class ListOutRecomClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOutRecomClothServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    //
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //
        ListOutRecomClothBean bean = new ListOutRecomClothBean();
        LineRecomClothBean recordbean =new LineRecomClothBean();
        LineRecomClothBean recordbean1 =new LineRecomClothBean();
        
        
        
        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/listoutrecomcloth.jsp" );
        disp.forward( request, response );
    }

}
