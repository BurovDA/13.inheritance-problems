package Netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

          @Test
        public void searchInSimpleTask() {
            SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
            Assertions.assertTrue(simpleTask.matches("Позвонить"));
        }
        @Test
        public void NotFoundInSimpleTask() {
            SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
            Assertions.assertFalse(simpleTask.matches("Позвонить друзьям"));
        }
        @Test
        public void searchInEpic() {
            String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
            Epic epic = new Epic(55, subtasks);
            Assertions.assertTrue(epic.matches("Хлеб"));
        }
        @Test
        public void NotFoundInEpic() {
            String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
            Epic epic = new Epic(55, subtasks);
            Assertions.assertFalse(epic.matches("Утро"));
        }
        @Test
        public void searchInMeeting() {
            Meeting meeting = new Meeting(
                    555,
                    "Выкатка 3й версии приложения",
                    "Приложение НетоБанка",
                    "Во вторник после обеда"
            );
            Assertions.assertTrue(meeting.matches("Во вторник"));
        }
        @Test
        public void NotFindInMeetingTopic() {
            Meeting meeting = new Meeting(
                    555,
                    "Выкатка 3й версии приложения",
                    "Приложение НетоБанка",
                    "Во вторник после обеда"
            );
            Assertions.assertTrue(meeting.matches("приложения"));
        }
        @Test
        public void searchInMeetingInProject() {
            Meeting meeting = new Meeting(
                    555,
                    "Выкатка 3й версии приложения",
                    "Приложение НетоБанка",
                    "Во вторник после обеда"
            );
            Assertions.assertTrue(meeting.matches("НетоБанка"));
        }
        @Test
        public void NotFoundInMeeting() {
            Meeting meeting = new Meeting(
                    555,
                    "Выкатка 3й версии приложения",
                    "Приложение НетоБанка",
                    "Во вторник после обеда"
            );
            Assertions.assertFalse(meeting.matches("ужина"));
        }
    }