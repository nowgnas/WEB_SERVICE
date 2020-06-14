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


/*TODO 끌어올 데이터 좀 생각해보기*/

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
        response.setContentType("text/html;charset=EUC-KR");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String userinfoget = username + password;

        PrintWriter out = response.getWriter();

        EmpDAO dao = new EmpDAO();
        ArrayList<EmpDTO> list = dao.select();

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
                request.setAttribute("name", username);

                ServletContext app = this.getServletContext();
                RequestDispatcher dispatcher = app.getRequestDispatcher("/index.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException e) {
                    out.println(e);
                }

            } else {
                out.println("<script>alert('아이디나 패스워드가 틀렸습니다.'); location.href='public/Login.jsp';</script>");
                break;
            }
        }

    }
}
