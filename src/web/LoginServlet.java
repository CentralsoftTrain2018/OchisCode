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
import service.UserService;

/**
 * ログイン用サーブレット
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println( "ログインサーブレット" );
        HttpSession session = request.getSession();
        //入力情報の取得
        String userid = request.getParameter( "userid" );
        String password = request.getParameter( "password" );

        UserService userv = new UserService();

        UserInfoBean userBean = userv.checkUser( userid, password );

        if (!userBean.isUserExist())
        {
            System.out.println( "ログイン失敗" );
            //エラー画面へ遷移
            RequestDispatcher disp = request.getRequestDispatcher( "/loginerror.html" );
            disp.forward( request, response );
        }
        System.out.println( "ログイン成功" );

        //管理者の場合管理者画面へ遷移する
        if (userBean.isUserExist() && userBean.getUserid().equals( "admin" ))
        {
            System.out.println( "管理者としてログイン" );
            RequestDispatcher disp = request.getRequestDispatcher( "ListOutLinkCountServlet" );
            disp.forward( request, response );
            return;
        }

        session.setAttribute( "userinfobean", userBean );
        //持ち服一覧へ遷移

        RequestDispatcher disp = request.getRequestDispatcher( "ListOutSaleClothServlet" );
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
