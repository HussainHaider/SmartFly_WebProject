package com.hussain.Data_Layer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

import static java.lang.System.out;

public class FlightSearchDao {
    String sqlquery=null;

    public ArrayList<Hashtable<String,String>> Searchflight(String source, String destionation,String time,String Fclass)
    {
        ArrayList<Hashtable<String,String>>list = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/smartflydb","root", null);



            out.println("flightClass check");
            sqlquery="select * from flight where source=? AND Destination=? And Date=? And flightCid=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sqlquery);
            preparedStatement.setString(1,source);
            preparedStatement.setString(2,destionation);
            preparedStatement.setString(3,"2017-10-18");
            preparedStatement.setString(4,"1");

            ResultSet rs=preparedStatement.executeQuery();

            while(rs.next()){
                Hashtable<String,String> hashTable=new Hashtable<String,String>();
                out.println("flightClass check2");

                String value = rs.getString("FID");
                hashTable.put("id", value);

                value = rs.getString("source");
                hashTable.put("source", value);

                value = rs.getString("Destination");
                hashTable.put("destination", value);

                value = rs.getString("Fname");
                hashTable.put("Fname", value);

                value = rs.getString("Date");
                hashTable.put("Date", value);

                value = rs.getString("DeptTime");
                hashTable.put("DeptTime", value);


                value = rs.getString("FlightTime");
                hashTable.put("FlightTime", value);

                value = rs.getString("approve");
                hashTable.put("approve", value);

                list.add(hashTable);
            }

        }catch (ClassNotFoundException e) {
            out.println("Check3");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }






    public Hashtable<String,String> SearchflightbyID(String FID)
    {
        Hashtable<String,String>list = new Hashtable<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/smartflydb","root", null);



            out.println("flightClass check");
            sqlquery="select * from flight where FID=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sqlquery);
            preparedStatement.setString(1,FID);

            ResultSet rs=preparedStatement.executeQuery();

            if(rs.next()){

                String value = rs.getString("FID");
                list.put("id", value);

                value = rs.getString("source");
                list.put("source", value);

                value = rs.getString("Destination");
                list.put("destination", value);

                value = rs.getString("Fname");
                list.put("Fname", value);

                value = rs.getString("Date");
                list.put("Date", value);

                value = rs.getString("DeptTime");
                list.put("DeptTime", value);


                value = rs.getString("FlightTime");
                list.put("FlightTime", value);

                value = rs.getString("flightCid");
                list.put("flightCid", value);

                value = rs.getString("Price");
                list.put("Price", value);
            }

        }catch (ClassNotFoundException e) {
            out.println("Check3");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
