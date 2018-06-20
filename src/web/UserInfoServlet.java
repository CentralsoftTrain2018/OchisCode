package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfoBean;

/**
 * ユーザー情報取得用サーブレット
 * 作成：功刀
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //セッションからユーザー情報を取得
        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean)session.getAttribute("userinfobean");

        //requestにユーザー情報のbeanをセット
        request.setAttribute( "bean", userBean );

        //ユーザー情報表示へ遷移
        RequestDispatcher disp = request.getRequestDispatcher("/userinfo.jsp");
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
