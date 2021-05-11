public class RecurringTask extends Task{
    private int startDate;
    private int endDate;
    private int frequency;

    public RecurringTask(String name, String type, float startTime, float duration, int startDate, int endDate, int frequency){
        super(name, type, startTime, duration);
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
    }

    public void compareDates(int startDate, int endDate){
        if (startDate <= endDate)
            System.out.println("valid!");
        else
            System.out.println("invalid!");

    }

