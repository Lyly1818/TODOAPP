package net.trancool.todoapp.repo

import androidx.room.TypeConverter
import java.time.Instant
import java.util.*


//convert Instant object into Date Long and vice versa
class TypeTransmogrifier {

    @TypeConverter
    fun fromInstant(date: Instant?) : Long? = date?.toEpochMilli()

//    @TypeConverter
//    fun toInstant(millisSinceEpoch:Long?): Instant? = millisSinceEpoch.let{
//        it?.let { it1 -> Instant.ofEpochMilli(it1) }
//    }

    @TypeConverter
    fun toInstant(millisSinceEpoch: Long?): Instant? = millisSinceEpoch?.let {
        Instant.ofEpochMilli(it)
    }




}