package task.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void matchesForSimpleTaskTrue(){
        SimpleTask simpleTask = new SimpleTask(12, "Забрать заказ");
        boolean actual = simpleTask.matches("заказ");

        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForSimpleTaskFalse(){
        SimpleTask simpleTask = new SimpleTask(12, "Забрать заказ");
        boolean actual = simpleTask.matches("собаку");

        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForEpicTrue(){
        Epic epic = new Epic(8, new String[]{"отправить письмо", "забрать заказ", "забарать посылку"});
        boolean actual = epic.matches("заказ");

        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForEpicFalse(){
        Epic epic = new Epic(8, new String[]{"отправить письмо", "забрать заказ", "забарать посылку"});
        boolean actual = epic.matches("сходить");

        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingTrueForTopic(){
        Meeting meeting = new Meeting(7, "дипломная работа", "развитие ресурсов", "25.04.2023 12:00");
        boolean actual = meeting.matches("диплом");

        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingFalseForTopic(){
        Meeting meeting = new Meeting(7, "дипломная работа", "развитие ресурсов", "25.04.2023 12:00");
        boolean actual = meeting.matches("курсовая");

        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingTrueForProject(){
        Meeting meeting = new Meeting(7, "дипломная работа", "развитие ресурсов", "25.04.2023 12:00");
        boolean actual = meeting.matches("ресурс");

        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingFalseForProject(){
        Meeting meeting = new Meeting(7, "дипломная работа", "развитие ресурсов", "25.04.2023 12:00");
        boolean actual = meeting.matches("вода");

        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
