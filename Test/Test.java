
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Scanner;

public class Test {
    
    public static void main(String[] args) throws Exception {
        
        while(true) {
            System.out.println("*****Menu*****");
            System.out.println("(1)Register");
            System.out.println("(2)Login");
            System.out.println("(3)Quit");
            Scanner readChoice;
            int choice = 0;
            try {
                readChoice = new Scanner(System.in);
                choice = readChoice.nextInt();
                readChoice.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }
            switch(choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
       
    }
    
    public static void register() throws Exception {
        
       PreparedStatement statement = null;
       
       Scanner readRegister = new Scanner(System.in);
       System.out.print("Enter your username: ");
       String username = readRegister.nextLine();
       
       try {
            Class.forName("org.sqlite.JDBC");
            Connection connection =DriverManager.getConnection("jdbc:sqlite:test.db");
            statement =(PreparedStatement) connection.prepareStatement("select * from account where username=?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                System.out.println("Username already exists!");
                resultSet.close();
                connection.close();
                statement.close();
                return;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
       
       System.out.print("Enter your password: ");
       String password = readRegister.nextLine();
       
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection =DriverManager.getConnection("jdbc:sqlite:test.db");
            statement = (PreparedStatement) connection.prepareStatement("insert into account(username,password)values(?,?)");
            statement.setString(1,username);
            statement.setString(2,password);
            statement.execute();
            connection.close();
            statement.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }       
    }
    
    public static void login() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Scanner readLogin = new Scanner(System.in);
        
        System.out.print("Enter your username: ");
        String username = readLogin.nextLine();
       
        System.out.print("Enter your password: ");
        String password = readLogin.nextLine();
       
        try{
            Class.forName("org.sqlite.JDBC");
            Connection connection=DriverManager.getConnection("jdbc:sqlite:test.db");
            statement=(PreparedStatement) connection.prepareStatement("select * from account where username=? and password=?");
            statement.setString(1, username);
            statement.setString(2, password);
        
            resultSet=statement.executeQuery();
            
            String usernameResult = null;
            String passwordResult = null;
            while (resultSet.next()){
                usernameResult = resultSet.getString("username");
                passwordResult = resultSet.getString("password");
                
            }
            
            if(usernameResult == null || passwordResult == null) {
                System.out.println("Wrong username or password!");
            } else {
                System.out.println("Login successful!");
            }
            connection.close();
            statement.close();
            resultSet.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();  
        } 
    }
    
}
