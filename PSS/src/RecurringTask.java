public class RecurringTask extends Task{
    int startDate;
    int endDate;
    int frequency;

    public RecurringTask(String name, String type, float startTime, float duration, float endDate, int frequency){
        super(name, type, startTime, duration);
    }

    public void compareDates(int startDate, int endDate){
    }

    public void checkOverlaps(){
    }
}
