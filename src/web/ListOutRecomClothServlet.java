package web;

import java.io.IOException;
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

/**
 * Servlet implementation class RegistServlet
 */
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
        LineRecomClothBean recordbean =new LineRecomClothBean();
        LineRecomClothBean recordbean1 =new LineRecomClothBean();

        recordbean.setCategory(CategoryEnum.半ズボン);
        recordbean.setColor( ColorEnum.白 );
        recordbean.setPattern( PatternEnum.無地 );

        recordbean1.setCategory(CategoryEnum.Tシャツ);
        recordbean1.setColor( ColorEnum.白 );
        recordbean1.setPattern( PatternEnum.水玉 );

        List<LineRecomClothBean> list =new ArrayList<>();
        list.add( recordbean );
        list.add( recordbean1 );
        bean.setList( list );
        //jspに遷移
        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/listoutrecomcloth.jsp" );
        disp.forward( request, response );
    }

}
