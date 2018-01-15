package com.gbc.flightbooker.db;

import android.arch.persistence.room.TypeConverter;
import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date fromTimestamp(Long value){
            return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long fromDate(Date date)
    {
        return date == null ? null : date.getTime();
    }
}
