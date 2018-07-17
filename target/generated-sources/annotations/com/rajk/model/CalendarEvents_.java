package com.rajk.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-17T09:30:03")
@StaticMetamodel(CalendarEvents.class)
public class CalendarEvents_ { 

    public static volatile SingularAttribute<CalendarEvents, Date> creminderTime;
    public static volatile SingularAttribute<CalendarEvents, Date> cdate;
    public static volatile SingularAttribute<CalendarEvents, String> ctitle;
    public static volatile SingularAttribute<CalendarEvents, Integer> ccalendarFk;
    public static volatile SingularAttribute<CalendarEvents, Date> ctime;
    public static volatile SingularAttribute<CalendarEvents, Integer> ceventId;
    public static volatile SingularAttribute<CalendarEvents, Character> creminderFlag;
    public static volatile SingularAttribute<CalendarEvents, String> cattendant;
    public static volatile SingularAttribute<CalendarEvents, String> clocation;

}