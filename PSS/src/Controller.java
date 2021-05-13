import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws Exception{
        Model testModel = new Model();
        //testModel.createTask("CS 3560", "Class", 12.26f, 4.5f); //basic task test

        //testModel.createTask("CS 1400", "Class", 12.26f, 4.5f, 1234567, 1234567, 7); //recurring task test



        /*testModel.viewTask("CS 3560");
        System.out.println();
        testModel.viewTask("CS 1400");*/

        boolean con = true;
        do {

            System.out.println("Welcome to your PSS");
            System.out.println("Select an activity:");
            System.out.println("1: Add a task");
            System.out.println("2: Delete a task");
            System.out.println("3: Edit a task");
            System.out.println("4: Exit program");
            Scanner scan = new Scanner(System.in);
            int selected = scan.nextInt();
            int taskType = 0;

            if (selected == 1) {
                System.out.println("1: Transient Task");
                System.out.println("2: Recurring Task");

                taskType = scan.nextInt();
            } else if(selected == 4){
                con = false;
            }
            scan.nextLine();

            if (taskType == 1) {
                System.out.println("Enter a name: ");
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
                System.out.println("Enter a name: ");
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
