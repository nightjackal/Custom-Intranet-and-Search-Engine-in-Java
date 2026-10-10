import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean stopBoolean = false;
        Scanner input = new Scanner(System.in);
        String line = "";
        {
            ShellCommands.clearScreen();
            ShellCommands.clearScreen();
            String welcome = "\nWelcome to Night Jackal's Intranet!\nHere you can use this CLI built search engine to browse the intranet.\nYou can find all sorts of information here, and even add your own files and articles!\n\tType \033[1;32m@commands\033[0m\033[1m to see all of the commands available ";
            ShellCommands.outPrinter(welcome, 5);
        }
        while (!stopBoolean) {
            line = input.nextLine();
            ShellCommands.clearScreen();
            int result = executeCommand(line);
            if (result != 0) {
                break;
            }
        }
        input.close();
    };

    private static String commands[] = {
            "@stop", "@commands", "@search"
    };

    private static int executeCommand(String command) {
        if (command.equals(commands[0].toString())) {
            ShellCommands.stop();
            return 1;
        }
        else if (command.equals(commands[1].toString())) {
            ShellCommands.showCommands();
        }
        else if (command.equals(commands[2].toString())) {
            ShellCommands.showCommands();
        }
        else  {
            ShellCommands.outPrinter("That is an invalid comamnd.\n\tPlease type: @commands\tto show commands", 1);
        }
        return 0;
    };
}
