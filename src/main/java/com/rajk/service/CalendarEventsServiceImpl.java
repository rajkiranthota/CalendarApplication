/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajk.service;

import com.rajk.model.CalendarEvents;
import com.rajk.dao.CalendarEventsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rajkiran_Macys
 */
@Component
public class CalendarEventsServiceImpl implements CalendarEventsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

        private CalendarEventsRepository calendarEventsRepository;

    @Override
    public Iterable<CalendarEvents> listAllCalendarsEvents() {
        logger.debug("listAllEvents called");
        return calendarEventsRepository.findAll();     
    }

    @Override
    public CalendarEvents getCalendarEventsById(Integer id) {
        logger.debug("getCalendarEventsById called");
        return calendarEventsRepository.findById(id).orElse(null);    }

    @Override
    public CalendarEvents saveCalendarEvents(CalendarEvents calendarEvents) {
        logger.debug("saveCalendarEvents called");
        return calendarEventsRepository.save(calendarEvents) ;
    }

    @Override
    public void deleteCalendarEvents(Integer id) {
        logger.debug("deleteCalendarEvents called");
        calendarEventsRepository.deleteById(id);    }
    
}
