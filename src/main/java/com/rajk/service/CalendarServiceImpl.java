package com.rajk.service;

import com.rajk.dao.CalendarRepository;
import com.rajk.model.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rajkiran_Macys
 */
@Component
public class CalendarServiceImpl implements CalendarService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private CalendarRepository calendarRepository;

    @Autowired
    public void setCalendarRepository(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }  

    @Override
    public Iterable<Calendar> listAllCalendars() {
         logger.debug("listAllEvents called");
        return calendarRepository.findAll();       
    }
    
    @Override
    public Calendar getCalendarById(Integer id) {
        logger.debug("getCalendarById called");
        return calendarRepository.findById(id).orElse(null);
    }

    @Override
    public Calendar saveCalendar(Calendar calendar) {
        logger.debug("saveCalendar called");
        return calendarRepository.save(calendar) ;

    }
    
    @Override
    public void deleteCalendar(Integer id) {
        logger.debug("deleteCalendar called");
        calendarRepository.deleteById(id);
  
    }
}
