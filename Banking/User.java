import java.sql.*;
import java.util.*;
public class User {
    private Scanner sc;
    private Connection con;
    public User(Scanner sc, Connection con) throws SQLException {
        this.sc = sc;
        this.con = con;
    }
    public void registration(){
        sc.nextLine();
        System.out.println("Registration started");
        System.out.println("Enter full name: ");
        String full_name = sc.nextLine();

        System.out.println("Email: ");
        String email = sc.nextLine();

        System.out.println("Password: ");
        String password = sc.nextLine();

        if(user_exist(email)){
            System.out.println("User Already Exists for this Email Address");
            return;
        }
        //Step 3 Statement:

        String query = "INSERT INTO user(full_name,email,password) VALUES(?,?,?)";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, full_name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            int affectedRows = preparedStatement.executeUpdate(); //Step 4 Execute
                if (affectedRows > 0) {
                    System.out.println("Registration Successful");
                }
                else{
                    System.out.println("Registration Failed");
                }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private boolean user_exist(String email) {
//        throw new UnsupportedOperationException("Unimplemented Method 'user_exist'");
        String query = "SELECT * FROM user WHERE email = ?";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
            else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public String login() {
        sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        String login_query = "SELECT * FROM User WHERE email = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(login_query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return email;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }
}
