import java.util.ArrayList;

public class Model {
    ArrayList<Object> testList = new ArrayList<Object>();
    
    public void createTask(String name, String type, float startTime, float duration){
        testList.add(new Task(name, type, startTime, duration));
      
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
