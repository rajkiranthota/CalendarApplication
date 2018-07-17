
package com.rajk.CalendarProj;

import com.rajk.dao.CalendarEventsRepository;
import com.rajk.dao.CalendarRepository;
import com.rajk.model.Calendar;
import com.rajk.model.CalendarEvents;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rajkiran_Macys
 */

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CalendarRepository calendarRepository;
    private CalendarEventsRepository calendarEventsRepository;


    private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setCalendarRepository(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

     @Autowired
    public void setCalendarEventsRepository(CalendarEventsRepository calendarEventsRepository) {
        this.calendarEventsRepository = calendarEventsRepository;
    }
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadCalendars();
        loadCalendarEvents();
    }

    private void loadCalendars() {
        Calendar acal = new Calendar();
        acal.setCid( 101 );
        acal.setCname("Calendar For Raj");
        acal.setCuser("Raj");
        calendarRepository.save(acal);

        log.info("Saved Calendar - id: " + acal.getCid());
        
        acal.setCid( 102 );
        acal.setCname("Calendar For Kiran");
        acal.setCuser("Kiran");
        calendarRepository.save(acal);

        log.info("Saved Calendar - id: " + acal.getCid());

    }
    
    private void loadCalendarEvents() {
        CalendarEvents acalevents = new CalendarEvents();
        String patterndate = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patterndate);
        Date date1 = null;
        try {
             date1 = simpleDateFormat.parse("2018-07-16");
        } catch (ParseException ex) {
        }
        String patterntime = "HH:mm";
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(patterntime);
        Date time1 = null;
        try {
             time1 = simpleTimeFormat.parse("11:30");
        } catch (ParseException ex) {
        }
        acalevents.setCeventId(1011);
        acalevents.setCtitle("Meeting with Eric");
        acalevents.setCtime(time1);
        acalevents.setCdate(date1);
        acalevents.setClocation("Meeting Room 4F");
        acalevents.setCattendant("Mike");
        acalevents.setCreminderFlag('N');
        acalevents.setCcalendarFk(101);
        acalevents.setCreminderTime(time1);
        calendarEventsRepository.save(acalevents);

        log.info("Saved Calendar Event- id: " + acalevents.getCeventId());

    }

}

