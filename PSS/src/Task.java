public class Task {
    public String name;
    String type;
    float startTime;
    float duration;

    public Task(String name, String type, float startTime, float duration){
        roundTime(startTime);
    }

    //true = valid
    public boolean checkStartTime(float startTime){
        if (startTime < 0 || startTime > 23.75){
            return false;
        }
        return true;
    }

    public boolean checkDurationTime(float duration){
        if (duration < .25 || duration > 23.75){
            return false;
        }
        return true;
    }

    public void roundTime(float time){
        temp = time - (int)time;
        if (temp < .125){
            //round to zero
        }
        else if (temp < .375){
            //round to .25
        }
        else if (temp < .625){
            //round to .5
        }
        else if (temp < .875){
            //round to .75
        }
        else{
            //round to 1
        }
    }

    public void checkTaskType(){
    }

    //true = valid
    public boolean checkTaskName(String name, Task[] listOfTasks){
        for (Task taskThing: listOfTasks){
            if(taskThing.name.equals(name)){
                return false;
            }
        }
        return true;
    }

    public void checkOverlaps(){
    }
}
