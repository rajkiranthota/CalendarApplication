
package com.rajk.service;

import com.rajk.model.Calendar;

/**
 *
 * @author Rajkiran_Macys
 */
public interface CalendarService {
       Iterable<Calendar> listAllCalendars() ; 
       
       Calendar getCalendarById(Integer id) ;
       
       Calendar saveCalendar(Calendar calendar);
       
       void deleteCalendar(Integer id) ;
       
       
}
