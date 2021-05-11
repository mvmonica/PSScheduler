import java.util.ArrayList;

public class RecurringTask extends Task{
    int startDate;
    int endDate;
    int frequency;

    public RecurringTask(String name, String type, float startTime, float duration, int startDate, int endDate, int frequency){
        super(name, type, startTime, duration);
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
    }

    //false = invalid
    public boolean compareDates(int startDate, int endDate){
        if (startDate > endDate){
            return false;
        }
        return true;
    }

    //true = there was an overlap
    public boolean checkOverlaps(ArrayList<Object> testList){
        for (int i = 0; i < testList.size(); i++){
            TransientTask temp = (TransientTask)testList.get(i);
            if (temp.type.equals("")){ //needs to be changed to getters

            }
        }
        return true;
    }
}
