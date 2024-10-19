package Model;

import java.util.ArrayList;

/**
 * Model class representing the main menu options.
 * It provides a list of available actions the user can select.
 */
public class MainMenu {

    /** List of menu options available in the main menu. */
    private ArrayList<String> menuOptions;

    /**
     * Constructor for MainMenu.
     * Initializes the list of menu options.
     */
    public MainMenu() {
        menuOptions = new ArrayList<>();
        initializeMenuOptions();
    }

    /**
     * Initializes the available options in the main menu.
     */
    private void initializeMenuOptions() {
        menuOptions.add("Add new student");
        menuOptions.add("Add grade to student");
        menuOptions.add("Remove student");
        menuOptions.add("Remove grade from student");
        menuOptions.add("Display all students and their grades");
        menuOptions.add("Edit student data");
        menuOptions.add("Edit student grade");
        menuOptions.add("Exit");
    }

    /**
     * Returns the menu option for a given index.
     *
     * @param index The index of the option to retrieve.
     * @return The menu option at the specified index, or null if out of bounds.
     */
    public String getOption(int index) {
        if (index >= 0 && index < menuOptions.size()) {
            return menuOptions.get(index);
        }
        return null;
    }

    /**
     * Returns the total number of available options in the main menu.
     *
     * @return The number of menu options.
     */
    public int getNumberOfOptions() {
        return menuOptions.size();
    }

    /**
     * Returns all menu options as a list.
     *
     * @return A list of all menu options.
     */
    public ArrayList<String> getMenuOptions() {
        return menuOptions;
    }
}
