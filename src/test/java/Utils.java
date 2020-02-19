import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {


    public static String getFormattedRandomDate() {
        LocalDate returnedDate = LocalDate.now();

        returnedDate = returnedDate.plusDays(new Random().nextInt((30 - 3) + 1) + 3);
        return returnedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
