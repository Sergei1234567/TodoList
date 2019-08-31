package indexServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@WebServlet(value = "/")
public class IndexServlet extends HttpServlet {
    private List<String> todoList;

    @Override
    public void init() {
        final Object todoList = getServletContext().getAttribute("todoList");

        if (todoList == null || !(todoList instanceof CopyOnWriteArrayList)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.todoList = (CopyOnWriteArrayList<String>) todoList;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.setAttribute("todoList", todoList);

        req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
    }

}
