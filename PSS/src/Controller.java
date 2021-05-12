import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws Exception{
        Model testModel = new Model();

        testModel.createTask("CS 3560", "Class", 12.26f, 4.5f); //basic task test
        //testModel.createTask("CS 1400", "Class", 12.26f, 4.5f, 1234567, 1234567, 7); //recurring task test
        testModel.viewTask("CS 3560");
        System.out.println();
        testModel.viewTask("CS 1400");

        userInterface(testModel);


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

    public void writeSchedule(String fileName){

    }

    public void readSchedule(String fileName){

    }

    public void writeSchedule(int date, String type){

    }

}
