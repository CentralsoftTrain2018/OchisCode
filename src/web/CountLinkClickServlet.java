package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClothService;

/**
 * Servlet implementation class CountLinkClickServlet
 */
@WebServlet("/CountLinkClickServlet")
public class CountLinkClickServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountLinkClickServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println( "クリック数カウント用" );
        request.setCharacterEncoding( "utf-8" );

        int clothid = Integer.parseInt( request.getParameter( "clothid" ));
        ClothService cserv =new ClothService();

        cserv.countPlus( clothid );

        //リンク先のECサイトへ遷移
        String linkURL = request.getParameter( "URL" );
        response.sendRedirect(linkURL);
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
