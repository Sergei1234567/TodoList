package indexServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(value = "/item/*")
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
            throws IOException {

        req.setCharacterEncoding("UTF8");

        final String newItem = req.getParameter("item");

        todoList.add(newItem);

        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("todoList", todoList);

        req.getRequestDispatcher("/view/todo-list-page.jsp").include(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF8");
        final String id = req.getParameter("value");
        if (id != null && !id.isEmpty()) {
            todoList.remove(id);
        }
        req.getRequestDispatcher("/").forward(new HttpServletRequestWrapper(req) {
            @Override
            public String getMethod() {
                String method = super.getMethod();
                if (method.equalsIgnoreCase("delete") || method.equalsIgnoreCase("put")) {
                    return "GET";
                } else {
                    return method;
                }
            }
        }, resp);
    }
}