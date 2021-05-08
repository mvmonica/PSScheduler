public class Controller {
    public static void main(String[] args) throws Exception{
        Model m = new Model();

        m.createTask("Sleep", "Transient" , 0200f, 0300f);
        m.createTask("Sleep", "Transient" , 0200f, 0300f);
        m.createTask("Sleep", "Transient" , 0200f, 0300f);
        m.createTask("Sleep", "Transient" , 0200f, 0300f);

        m.editTask("Sleep");

    }

    public void writeSchedule(String fileName){

    }

    public void readSchedule(String fileName){

    }

    public void writeSchedule(int date, String type){

    }

}
