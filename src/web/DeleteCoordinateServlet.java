package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CodeService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/DeleteCoordinateServlet")

//服のシミュレーション画面
public class DeleteCoordinateServlet extends HttpServlet
{
   private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCoordinateServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    //モデルが着ている服をもってくる
    //作成者<野間>
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding( "utf-8" );
        //値の取り出し

        String CodenumStr = request.getParameter("code");
        int CodeNum=Integer.parseInt(CodenumStr);

        CodeService cserv=new CodeService();
        cserv.deleteCoordinate(CodeNum);


        RequestDispatcher disp = request.getRequestDispatcher( "/CoordinateServlet" );
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