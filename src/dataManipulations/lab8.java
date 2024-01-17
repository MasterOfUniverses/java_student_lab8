package dataManipulations;

public class lab8 {
    public static void main(String[] args) throws Exception{
        String input = "input.txt";
        String output = "output.txt";
        DataManager dm = new DataManager();
        Filter proc = new Filter();
        try{
            dm.registerDataProcessor(proc);
            dm.loadData(input);
            dm.processData();
            dm.saveData(output);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
