package com.gbc.flightbooker.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.util.Log;

import com.gbc.flightbooker.db.dao.*;
/**
 * Created on 12/14/2017.
 */

@Database(entities = {Customer.class, Booking.class, Flight.class}, version = 13, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase{
     private static AppDatabase INSTANCE;

     public abstract CustomerDao customerDao();
     public abstract BookingDao bookingDao();
     public abstract FlightDao flightDao();

     public static AppDatabase getDatabase(Context context){
         if(INSTANCE ==null){
             INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "FlightDB")
                     .fallbackToDestructiveMigration()
                     .allowMainThreadQueries()
                     .build();
         }
         return INSTANCE;
     }


     public static void destroyInstance(){
         INSTANCE = null;
     }

}
