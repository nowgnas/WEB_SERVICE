package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectDAOServlet
 */
@WebServlet("/SelectDAOServlet")
public class SelectDAOServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectDAOServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Java Bean을 사용하여 사용자 정보를 확인한다.*/
        response.setContentType("text/html;charset=EUC-KR");

        /*로그인시 사용자가 입력한 ID*/
        String username = request.getParameter("username");
        /*로그인시 사용자가 입력한 PW*/
        String password = request.getParameter("password");

        /*사용자 ID+PW*/
        String userinfoget = username + password;

        PrintWriter out = response.getWriter();

        EmpDAO dao = new EmpDAO();
        ArrayList<EmpDTO> list = dao.select();

        /*MySql에 있는 사용자 정보를 저장할 리스트*/
        ArrayList<String> compare = new ArrayList<>();

        for (EmpDTO dto : list) {
            String id = dto.getId();
            String pw = dto.getPw();

            String userinfo = id + pw;
            compare.add(userinfo);
        }

        for (String comp : compare) {
            if (comp.equals(userinfoget)) {
                System.out.println("일치");
                /*메인 페이지에 넘길 사용자ID*/
                request.setAttribute("name", username);

                ServletContext app = this.getServletContext();
                RequestDispatcher dispatcher = app.getRequestDispatcher("/index.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    out.println(e);
                }

                /*로그인 실패시 경고창 띄우기*/
            } else {
                out.println("<script>alert('아이디나 패스워드가 틀렸습니다.'); location.href='public/Login.jsp';</script>");
                break;
            }
        }

    }
}
