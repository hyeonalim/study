import java.util.HashSet;
import java.util.Scanner;

public class Library {

    Scanner scn = new Scanner(System.in);

    void run(HashSet<String> members, HashSet<String> books, HashSet<Rental> rentals) throws Exception {
        
        System.out.println("1. 새 도서 입고");
        System.out.println("2. 회원 등록");
        System.out.println("3. 도서 대여");
        System.out.println("4. 도서 반납");
        System.out.println("5. 도서 삭제");
        System.out.println("6. 회원 삭제");
        System.out.println("7. 전체 도서");
        System.out.println("8. 대여 가능한 도서");
        System.out.println("9. 회원목록 출력");

        int no = scn.nextInt();
        scn.nextLine();

        if(no == 1) {

            newBook(books);

        } else if(no == 2) {

            newMember(members);

        } else if(no == 3) {

            rentalBook(members, books, rentals);

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

    void newBook(HashSet<String> books){

        //1. 도서 추가
        System.out.println("추가할 도서명 입력");
        String book = scn.nextLine();
        scn.nextLine();

        if(books.contains(book)){

            System.out.println(book + ", 이미 추가된 도서명");

        }else{

            books.add(book);
            System.out.println(book + ", 추가 입고 완료");
            
        }

        System.out.println();

    }
    
    void newMember(HashSet<String> members){

        //2. 회원 추가
        System.out.println("등록할 회원명 입력");
        String member = scn.nextLine();
        scn.nextLine();

        if(members.contains(member)){

            System.out.println(member + ", 이미 추가된 회원명");

        }else{

            members.add(member);
            System.out.println(member + ", 추가 등록 완료");
            
        }

        System.out.println();
        
    }

    void rentalBook(HashSet<String> members, HashSet<String> books, HashSet<Rental> rentals){

        //3. 도서 대여
        System.out.println("도서 대여 진행");
        System.out.println("회원명 입력");
        String member = scn.nextLine();
        scn.nextLine();

        if(!members.contains(member)){

            System.out.println(member + ", 없는 회원");

        }else{
            
            System.out.println("도서명 입력");
            String book = scn.nextLine();
            scn.nextLine();

            if(!books.contains(book)){
                
                System.out.println(book + ", 없는 도서");

            }else{

                boolean isRentaled = false;

                for(Rental r: rentals){

                    if(r.book.equals(book)){
                        if(r.member.equals(member)){

                            System.out.println("이미 대여 중입니다.");
                            isRentaled = true;

                            break;

                        }else{

                            System.out.println("다른 분이 대여 중입니다.");
                            isRentaled = true;

                            break;

                        }
                    }          
                }

                if(isRentaled != true){

                    Rental r = new Rental(member, book);

                    rentals.add(r);

                    System.out.println(member + " 님이 " + book + "을 대여 완료");

                }
            }
        }

        System.out.println();

    }

    void returnBook(HashSet<String> members, HashSet<String> books, HashSet<Rental> rentals){

        //4. 도서 반납
        System.out.println("도서 반납 진행");
        System.out.println("회원명 입력");
        String member = scn.nextLine();
        scn.nextLine();

        if(!members.contains(member)){
            
            System.out.println("등록된 회원이 아닙니다.");

        }else{
            
            System.out.println("반납할 도서명 입력");
            String book = scn.nextLine();
            scn.nextLine();

            if(!books.contains(book)){
                
                System.out.println("등록된 도서가 아닙니다.");

            }else{
                

                for(Rental r: rentals){

                    if(r.book.equals(book)){
                        if(r.member.equals(member)){
                        
                            rentals.remove(rental);
                            System.out.println(member + "님의 " + book + "도서 반납 완료");
                        
                            break;

                        }else{

                            System.out.println(book + "은 다른 분이 대여하고 있습니다.");

                            break;
                        }    
                    }else{

                        System.out.println("아무도 " + book + "을 대여하고 계시지 않습니다.");

                        break;

                    }
                }
            }
        }

        System.out.println();
    }

    void deleteBook(HashSet<String> books, HashSet<Rental> rentals){

        //5. 책 삭제
        System.out.println("삭제할 도서명 입력");
        String book = scn.nextLine();
        scn.nextLine();

        if(!books.contains(book)){

            System.out.println(book + ", 없는 도서");

        }else{

            boolean isRentaled = false;

            for(Rental r: rentals){

                if(r.book.equals(book)){

                    System.out.println("대여 중인 도서라 삭제 불가");
                    isRentaled = true;

                    break;

                }
            }

            if(isRentaled != true){

                books.remove(book);
                System.out.println(book + "도서가 삭제되었습니다.");

            }

         
        }
        
        System.out.println();
    }

    void delteMember(HashSet<String> members, HashSet<Rental> rentals){

        //6. 회원 삭제
        System.out.println("삭제할 회원명 입력");
        String member = scn.nextLine();
        scn.nextLine();

        if(!members.contains(member)){

            System.out.println(member + ", 없는 회원");

        }else{

            boolean isRentaled = false;

            for(Rental r: rentals){

                if(r.member.equals(member)){

                    System.out.println("대여 중인 도서가 존재해 삭제 불가");
                    isRentaled = true;

                    break;

                }
            }

            if(isRentaled != true){

                members.remove(member);
                System.out.println(member + "회원이 삭제되었습니다.");

            }
        }

        System.out.println();

    }

    void allBook(HashSet<String> books, HashSet<Rental> rentals){

        //7. 모든 책
        System.out.println("모든 책");

        if(books.size() == 0){

            System.out.println("도서관에 도서가 없습니다.");

        }else{

            HashSet<String> free = new HashSet<>();
            HashSet<String> notFree = new HashSet<>();

            for(String bk: books){

                boolean isRentaled = false;

                for(Rental r: rentals){

                    if(r.book.equals(bk)){

                        isRentaled = true;

                        break;
                    }
                }

                if(isRentaled != true){

                    free.add(bk);

                }else{

                    notFree.add(bk);
                }
            }
            
            for(String freeBook: free){

                System.out.println(freeBook);

            }

            for(String notFreeBook: notFree){

                System.out.println(notFreeBook + "(대여중)");

            }
        }
    }

    void rentalFree(HashSet<String> books, HashSet<Rental> rentals){

        //8. 대여 가능 책
        System.out.println("대여 가능한 책");

        if(books.size() == 0){

            System.out.println("도서관에 도서가 없습니다.");

        }else{

            HashSet<String> free = new HashSet<>();

            for(String bk: books){

                boolean isRentaled = false;

                for(Rental r: rentals){
                
                    if(r.book.equals(bk)){

                        isRentaled = true;

                        break;

                    }
                }

                if(isRentaled != true){

                    free.add(bk);

                }
            }
            
            for(String freeBook: free){

                int no = 1;

                System.out.println("No." + no + " " + freeBook);

                no++;

            }
        }

        System.out.println();
    }

    void allMembers(HashSet<String> members){

        //9. 모든 회원
        if(members.size() == 0){
            System.out.println("등록된 회원이 없습니다.");
        }else{
          
            int i = 1;
          
            for(String m: members){
          
                System.out.println("No." + i + " " + m);
          
                i++;

            }
        }    
    }
}
