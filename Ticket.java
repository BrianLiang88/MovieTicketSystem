import java.time.LocalDateTime;

public class Ticket {
    private Movie movie; // 电影
    private int movieScene; // 电影场次
    private String buyer; // 购票人
    private int ticketNum; // 购票张数
    private LocalDateTime purchaseTime; // 购票时间

    public Ticket(Movie movie, int movieScene, String buyer, int ticketNum, LocalDateTime purchaseTime) {
        this.movie = movie;
        this.movieScene = movieScene;
        this.buyer = buyer;
        this.ticketNum = ticketNum;
        this.purchaseTime = purchaseTime;
    }

    public Ticket(String name, int playTime, String buyerName, int ticketNum) {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getMovieScene() {
        return movieScene;
    }

    public void setMovieScene(int movieScene) {
        this.movieScene = movieScene;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    @Override
    public String toString() {
        return "订单号：" + hashCode() +
                "\n电影场次：" + movieScene +
                "\n购票人：" + buyer +
                "\n购票张数：" + ticketNum +
                "\n购票时间：" + purchaseTime + "\n";
    }
}
