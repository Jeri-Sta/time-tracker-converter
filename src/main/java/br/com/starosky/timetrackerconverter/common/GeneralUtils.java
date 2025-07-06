package br.com.starosky.timetrackerconverter.common;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class GeneralUtils {

    public static LocalDate parseDate(String dateStr) {
        String[] parts = dateStr.split(" ")[0].split("-");
        return LocalDate.of(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2])
        );
    }

    public static String getFinalDecimalString(String hoursString) {
        String clean = hoursString.replaceAll("[^0-9.,]", "").replace(",", ".").replace("\"", "");
        double value = Double.parseDouble(clean);
        int hours = (int) value;
        int minutes = (int) Math.round((value - hours) * 60);

        if (minutes == 60) {
            hours++;
            minutes = 0;
        }
        return hours + "." + String.format("%02d", minutes);
    }
}
