package fr.dawan.formation.QCMappPersistenceInterfaces;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
 
/**
 * java.util.date to java.sql.date
 */
public class DatesConversion {
 
        java.util.Date uDate = new java.util.Date();
        java.sql.Date sDate = convertUtilToSql(uDate);
        
    
 
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}

