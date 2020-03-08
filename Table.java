/* to hold field name and the records, the moethod in the Table class,
   including store the fieldnames, insert, delete, select and update
   the data of rows*/

import java.util.*;
import java.lang.*;

class Table {

    private int countRows = 0;
    private String ttName;
    private Record fieldName = new Record();
    private List<Record> rows = new ArrayList<Record>();


    Table(String ttName0)
    {
        this.ttName = ttName0;
    }

    public String getTtName()
    {
        return ttName;
    }

    public void setFieldName(String... s)
    {
        fieldName.setValues(s);
    }

    public Record getFieldName()
    {
        return fieldName;
    }

    public void insert(String... s)
    {
        if(!checkDoubleKey(s[0])) {
            Record tmp = new Record();
            tmp.setValues(s);
            rows.add(tmp);
            countRows++;
        }
    }

    public void delete(int i)
    {
        rows.remove(rows.get(i));
        countRows--;

    }

    public void update(int i, String... s)
    {
        for(int j=0; j<rows.get(i).getSize(); j++) {
            rows.get(i).updateValues(j, s[j]);
        }
    }

    public Record select(int i)
    {
        return rows.get(i);
    }

    public int getTableSize()
    {
        return rows.size();
    }

    boolean checkDoubleKey(String s)
    {
        for (int i=0; i<countRows; i++){
            if (rows.get(i).getValues(0).equals(s)){
                return true;
            }
        }
        return false;
    }

    public String selectKey(int i)
    {
        return rows.get(i).getValues(0);
    }



    //---------- Testing -----------

    public static void main(String[] args) {
        Table program = new Table("");
        program.run();
    }

    void run() {
        boolean testing = false;
        assert(testing = true);
        if (! testing) throw new Error("Use java -ea Board");
        testSetFieldName();
        testInsert();
        testDelete();
        testUpdate();
        System.out.println("All tests past!!");
    }

    private void testSetFieldName()
    {
        setFieldName("id", "Name", "Kind", "Owner");
        assert(fieldName.getValues(0)=="id");
        assert(fieldName.getValues(1)=="Name");
        assert(fieldName.getValues(2)=="Kind");
        assert(fieldName.getValues(3)=="Owner");
    }

    private void testInsert()
    {
        insert("1", "Fido", "dog", "ab123");
        assert(rows.get(0).field.get(0) == "1");
        assert(rows.get(0).field.get(1) == "Fido");
        assert(rows.get(0).field.get(2) == "dog");
        assert(rows.get(0).field.get(3) == "ab123");
    }

    private void testDelete()
    {
        insert("1", "Fido", "dog", "ab123");
        delete(0);
    }

    private void testUpdate()
    {
        insert("1", "Fido", "dog", "ab123");
        assert(rows.get(0).field.get(0) == "1");
        assert(rows.get(0).field.get(1) == "Fido");
        assert(rows.get(0).field.get(2) == "dog");
        assert(rows.get(0).field.get(3) == "ab123");
        update(0, "2", "Demo", "fish", "as234");
        assert(rows.get(0).field.get(0) == "2");
        assert(rows.get(0).field.get(1) == "Demo");
        assert(rows.get(0).field.get(2) == "fish");
        assert(rows.get(0).field.get(3) == "as234");
    }

    private void testSelectKey()
    {
        insert("3", "Fi", "cat", "ak789");
        assert(selectKey(0) == "3");
    }

}
