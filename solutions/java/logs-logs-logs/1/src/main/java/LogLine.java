public class LogLine {

    String str;
    String lvlStr;
    
    public LogLine(String logLine) {
        str = logLine;
    }

    public LogLevel getLogLevel() {
         lvlStr = str.substring(1,4);

        switch (lvlStr){
case "TRC": return LogLevel.TRACE;
            case "DBG": return LogLevel.DEBUG;
            case "INF": return LogLevel.INFO;
            case "WRN": return LogLevel.WARNING;
            case "ERR": return LogLevel.ERROR;
            case "FTL": return LogLevel.FATAL;
            default:    return LogLevel.UNKNOWN;
    }}

    public String getOutputForShortLog() {
         
// 1. Get the enum level and its number (assumes UNKNOWN is first in your Enum so it's 0)
        int encodedLevel = getLogLevel().getEncodedLevel();
        
        // 2. Grab the actual message (skips the "[INF]: " part which is 7 characters long)
        String message = str.substring(7);
         
        // 3. Return it in the required "number:message" format
        return encodedLevel + ":" + message;    }
}
