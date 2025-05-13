package MiniShellTom;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class MiniShell {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ShellCommandHandler handler = new ShellCommandHandler();
        System.out.println("Welcome to MiniShell! Type 'help' for a list of commands.");

        while (true) {
            System.out.print(handler.getCurrentDirectory().getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;

            // TODO: Implement the command switch structure
            // You need to handle the following commands:
            if (command.equals("pwd")) {
                handler.printWorkingDirectory();
            }
            // - ls: List files in current directory
            else if (command.equals("ls")) {
                handler.listDirectory();
            }
            // - cd: Change directory
            else if (command.equals("cd")) {
                handler.changeDirectory(argument);
            }
            // - mkdir: Create new directory
            else if (command.equals("mkdir")) {
                handler.makeDirectory(argument);
            }
            // - touch: Create new file
            else if (command.equals("touch")) {
                handler.createFile(argument);
            }
            // - help: Show help information
            else if (command.equals("help")) {
                handler.printHelp();
            }
            // - exit: Exit the program
            else if (command.equals("exit")) {
                System.out.println("goodbye");
            return;
            }else {
                System.out.println("unknown command. type help to see the command menu");
            // Your code should call the appropriate methods from the ShellCommandHandler class
            }
        }
    }
}