package View;

import Controller.MainMenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author adico
 */
public class MainMenuView {

    private MainMenuController mainMenuController;

    public MainMenuView(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }

    public void displayMainMenu() {
        JFrame frame = new JFrame("Students Diary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));

        JButton addStudentButton = new JButton("Add new student");
        addStudentButton.setMnemonic(KeyEvent.VK_1);
        addStudentButton.setToolTipText("Click to add a new student");
        addStudentButton.getAccessibleContext().setAccessibleName("Add student button");
        addStudentButton.getAccessibleContext().setAccessibleDescription("Button to add a new student, press Alt and 1 to activate");

        JButton addGradeButton = new JButton("Add grade to student");
        addGradeButton.setMnemonic(KeyEvent.VK_2);
        addGradeButton.setToolTipText("Click to add a grade to a student");
        addGradeButton.getAccessibleContext().setAccessibleName("Add grade button");
        addGradeButton.getAccessibleContext().setAccessibleDescription("Button to add a grade to a student, press Alt and 2 to activate");

        JButton removeStudentButton = new JButton("Remove student");
        removeStudentButton.setMnemonic(KeyEvent.VK_3);
        removeStudentButton.setToolTipText("Click to remove a student");
        removeStudentButton.getAccessibleContext().setAccessibleName("Remove student button");
        removeStudentButton.getAccessibleContext().setAccessibleDescription("Button to remove a student, press Alt and 3 to activate");

        JButton removeGradeButton = new JButton("Remove grade from student");
        removeGradeButton.setMnemonic(KeyEvent.VK_4);
        removeGradeButton.setToolTipText("Click to remove a grade from a student");
        removeGradeButton.getAccessibleContext().setAccessibleName("Remove grade button");
        removeGradeButton.getAccessibleContext().setAccessibleDescription("Button to remove a grade from a student, press Alt and 4 to activate");

        JButton displayStudentsButton = new JButton("Display all students");
        displayStudentsButton.setMnemonic(KeyEvent.VK_5);
        displayStudentsButton.setToolTipText("Click to display all students");
        displayStudentsButton.getAccessibleContext().setAccessibleName("Display students button");
        displayStudentsButton.getAccessibleContext().setAccessibleDescription("Button to display all students, press Alt and 5 to activate");

        JButton editStudentButton = new JButton("Edit student data");
        editStudentButton.setMnemonic(KeyEvent.VK_6);
        editStudentButton.setToolTipText("Click to edit student data");
        editStudentButton.getAccessibleContext().setAccessibleName("Edit student button");
        editStudentButton.getAccessibleContext().setAccessibleDescription("Button to edit student data, press Alt and 6 to activate");

        JButton editGradeButton = new JButton("Edit student grade");
        editGradeButton.setMnemonic(KeyEvent.VK_7);
        editGradeButton.setToolTipText("Click to edit a student's grade");
        editGradeButton.getAccessibleContext().setAccessibleName("Edit grade button");
        editGradeButton.getAccessibleContext().setAccessibleDescription("Button to edit a student's grade, press Alt and 7 to activate");

        JButton exitButton = new JButton("Exit");
        exitButton.setMnemonic(KeyEvent.VK_8);
        exitButton.setToolTipText("Click to exit the application");
        exitButton.getAccessibleContext().setAccessibleName("Exit button");
        exitButton.getAccessibleContext().setAccessibleDescription("Button to exit the application, press Alt and 8 to activate");

        addStudentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addGradeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeStudentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeGradeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayStudentsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editStudentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editGradeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addStudentButton.addActionListener(e -> mainMenuController.showAddStudentDialog());
        addGradeButton.addActionListener(e -> mainMenuController.showAddGradeToStudentDialog());
        removeStudentButton.addActionListener(e -> mainMenuController.showRemoveStudentDialog());
        removeGradeButton.addActionListener(e -> mainMenuController.showRemoveGradeDialog());
        displayStudentsButton.addActionListener(e -> mainMenuController.showStudentListDialog());
        editStudentButton.addActionListener(e -> mainMenuController.showEditStudentDialog());
        editGradeButton.addActionListener(e -> mainMenuController.showEditGradeDialog());
        exitButton.addActionListener(e -> mainMenuController.showExitDialog());

        mainPanel.add(addStudentButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(addGradeButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(removeStudentButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(removeGradeButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(displayStudentsButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(editStudentButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(editGradeButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(exitButton);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

}
