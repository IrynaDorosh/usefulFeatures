package other;

import org.testng.annotations.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class Dates {

    /**
     * EET (winter) - Eastern Europe Time = UTC+2
     * EEST (summer)                     = UTC+3
     *
     * PST (winter) - America/Los_Agneles  = UTC-8
     * PDT (summer)                        =UTC-7
     *
     * z = UTC time
     */


    @Test
    public void testName() {
        System.out.println(apiToUiTimeConverter(ZonedDateTime.now()));
   }

    public String apiToUiTimeConverter(ZonedDateTime apiTime) {
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd, yyy hh:mm a");
        ZonedDateTime zoned = apiTime.withZoneSameInstant(zoneId);
        return zoned.format(dateTimeFormatter);
    }



    @Test
    public void convertSecondsToZonedDateTime() {

        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zdtActual = ZonedDateTime.parse("2020-03-14T20:02:50Z[UTC]");

        Long zdtActualLong = zdtActual.toEpochSecond();
        Instant i = Instant.ofEpochSecond(zdtActualLong);

        ZonedDateTime zdtExpected = ZonedDateTime.ofInstant(i, ZoneId.of("UTC"));
///        ZonedDateTime zdtExpected = ZonedDateTime.ofInstant(i, zoneId);  <- either with UTC, as above, or with exact timezone
        System.out.println(zdtExpected);

        assertThat(zdtActual, equalTo(zdtExpected));
    }






}
