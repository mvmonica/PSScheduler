public class Controller {
    public static void main(String[] args) throws Exception{
        Model testModel = new Model();
        testModel.createTask("CS 3560", "Class", 12.26f, 4.5f); //basic task test

        testModel.createTask("CS 1400", "Class", 12.26f, 4.5f, 1234567, 1234567, 7); //recurring task test



        testModel.viewTask("CS 3560");
        System.out.println();
        testModel.viewTask("CS 1400");
    }

    public void writeSchedule(String fileName){

    }

    public void readSchedule(String fileName){

    }

    public void writeSchedule(int date, String type){

    }

}
