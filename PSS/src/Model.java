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

    public void editTask(String name){
    }

}
