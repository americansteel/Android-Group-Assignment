package com.gbc.flightbooker.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.gbc.flightbooker.db.Flight;
import java.util.List;

/**
 * Created on 12/14/2017.
 */
@Dao
public interface FlightDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Flight> flight);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Flight flight);

    @Query("DELETE FROM Flight")
    void deleteAllFlights();

    @Query("SELECT * FROM flight")
    List<Flight> fetchAllFlights();

    @Query("SELECT * FROM flight WHERE flightId = :id")
    List<Flight> fetchFlightByID(int id);

    @Query("SELECT * from flight WHERE destination LIKE :destination COLLATE NOCASE AND departureDate BETWEEN date(:start) AND date(:start, '+1 day')")
    List<Flight> fetchFlightByCityDate(String destination, String start);

    @Query("Delete FROM flight WHERE flightId = :id")
    void deleteFlightByID(int id);

}
