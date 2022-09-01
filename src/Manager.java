import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {

    Kartei k = new Kartei();



    public void addPasswort(String s, String p) {
        k.store(s,p);

    }

    public String getPasswort(String name){
       return k.search(name);

    }


    public String proofSafety(String name){
        name = getPasswort(name);
        System.out.println(name);
        return k.pwSafety(name);
    }


    }
