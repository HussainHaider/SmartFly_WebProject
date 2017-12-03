package com.hussain.Business_Layer;

import com.hussain.Data_Layer.FlightSearchDao;

import java.util.ArrayList;
import java.util.Hashtable;

public class flightServices {

    FlightSearchDao flightsearch=new FlightSearchDao();

    public ArrayList<flightClass> searchOneWayflight(String source, String destionation, String date, String Fclass)
    {
        flightClass F=null;
        ArrayList<Hashtable<String,String >> hashTable = flightsearch.Searchflight(source,destionation,date,Fclass);
        ArrayList<flightClass> list=new ArrayList<>();

        if(hashTable != null)
        {
            for (int i=0;i<hashTable.size();i++)
            {
                String id= hashTable.get(i).get("id");
                String sources=hashTable.get(i).get("source");
                String destination= hashTable.get(i).get("destination");
                String Fname= hashTable.get(i).get("Fname");
                String Date= hashTable.get(i).get("Date");
                String DeptTime= hashTable.get(i).get("DeptTime");
                String FlightTime =hashTable.get(i).get("FlightTime");
                String flightCid= hashTable.get(i).get("flightCid");
                String Price= hashTable.get(i).get("Price");


//                out.println("Check1"+id);
//                out.println("Check2"+sources);
//                out.println("Check3"+destination);
//                out.println("Check4"+Fname);
//                out.println("Check5"+Date);
//                out.println("Check6"+DeptTime);
//                out.println("Check7"+FlightTime);
//                out.println("Check8"+flightCid);
//                out.println("Check9"+Price);




//                list.add(new flightClass(Integer.valueOf(id),sources,destination,Fname,Date,DeptTime,FlightTime,flightCid,Integer.valueOf(Price)));
            }
        }
        return list;
    }


    public flightClass getOneWayflight(String FID)
    {
        flightClass F=null;
        Hashtable<String,String > hashTable = flightsearch.SearchflightbyID(FID);

        if(hashTable != null)
        {
            String id= hashTable.get("id");
            String sources=hashTable.get("source");
            String destination= hashTable.get("destination");
            String Fname= hashTable.get("Fname");
            String Date= hashTable.get("Date");
            String DeptTime= hashTable.get("DeptTime");
            String FlightTime =hashTable.get("FlightTime");
            String flightCid= hashTable.get("flightCid");
            String Price= hashTable.get("Price");


 //           F=new flightClass(Integer.valueOf(id),sources,destination,Fname,Date,DeptTime,FlightTime,flightCid,Integer.valueOf(Price));

        }
        return F;
    }

}
