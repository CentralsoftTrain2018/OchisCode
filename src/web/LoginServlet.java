package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ListOutUserClothBean;
import bean.UserInfoBean;
import service.ClothService;
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
        //TODO サービスへID,パスを渡す
        UserService userv= new UserService();
        //TODO 結果に応じて遷移先を変更
        UserInfoBean userBean = new UserInfoBean();


        userBean=userv.checkUser(userid, password);

        if(!userBean.isUserExist())
        {//false
         // TODO エラー画面へ
           System.out.println("ログイン失敗");


           //エラー画面へ遷移
            RequestDispatcher disp = request.getRequestDispatcher( "/loginerror.html" );
            disp.forward( request, response );

        }
        System.out.println("ログイン成功");
        ClothService cserv = new ClothService();
        ListOutUserClothBean bean;

        bean = cserv.userCloth( userBean.getUserid(), "", "", "");//userIdは定数
        session.setAttribute("userclothbean", bean);

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
