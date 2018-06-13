package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.SexEnum;
import domain.SizeEnum;
import service.UserService;

/**
 * Servlet implementation class RegistUserServlet
 */

//ユーザー登録用サーブレット
//作成：功刀
@WebServlet("/RegistUserServlet")
public class RegistUserServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistUserServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    //登録
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println( "登録サーブレット" );
        //文字コード指定
        request.setCharacterEncoding("utf-8");
        //リクエストから値を取得
        String userIdStr =request.getParameter("userid");
        String passwordStr =request.getParameter("password");
        String userHeightStr =request.getParameter("userheight");
        String sizeStr =request.getParameter("size");
        String budgetStr =request.getParameter("budget");
        String sexStr =request.getParameter("sex");
        System.out.println(userIdStr+"-");
        //入力がnullでないか確認し、nullの場合別画面に遷移
        if(		userIdStr == "" ||
                passwordStr == "" ||
                userHeightStr == "" ||
                sizeStr == "" ||
                budgetStr == "" ||
                sexStr == "")
        {
            System.out.println( "NULL" );
            RequestDispatcher disp = request.getRequestDispatcher( "/nullerror.jsp" );
            disp.forward( request, response );
            return;
        }

        //数値が入力されているか確認し、数値でない場合は別画面に遷移
        if(!isNumber( userHeightStr )
                || !isNumber( budgetStr ))
        {
            RequestDispatcher disp = request.getRequestDispatcher( "/numbererror.jsp" );
            disp.forward( request, response );
            return;
        }
        //身長、サイズ、予算、性別を適切な型に変換
        int userHeight = Integer.parseInt( userHeightStr );
        SizeEnum size =SizeEnum.valueOf(sizeStr);
        int budget = Integer.parseInt( budgetStr );
        SexEnum sex = SexEnum.valueOf( sexStr );
        UserService userv =new UserService();
        //サービスに受け渡し
        userv.registUser( userIdStr, passwordStr, userHeight, size, budget, sex );

        System.out.println( "サーブレット：登録完了" );
        RequestDispatcher disp = request.getRequestDispatcher( "/login.html" );
        disp.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet( request, response );
    }

    //数値チェック
    private boolean isNumber(String str) {
        try
        {
            Integer.parseInt( str );
            return true;
        }catch (NumberFormatException e)
        {
            return false;
        }
    }
}
