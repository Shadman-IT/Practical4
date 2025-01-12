class Practical4 {
    public static void main(String[] args) {
        System.out.println(getNumber(129, "byte"));

    }

    static int getByte(int number) {
        int reminder = number % 256;
        if (reminder > 127) {
            return reminder - 256;
        }
        if (reminder < -128) {
            return reminder + 256;
        } else {
            return reminder;
        }

    }

    public static String toLowerCaseManual(String input) {
        char[] characters = input.toCharArray(); // Convert the input string to a char array
        for (int i = 0; i < characters.length; i++) {
            char ch = characters[i];
            // If the character is uppercase, convert to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                characters[i] = (char) (ch + ('a' - 'A'));
            }
        }
        return new String(characters); // Create a new string from the modified char array
    }
    

    static int getShort(int number) {
        int reminder = number % 65536;
        if (reminder > 32767) {
            return reminder - 65536;
        }
        if (reminder < -32768) {
            return reminder + 65536;
        } else {
            return reminder;
        }
    }

    static String getNumber(int number, String byteorshort) {
        byteorshort = toLowerCaseManual(byteorshort);

        // string
        if (byteorshort.equals("byte")) {
            return String.valueOf(getByte(number));
        } else if (byteorshort.equals("short")) {
            return String.valueOf(getShort(number));
        }

        return "0";
    }
}
