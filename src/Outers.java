public class Outers {
    public static void main(String[] args) {
        for(int i = 0; i <10; i++){
            System.out.println("Outer: " + i);
        }

        for(int j = 1; j <= 5; j++){
            System.out.println("inner: " + j);
        }
    }
}
