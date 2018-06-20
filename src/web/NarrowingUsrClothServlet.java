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

/**
 * Servlet implementation class NarrowingUsrClothServlet
 */
@WebServlet("/NarrowingUsrClothServlet")
public class NarrowingUsrClothServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NarrowingUsrClothServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );

      //sessionでユーザの情報を取得
        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean) session.getAttribute( "userinfobean" );

        ListOutUserClothBean bean = new ListOutUserClothBean();

        ClothService cserv = new ClothService();

        int page = Integer.parseInt(request.getParameter("page"));
        int offsetnum = 5 * (page - 1);
        String offset = " offset " + offsetnum + " ";

        String narrow = request.getParameter("narrow");
        bean = cserv.userCloth( userBean.getUserid(), narrow, " limit 5 ", offset);//userIdは定数
        bean.setPage(page);

        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/listoutusercloth.jsp" );
        disp.forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
