package Controller;

import Model.MainMenu;
import Model.MessagePrinter;
import View.MainMenuView;
import java.util.Scanner;

/**
 * Controller responsible for handling the main menu interactions in the application.
 * It coordinates actions between the view and the student list controller.
 *
 * @author Adrian Reszka
 * @version 1.0
 */
public class MainMenuController {

    /**
     * A scanner object used to capture user input from the console for general menu selections and numeric inputs.
     */
    private Scanner scanner;

    /**
     * A scanner object configured to capture input from the console, specifically using a newline as the delimiter.
     */
    private Scanner spacebarScanner;

    /**
     * Model class representing the main menu options.
     */
    private MainMenu mainMenu;

    /**
     * View class responsible for displaying the main menu to the user.
     */
    private MainMenuView menuView;

    /**
     * Controller responsible for managing student-related operations.
     */
    private StudentListController studentListController;

    /**
     * Constructor for MainMenuController.
     * Initializes the scanners, view, model, and student list controller.
     *
     * @param studentListController The controller managing student-related operations.
     * @param menuView              The view responsible for displaying the main menu.
     */
    public MainMenuController(StudentListController studentListController, MainMenuView menuView) {
        this.scanner = new Scanner(System.in);
        this.spacebarScanner = new Scanner(System.in).useDelimiter("\n");
        this.studentListController = studentListController;
        this.menuView = menuView;
        this.mainMenu = new MainMenu();
    }

    /**
     * Starts the main menu loop. It repeatedly shows the menu, gets the user's choice,
     * and invokes the corresponding action based on the selection.
     */
    public void start() {
        boolean running = true;

        while (running) {
            menuView.showMenu(mainMenu.getMenuOptions());
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGradeToStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    removeGradeFromStudent();
                    break;
                case 5:
                    displayStudents();
                    break;
                case 6:
                    editStudentData();
                    break;
                case 7:
                    editStudentGrade();
                    break;
                case 8:
                    menuView.exitingProgramMessage();
                    running = false;
                    break;
                default:
                    menuView.printWrongOptionMessage();
            }
        }
    }

    /**
     * Gets the user's menu choice as an integer.
     *
     * @return The chosen menu option as an integer.
     */
    private int getMenuChoice() {
        return scanner.nextInt();
    }

    /**
     * Captures the student ID input from the user.
     *
     * @return The entered student ID as an integer.
     */
    private int getStudentIdInput() {
        int id = -1;
        while (true) {
            menuView.enterStudentIdMessage();
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                return id;
            } else {
                menuView.printInvalidIdInputMessage();
                scanner.next();  // Clear invalid input
                return -1;
            }
        }
    }

    /**
     * Captures the student name input from the user.
     *
     * @return The entered student name as a string.
     */
    private String getStudentNameInput() {
        menuView.enterStudentNameMessage();
        return scanner.next();
    }

    /**
     * Captures the student surname input from the user.
     *
     * @return The entered student surname as a string.
     */
    private String getStudentSurnameInput() {
        menuView.enterStudentSurnameMessage();
        return scanner.next();
    }

    /**
     * Captures the grade input from the user.
     *
     * @return The entered grade value as a string.
     */
    private String getGradeInput() {
        menuView.enterStudentGradeMessage();
        return scanner.next();
    }

    /**
     * Captures the teacher's name input from the user.
     *
     * @return The entered teacher name as a string.
     */
    private String getTeacherInput() {
        menuView.enterTeacherNameMessage();
        return spacebarScanner.next();
    }

    /**
     * Captures the subject name input from the user.
     *
     * @return The entered subject name as a string.
     */
    private String getSubjectInput() {
        menuView.enterSubjectNameMessage();
        return spacebarScanner.next();
    }

    /**
     * Captures the grade index input for removal or editing from the user.
     *
     * @return The entered grade index as an integer (1-based index).
     */
    private int getGradeIndexInput() {
        menuView.enterGradeIndexMessage();
        return scanner.nextInt();
    }

    /**
     * Adds a new student using inputs from the view.
     */
    private void addStudent() {
        int id = getStudentIdInput();
        if (id == -1) {
            return;
        }
        String name = getStudentNameInput();
        String surname = getStudentSurnameInput();
        studentListController.createNewStudent(id, name, surname);
    }

    /**
     * Adds a grade to an existing student using inputs from the view.
     */
    private void addGradeToStudent() {
        int studentId = getStudentIdInput();
        if (studentId == -1) {
            return;
        }
        String grade = getGradeInput().replace(',', '.');
        String teacher = getTeacherInput();
        String subject = getSubjectInput();
        studentListController.addGradeToStudent(studentId, grade, teacher, subject);
    }

    /**
     * Removes a student based on the provided ID.
     */
    private void removeStudent() {
        int studentId = getStudentIdInput();
        studentListController.removeStudent(studentId);
    }

    /**
     * Removes a grade from a student based on the provided index.
     */
    private void removeGradeFromStudent() {
        int studentId = getStudentIdInput();
        int gradeIndex = getGradeIndexInput() - 1;
        studentListController.removeGradeFromStudent(studentId, gradeIndex);
    }

    /**
     * Displays the list of students.
     */
    private void displayStudents() {
        studentListController.updateView();
    }

    /**
     * Edits the data of an existing student using inputs from the view.
     */
    private void editStudentData() {
        int studentId = getStudentIdInput();
        String newName = getStudentNameInput();
        String newSurname = getStudentSurnameInput();
        studentListController.editStudentData(studentId, newName, newSurname);
    }

    /**
     * Edits a grade for a student using inputs from the view.
     */
    private void editStudentGrade() {
        int studentId = getStudentIdInput();
        int gradeIndex = getGradeIndexInput() - 1;
        String newGrade = getGradeInput().replace(',', '.');
        String newTeacher = getTeacherInput();
        String newSubject = getSubjectInput();
        studentListController.editGradeForStudent(studentId, gradeIndex, Double.parseDouble(newGrade), newTeacher, newSubject);
    }
}

