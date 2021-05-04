import java.util.ArrayList;

public class Model {

    
    Task[] listOfTasks; //going to change array to arrayList make edits to the schedule easier

    int listSize = 0;
    ArrayList<Object> testList = new ArrayList<Object>();
    
    public void createTask(String name, String type, float startTime, float duration){
        testList.add(new Task(name, type, startTime, duration));
    }

    public void roundTime(){

    }

    public void viewTask(String name){
        for (int i = 0; i < testList.size(); i++){
            Task temp = (Task)testList.get(i);
            if (temp.name.equals(name)){
                System.out.println("Name: " + temp.name);
                System.out.println("Type: " + temp.type);
                System.out.println("Start Time: " + temp.startTime);
                System.out.println("Duration: " + temp.duration);
                break;
            }
        }


 
    }

    public void deleteTask(String name){
        for (Task taskThing: listOfTasks){
            if(taskThing.name.equals(name)){
                
            }
        }
    }

    public void editTask(){
    }

}
