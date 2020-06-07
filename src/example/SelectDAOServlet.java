package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
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
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
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


        System.out.println(username + "," + password);

        PrintWriter out = response.getWriter();
        out.print("<html><body>");

        EmpDAO dao = new EmpDAO();
        ArrayList<EmpDTO> list = dao.select();

        ArrayList<String> compare = new ArrayList<>();

        for (EmpDTO dto : list) {
            String emp_id = dto.getId();
            String ename = dto.getName();
            int salary = dto.getSalary();
            String depart = dto.getDepart();

            compare.add(emp_id);
            compare.add(depart);

            out.print(emp_id + "\t" + ename + "\t" + salary + "\t" + depart + "<br>");
        }
        for (String comp : compare) {
            if (comp.equals(username)) {
                System.out.println("일치");
                break;
            } else {
                System.out.println("불일치");
            }

        }

        out.print("</body></html>");
    }

}
