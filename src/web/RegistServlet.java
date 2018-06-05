package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
//ああ
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        System.out.println("RegistServletが実行されました。");
        String inputidStr = request.getParameter("id");
        String inputnameStr = request.getParameter("name");
        String inputsexStr = request.getParameter("sex");
        int inputNum = Integer.parseInt(inputidStr);
//        SexEnum inputSex = SexEnum.valueOf(inputsexStr);
//        KaiinnService kserv = new KaiinnService();

//        RegistBean bean = kserv.regist(inputNum,inputnameStr,inputSex);

//        request.setAttribute("bean", bean);

        RequestDispatcher disp = request.getRequestDispatcher("/regist.jsp");
        disp.forward(request, response);
    }

}
