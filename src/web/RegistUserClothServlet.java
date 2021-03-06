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
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import service.ClothService;

//持ち服登録
/**
 * Servlet implementation class RegistUserClothServlet
 */
@WebServlet("/RegistUserClothServlet")
public class RegistUserClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistUserClothServlet()
    {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding( "utf-8" );

      //sessionでユーザの情報を取得
        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean) session.getAttribute( "userinfobean" );

        //値の取り出し
        String color = request.getParameter( "color" );
        String pattern = request.getParameter( "pattern" );
        String category = request.getParameter( "category" );
        String size = request.getParameter( "size" );

        String id = userBean.getUserid();

        ClothService cloth = new ClothService();

        cloth.registCloth( id, SizeEnum.valueOf( size ), ColorEnum.valueOf( color ),
                PatternEnum.valueOf( pattern ), CategoryEnum.valueOf( category ) );

        RequestDispatcher disp = request.getRequestDispatcher( "/ListOutUserClotheServlet" );
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
