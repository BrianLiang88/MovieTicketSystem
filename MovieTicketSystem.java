import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketSystem {
    private ArrayList<Movie> movieList;    // 电影列表
    private ArrayList<Ticket> ticketList;  // 电影票列表

    // 构造方法，初始化电影和电影票列表
    public MovieTicketSystem() throws Exception {
        movieList = new ArrayList<>();
        ticketList = new ArrayList<>();

        // 初始化电影列表
        movieList.add(new Movie("1945", "10:00", 200, 10));
        movieList.add(new Movie("1945", "15:00", 200, 10));
        movieList.add(new Movie("2023", "10:00", 200, 10));
        movieList.add(new Movie("2023", "15:00", 200, 10));
    }

    // 显示主菜单
    public void showMainMenu() {
        System.out.println("\n主菜单");
        System.out.println("1. 显示电影场次及余票");
        System.out.println("2. 购票登记");
        System.out.println("3. 显示售票记录");
        System.out.println("4. 显示销售统计");
        System.out.println("5. 保存购票记录");
        System.out.println("6. 导入购票记录");
        System.out.println("7. 退出");
    }

    // 显示电影场次及余票
    public void showMovieList() {
        System.out.println("\n--------------可售电影场次安排如下---------------------------");
        for (Movie movie : movieList) {
            System.out.println("场次：" + movie.getPlayTime() + "，电影：" + movie.getName() +
                    "，余票数量：" + movie.getRemainingTickets());
        }
    }

    // 购票登记
    public void registerTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n请输入购票信息：");
        System.out.print("电影名称：");
        String movieName = scanner.nextLine();
        System.out.print("场次：");
        int playTime = scanner.nextInt();
        System.out.print("购票人姓名：");
        String buyerName = scanner.nextLine();
        System.out.print("购票张数：");
        int ticketNum = scanner.nextInt();

        // 检查电影是否存在
        Movie movie = null;
        for (Movie m : movieList) {
            if (m.getName().equals(movieName) && m.getPlayTime()==playTime) {
                movie = m;
                break;
            }
        }
        if (movie == null) {
            System.out.println("无效场次，请重新输入！");
            return;
        }

        // 检查余票数量是否足够
        if (movie.getRemainingTickets() < ticketNum) {
            System.out.println("余票不足，请重新输入！");
            return;
        }

        // 售出电影票
        movie.sellTicket(ticketNum);
        Ticket ticket = new Ticket(movie.getName(), movie.getPlayTime(), buyerName, ticketNum);
        ticketList.add(ticket);
        System.out.println("购票成功！购票信息如下：");
        System.out.println(ticket.toString());
    }

    // 显示售票记录
    public void showTicketList() {
        System.out.println("\n--------------------- 订单列表如下 ----------------------------------");
        for (Ticket ticket : ticketList) {
            System.out.println(ticket.toString());
        }
    }

    // 显示销售统计
    public void showSalesStatistics() {
        int totalSales = 0; // 总销售额
        System.out.println("\n--------------------- 销售统计如下 ----------------------------------");
        for (Movie movie : movieList) {
            int soldTickets = movie.getTotalTickets() - movie.getRemainingTickets(); // 卖出的电影票数量
            int sales = (int) (soldTickets * movie.getPrice()); // 卖出的电影票总价值
            System.out.println("电影名称：" + movie.getName() + "，场次：" + movie.getPlayTime() +
                    "，售出电影票数量：" + soldTickets + "，电影票总价值：" + sales);
            totalSales += sales;
        }
        System.out.println("总销售额：" + totalSales);
    }

    // 保存购票记录
    public void saveTicketList() {
// 省略保存购票记录的代码
        System.out.println("\n购票记录已保存！");
    }

    // 导入购票记录
    public void importTicketList() {
// 省略导入购票记录的代码
        System.out.println("\n购票记录已导入！");
    }

    // 运行电影票系统
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMainMenu();
            System.out.print("请选择：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符
            switch (choice) {
                case 1:
                    showMovieList();
                    break;
                case 2:
                    registerTicket();
                    break;
                case 3:
                    showTicketList();
                    break;
                case 4:
                    showSalesStatistics();
                    break;
                case 5:
                    saveTicketList();
                    break;
                case 6:
                    importTicketList();
                    break;
                case 7:
                    System.out.println("\n感谢使用本系统，再见！");
                    return;
                default:
                    System.out.println("\n输入有误，请重新输入！");
                    break;
            }
        }
    }
    public static void main(String[] args) throws Exception {

        // 创建一个新的电影票系统对象
        MovieTicketSystem ticketSystem = new MovieTicketSystem();
        // 调用run方法启动电影票系统
        ticketSystem.run();
    }
}
