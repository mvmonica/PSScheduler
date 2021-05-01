public class Model {
    Task[] listOfTasks;
    
    public void createTask(String name, String type, float startTime, float duration){
    }

    public void roundTime(){
    }

    public void viewTask(String name){
        for (Task taskThing: listOfTasks){
            if(taskThing.name.equals(name)){
                //display task info\
                System.out.println("found " + name);
            }
        } 
    }

    public void deleteTask(){
    }

    public void editTask(){
    }

}
