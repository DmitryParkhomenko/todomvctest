package com.mytests;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class TodoMVCTest {
    @Test
    public void testCreateTask() {
        // Configuration.browser = "opera";
        //Configuration.timeout = 2000;
        open("http://todomvc4tasj.herokuapp.com/");
        $("#new-todo").setValue("do something").pressEnter();
        $("#new-todo").setValue("do something else").pressEnter();
        $$("#todo-list li").shouldHave(size(2));
        $$("#todo-list li").shouldHave(exactTexts("do something", "do something else"));


    }
}
