package ac.za.cput.factory.logevent;

import ac.za.cput.domain.logevent.LogEvent;

public class LogEventFactory {

    public static LogEvent GenerateBuilder(String responseCode,String responseDesc)
    {
        return new LogEvent(responseCode,responseDesc);
    }

}
