// AGGREGATION: NoticeBoard aggregated by SchoolManagement
import java.util.Scanner;

public class NoticeBoard {

    String[] newsList;
    int newsCount;
    String inchargeName; // ASSOCIATION: NoticeBoard used by Employee

    Scanner scanner = new Scanner(System.in);


    public NoticeBoard() {
        newsList = new String[50];
        newsCount = 0;
        inchargeName = "";

    }


    public NoticeBoard(String inchargeName) {
        newsList = new String[50];
        newsCount = 0;
        this.inchargeName = inchargeName;
    }


    public void setInchargeName(String inchargeName) {
        this.inchargeName = inchargeName;
    }

    public void display() {
        System.out.println("===== NOTICE BOARD =====");
        if (newsCount == 0) {
            System.out.println("No news available.");
        } else {
            for (int i = 0; i < newsCount; i++) {
                System.out.println((i + 1) + ". " + newsList[i]);
            }
        }
        System.out.println("Incharge: " + inchargeName);
        System.out.println("========================");
    }

    public void addContent() {
        Scanner scanner = new Scanner(System.in);

        if (newsCount >= newsList.length) {
            System.out.println("Notice board is full. Can't add more news.");
            return;
        }

        System.out.print("Enter new notice: ");
        String newNotice = scanner.nextLine();

        newsList[newsCount] = newNotice;
        newsCount++;

        System.out.println("Notice added successfully.");
    }

    public void NoticeBoardMenu() {
        boolean run = true;
        while (run) {
            System.out.println("---NoticeBoard Menu---");
            System.out.println("1. Add Content");
            System.out.println("2. Show The Notice Board");
            System.out.println("3. EXIT");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addContent();
                    break;
                case 2:
                    display();
                    break;
                case 3: {
                    System.out.println("Exiting NoticeBoard Menu...");
                    run = false;
                }
                default:
                    System.out.println("Invalid choice Enter a number between 1 and 3.");
            }
        }
    }


}

