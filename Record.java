/* this class is for storing the data of fields */
import java.util.*;

class Record {
    List<String> field = new ArrayList<String>();

    public void setValues(String... s)
    {
        for(String n : s) {
            field.add(n);
        }
    }

    public String getValues(int i)
    {
        return field.get(i);
    }

    public List<String> getAllValues()
    {
        return field;
    }

    //replace the data
    public String updateValues(int i, String s)
    {
        return field.set(i, s);
    }

    public int getSize()
    {
        return field.size();
    }


    // ---------- Testing -----------

    public static void main (String[] args) {
        Record program = new Record();
        program.run();
    }

    //run all the tests
    private void run()
    {
        boolean testing = false;
        assert(testing = true);
        if (! testing) throw new Error("Use java -ea Record");
        testSetValues();
        testGetAllValues();
        testSize();
        testUpdateValues();
        System.out.println("All test pass!");
    }

    private void testSetValues()
    {
        setValues("1", "Fido", "dog", "ab123");
        assert(getValues(0)== "1");
        assert(getValues(1)== "Fido");
        assert(getValues(2)== "dog");
        assert(getValues(3)== "ab123");
        field.clear();
    }

    private void testGetAllValues()
    {
        setValues("1", "Fido", "dog", "ab123");
        List tmp = Arrays.asList(new String[] {"1", "Fido", "dog", "ab123"});
        assert(getAllValues().equals(tmp));
        field.clear();
    }

    private void testSize()
    {
        setValues("1", "Fido", "dog", "ab123");
        assert(getSize() == 4);
        field.clear();
        assert(getSize()== 0);
    }

    private void testUpdateValues()
    {
        setValues("1", "Fido", "dog", "ab123");
        updateValues(0, "2");
        updateValues(2, "fish");
        assert(getValues(0)== "2");
        assert(getValues(2)== "fish");
        field.clear();
    }

}
