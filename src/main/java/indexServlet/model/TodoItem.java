package indexServlet.model;

public class TodoItem {
    private String task;
    private int id;

    public TodoItem(String task, int id) {
        this.task = task;
        this.id = id;
    }
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
