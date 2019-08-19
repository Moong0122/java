import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        Theater t = new Theater(10,16);
        Scanner scanner = new Scanner(System.in);
        boolean out = false;

        System.out.println(" < Moong box >");
        while(out != true) {
            System.out.println("1. 예매하기");
            System.out.println("2. 예매 취소하기");
            System.out.println("3. 예매 확인하기");
            System.out.println("4. 종료하기");
            System.out.println("번호를 입력해주세요");
            System.out.print("-> ");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println(" < 예매하기 >");
                    t.printSeatMatrix();
                    System.out.println("예약자의 성함을 입력해주세요");
                    System.out.print("-> ");
                    String name = scanner.next();
                    System.out.println("원하는 좌석의 열과 번호, 예약하실 좌석 수를 입력해주세요");
                    System.out.print("-> ");
                    char c = scanner.next().toUpperCase().charAt(0);
                    int num = scanner.nextInt();
                    int cnt = scanner.nextInt();
                    System.out.println(name + "님의 이름으로 " + c + "열 " + num + "번부터 " + cnt + "석 예매" + (t.reserve(name, c, num, cnt) ? " 완료했습니다" : " 실패했습니다"));
                    break;
                case 2:
                    System.out.println("예약자의 성함을 입력해주세요");
                    System.out.print("-> ");
                    name = scanner.next();
                    System.out.println(name + "님의 좌석 취소: 총 " + t.cancel(name) + "개의 좌석이 취소되었습니다.");
                    break;
                case 3:
                    t.printSeatMatrix();
                    break;
                case 4:
                    System.out.println("이용해주셔서 감사합니다!");
                    out = true;
                    break;
                default:
                    System.out.println("다시 한번 숫자 입력바랍니다.");
                    break;
            }
        }
    }
}