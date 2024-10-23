package Controller;

import Model.Grade;
import Model.Student;
import Model.StudentAlreadyExistsException;
import Model.StudentList;
import View.MainMenuView;
import View.StudentListView;

import javax.swing.*;
import java.awt.*;

public class MainMenuController {

    private StudentListController studentListController;
    private MainMenuView mainMenuView;

    public MainMenuController(StudentList studentList, StudentListView studentListView) {
        studentListController = new StudentListController(studentList, studentListView);
        mainMenuView = new MainMenuView(this);
    }

    public void showAddStudentDialog() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Surname:"));
        JTextField surnameField = new JTextField();
        panel.add(surnameField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Add new student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String surname = surnameField.getText();
            studentListController.createNewStudent(id, name, surname);
            JOptionPane.showMessageDialog(null, "Student added successfully!");
        }
    }

    public void showAddGradeToStudentDialog(){

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Grade:"));
        JTextField gradeField = new JTextField();
        panel.add(gradeField);

        panel.add(new JLabel("Teacher:"));
        JTextField teacherField = new JTextField();
        panel.add(teacherField);

        panel.add(new JLabel("Subject:"));
        JTextField subjectField = new JTextField();
        panel.add(subjectField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Add grade to student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String grade = gradeField.getText().replace(',','.');
            String teacher = teacherField.getText();
            String subject = subjectField.getText();
            studentListController.addGradeToStudent(id, grade, teacher, subject);
            JOptionPane.showMessageDialog(null, "Grade added successfully!");
        }
    }

    public void showRemoveStudentDialog() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Remove student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            studentListController.removeStudent(id);
            JOptionPane.showMessageDialog(null, "Student removed successfully!");
        }
    }

    public void showRemoveGradeDialog() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Grade index:"));
        JTextField gradeIndexField = new JTextField();
        panel.add(gradeIndexField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Remove grade from student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            int gradeIndex = Integer.parseInt(gradeIndexField.getText()) - 1;
            studentListController.removeGradeFromStudent(id, gradeIndex);
            JOptionPane.showMessageDialog(null, "Grade removed successfully!");
        }
    }

    public void showEditStudentDialog() {

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("New name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("New surname:"));
        JTextField surnameField = new JTextField();
        panel.add(surnameField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Edit student data", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String newName = nameField.getText();
            String newSurname = surnameField.getText();
            studentListController.editStudentData(id, newName, newSurname);
            JOptionPane.showMessageDialog(null, "Student data updated successfully!");
        }
    }

    public void showEditGradeDialog() {

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Grade index:"));
        JTextField gradeIndexField = new JTextField();
        panel.add(gradeIndexField);

        panel.add(new JLabel("New grade:"));
        JTextField newGradeField = new JTextField();
        panel.add(newGradeField);

        panel.add(new JLabel("New teacher:"));
        JTextField newTeacherField = new JTextField();
        panel.add(newTeacherField);

        panel.add(new JLabel("New subject:"));
        JTextField newSubjectField = new JTextField();
        panel.add(newSubjectField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Edit student grade", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            int gradeIndex = Integer.parseInt(gradeIndexField.getText()) - 1;
            String newGrade = newGradeField.getText();
            String newTeacher = newTeacherField.getText();
            String newSubject = newSubjectField.getText();
            studentListController.editGradeForStudent(id, gradeIndex, Double.parseDouble(newGrade), newTeacher, newSubject);
            JOptionPane.showMessageDialog(null, "Grade updated successfully!");
        }
    }

    public void showStudentListDialog() {
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        for (Student student : studentListController.getStudentList().getStudents()) {
            textArea.append("ID: " + student.getId() + ", Name: " + student.getName() + ", Surname: " + student.getSurname() + "\n");
            for (Grade grade : student.getGrades()) {
                textArea.append("  - Grade: " + grade.getValue() + ", Teacher: " + grade.getTeacher() + ", Subject: " + grade.getSubject() + "\n");
            }
            textArea.append("\n");
        }

        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Students List", JOptionPane.INFORMATION_MESSAGE);
    }



    public void showExitDialog() {
        System.exit(0);
    }
}
