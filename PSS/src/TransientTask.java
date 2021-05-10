public class TransientTask extends Task{
    private int date;

    public TransientTask(String name, String type, float startTime, float duration, int date){
        super(name, type, startTime, duration);
        this.date = date;
    }

    public void checkDate(int date){
    }

    public void checkOverlaps(){       
    }

    public int getDate() {
        return date;
    }
}
