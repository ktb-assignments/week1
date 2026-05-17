import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        IBWorker worker = initialIBWorker();
        menuOfIB(worker);

    }

    public static IBWorker initialIBWorker() {
        System.out.println("안녕하세요, 작업을 위해 간단한 정보를 입력해주세요.");
        System.out.println("작업자명을 입력해주세요.");
        String name = sc.nextLine();
        System.out.println("진행할 작업의 수 입력해주세요.");
        int count = sc.nextInt();

        return new IBWorker(name, count);
    }

    public static void menuOfIB(IBWorker worker) {
        while (true) {
            Menu.showCommonMenu();
            Menu.shoIBWorkerMenu();

            int choice = sc.nextInt();

            switch (choice) {
                case 0 -> {
                    extracted0();
                    return;
                }
                case 1 -> extracted1(worker);
                case 2 -> extracted2(worker);
                case 3 -> {
                    if (extracted3(worker)) {
                        return;
                    }
                }
                case 11 -> extracted11(worker);
                case 12 -> extracted12(worker);
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void extracted0() {
        System.out.println("작업 도중 도망칩니다.");
    }

    private static void extracted1(IBWorker worker) {
        worker.showInfo();
    }

    private static void extracted2(IBWorker worker) {
        System.out.println("추가로 할당할 작업 수를 입력하세요.");
        int count = sc.nextInt();
        worker.addTask(count);
    }

    private static boolean extracted3(IBWorker worker) {
        if (worker.getIsDone()) {
            System.out.println("수고하셨습니다.");
            return true;
        }
        System.out.println("작업을 아직 마치지 않았습니다.");
        return false;
    }

    private static void extracted11(IBWorker worker) {
        sc.nextLine();
        System.out.println("추천받을 항목은? (phoneCase, cup, snack)");
        String productName = sc.nextLine();
        int boxNum = worker.getRecommendBoxNumber(productName);
        System.out.println("추천 박스 호수: " + boxNum + "호입니다.");
    }

    private static void extracted12(IBWorker worker) {
        sc.nextLine();
        System.out.println("포장을 진행할 상품명은? (phoneCase, cup, snack)");
        String productName = sc.nextLine();
        System.out.println("포장을 진행할 박스 호수는?");
        int boxNumber = sc.nextInt();
        boolean isCompleted = worker.completePackaging(productName, boxNumber);
        if (isCompleted) {
            System.out.println("포장 완료!");
            worker.complete();
        } else {
            System.out.println("박스 호수가 맞지 않습니다.");
        }
    }
}