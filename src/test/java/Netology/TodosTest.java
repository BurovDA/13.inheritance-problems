package Netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void searchFindOneTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Выкатка приложения");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
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
        Task[] actual = todos.search("Приложение");
        Task[] expected = {meeting};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchFindTwoTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Протестировать приложения");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
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
        Task[] actual = todos.search("приложения");
        Task[] expected = {simpleTask, meeting};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNotFoundTwoTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Протестировать приложения");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
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
        Task[] actual = todos.search("В среду");
        Task[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchFindAllTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Протестировать приложения");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
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

        Task[] actual = todos.findAll();
        Task[] expected = {simpleTask, epic, meeting};

        Assertions.assertArrayEquals(expected, actual);
    }
}