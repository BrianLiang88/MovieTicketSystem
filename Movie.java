import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
    private String name; // 电影名称
    private Date time; // 播放时间
    private int remainingTickets; // 剩余票数
    private int price;
    private int playTime;
    private int ticketCount;

    public Movie(String name, Date time, int remainingTickets) {
        this.name = name;
        this.time = time;
        this.remainingTickets = remainingTickets;
    }

    public Movie(String name, String timeStr, int remainingTickets, int playTime) throws Exception {
        this.name = name;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        this.time = formatter.parse(timeStr);
        this.remainingTickets = remainingTickets;
        this.playTime = playTime;
    }

    public String getName() {
        return name;
    }

    public Date getTime() {
        return time;
    }

    public int getRemainingTickets() {
        return remainingTickets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setRemainingTickets(int remainingTickets) {
        this.remainingTickets = remainingTickets;
    }

    public int getPlayTime() {
        return this.playTime;
    }

    public void sellTicket(int ticketNum) {
        this.ticketCount++;
    }

    public double getPrice() {
        return this.price;
    }


    // 重写toString方法，方便输出电影信息
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "电影：" + name + "\n" +
                "放映时间：" + sdf.format(time) + "\n" +
                "余票数量：" + remainingTickets + "\n";
    }

    public int getTotalTickets() {
        return 20;
    }
}
