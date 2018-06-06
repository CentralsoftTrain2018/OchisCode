package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SelectBean;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/SelectClothServlet")
public class SelectClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectClothServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    //シミュレーション部分
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String colorStr = request.getParameter("color");
        String patternStr = request.getParameter( "pattern" );
        String categoryStr = request.getParameter( "category" );
        String sizeStr = request.getParameter("size");

        SelectBean bean = new SelectBean();

        request.setAttribute( "bean", bean );

        RequestDispatcher disp = request.getRequestDispatcher( "/selectcloth.jsp" );
        disp.forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet( request, response );

    }

}
