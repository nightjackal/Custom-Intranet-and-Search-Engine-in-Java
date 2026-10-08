 //Definite work in progress, but so far this part is functional
public class CLICommands {
    protected enum commandCLICodes {
        STOP,
        SEARCH,
        DO,
        COMPILE_CPP,
        COMPILE_C,
        COMPILE_JAVA,
        RUN_CPP,
        RUN_C,
        RUN_JAVA;
    }

    public static String colorCodesData[] = {
        "\033[0m", "\033[1;31m", "\033[1;32m", "\033[1;34m", "\033[1;37m", "\033[1m" // Add the white part feature
    };

    /**
     * This is essentially the printing method, used to print everything and allverything 
     * @param string
     * @param textDecoration
     */
    public static void outPrinter(String stringCommand, int color) {
        String output = (CLICommands.colorCodesData[color]) + stringCommand + CLICommands.colorCodesData[0]; // Best method here LOL
        System.out.println(output);
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

    public static void showCommands() {
        String commands = "@stop\t@commands\t@search\t@list\n@new note\thelp";
        outPrinter(commands, 2);
    }
}
