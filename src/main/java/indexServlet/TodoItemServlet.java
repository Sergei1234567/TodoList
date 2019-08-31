package indexServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(value = "/item")
public class TodoItemServlet extends HttpServlet {
    private List<String> todoList;

    public void init() {

        final Object todoList = getServletContext().getAttribute("todoList");

        if (todoList == null || !(todoList instanceof CopyOnWriteArrayList)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.todoList = (CopyOnWriteArrayList<String>) todoList;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

        final String newItem = req.getParameter("item");

        todoList.add(newItem);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
