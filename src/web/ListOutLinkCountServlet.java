package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListOutLinkCountBean;
import service.ClothService;

/**
 * 管理者用クリック数確認画面に遷移
 */
@WebServlet("/ListOutLinkCountServlet")
public class ListOutLinkCountServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOutLinkCountServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println( "管理者用遷移サーブレット" );
        ClothService cserv =new ClothService();
        //クリック数をDBから取得
        ListOutLinkCountBean bean = cserv.getAllClothCount();
        request.setAttribute( "bean", bean );
        //一覧画面に遷移
        System.out.println( "jspに遷移" );

        
        RequestDispatcher disp = request.getRequestDispatcher("/listoutlinkcount.jsp");
        disp.forward(request, response);
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
