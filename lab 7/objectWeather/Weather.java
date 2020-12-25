package objectWeather;

public class Weather {
    private String town;
    private Object dayW;
    private Object time;
    private String t;
    private String rains;
    private String Vw;
    private String P;

    public static int node = 0;

    public void setTown(String town) {
        this.town = town;
    }
    public void setDayW(String dayW) {
        this.dayW = dayW;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setT(String t) {
        this.t = t;
    }
    public void setRains(String rains) {
        this.rains = rains;
    }
    public void setVw(String vw) {
        Vw = vw;
    }
    public void setP(String p) {
        P = p;
    }

    public String getTown() {
        return town;
    }
    public Object getDayW() {
        return dayW;
    }
    public Object getTime() {
        return time;
    }
    public String getT() {
        return t;
    }
    public String getRains() {
        return rains;
    }
    public String getVw() {
        return Vw;
    }
    public String getP() {
        return P;
    }

    public Weather(String town, Object dayW, Object time,
                   String t, String rains,
                   String Vw, String P) {
        this.town = town;
        this.dayW = dayW;
        this.time = time;
        this.t = t;
        this.rains = rains;
        this.Vw = Vw;
        this.P = P;
    }
}
