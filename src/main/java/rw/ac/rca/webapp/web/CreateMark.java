package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.MarkDAO;
import rw.ac.rca.webapp.dao.impl.MarkDAOImpl;
import rw.ac.rca.webapp.orm.Mark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class CreateCourse
 */
public class CreateMark extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MarkDAO markDAO  = MarkDAOImpl.getInstance();



    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMark() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);

        if (pageRedirect != null) {
            System.out.println("The print statement is and the only is: " + pageRedirect);
            if (pageRedirect.equals("createmark")) {

                request.getRequestDispatcher("WEB-INF/createMark.jsp").forward(request, response);
            } else {
                request.setAttribute("CreateUsererror ", "No user found");
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("CreateUsererror ", "No user found");
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");

        if (pageRedirect != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (pageRedirect.equals("createmark")) {
//

                Mark mark = new Mark();



                mark.setAverageMarks(Integer.parseInt(request.getParameter("averageMarks")));
                mark.setCourseName(request.getParameter("courseName"));
                mark.setInstructorName(request.getParameter("instructorName"));

                // Saving the course;
                try {
                    markDAO.saveMark(mark);
                    request.setAttribute("successMark", "Successfully created the Marks");
                    request.getRequestDispatcher("WEB-INF/createMark.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("CreateMarkserror", "Failed to create the Marks");
                    request.getRequestDispatcher("WEB-INF/createMark.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }
}