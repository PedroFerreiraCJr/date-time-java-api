package br.com.dotofcodex.java8_timeapi;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalQueries;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.Consumer;

/**
 * Classes:
 * {@link Instant}
 * {@link LocalDate}
 * {@link LocalTime}
 * {@link LocalDateTime}
 * {@link OffsetDateTime}
 * {@link ZonedDateTime}
 * {@link ZoneId}
 * {@link ZoneOffset}
 * {@link Period}
 * {@link Duration}
 * {@link Clock}
 * {@link DateTimeFormatter}
 * {@link DateTimeFormatterBuilder}
 * 
 * 
 * Pre Java 8:
 * {@link Date}
 * {@link Calendar}
 * {@link GregorianCalendar}
 * {@link SimpleDateFormat}
 *
 * 
 * Packages: java.time; java.time.chrono; java.time.format; java.time.temporal;
 * java.time.zone;
 * 
 * 
 * Docs: https://docs.oracle.com/javase/8/docs/api/; https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 * Tutorial: https://www.baeldung.com/java-8-date-time-intro; https://www.baeldung.com/java-date-to-localdate-and-localdatetime; https://www.journaldev.com/2800/java-8-date-localdate-localdatetime-instant
 */
public class Main {

	private static final SimpleDateFormat sdf;
	
	static {
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	}
	
	public static void main(String[] args) {
		// using instant
		System.out.println("Instant: ".concat(Instant.now().toString()));
		
		// using localdate
		System.out.println("LocalDate: ".concat(LocalDate.now().toString()));
		
		// using localtime
		System.out.println("LocalTime: ".concat(LocalTime.now().toString()));
		
		// using localdatetime
		System.out.println("LocalDateTime: ".concat(LocalDateTime.now().toString()));
		
		// using date (pre java 8)
		System.out.println("Date: ".concat(sdf.format(new Date())));
		
		// using offsetdatetime
		System.out.println("OffsetDateTime: ".concat(OffsetDateTime.now().toString()));
		
		// using zonedatetime
		System.out.println("ZoneDateTime: ".concat(ZonedDateTime.now().toString()));
		
		// using zoneid
		System.out.println("ZoneId: ".concat(ZoneId.systemDefault().toString()));
		
		// using zoneoffset
		System.out.println("ZoneOffset: ".concat(ZoneId.systemDefault().getRules().getOffset(LocalDateTime.now()).toString()));
		
		// using datetimeformatter
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS z");
		String d = "2019-04-18 23:25:59:159 -03:00";
		System.out.println("DateTimeFormatter[Date]: ".concat(dtf.parse(d, TemporalQueries.localDate()).toString()));
		System.out.println("DateTimeFormatter[Time]: ".concat(dtf.parse(d, TemporalQueries.localTime()).toString()));
		System.out.println("DateTimeFormatter[Zone]: ".concat(dtf.parse(d, TemporalQueries.zone()).toString()));
		
		localDateTime();
	}
	
	public static void localDateTime() {
		LocalDateTime today = LocalDateTime.now(ZoneId.systemDefault());
		System.out.println(today);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		ZoneId.getAvailableZoneIds().forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				if (t.toLowerCase().contains("america")) {
					System.out.println(t);
				}
				
			}
		});
	}

}
