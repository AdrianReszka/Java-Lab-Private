package com.mycompany.studentsdiary_swing;

import javax.swing.*;
import java.awt.*;

import Controller.MainMenuController;
import Controller.StudentListController;
import Model.StudentList;
import View.MainMenuView;
import View.StudentListView;

public class StudentsDiary_Swing {

    public static void main(String[] args) {

        StudentList studentList = new StudentList();
        StudentListView studentListView= new StudentListView();
        MainMenuController mainMenuController = new MainMenuController(studentList, studentListView);
        MainMenuView mainMenuView = new MainMenuView(mainMenuController);
        mainMenuView.displayMainMenu();
    }
}
