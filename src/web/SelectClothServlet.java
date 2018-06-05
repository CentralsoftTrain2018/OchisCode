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

import bean.SelectBean;
import domain.CategoryEnum;
import domain.ColorEnum;
import domain.PatternEnum;
import domain.SizeEnum;



/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/SelectClothServlet")
public class SelectClothServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectClothServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //		// TODO Auto-generated method stub
        //		response.getWriter().append("Served at: ").append(request.getContextPath());

        SelectBean bean =new SelectBean();

        List <PatternEnum> list =new ArrayList<PatternEnum>();
        for(PatternEnum pe : PatternEnum.values()) {
            list.add(pe);
        }
        bean.setPatternlist( list );
        List <ColorEnum> list2 =new ArrayList<ColorEnum>();
        for(ColorEnum ce : ColorEnum.values()) {
            list2.add(ce);
        }
        bean.setColorlist( list2 );
        List <CategoryEnum> list3 =new ArrayList<CategoryEnum>();
        for(CategoryEnum cae : CategoryEnum.values()) {
            list3.add(cae);
        }
        bean.setCategorylist( list3 );
        List <SizeEnum> list4 =new ArrayList<SizeEnum>();
        for(SizeEnum se : SizeEnum.values()) {
            list4.add(se);
        }
        bean.setSizelist( list4 );

        request.setAttribute( "bean", bean );

        RequestDispatcher disp = request.getRequestDispatcher("/selectcloth.jsp");
        disp.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);



    }

}
