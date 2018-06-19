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
 * ユーザー退会(ユーザー情報削除)
 * 作成：功刀
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("ユーザー退会サーブレット");

        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean)request.getSession().getAttribute("userinfobean");

        UserService userv = new UserService();
        //サービス層へユーザーID受け渡し
        userv.deleteUser( userBean.getUserid() );
        //セッションで保持しているユーザー情報を削除
        session.removeAttribute("userinfobean");

        //
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
