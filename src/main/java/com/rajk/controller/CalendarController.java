
package com.rajk.controller;

import com.rajk.model.Calendar;
import com.rajk.model.CalendarEvents;
import com.rajk.service.CalendarService;
import com.rajk.service.CalendarServiceImpl;
import com.rajk.service.CalendarEventsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Rajkiran_Macys
 */

@RestController
@RequestMapping("/calendar")
@Api(value="calendar", description="Calendar Operations")
public class CalendarController {

    private CalendarService calendarService;
    private CalendarEventsService calendarEventsService;

    @Autowired
    public void setCalendarService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }
    
    @Autowired
    public void setCalendarEventsService(CalendarEventsService calendarEventsService) {
        this.calendarEventsService = calendarEventsService;
    }

    @ApiOperation(value = "View a list of available Calendars",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Calendar> list(Model model){
        Iterable<Calendar> calendarList =  calendarService.listAllCalendars();
        return calendarList;
    }

    @ApiOperation(value = "View a list of event",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved event list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/calendarlist", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Calendar> eventslist(Model model){
       Iterable<Calendar> evtList = calendarService.listAllCalendars()  ;
       return evtList;
    }
 
    
    @ApiOperation(value = "Search a calendar with an ID",response = Calendar.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Calendar showEvent(@PathVariable Integer id, Model model){
       Calendar cal = calendarService.getCalendarById(id);
        return cal;
    }

    @ApiOperation(value = "Add a Calendar")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveCalendar(@RequestBody Calendar calendar){
        calendarService.saveCalendar(calendar);
        return new ResponseEntity("Calendar saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update an Calendar")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateCalendar(@PathVariable Integer id, @RequestBody Calendar cal){
        Calendar calendar = calendarService.getCalendarById(id);
        if ( cal.getCname() != null  )
            calendar.setCname( cal.getCname() );

        calendarService.saveCalendar(calendar);
        return new ResponseEntity("Calendar updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Calendar")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id){
        calendarService.deleteCalendar(id);
        return new ResponseEntity("Calendar deleted successfully", HttpStatus.OK);
    } 

    @RequestMapping(value = "/calendarEventlist", method= RequestMethod.GET, produces = "application/json")
    public Iterable<CalendarEvents> calendarEventslist(Model model){
       Iterable<CalendarEvents> evtList = calendarEventsService.listAllCalendarsEvents() ;
       return evtList;
    }
 
    
    @ApiOperation(value = "Search a calendar with an ID",response = CalendarEvents.class)
    @RequestMapping(value = "/showEvent/{id}", method= RequestMethod.GET, produces = "application/json")
    public CalendarEvents showCalendarEvent(@PathVariable Integer id, Model model){
       CalendarEvents cal = calendarEventsService.getCalendarEventsById(id);
        return cal;
    }

    @ApiOperation(value = "Add a Calendar")
    @RequestMapping(value = "/addEvents", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveCalendarEvents(@RequestBody CalendarEvents calendarEvents){
        calendarEventsService.saveCalendarEvents(calendarEvents);
        return new ResponseEntity("Calendar saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update an Calendar")
    @RequestMapping(value = "/updateCalendarEvents/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateCalendarEvents(@PathVariable Integer id, @RequestBody CalendarEvents cal){
        CalendarEvents calendarEvents = calendarEventsService.getCalendarEventsById(id);
        if ( cal.getCtime() != null  )
            calendarEvents.setCtitle( calendarEvents.getCtitle() );
            calendarEvents.setCdate(calendarEvents.getCdate());
            calendarEvents.setCtime(calendarEvents.getCtime());
            calendarEvents.setClocation(calendarEvents.getClocation());
            calendarEvents.setCattendant(calendarEvents.getCattendant());
            calendarEvents.setCreminderFlag(calendarEvents.getCreminderFlag());
            calendarEvents.setCreminderTime(calendarEvents.getCreminderTime());
        calendarEventsService.saveCalendarEvents(calendarEvents);
        return new ResponseEntity("Calendar updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Calendar")
    @RequestMapping(value="/deleteCalendarEvents/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteCalendarEvents(@PathVariable Integer id){
        calendarEventsService.deleteCalendarEvents(id);
        return new ResponseEntity("Calendar deleted successfully", HttpStatus.OK);
    } 
    }

    

