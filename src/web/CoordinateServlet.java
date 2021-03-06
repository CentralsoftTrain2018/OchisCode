package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CoordinateDisplayBean;
import bean.UserInfoBean;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;
import service.ClothService;
import service.CodeService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/CoordinateServlet")

//服のシミュレーション画面
public class CoordinateServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoordinateServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    //シミュレーション部分(初回表示)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        CoordinateDisplayBean bean = new CoordinateDisplayBean();
        ClothService cserv = new ClothService();
        CodeService codeserv = new CodeService();

        //sessionでユーザの情報を取得
        HttpSession session = request.getSession();
        UserInfoBean userBean = (UserInfoBean) session.getAttribute( "userinfobean" );

        //デフォルトの服をセット(上)
        bean.setTopCategory( CategoryEnum.Tシャツ );
        bean.setTopColor( ColorEnum.白 );
        bean.setTopPattern( PatternEnum.無地 );
        bean.setTopSize( SizeEnum.M );

        //デフォルトの服をセット(下)
        bean.setBottomCategory( CategoryEnum.半ズボン );
        bean.setBottomColor( ColorEnum.白 );
        bean.setBottomPattern( PatternEnum.無地 );
        bean.setBottomSize( SizeEnum.M );
        //ユーザーの性別をセット
        bean.setSex( userBean.getSex() );

        //持ち服を上下に分けて取得
        bean.setUscbean( cserv.userSaleCloth( userBean.getUserid() ) );

        //コーデ情報を取得
        bean.setList( codeserv.coordinateDisplay( userBean.getUserid() ) );

        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/coordinatedisplay.jsp" );
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
