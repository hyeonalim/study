public class App {
    public static void main(String[] args) throws Exception {
        
        boolean loop = true;

        while(loop){

            SnackShop snackShop = new SnackShop();
            snackShop.run();

        }

        System.out.println("프로그램 종료");
    }
}
