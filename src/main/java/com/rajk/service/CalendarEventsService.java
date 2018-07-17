/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajk.service;

import com.rajk.model.CalendarEvents;

/**
 *
 * @author Rajkiran_Macys
 */
public interface CalendarEventsService {
    Iterable<CalendarEvents> listAllCalendarsEvents() ; 
       
       CalendarEvents getCalendarEventsById(Integer id) ;
       
       CalendarEvents saveCalendarEvents(CalendarEvents calendarEvents);
       
       void deleteCalendarEvents(Integer id) ;
}
