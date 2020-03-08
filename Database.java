import java.io.File;

class Database{
    String dbName;

    Database(String dbName0) {
        this.dbName = dbName0;
        createANewFolder(this.dbName);
    }

    private void createANewFolder(String name)
    {

        File dir = new File(name);
        boolean successful = dir.exists();
        if (!successful){
            dir.mkdirs();
            System.out.println("Folder was created !");
        }
        else{
            System.out.println("already exist!");
        }
    }

    public void createPath(Table tt)
    {
        Files write = new Files();
        write.writeToFile(dbName,tt);
    }

    public static void main(String[] args){
        Database db = new Database("University of BB");
        db.run();
    }

    private void run()
    {
        Table test_tt = new Table("ss");
        createANewFolder("testing folder");
        createPath(test_tt);
    }
}
