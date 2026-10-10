import java.io.IOException;

public class CLICommands {
    public static String colorCodesData[] = {
        "\033[0m"/*Clear */, "\033[1;31m"/* Bold Red*/, "\033[1;32m"/*Bold Green */, "\033[1;37m"/*Bold White */, "\033[4;34m"/*Underline Blue */, "\033[1m"/*Bold */, "\033[4m"/*Underline */ // Add the white part feature
    };

    /**
     * This is essentially the printing method, used to print everything and allverything 
     * @param string stringCommands - the specific command needing for loading and execution
     * @param int color - specifies the specific index of the colorCodesData
     */
    public static void outPrinter(String stringCommand, int color) {
        String output = (ShellCommands.colorCodesData[color]) + stringCommand + ShellCommands.colorCodesData[0];
        System.out.println(output);
    }

    /**
     * This method clears the screen to provide a nice and clean layout.
     * Preconditions: none.
     * Postconditions: There is only one past command visible at one time.
     */
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            System.out.print("\n");
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }

        } catch (IOException | InterruptedException e) {
            outPrinter("Error on line 17-23", 1);
            e.printStackTrace();
        }
    }
    
    /**
     * Stops the entire program.
     * Preconditions: none.
     * Postconditions: the entire program ends.
     * @return intger literal 1
     */
    public static int stop() {
        String tempString = "Have a good day.";
        try {
            outPrinter(tempString, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * Shows the list of custom CLI commands.
     * Preconditions: none.
     * Postconditions: lists all of the possible commands.
     */
    public static void showCommands() {
        String commands = "\nHere are the commands:\n@stop @commands @search @list\n@newNote @help\n";
        outPrinter(commands, 2);
    }

    public static void help() {

    }

    public static void search() {
        
    }
}
