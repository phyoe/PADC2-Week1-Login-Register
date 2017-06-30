package xyz.phyoekhant.padc2_week1_login_register.events;

/**
 * Created by aung on 7/9/16.
 */
public class DataEvent {

    public static class DatePickedEvent {
        private String dateOfBrith;

        public DatePickedEvent(String dateOfBrith) {
            this.dateOfBrith = dateOfBrith;
        }

        public String getDateOfBrith() {
            return dateOfBrith;
        }
    }
}
