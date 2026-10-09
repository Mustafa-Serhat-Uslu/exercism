import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Fixed import

class AppointmentScheduler {

    DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    // LocalDateTime datetime;
    
    public LocalDateTime schedule(String appointmentDateDescription) {
       return LocalDateTime.parse(appointmentDateDescription, parser);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return LocalDateTime.now().isAfter(appointmentDate);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
         int theHour = appointmentDate.getHour();

            return theHour >= 12 && theHour < 18;
    }

public String getDescription(LocalDateTime appointmentDate) {
    // 1. Create a formatter with the exact pattern needed
    DateTimeFormatter printer = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a");
    
    // 2. Format the date and combine it into the expected sentence
    return "You have an appointment on " + printer.format(appointmentDate) + ".";
}

    public LocalDate getAnniversaryDate() {
        int currentYear = LocalDateTime.now().getYear();
    
    // 2. Construct a new date for Sept 15th of the current year at 00:00 (midnight)
return LocalDate.of(currentYear, 9, 15);    }
}
