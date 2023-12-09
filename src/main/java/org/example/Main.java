package org.example;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:hello.sqlite";
        Connection connection = DriverManager.getConnection(url);

        Statement statement = connection.createStatement();  //what runs SQL queries for us

//       String createTableSQL = "CREATE TABLE cats (name TEXT, age INTEGER)";
//       statement.execute(createTableSQL);  //send to database to ask it to create the table

//        String insertDataSQL = "INSERT INTO cats VALUES ('Maru', 10)";
//        statement.execute(insertDataSQL);

//        String insertDataSQL = "INSERT INTO cats VALUES ('Hello Kitty', 40)";
//        statement.execute(insertDataSQL);


        String getAllDataSQL = "SELECT * FROM cats";  //read data from the database
        ResultSet allCats = statement.executeQuery(getAllDataSQL);

        while (allCats.next()) {  //since we might not know how large database, access data one row at a time
            //next returns true if there are more rows to read and false if the next line is empty
            String name = allCats.getString("name");
            int age = allCats.getInt("age");
            System.out.println(name + " is " + age + " years old.");
        }
        connection.close();



        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        //for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
           // System.out.println("i = " + i);
       // }
    }
}