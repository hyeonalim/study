mport java.util.ArrayList;
import java.util.Scanner;

public class Library {

    Scanner scn = new Scanner(System.in);

    void run(ArrayList<String> members, ArrayList<String> books, ArrayList<Rental> rentals){

        System.out.println("1. 새 도서 입고, 2. 새 회원 등록, 3. 도서 대여, 4. 도서 삭제, 5. 회원 삭제, 6. 전체 도서 및 상황 출력, 7. 대여가 가능한 도서 목록 출력, 8. 회원 목록 출력");
        int no = scn.nextInt();
        scn.nextLine();    

        if(no == 1){

            newBook(books);

        }else if(no == 2){

            newMember(members);

        }else if(no == 3){

            rentalBook(books, members, rentals);

        } else if(no == 4) {
        
            returnBook(members, books, rentals);

        }else if(no == 5) {

            deleteBook(books, rentals);

        } else if(no == 6) {

            delteMember(members, rentals);

        } else if(no == 7) {

            allBook(books, rentals);

        } else if(no == 8) {

            rentalFree(books, rentals);
            
        } else if(no == 9) {

            allMembers(members);

        } else {
            
            System.out.println("다시 입력해주세요.");

        }

    }

    void newBook(ArrayList<String> books){

        //1. 새 도서
        System.out.println("새 도서명 입력");
        String book = scn.nextLine();
        scn.nextLine();

        if(books.contains(book) == true) {

            System.out.println("이미 있는 도서");

        }else {
            books.add(book);

            System.out.println(book + "입고 완료");

        }
    }

    void newMember(ArrayList<String> members){

        //2. 새 멤버
        System.out.println("새 멤버 입력");
        String member = scn.nextLine();
        scn.nextLine();

        if(members.contains(member) == true) {
        
            System.out.println("이미 있는 회원");

        }else {
            members.add(member);

            System.out.println(member + "등록 완료");

        }
    }

    void rentalBook(ArrayList<String> members, ArrayList<String> books, ArrayList<Rental> rentals){

        //3. 도서 대여
        System.out.println("회원명 입력");
        String member = scn.nextLine();
        scn.nextLine();

        if(members.contains(member) == false) {

            System.out.println("회원이 존재하지 않습니다.");

        }else {

            System.out.println("도서명 입력");
            String book = scn.nextLine();
            scn.nextLine();

            if(books.contains(book) == false) {

                System.out.println("도서가 존재하지 않습니다.");

            }else {

                boolean isRentaled = false;

                for(int i = 0; i < rentals.size(); i++) {

                    Rental r = rentals.get(i);

                    if(r.book.equals(book)) {

                        if(r.member.equals(member)) {
                            
                            System.out.println("이미 대여중이십니다.");
                            isRentaled = true;
                            break;

                        }else {
                            
                            System.out.println("죄송합니다. " + book + "도서는 " + r.member + "님이 대여하는 중입니다.");

                            isRentaled = true;
                            break;
                        }
                    }
                }

                if(isRentaled != true){
                    
                    rentals.add(new Rental(member, book));
                
                    System.out.println(member + " 회원님이 " + book + "도서를 대여하였습니다.");
                
                }

            }
        }

    }

    void returnBook(ArrayList<String> members, ArrayList<String> books, ArrayList<Rental> rentals){

        //4. 도서 반납
        System.out.println("회원명 입력");
        String member = scn.nextLine();
        scn.nextLine();

        if(members.contains(member) == false) {

            System.out.println("회원이 존재하지 않습니다.");

        }else {

            System.out.println("도서명 입력");
            String book = scn.nextLine();
            scn.nextLine();

            if(books.contains(book) == false) {

                System.out.println("도서가 존재하지 않습니다.");

            }else {

                boolean isRentaled = false;

                for(int i = 0; i < rentals.size(); i++) {

                    Rental r = rentals.get(i);

                    //대여한 책 찾기
                    if(r.book.equals(book) == true) {

                        if(r.member.equals(member) == true) {

                            rentals.remove(r);

                            System.out.println(member + "님이 대여하신 " + book + "반납 완료");
                            break;

                        }else{

                            System.out.println(book + "은 " + r.member + "님이 대여 중");

                        }
                    }else{

                        System.out.println("아무도 대여중이지 않습니다.");

                    }
                }

            }
        }
    }

    void deleteBook(ArrayList<String> books, ArrayList<Rental> rentals){

        //5. 도서 삭제
        System.out.println("삭제 도서 입력");
        String book = scn.nextLine();
        scn.nextLine();

        if(books.contains(book) == true) {

            boolean hereBook = false;

            for(int i = 0; i < rentals.size(); i++) {

                Rental r = rentals.get(i);

                if(r.book.equals(book)) {

                    System.out.println(book + " 빌리는 중이라 삭제 불가");
                    
                    hereBook = true;
                    break;

                }
    
            }

            if(hereBook != true) {
            
                books.remove(book);

                System.out.println(book + " 도서 삭제 완료");
            
            }

        } else {

            System.out.println(book + "도서는 도서관에 없습니다.");

        }
    }

    void delteMember(ArrayList<String> members, ArrayList<Rental> rentals){

        //6. 회원 삭제
        System.out.println("삭제할 회원명 입력");
        String member = scn.nextLine();
        scn.nextLine();

        if(members.contains(member) == true) {

            boolean hereMember = false;

            for(int i = 0; i < rentals.size(); i++) {

                Rental r = rentals.get(i);

                if(r.member.equals(member)) {

                    System.out.println(member + " 회원님은 대여중이라 삭제 불가");
                    
                    hereMember = true;
                    break;

                }

            }

            if(hereMember != true) {

                members.remove(member);

                System.out.println(member + " 회원 삭제 완료");

            }
        }else {
            System.out.println("존재하지 않는 회원명");
        }
    }

    void allBook(ArrayList<String> books, ArrayList<Rental> rentals){

        //7.모든 책 목록
        System.out.println("모든 도서 목록");

        if(books.size() == 0) {

            System.out.println("등록된 도서가 없습니다.");

        }else {

            ArrayList<String> free = new ArrayList<>();
            ArrayList<String> rentaling = new ArrayList<>();

            for(int i = 0; i < books.size(); i++) {

                boolean hereRentalFree = false;

                for(int j = 0; j < rentals.size(); j++) {
                    
                    Rental r = rentals.get(j);
                    
                    if(r.book.equals(books.get(i))) {

                        rentaling.add(books.get(i));
                        hereRentalFree = true;

                        break;
                    }
                }

                if(hereRentalFree != true) {
                    
                    free.add(books.get(i));

                }
            }

            for(int i = 0; i < free.size(); i++) {
                
                System.out.println(free.get(i));

            }

            for(int i = 0; i < rentaling.size(); i++) {
                
                System.out.println(rentaling.get(i) + "(대여중)");

            }

        }

    }
    
    void rentalFree(ArrayList<String> books, ArrayList<Rental> rentals){

        //8. 대여 가능한 목록
        System.out.println("대여 가능한 도서 목록");

        if(books.size() == 0){

            System.out.println("등록된 도서가 없습니다.");

        }else{

            ArrayList<String> free = new ArrayList<>();

            for(int i = 0; i < books.size(); i++) {

                boolean hereRentalFree = false;

                for(int j = 0; j < rentals.size(); j++) {
                    
                    Rental r = rentals.get(j);
                    
                    if(r.book.equals(books.get(i))) {

                        hereRentalFree = true;

                        break;
                    }
                }

                if(hereRentalFree != true) {
                    
                    free.add(books.get(i));
                    
                }
            }

            for(int i = 0; i < free.size(); i++) {
                
                System.out.println(free.get(i));

            }

            if(free.isEmpty() == true) {

                System.out.println("대여 가능한 도서가 존재하지 않습니다.");

            }
        }

    }

    void allMembers(ArrayList<String> members){

        //9. 회원목록
        if(members.isEmpty() == true) {

            System.out.println("등록된 회원이 없습니다.");

        }else {
            int no = 1;

            for(int i = 0; i < members.size(); i++) {

                System.out.println("회원" + no + ": " + members.get(i));

                no++;
            }
        }
    }

}
