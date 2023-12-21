public class Main {
    public static void main(String[] args) {
        String s = "55AA";
        int len = s.length();
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < s.length(); i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        for (byte b : bytes) {
            System.out.println(b);
        }
        System.out.println(0x55);
        System.out.println(0xAA);
    }
}

