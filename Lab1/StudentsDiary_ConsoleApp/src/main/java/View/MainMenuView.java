package View;

import java.util.ArrayList;

/**
 * View class responsible for displaying the main menu to the user.
 * It prints the list of available options and prompts the user for a choice.
 *
 * @author Adrian Reszka
 * @version 1.0
 */
public class MainMenuView {

    /**
     * Default constructor for MainMenuView.
     */
    public MainMenuView() {}

    /**
     * Displays the menu options to the user.
     *
     * @param menuOptions A list of menu options to display.
     */
    public void showMenu(ArrayList<String> menuOptions) {
        System.out.println("\nStudents Diary!");
        System.out.println("Menu:");
        for (int i = 0; i < menuOptions.size(); i++) {
            System.out.println((i + 1) + ". " + menuOptions.get(i));
        }
        System.out.print("Choose an option: ");
    }

    /**
     * Displays text when wrong main menu option was chosen
     */
    public void printWrongOptionMessage() {
        System.out.println("Wrong option!");
    }

    /**
     * Displays invalid input message
     */
    public void printInvalidIdInputMessage() {
        System.out.println("Invalid input. Please enter a valid integer ID.");
    }

    /**
     * Displays enter student id message
     */
    public void enterStudentIdMessage() {
        System.out.println("Enter student ID (must be an integer): ");
    }

    /**
     * Displays enter student name message
     */
    public void enterStudentNameMessage() {
        System.out.println("Enter student name: ");
    }

    /**
     * Displays enter student surname message
     */
    public void enterStudentSurnameMessage() {
        System.out.println("Enter student surname: ");
    }

    /**
     * Displays enter student grade message
     */
    public void enterStudentGradeMessage() {
        System.out.println("Enter grade value (use dot or comma): ");
    }

    /**
     * Displays enter teacher name message
     */
    public void enterTeacherNameMessage() {
        System.out.println("Enter teacher name: ");
    }

    /**
     * Displays enter subject name message
     */
    public void enterSubjectNameMessage() {
        System.out.println("Enter subject name: ");
    }

    /**
     * Displays enter grade index message
     */
    public void enterGradeIndexMessage() {
        System.out.println("Enter grade index to remove: ");
    }

    /**
     * Displays exiting program message
     */
    public void exitingProgramMessage() {
        System.out.println("Exiting program...");
    }
}
