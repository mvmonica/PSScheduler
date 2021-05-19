import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

public class Controller {
    public static void main(String[] args) throws Exception{
        Model testModel = new Model();

       /* testModel.createTask("CS 3560", "Class", 12.26f, 4.5f); //basic task test
        //testModel.createTask("CS 1400", "Class", 12.26f, 4.5f, 1234567, 1234567, 7); //recurring task test
        testModel.viewTask("CS 3560");
        System.out.println();
        testModel.viewTask("CS 1400");

        userInterface(testModel);*/
        demo(testModel);
    }

    public static void demo(Model testModel) throws IOException, ParseException{
        boolean con = true;
        System.out.println("\nWelcome to your PSS");
        do {

            System.out.println("\n1: Add a task");
            System.out.println("2: Delete a task");
            System.out.println("3: Edit a task");
            System.out.println("4: View Schedule");
            System.out.println("5: Open File");
            System.out.println("6: Save File");
            System.out.println("7: Exit");
            System.out.print("Select an activity: ");
            Scanner scan = new Scanner(System.in);
            int selected = scan.nextInt();
            int taskType = 0;

            if (selected == 1) {
                System.out.println("\n1: Transient Task");
                System.out.println("2: Recurring Task");
                System.out.println("3: Anti Task");
                System.out.print("Task Type: ");
                taskType = scan.nextInt();
                scan.nextLine();
            } else if(selected == 2) {
                //System.out.print("\nEnter a date: ");
                //int date = scan.nextInt();
                System.out.print("Enter a name: ");
                scan.nextLine();
                String name = scan.nextLine();

                testModel.deleteTask(name);
            } else if(selected == 3){
                System.out.print("\nEnter a date: ");
                int date = scan.nextInt();
                System.out.print("Enter a name: ");
                scan.nextLine();
                String name = scan.nextLine();

                testModel.editTask(date, name);
            } else if(selected == 4) {
                System.out.println("\n1: Daily");
                System.out.println("2: Weekly");
                System.out.println("3: Monthly");
                System.out.print("Schedule type: ");
                int scheType = scan.nextInt();
                if(scheType == 1){
                    System.out.print("Date to view: ");
                    int day = scan.nextInt();
                    scan.nextLine();
                    testModel.schedulePrinter(day, day);
                } else {
                    System.out.print("From date: ");
                    int from = scan.nextInt();
                    System.out.print("To date: ");
                    int end = scan.nextInt();
                    scan.nextLine();
                    testModel.schedulePrinter(from, end);
                }
            } else if(selected == 5){
                System.out.print("\nFile Name: ");
                scan.nextLine();
                String fileName = scan.nextLine();
                System.out.print(fileName);

                testModel.readFromFile(fileName);
            } else if(selected == 6){
                System.out.print("\nFile Name: ");
                scan.nextLine();
                String fileName = scan.nextLine();
                System.out.print(fileName);

                testModel.saveToFile(fileName);
            } else if(selected == 7){
                con = false;
                System.out.print("\nGood bye");
            }


            if (taskType == 1) {
                System.out.println("\nEnter a name: ");
                String name = scan.nextLine();

                System.out.println("Enter Task Category: ");
                String cat = scan.nextLine();

                System.out.println("Enter start time: ");
                float time = scan.nextFloat();

                System.out.println("Enter a duration: ");
                float duration = scan.nextFloat();

                System.out.println("Enter a date: ");
                int date = scan.nextInt();
                testModel.createTask(name, cat, time, duration, date);
            } else if (taskType == 2) {
                System.out.println("\nEnter a name: ");
                String name = scan.nextLine();

                System.out.println("Enter Task Category: ");
                String cat = scan.nextLine();

                System.out.println("Enter start time: ");
                float time = scan.nextFloat();

                System.out.println("Enter a duration: ");
                float duration = scan.nextFloat();

                System.out.println("Enter a start date: ");
                int startDate = scan.nextInt();

                System.out.println("Enter an end date: ");
                int endDate = scan.nextInt();

                System.out.println("Enter frequency (1, 7): ");
                int freq = scan.nextInt();
                testModel.createTask(name, cat, time, duration, startDate, endDate, freq);
            }else if(taskType == 3) {
                System.out.println("\nEnter a name: ");
                String name = scan.nextLine();

                System.out.println("Enter Task Category: ");
                String cat = scan.nextLine();

                System.out.println("Enter start time: ");
                float time = scan.nextFloat();

                System.out.println("Enter a duration: ");
                float duration = scan.nextFloat();

                System.out.println("Enter a date: ");
                int date = scan.nextInt();
                testModel.createAntiTask(name, cat, time, duration, date);
            }

        } while(con);

        
    }

    public void writeSchedule(String fileName){

    }

    public void readSchedule(String fileName){

    }

    public void writeSchedule(int date, String type){

    }

}
