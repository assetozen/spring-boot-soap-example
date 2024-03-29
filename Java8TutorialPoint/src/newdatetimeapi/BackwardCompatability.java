package newdatetimeapi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * A toInstant() method is added to the original Date and Calendar objects,
 * which can be used to convert them to the new Date-Time API.
 * Use an ofInstant(Insant,ZoneId) method to get a LocalDateTime or ZonedDateTime object.
 */
public class BackwardCompatability {
    public static void main(String[] args) {
        BackwardCompatability backwardCompatability = new BackwardCompatability();
        backwardCompatability.testBackwardCompatability();
    }

    private void testBackwardCompatability() {
        //Get the current date
        Date currentDate = new Date();
        System.out.println("Current date: "+ currentDate);

        //Get the instant of current date in terms of milliseconds
        Instant now = currentDate.toInstant();
        ZoneId currentZone = ZoneId.systemDefault();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
        System.out.println("Local date: "+ localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
        System.out.println("Zoned date: "+ zonedDateTime);

    }
}
