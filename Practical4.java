class Practical4 {
    public static void main(String[] args) {
        System.out.println(getNumber(129, "byte"));

    }
    // Method to convert a number from any base to decimal
int convertToDecimal(String num) {
    num = num.toLowerCaseManual(); // Make input case insensitive
    int decimalValue = 0; // Initialize decimal value

    if (num.startsWith("0b")) { // Binary conversion
        for (int i = 2; i < num.length(); i++) {
            decimalValue = decimalValue * 2 + (num.charAt(i) - '0');
        }
    } else if (num.startsWith("0x")) { // Hexadecimal conversion
        for (int i = 2; i < num.length(); i++) {
            char digit = num.charAt(i);
            if (digit >= '0' && digit <= '9') {
                decimalValue = decimalValue * 16 + (digit - '0');
            } else if (digit >= 'a' && digit <= 'f') {
                decimalValue = decimalValue * 16 + (digit - 'a' + 10);
            }
        }
    } else if (num.startsWith("0") && num.length() > 1) { // Octal conversion
        for (int i = 1; i < num.length(); i++) {
            decimalValue = decimalValue * 8 + (num.charAt(i) - '0');
        }
    } else { // Decimal conversion
        for (int i = 0; i < num.length(); i++) {
            decimalValue = decimalValue * 10 + (num.charAt(i) - '0');
        }
    }

    return decimalValue; // Return the decimal equivalent
}

// Method to convert a decimal number to a target base
String convertFromDecimal(int decimalValue, int base) {
    String result = ""; // Result in the target base
    char[] digits = "0123456789ABCDEF".toCharArray(); // Characters for different bases

    while (decimalValue > 0) {
        int remainder = decimalValue % base;
        result = digits[remainder] + result;
        decimalValue /= base;
    }

    return result.isEmpty() ? "0" : result; // Handle the case for 0
}

// Method to convert a number to a specified base
String toxxString(String num, String xx) {
    int decimalValue = convertToDecimal(num); // Convert input to decimal
    xx = xx.toLowerCase(); // Normalize the base identifier

    switch (xx) {
        case "0b": // Convert to binary
            return "0b" + convertFromDecimal(decimalValue, 2);
        case "0x": // Convert to hexadecimal
            return "0x" + convertFromDecimal(decimalValue, 16);
        case "0": // Convert to octal
            return "0" + convertFromDecimal(decimalValue, 8);
        case "d": // Convert to decimal
            return String.valueOf(decimalValue);
        default:
            return "Invalid base: " + xx; // Handle invalid bases
    }
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
