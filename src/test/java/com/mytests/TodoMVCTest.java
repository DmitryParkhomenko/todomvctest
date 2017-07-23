package com.mytests;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TodoMVCTest {

    @Test
    public void testTasksLifeCircle() {
        openPage();
        createFourTasks();
        checkListSize();
        deleteTaskTwo();
        markTaskFourAsCompleted();
        clearCompleted();
        markAllAsCompleted();
        clearAllAsCompleted();
        checkFinalListSize();
    }

    public static void openPage() {
        open("https://todomvc4tasj.herokuapp.com/#/");
    }

    public void createFourTasks() {
        /*
        1 create task1
        2 create task2
        3 create task3
        4 create task4
         */
        $("#new-todo").setValue("task1").pressEnter();
        $("#new-todo").setValue("task2").pressEnter();
        $("#new-todo").setValue("task3").pressEnter();
        $("#new-todo").setValue("task4").pressEnter();
    }

    public void checkListSize() {
        $$("#todo-list li").shouldHaveSize(4);
    }

    public void deleteTaskTwo() {
        //5 delete task2
        $$("#todo-list li").findBy(exactText("task2")).hover().find(".destroy").click();
    }

    public void markTaskFourAsCompleted() {
        //6 mark task4 as completed
        $$("#todo-list li").findBy(exactText("task4")).find(".toggle").click();
    }

    public void clearCompleted() {
        //7 clear completed
        $$("#todo-list li").findBy(exactText("task4")).hover().find(".destroy").click();
    }

    public void markAllAsCompleted() {
        //8 mark all as completed
        $$("#todo-list li").findBy(exactText("task1")).find(".toggle").click();
        $$("#todo-list li").findBy(exactText("task3")).find(".toggle").click();
    }

    public void clearAllAsCompleted() {
        //9 clear completed
        $$("#todo-list li").findBy(exactText("task1")).hover().find(".destroy").click();
        $$("#todo-list li").findBy(exactText("task3")).hover().find(".destroy").click();
    }

    public void checkFinalListSize() {
        $$("#todo-list li").shouldHaveSize(0);
    }
}