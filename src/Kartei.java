import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Kartei {

    private Character[] sondZeichen = new Character[]{
            '!','"','§','$','%','&'
            ,'/','(',')','=','?','*'
            ,':',';','.','-','#','+'
            ,']','[','{'
    };


    public Kartei(){

    }




    public void deletePassword(String s){


    }



    public String pwSafety(String pw){

        boolean k = kleineBst(pw);
        boolean g = großeBst(pw);
        boolean z = zahl(pw);
        boolean s = sonderzeichen(pw);

        boolean[] booleans = new boolean[4];

        booleans[0] = k;
        booleans[1] = g;
        booleans[2] = z;
        booleans[3] = s;

        int counter = 0;
        for(int i =0 ; i<4;i++){

            if(booleans[i] == true){
                counter++;
            }
        }

        if(counter == 4 && pw.length() > 8){

            System.out.println("Sehr Sicher");
            return "Sehr Sicher";

        }
        if(counter == 3 && pw.length() >5){
            System.out.println("Sicher");
            return "Sicher";
        }
        if(counter == 2 && pw.length()>5){
            System.out.println("Ausreichend");
            return "Ausreichend";
        }
        if(counter == 1){
            System.out.println("Ungenuegend");
            return "Ungenuegend";

        }
        System.out.println("Wähle ein anderes Passwort");
        return "Wähle ein anderes Passwort";
    }



    //Pw-Safety
    public boolean kleineBst(String s){

        for(int i =0; i<s.length(); i++){

            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                System.out.println("KLBST");
                return true;
            }

        }

        return false;
    }


    public boolean großeBst(String s){

        for(int i =0; i<s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                System.out.println("grBST");
                return true;
            }
        }
        return false;
    }
    public boolean zahl(String s){

        for(int i =0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                System.out.println("Zahl");
                return true;
            }
        }
        return false;
    }

    public boolean sonderzeichen(String s){

        for(int i = 0; i<s.length();i++){

            for(int j = 0; j<sondZeichen.length;j++){

                if(s.charAt(i) == sondZeichen[j]){
                    System.out.println("sond");
                    return true;

                }
            }

        }

        return false;
    }

    //Database

    public void store(String name, String pw){

        String query1 = "insert into manager (pwName,passwort)" + "values('"+name+"','"+pw+"');";
        try{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","34!DBf)(57MnZch-");System.out.println("Connection Succesfull");

            Statement statement = connection.createStatement();

            int rs = statement.executeUpdate(query1);

        }catch(Exception e){

            System.out.println(e);
        }
    }

    public String search(String name){

        String query1 = "select passwort from Manager where pwName = '"+name+"'";
        try{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","34!DBf)(57MnZch-");System.out.println("Connection Succesfull");

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query1);

            while(rs.next()){
                return (rs.getString("passwort"));
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return "No Entry";
    }
}
