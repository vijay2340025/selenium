package assignment;

public class Question10 {
    public static void main(String[] args) {
        String name = "JM248AN";
        String alpha = "", numeric = "";
        for (char c : name.toCharArray()) {
            if(Character.isDigit(c)) {
                numeric = numeric + c;
            }
            else {
                alpha = alpha + c;
            }
        }
        System.out.println(alpha+numeric);
    }
}
