import java.util.*;
import java.io.*;
import org.json.simple.*;


public class Model {
    ArrayList<Object> testList = new ArrayList<Object>();
    
    public void createTask(String name, String type, float startTime, float duration) throws FileNotFoundException {
//        testList.add(new Task(name, type, startTime, duration));

        JSONObject jo = new JSONObject();

        // putting data to JSONObject
        jo.put("Name of task", name);
        jo.put("Type of task", type);
        jo.put("Start time", startTime);
        jo.put("Duration", duration);

        //Making a new file with the given name. ".json" will ensure that it is json file.
        //This file will be in the main directory
        PrintWriter pw = new PrintWriter(new File("./JSON_Files", name + ".json"));
        pw.write(jo.toJSONString());

        pw.flush();
        pw.close();
        System.out.println(jo.toString());
    }

    public void createTask(String name, String type, float startTime, float duration, int startDate, int endDate, int frequency){
        testList.add(new RecurringTask(name, type, startTime, duration, startDate, endDate, frequency));
    }

    

    public void viewTask(String name){
        for (int i = 0; i < testList.size(); i++){
            Task temp = (Task)testList.get(i);
            if (temp.name.equals(name)){
                //displays a task, but should be replaced later
                System.out.println("Name: " + temp.name);
                System.out.println("Type: " + temp.type);
                System.out.println("Start Time: " + temp.startTime);
                System.out.println("Duration: " + temp.duration);
                break;
            }
        }
    }

    public void deleteTask(String name){
        for (int i = 0; i < testList.size(); i++){
            Task temp = (Task)testList.get(i);
            if (temp.name.equals(name)){
                testList.remove(i);
            }
        }
    }

    public void editTask(String name) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        ArrayList <Object> testList1 = new ArrayList<Object>();

        //Searching for the items and counting how many similar items are available.
        //if there are more than one this is likely a recurring task.
        //save those into
        int count = 0;
        for (Object o : testList) {
            JSONObject jo = (JSONObject) o;
            if(jo.containsValue(name)){
                count++;
                testList1.add(jo);
            }
        }

        //if no items found exit
        if(count == 0){
            System.out.println("no items to change");
            System.exit(0);
        }

        //tell the user how many items found.
        System.out.printf("found %d item/s", count);


        for (Object o : testList1) {
            JSONObject jo = (JSONObject) o;
            System.out.println("do you want to change this item? (y/n)" );
            System.out.println(jo.toString());
            if(input.nextLine().equals("y")){
                takeInfo();
            }
        }
        System.out.println("no items to change!");
    }

    public void takeInfo() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("what is the name of this task?");
        String name = input.nextLine();

        System.out.println("what is the type of this task?");
        String type = input.nextLine();

        System.out.println("when does this task start?");
        float date = input.nextFloat();

        System.out.println("what is the duration?");
        float duration = input.nextFloat();

        createTask(name, type, date, duration);
    }

}
