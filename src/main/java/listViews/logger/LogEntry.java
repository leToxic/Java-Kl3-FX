package listViews.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created: 25.05.2023 at 20:26
 *
 * @author Plasek Sebastian
 */
public class LogEntry {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss");
    private final String desc;
    private final LocalDateTime timestamp;

    public LogEntry(String desc) {
        this.desc = desc;
        this.timestamp = LocalDateTime.now();
    }

    public String makeText() {
        return timestamp.format(formatter) + ": " + desc;
    }
}
