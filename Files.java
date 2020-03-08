/* This class provides two methods, one is to read the table from file.txt
   the other one is to write the table to the file.txt */
import java.io.File;
import java.util.*;
import java.io.*;

class Files{

    public Table readFromFile()
    {
        Table tt = new Table("");
        Boolean flag = true;
        try {
            File file = new File("pets.txt");
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (flag){
                    tt.setFieldName(line.split(" "));
                    flag = false;
                }else{
                    tt.insert(line.split(" "));
                }
                // System.out.println(line);
            }
            in.close();
        } catch (Exception e) { throw new Error(e); }

        return tt;
    }


    public void writeToFile(String databse, Table tw)
    {
        Boolean flag = true;
        try {
            FileWriter writer = new FileWriter(databse+"/"+tw.getTtName()+".txt");
            BufferedWriter buffer = new BufferedWriter(writer);

            if (tw.getTableSize()!=0) {
                Record columns = tw.getFieldName();
                System.out.println(columns.getValues(0));
                buffer.write(columns.getValues(0));
                buffer.newLine();

                for (int i=0; i<tw.getTableSize(); i++){
                    Record recordField = tw.select(i);
                    for (int j=0; j<recordField.getSize(); j++){
                        // System.out.println(recordField.getValues(j));
                        buffer.write(recordField.getValues(j));
                    }
                    buffer.newLine();
                }
                buffer.close();
            }
        } catch (Exception e) { throw new Error(e); }


    }


    //----Testing----
    public static void main(String[] args) {
        Files program = new Files();
        program.run();
    }


    void run() {
        Table test_table = readFromFile();
        Printer pt = new Printer();
        pt.printTable(test_table);
        // writeToFile(db, test_table);
    }

}
