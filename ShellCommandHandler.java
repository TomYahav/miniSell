import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {
    private File currentDirectory;

    public ShellCommandHandler() {
        // TODO: Initialize currentDirectory to the user's current working directory
        // Hint: Use System.getProperty("user.dir")
        // מראה לי את התיקייה שהתוכנית שלי רצה עליה כרגע. user.dir
        //משמע התוכנית בשורה הזו יצרה אובייקט שמייצג את התיקייה של הוראות לתרגיל ראשון
        currentDirectory = new File(System.getProperty("user.dir"));
    }

    public void printWorkingDirectory() {
        // TODO: Print the absolute path of the current directory
//        פונקציה המדפיסה את הנתיב אל התיקייה עליה אפעיל את הםונקציה
        System.out.println(currentDirectory.getAbsolutePath());
    }

    public void listDirectory() {
        // TODO: List all files and directories in the current directory
        File [] files = currentDirectory.listFiles();

        if (files != null ){
            for (int i =0 ; i < files.length ;  i ++){
                File file = files[i];

                if(file.isDirectory()){
                System.out.println("[DIR]" + file.getName());
                }else{
                    System.out.println(("[FILE") + file.getName());
                }
            }
        }

    }
    public void changeDirectory(String name) {
        // TODO: Implement the change directory command
        if (name == null) {
            System.out.println("Usage: cd " + name);
            return;
        }
        // If name is "..", move to parent directory if possible
        File destination;
        if (name.equals("..")) {
            destination = currentDirectory.getParentFile();
            if (destination == null) {
                System.out.println("no target directory eas insert");
            }
            return;
            // Otherwise, try to move to the specified directory
        } else {
            destination = new File(currentDirectory, name);
            currentDirectory = destination;
        }
        if (destination != null && destination.isDirectory()) {
            currentDirectory = destination;
            // If directory doesn't exist, print error message: "Directory not found: [name]"
        } else {
            System.out.println("directory was not found" + name);
        }
    }


    public void makeDirectory(String name) {
        // TODO: Implement the make directory command
        // If name is null, show usage message: "Usage: mkdir [directory_name]"
        if (name == null){
            System.out.println("no name was enter, Usage: mkdir"+ name + "to create this Directory");
            return;
        }
        File directoryCreation = new File(currentDirectory,name);
        // If directory already exists, print: "Directory already exists."
        if (directoryCreation.exists()){
             System.out.println("directory already exists");
        // If directory creation is successful, print: "Directory created: [name]"
        }else if(directoryCreation.mkdir()){
            System.out.println("the directory " + name + " " + "was created successfully");
            // If directory creation fails, print: "Failed to create directory."
        }else {
            System.out.println("+failed to create the directory"+name);
        }
    }

    public void createFile(String name) throws IOException {
        // TODO: Implement the create file command
        // If name is null, show usage message: "Usage: touch [file_name]"
        if (name == null){
            System.out.println("no file name was enter to cerat the file" + name);
        return;
        }
        // If file already exists, print: "File already exists."
        File fileCreation  = new File(currentDirectory,name);
        if (fileCreation.exists()){
            System.out.println("the file with the name " + name + " " + "already exists" );
        // If file creation is successful, print: "File created: [name]"
        }else {
            fileCreation.createNewFile();
        }
        if (fileCreation.exists() == true){
            System.out.println("the file" + " " + name + " "+ " was created successfully ");
        }else {
            System.out.println("failed to create the file " + name + " "  );
        }
    }
    public void printHelp() {
        // TODO: Implement help command to print information about all available commands
        // List all commands with their descriptions
        System.out.println("for the commands manu + description press enter");
        System.out.println("pwd - print the current directory your at");
        System.out.println("ls - show the list of all the directory in the current directory");
        System.out.println("cd + {DIR} : move to the specific directory (use "+ " .. " +" " + "to move one directory back ");
        System.out.println("mkdir + {DIR} : to create new directory");
        System.out.println("touch + {FILE} : to create new file ");
        System.out.println("exit - to exit the program ");
    }

    public File getCurrentDirectory() {
        // TODO: Return the current directory
        return currentDirectory; // Replace this with your implementation
    }
}