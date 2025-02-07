import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        System.out.println(random.nextInt(21));
    }
}
