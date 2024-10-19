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

    /** A scanner object used to capture user input from the console for general menu selections and numeric inputs. */
    private Scanner scanner;

    /** A scanner object configured to capture input from the console, specifically using a newline as the delimiter. */
    private Scanner spacebarScanner;

    /** Model class representing the main menu options. */
    private MainMenu mainMenu;

    /** View class responsible for displaying the main menu to the user. */
    private MainMenuView menuView;

    /** Controller responsible for managing student-related operations. */
    private StudentListController studentListController;

    /** Utility class for printing messages to the user. */
    private MessagePrinter messagePrinter;

    /**
     * Constructor for MainMenuController.
     * Initializes the scanners, view, model, and student list controller.
     *
     * @param studentListController The controller managing student-related operations.
     * @param menuView The view responsible for displaying the main menu.
     */
    public MainMenuController(StudentListController studentListController, MainMenuView menuView) {
        this.scanner = new Scanner(System.in);
        this.spacebarScanner = new Scanner(System.in).useDelimiter("\n");
        this.studentListController = studentListController;
        this.menuView = menuView;
        this.mainMenu = new MainMenu();
        this.messagePrinter = new MessagePrinter();
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
                    exitProgram();
                    running = false;
                    break;
                default:
                    messagePrinter.printErrorMessage("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Gets the user's menu choice as an integer.
     *
     * @return The chosen menu option as an integer.
     */
    public int getMenuChoice() {
        return scanner.nextInt();
    }

    /**
     * Captures the student ID input from the user.
     *
     * @return The entered student ID as an integer.
     */
    public int getStudentIdInput() {
        int id = -1;
        while (true) {
            messagePrinter.printInputMessage("Enter student ID (must be an integer): ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                return id;
            } else {
                messagePrinter.printErrorMessage("Invalid input. Please enter a valid integer ID.");
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
    public String getStudentNameInput() {
        messagePrinter.printInputMessage("Enter student name: ");
        return scanner.next();
    }

    /**
     * Captures the student surname input from the user.
     *
     * @return The entered student surname as a string.
     */
    public String getStudentSurnameInput() {
        messagePrinter.printInputMessage("Enter student surname: ");
        return scanner.next();
    }

    /**
     * Captures the grade input from the user.
     *
     * @return The entered grade value as a string.
     */
    public String getGradeInput() {
        messagePrinter.printInputMessage("Enter grade value (use dot or comma): ");
        return scanner.next();
    }

    /**
     * Captures the teacher's name input from the user.
     *
     * @return The entered teacher name as a string.
     */
    public String getTeacherInput() {
        messagePrinter.printInputMessage("Enter teacher name: ");
        return spacebarScanner.next();
    }

    /**
     * Captures the subject name input from the user.
     *
     * @return The entered subject name as a string.
     */
    public String getSubjectInput() {
        messagePrinter.printInputMessage("Enter subject name: ");
        return spacebarScanner.next();
    }

    /**
     * Captures the grade index input for removal or editing from the user.
     *
     * @return The entered grade index as an integer (1-based index).
     */
    public int getGradeIndexInput() {
        messagePrinter.printInputMessage("Enter grade index to remove/edit (1-based index): ");
        return scanner.nextInt();
    }

    /**
     * Adds a new student using inputs from the view.
     */
    public void addStudent() {
        int id = getStudentIdInput();
        if (id == -1) {
            return;
        }

        String name = getStudentNameInput();
        String surname = getStudentSurnameInput();
        studentListController.createNewStudent(id, name, surname);
        messagePrinter.printSuccessMessage();
    }

    /**
     * Adds a grade to an existing student using inputs from the view.
     */
    public void addGradeToStudent() {
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
    public void removeStudent() {
        int studentId = getStudentIdInput();
        studentListController.removeStudent(studentId);
    }

    /**
     * Removes a grade from a student based on the provided index.
     */
    public void removeGradeFromStudent() {
        int studentId = getStudentIdInput();
        int gradeIndex = getGradeIndexInput() - 1;
        studentListController.removeGradeFromStudent(studentId, gradeIndex);
    }

    /**
     * Displays the list of students.
     */
    public void displayStudents() {
        studentListController.updateView();
    }

    /**
     * Edits the data of an existing student using inputs from the view.
     */
    public void editStudentData() {
        int studentId = getStudentIdInput();
        String newName = getStudentNameInput();
        String newSurname = getStudentSurnameInput();
        studentListController.editStudentData(studentId, newName, newSurname);
    }

    /**
     * Edits a grade for a student using inputs from the view.
     */
    public void editStudentGrade() {
        int studentId = getStudentIdInput();
        int gradeIndex = getGradeIndexInput() - 1;
        String newGrade = getGradeInput().replace(',', '.');
        String newTeacher = getTeacherInput();
        String newSubject = getSubjectInput();
        studentListController.editGradeForStudent(studentId, gradeIndex, Double.parseDouble(newGrade), newTeacher, newSubject);
    }

    /**
     * Exits the program by saving the student data to a file and showing an exit message.
     */
    private void exitProgram() {
        messagePrinter.printInputMessage("Exiting program...");
    }
}
