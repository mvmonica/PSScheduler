
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public static void userInterface(Model testModel){
        Scanner scnr = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println("\nPlease select your chosen operation:" +
            "\n1) Read from file"+
            "\n2) Save schedule to file"+
            "\n3) View schedule"+
            "\n4) Add task"+
            "\n5) Delete task"+
            "\n6) Edit task"+
            "\n7) Exit\n");

            String chosenOperation = scnr.nextLine();
          
            if (chosenOperation.equals("1")){
                System.out.println("you typed 1");
            }
            else if (chosenOperation.equals("2")){
                System.out.println("you typed 2");
            }
            else if (chosenOperation.equals("3")){
                System.out.println("you typed 3");
            }
            else if (chosenOperation.equals("4")){
                System.out.print("Task name:");
                String name = scnr.nextLine();
                
                System.out.print("Task Type:");
                String type = scnr.nextLine();

                System.out.print("Task Type:");
                float startTime = scnr.nextFloat();

                System.out.print("Task Type:");
                float duration = scnr.nextFloat();


                try {
                    testModel.createTask(name, type, startTime, duration);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
             
                
            }
            else if (chosenOperation.equals("5")){
                System.out.println("you typed 5");
            }
            else if (chosenOperation.equals("6")){
                System.out.println("you typed 6");
            }
            else if (chosenOperation.equals("7")){
                System.out.println("you typed 7");
                exit = true;
            }
            else{
                System.out.println("invalid input");
            }
        }   
        scnr.close();
    }

    public static void demo(Model testModel){
        boolean con = true;
        System.out.println("\nWelcome to your PSS");
        do {

            System.out.println("\n\n1: Add a task");
            System.out.println("2: Delete a task");
            System.out.println("3: Edit a task");
            System.out.println("4: View Schedule");
            System.out.print("Select an activity: ");
            Scanner scan = new Scanner(System.in);
            int selected = scan.nextInt();
            int taskType = 0;

            if (selected == 1) {
                System.out.println("\n1: Transient Task");
                System.out.println("2: Recurring Task");
                System.out.print("Task Type: ");
                taskType = scan.nextInt();
                scan.nextLine();
            } else if(selected == 2) {
                System.out.print("\nEnter a date: ");
                int date = scan.nextInt();
                System.out.print("Enter a name: ");
                scan.nextLine();
                String name = scan.nextLine();

                testModel.deleteTask(name, date);
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

                System.out.println("Enter frequency (1, 7, 30): ");
                int freq = scan.nextInt();
                testModel.createTask(name, cat, time, duration, startDate, endDate, freq);
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
