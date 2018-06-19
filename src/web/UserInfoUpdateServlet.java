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
import domain.SexEnum;
import domain.SizeEnum;

/**
 * 入力をもとにユーザー情報を更新するサーブレット
 * 作成：功刀
 */
@WebServlet("/UserInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoUpdateServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding( "utf-8" );
        String userheightStr = request.getParameter( "userheight" );
        String sizeStr = request.getParameter( "size" );
        String budgetStr = request.getParameter( "budget" );
        String sexStr = request.getParameter( "sex" );

        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean) session.getAttribute( "userinfobean" );

        //入力があったかどうかの確認を行い、入力があった場合はユーザー情報のBeanの値を更新
        //身長
        if (userheightStr != null)
        {
            userBean.setUserheight( Integer.parseInt( userheightStr ) );
        }
        //性別
        userBean.setSize( SizeEnum.valueOf( sizeStr ) );
        //予算
        if (budgetStr != null)
        {
            userBean.setBudget( Integer.parseInt( budgetStr ) );
        }
        //性別
        if (sexStr != null)
        {
            userBean.setSex( SexEnum.valueOf( sexStr ) );
        }

        //TODO サービス層へデータを受け渡し、DBを更新する


        //セッションにユーザー情報をセット
        session.setAttribute( "userinfobean", userBean );
        //requestにユーザー情報をセット
        request.setAttribute( "bean", userBean );
        //ユーザー情報表示へ遷移
        RequestDispatcher disp = request.getRequestDispatcher( "/userinfo.jsp" );
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
