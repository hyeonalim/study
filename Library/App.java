import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        ArrayList<String> books = new ArrayList<>();
        ArrayList<String> members = new ArrayList<>();
        ArrayList<Rental> datas = new ArrayList<Rental>();

        Rental rental = new Rental();

        while (true) {

            System.out.println(
                    "1. 새 도서 입고, 2. 새 회원 등록, 3. 도서 대여, 4. 도서 삭제, 5. 회원 삭제, 6. 전체 도서 및 상황 출력, 7. 대여가 가능한 도서 목록 출력, 8. 회원 목록 출력");
            int no = scn.nextInt();
            scn.nextLine();

            if (no == 1) {

                // 1. 새 도서 입고
                System.out.println("새로 입고한 도서명을 입력해주세요:");
                String book = scn.nextLine();
                scn.nextLine();

                books.add(book);

                System.out.println(book + "의 입고가 완료되었습니다.");

            } else if (no == 2) {

                // 2. 새 회원 등록
                System.out.println("새로 가입할 회원이름을 입력하세요:");
                String member = scn.nextLine();
                scn.nextLine();

                members.add(member);

                System.out.println(member + "님, 환영합니다. 이제 책을 대여하실 수 있습니다.");

            } else if (no == 3) {

                System.out.println("회원명을 입력하세요:");
                String member = scn.nextLine();
                scn.nextLine();

                if (members.indexOf(member) == -1) {

                    // 만약 없는 회원을 입력할 경우
                    System.out.println("죄송합니다. " + member + "는 존재하지 않는 회원입니다. 회원 등록 후 대여 신청을 해주세요.");

                } else {

                    System.out.println("대여를 원하시는 도서명을 입력하세요:");
                    String book = scn.nextLine();
                    scn.nextLine();

                    if (books.indexOf(book) == -1) {

                        // 만약 등록된 회원이 없는 도서명을 입력한 경우
                        System.out.println("죄송합니다. " + book + "은 입고되어 있지 않습니다. 도서 목록을 확인 후 입고된 도서에 한해서 선택을 하시길 바랍니다.");

                    } else {

                        rental.member = member;
                        rental.book = book;

                        // 만약 등록된 회원이, 다른 회원이 빌려간 책을 입력했다면
                        if (rental.book.equals(book)) {

                            System.out.println(
                                    "죄송합니다. " + book + "은 " + rental.member + "님이 먼저 대여를 완료하여 재고가 없습니다. 다음에 다시 이용해주세요");

                        } else {

                            System.out.println(member + "님의 " + book + " 대여가 완료되었습니다.");

                        }
                    }

                }

            } else if (no == 4) {

                // 4. 도서 삭제
                System.out.println("삭제할 도서명을 입력하세요:");
                String book = scn.nextLine();
                scn.nextLine();

                if (books.indexOf(book) == -1) {

                    System.out.println("입력하신 " + book + "은 재고에 없습니다. 삭제 처리가 정상적으로 되지 않았습니다.");

                } else {

                    books.remove(book);

                    System.out.println(book + " 삭제 처리가 완료되었습니다.");

                }

            } else if (no == 5) {

                // 5. 회원 삭제
                System.out.println("삭제할 회원명을 입력하세요:");
                String member = scn.nextLine();
                scn.nextLine();

                if (members.indexOf(member) == -1) {

                    System.out.println("입력하신 " + member + "은 회원 목록에 없습니다. 삭제 처리가 정상적으로 되지 않았습니다.");

                } else {

                    members.remove(member);

                    System.out.println(member + " 삭제 처리가 완료되었습니다.");

                }

            } else if (no == 6) {

                System.out.println("전체 도서 및 상황을 출력합니다.");

                if (books.size() == 0) {

                    System.out.println("등록된 도서가 없습니다.");

                } else {

                    for (int i = 0; i < books.size(); i++) {

                        System.out.println("No." + i + 1 + " " + books.get(i));

                    }

                }

            } else if (no == 7) {

                System.out.println("대여 가능한 도서 목록입니다.");

                if (books.size() == 0) {

                    System.out.println("등록된 도서가 없습니다.");

                } else {

                    for (int i = 0; i < books.size(); i++) {

                        System.out.println("No." + i + 1 + " " + books.get(i));

                    }

                }

            } else if (no == 8) {

                // 8. 회원 목록 출력
                System.out.println("회원 목록입니다.");

                if (members.size() == 0) {

                    System.out.println("등록된 회원이 없습니다.");

                } else {

                    for (int i = 0; i < members.size(); i++) {

                        System.out.println("No." + i + 1 + " " + members.get(i));

                    }

                }

            } else {
                System.out.println("다시 선택해주세요.");
            }

        }
    }
}
