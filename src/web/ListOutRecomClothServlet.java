package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LineRecomClothBean;
import bean.ListOutRecomClothBean;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import service.ClothService;

/**
 * Servlet implementation class RegistServlet
 */
//持ち服を基に一覧表示
@WebServlet("/ListOutRecomClothServlet")
public class ListOutRecomClothServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOutRecomClothServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    //オススメ一覧表示
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ListOutRecomClothBean bean = new ListOutRecomClothBean();
        LineRecomClothBean recordbean = new LineRecomClothBean();
        LineRecomClothBean recordbean1 = new LineRecomClothBean();

        //ListOutRecomClothBean bean =cs.UserCloth();

        //持ち服の表示
        //TODO 持ち服情報を取っているが、beanにまとめて次のページに送れていない。
//        ClothService cserv = new ClothService();
//        cserv.userCloth( 1 );//userId=1の持ち服情報のbeanが帰ってくる。
//        //bean2= cserv.UserCloth();

        ClothService cs = new ClothService();
        try {
            cs.getRecommendCloth(1);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        recordbean.setCategory( CategoryEnum.半ズボン );
        recordbean.setColor( ColorEnum.白 );
        recordbean.setPattern( PatternEnum.無地 );

        recordbean1.setCategory( CategoryEnum.Tシャツ );
        recordbean1.setColor( ColorEnum.白 );
        recordbean1.setPattern( PatternEnum.水玉 );

        List<LineRecomClothBean> list = new ArrayList<LineRecomClothBean>();
        list.add( recordbean );
        list.add( recordbean1 );
        bean.setList( list );
        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/listoutrecomcloth.jsp" );
        disp.forward( request, response );
        doGet( request, response );
    }

}
