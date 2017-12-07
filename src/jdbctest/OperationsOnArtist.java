package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class OperationsOnArtist {

    static Connection myConn;
    static Statement mySmt;
    static ResultSet myRs;
    static PreparedStatement mySmt1;

    public static void openConnection() throws SQLException {
        myConn = DriverManager.getConnection("jdbc:derby://localhost:1527/people", "root", "root");
        mySmt = myConn.createStatement();
    }

    public static ArrayList addArtist(int id, String name, String lastName, int birthYear) throws SQLException {
        mySmt1 = myConn.prepareStatement("insert into artists (id, name, lastname, birthyear) values (?,?,?,?)");
        mySmt1.setInt(1, id);
        mySmt1.setString(2, name);
        mySmt1.setString(3, lastName);
        mySmt1.setInt(4, birthYear);

        int queryUpdate = mySmt1.executeUpdate();

        return findById(id);
    }

    public static ArrayList updateArtist(int id, String name, String lastName, int birthYear) throws SQLException {

        mySmt1 = myConn.prepareStatement("update artists set name=?, lastname = ?, birthyear = ? where id = ?");

        mySmt1.setString(1, name);
        mySmt1.setString(2, lastName);
        mySmt1.setInt(3, birthYear);
        mySmt1.setInt(4, id);

        int queryUpdate = mySmt1.executeUpdate();
        return findById(id);
    }

    public static ArrayList deleteArtist(int id) throws SQLException {
        mySmt1 = myConn.prepareStatement("DELETE FROM artists WHERE id =? ");
        mySmt1.setInt(1, id);

        int queryUpdate = mySmt1.executeUpdate();

        return showAll();
    }

    public static ArrayList findById(int id) throws SQLException {
        ArrayList<Artist> tempList = new ArrayList<>();
        mySmt1 = myConn.prepareStatement("select * from artists where id = ?");
        mySmt1.setInt(1, id);
        ResultSet myRs2 = mySmt1.executeQuery();

        while (myRs2.next()) {
            tempList.add(new Artist(myRs2.getInt("id"), myRs2.getString("name"), myRs2.getString("lastname"), myRs2.getInt("birthyear")));
        }
        return tempList;
    }

    public static ArrayList findByName(String name) throws SQLException {
        ArrayList<Artist> tempList = new ArrayList<>();
        mySmt1 = myConn.prepareStatement("select * from artists where name = ?");
        mySmt1.setString(1, name);
        ResultSet myRs2 = mySmt1.executeQuery();

        while (myRs2.next()) {
            tempList.add(new Artist(myRs2.getInt("id"), myRs2.getString("name"), myRs2.getString("lastname"), myRs2.getInt("birthyear")));
        }
        return tempList;
    }

    public static ArrayList findByBirthYear(int age) throws SQLException {
        ArrayList<Artist> tempList = new ArrayList<>();
        mySmt1 = myConn.prepareStatement("select * from artists where birthyear = ?");
        mySmt1.setInt(1, age);
        ResultSet myRs2 = mySmt1.executeQuery();

        while (myRs2.next()) {
            tempList.add(new Artist(myRs2.getInt("id"), myRs2.getString("name"), myRs2.getString("lastname"), myRs2.getInt("birthyear")));
        }
        return tempList;
    }

    public static ArrayList showAll() throws SQLException {
        ArrayList<Artist> tempList = new ArrayList<>();

        myRs = mySmt.executeQuery("select * from artists");

        while (myRs.next()) {
            tempList.add(new Artist(myRs.getInt("id"), myRs.getString("name"), myRs.getString("lastname"), myRs.getInt("birthyear")));
        }
        return tempList;
    }

}
