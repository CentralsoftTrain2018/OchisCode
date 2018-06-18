package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfoBean;
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
        UserInfoBean userBean = (UserInfoBean) request.getSession().getAttribute( "userinfobean" );

        if (userheightStr != null)
        {
            userBean.setUserheight( Integer.parseInt( userheightStr ) );
        }

        if (sizeStr != null)
        {
            userBean.setSize( SizeEnum.valueOf( sizeStr ) );
        }
        //TODO 以降のnullチェック
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
