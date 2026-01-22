package library.project;

public class Date {
    
    public int Year;
    public int Month;
    public int Day;
    
    // Constructor
    /**
     * 
     * @param Year
     * @param Month
     * @param Day
     */
    public Date(int Year, int Month, int Day) {
        this.Year = Year;
        this.Month = Month;
        this.Day = Day;
    }

    // Getters
    public int getYear() {
        return this.Year;
    }

    public int getMonth() {
        return this.Month;
    }

    public int getDay() {
        return this.Day;
    }

    public Date getDueDate() {
        int y;
        int m;
        int d;

        y = (this.Month == 12 ? this.Year + 1 : this.Year);
        m = (this.Month + 1) % 12;
        d = this.Month % 28;

        return new Date(y, m, d);
    }


    public static Date Earliest(Date date1, Date date2) {
        if (date1.getYear() < date2.getYear()) {
            return date1;
        }
        else if (date2.getYear() < date1.getYear()) {
            return date2;
        } 
        else {
            if (date1.getMonth() < date2.getMonth()) {
                return date1;
            }
            else if (date2.getMonth() < date1.getMonth()) {
                return date2;
            } 
            else {
                if (date1.getDay() < date2.getDay()) {
                    return date1;
                }
                else if (date2.getDay() < date1.getDay()) {
                    return date2;
                } 
                else {
                    return date1;
                }
            }
        }
    }

    public boolean isEarlier(Date date2) {
        if (this.getYear() < date2.getYear()) {
            return true;
        }
        else if (date2.getYear() < this.getYear()) {
            return false;
        } 
        else {
            if (this.getMonth() < date2.getMonth()) {
                return true;
            }
            else if (date2.getMonth() < this.getMonth()) {
                return false;
            } 
            else {
                if (this.getDay() < date2.getDay()) {
                    return true;
                }
                else if (date2.getDay() < this.getDay()) {
                    return false;
                } 
                else {
                    return true;
                }
            }
        }
    }

    @Override
    public String toString() {
        String y = Integer.toString(this.getYear());
        String m = (this.getMonth() < 10 ? "0" + Integer.toString(this.getMonth()) : Integer.toString(this.getMonth()));
        String d = (this.getDay() < 10 ? "0" + Integer.toString(this.getDay()) : Integer.toString(this.getDay()));

        return (y + m + d);
    }

    public static Date fromString(String dateString) {
        int date = Integer.parseInt(dateString);

        int y;
        int m;
        int d;

        d = date % 100;
        m = (date / 100) % 100;
        y = date / 10000;

        return new Date(y, m, d);
    }

}
