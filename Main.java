import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean stopBoolean = false;
        Scanner input = new Scanner(System.in);
        String line = "";
        ShellCommands shellCommands = new ShellCommands(); // Is this necessary?
        while (!stopBoolean) {
            line = input.nextLine();
            for (int i = 0; i < commands.length; i++) {
                executeCommand(line);
            }
        }
        input.close();
    };

    private static String commands[] = {
            "@stop", "@commands", "@search"
    };

    private static int executeCommand(String command) { // There is a bug here that I need to fix, 
                                                        // it has to do with the comparison of strings to my string array and also the for loop I used.
        boolean commandExist = false;
        if (command == commands[0].toString()) {
            ShellCommands.stop();
            commandExist = true;
            return 1;
        }
        else if (command == commands[1].toString()) {
            ShellCommands.showCommands();
            commandExist = true;
        }
        else if (!commandExist) {
            ShellCommands.outPrinter("That is an invalid comamnd.\n\tPlease type: @commands\tto show commands", 1);
        }
        return 0;
    };
}
