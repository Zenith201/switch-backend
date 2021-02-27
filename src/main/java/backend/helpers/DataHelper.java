package backend.helpers;

import backend.model.Page;
import backend.model.Upload;
import backend.model.User;
import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DataHelper {

    private static DataHelper instance;
    ArrayList<Page>pages=new ArrayList<>();
    ArrayList<User>followers=new ArrayList<>(),following=new ArrayList<>();
    ArrayList<Upload>uploads=new ArrayList<>();

    public static DataHelper getInstance() {
        if (instance==null)
            instance=new DataHelper();
        return instance;
    }

    public String createAccount(HashMap<String,String> body){
        HashMap<String,String>response=new HashMap<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection connection = DriverManager.getConnection("jdbc:sqlserver://switch-db-sql-server.database.windows.net:1433;database=switch-db;encrypt=true;trustServerCertificate=true;", "zane", "takougoum2001NANA");
            final PreparedStatement SaveStatement = connection.prepareStatement("INSERT INTO switch_user  ([username], [password], [phone_number], [type],[followers],[following],[uploads],[pages]) VALUES ('"+body.get("username")+"', " +
                    "'"+body.get("password")+"', '"+body.get("phone_number")+"','"+body.get("type")+"','"+new Gson().toJson(followers)+"','"+new Gson().toJson(following)+"','"+new Gson().toJson(uploads)+"','"+new Gson().toJson(pages)+"');");
            SaveStatement.execute();
            connection.close();
            SaveStatement.close();
        }
        catch (Exception e) {
            response.put("time_stamp", new Date().toLocaleString());
            response.put("status","error");
            response.put("cause",e.getMessage());
            return new Gson().toJson(response);
        }

        response.put("time_stamp",new Date().toLocaleString());
        response.put("status","success");
        response.put("cause",null);

         return new Gson().toJson(response);
    }

    public String getUsers(){
        ArrayList<User> users=new ArrayList<>();
        HashMap<String,Object>response=new HashMap<>();
        User user;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection connection = DriverManager.getConnection("jdbc:sqlserver://switch-db-sql-server.database.windows.net:1433;database=switch-db;encrypt=true;trustServerCertificate=true;", "zane", "takougoum2001NANA");
            final Statement selectStatement = connection.createStatement();
            ResultSet resultSet=selectStatement.executeQuery("Select * from switch_user");
            while (resultSet.next()){
                user=new User(resultSet.getString("id"),resultSet.getString("username"),
                        resultSet.getString("password"),resultSet.getString("phone_number"),
                        resultSet.getString("type"),resultSet.getString("profile_pic"),new Gson().fromJson(resultSet.getString("uploads"),
                        ArrayList.class),new Gson().fromJson(resultSet.getString("followers"),ArrayList.class),new Gson().fromJson(resultSet.getString("following"),ArrayList.class)
                ,new Gson().fromJson(resultSet.getString("pages"),ArrayList.class));

                users.add(user);
            }
            connection.close();
            selectStatement.close();
            resultSet.close();
        }
        catch (Exception e) {
            response.put("time_stamp", new Date().toLocaleString());
            response.put("status","error");
            response.put("cause",e.getMessage());
            System.out.println(e.getMessage());
            return new Gson().toJson(response);
        }

        response.put("time_stamp",new Date().toLocaleString());
        response.put("status","success");
        response.put("cause",null);
        response.put("data",users);

        return new Gson().toJson(response);
    }

    public String getUserNames(){
        ArrayList<String> usernames=new ArrayList<>();
        HashMap<String,Object>response=new HashMap<>();
        User user;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            final Connection connection = DriverManager.getConnection("jdbc:sqlserver://switch-db-sql-server.database.windows.net:1433;database=switch-db;encrypt=true;trustServerCertificate=true;", "zane", "takougoum2001NANA");
            final Statement selectStatement = connection.createStatement();
            ResultSet resultSet=selectStatement.executeQuery("Select username from switch_user ");
            while (resultSet.next()){
                usernames.add(resultSet.getString("username"));
            }
            connection.close();
            selectStatement.close();
            resultSet.close();
        }
        catch (Exception e) {
            response.put("time_stamp", new Date().toLocaleString());
            response.put("status","error");
            response.put("cause",e.getMessage());
            System.out.println(e.getMessage());
            return new Gson().toJson(response);
        }

        response.put("time_stamp",new Date().toLocaleString());
        response.put("status","success");
        response.put("cause",null);
        response.put("data",usernames);

        return new Gson().toJson(response);
    }



}
