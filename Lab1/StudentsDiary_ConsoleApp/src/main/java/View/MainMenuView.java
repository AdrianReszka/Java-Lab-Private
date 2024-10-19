package View;

import java.util.ArrayList;

/**
 * View class responsible for displaying the main menu to the user.
 * It prints the list of available options and prompts the user for a choice.
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
}
