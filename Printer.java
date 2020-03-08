/*This class is for printing the tables*/
import java.util.*;

class Printer{

    public void printTable(Table tt)
    {
        Record cols = tt.getFieldName();
        System.out.println("+-------+----------+--------+-------+");
        for(String field:cols.getAllValues()){
            System.out.format("%-10s", field);
        }
        System.out.println("");

        for (int i=0; i<tt.getTableSize(); i++){
            Record rows = tt.select(i);
            System.out.println("+-------+----------+--------+-------+");
            for(String attrs:rows.getAllValues()){
                System.out.format("%-10s", attrs);
            }
            System.out.println("");
        }
        System.out.println("+-------+----------+--------+-------+");
    }


    //-----Testing------
    public static void main(String[] args) {
        Printer program = new Printer();
        program.run();
    }

    private void run()
    {
        Files test = new Files();
        Table test_table = test.readFromFile();
        printTable(test_table);
    }

}
