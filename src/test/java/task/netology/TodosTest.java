package task.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForTodosFindTwoTasks(){
        SimpleTask simpleTask = new SimpleTask(1, "купить литые диски");
        String[] subtasks = {"диски", "болты"};
        Epic epic = new Epic(11, subtasks);
        Meeting meeting = new Meeting(111, "дипломная работа", "развитие ресурсов", "25.04.2023 12:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("диск");
        Task[] expected = {simpleTask, epic};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForTodosFindOneTask(){
        SimpleTask simpleTask = new SimpleTask(1, "купить литые диски");
        String[] subtasks = {"диски", "болты"};
        Epic epic = new Epic(11, subtasks);
        Meeting meeting = new Meeting(111, "дипломная работа", "развитие ресурсов", "25.04.2023 12:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("работа");
        Task[] expected = {meeting};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForTodosFindNoneTask() {
        SimpleTask simpleTask = new SimpleTask(1, "купить литые диски");
        String[] subtasks = {"диски", "болты"};
        Epic epic = new Epic(11, subtasks);
        Meeting meeting = new Meeting(111, "дипломная работа", "развитие ресурсов", "25.04.2023 12:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("машина");
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

}
