package indexServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebListener
public class ContextListener implements ServletContextListener {
    private List<String> todoList;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext = servletContextEvent.getServletContext();

        todoList = new CopyOnWriteArrayList();

        servletContext.setAttribute("todoList", todoList);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Close recourse.
        todoList = null;
    }
}
