/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nicole Hernandez
 */
public class NumericalSystem {

    String numericalSystem;

    Map<String, String> mapBinaryToOctal;
    Map<String, String> mapOctalToBinary;
    Map<String, String> mapBinaryToHex;
    Map<String, String> mapHexToBinary;

    public NumericalSystem() {
        this.initialiOctal();
        this.initialiHexa();
    }

    private void initialiOctal() {
        mapBinaryToOctal = Map.of(
                "000", "0",
                "001", "1",
                "010", "2",
                "011", "3",
                "100", "4",
                "101", "5",
                "110", "6",
                "111", "7"
        );

        mapOctalToBinary = Map.of(
                "0", "000",
                "1", "001",
                "2", "010",
                "3", "011",
                "4", "100",
                "5", "101",
                "6", "110",
                "7", "111"
        );
    }

    private void initialiHexa() {
        mapBinaryToHex = new HashMap<>();
        mapBinaryToHex.put("0000", "0");
        mapBinaryToHex.put("0001", "1");
        mapBinaryToHex.put("0010", "2");
        mapBinaryToHex.put("0011", "3");
        mapBinaryToHex.put("0100", "4");
        mapBinaryToHex.put("0101", "5");
        mapBinaryToHex.put("0110", "6");
        mapBinaryToHex.put("0111", "7");
        mapBinaryToHex.put("1000", "8");
        mapBinaryToHex.put("1001", "9");
        mapBinaryToHex.put("1010", "A");
        mapBinaryToHex.put("1011", "B");
        mapBinaryToHex.put("1100", "C");
        mapBinaryToHex.put("1101", "D");
        mapBinaryToHex.put("1110", "E");
        mapBinaryToHex.put("1111", "F");

        mapHexToBinary = new HashMap<>();
        mapHexToBinary.put("0", "0000");
        mapHexToBinary.put("1", "0001");
        mapHexToBinary.put("2", "0010");
        mapHexToBinary.put("3", "0011");
        mapHexToBinary.put("4", "0100");
        mapHexToBinary.put("5", "0101");
        mapHexToBinary.put("6", "0110");
        mapHexToBinary.put("7", "0111");
        mapHexToBinary.put("8", "1000");
        mapHexToBinary.put("9", "1001");
        mapHexToBinary.put("A", "1010");
        mapHexToBinary.put("B", "1011");
        mapHexToBinary.put("C", "1100");
        mapHexToBinary.put("D", "1101");
        mapHexToBinary.put("E", "1110");
        mapHexToBinary.put("F", "1111");
    }

    public NumericalSystem(String numericalSystem) {
        this.numericalSystem = numericalSystem;
    }

    @Override
    public String toString() {
        return numericalSystem;
    }

    public long binaryToDecimal(String binary) {
        return somethingToDecimal(binary, 2);
    }

    public String binaryToOctal(String binary) {
        binary = this.padBinaryToMultiple(binary, 3);
        return this.binaryToSomething(binary, 8, 3);
    }

    public String binaryToHexadecimal(String binary) {
        binary = this.padBinaryToMultiple(binary, 4);
        return this.binaryToSomething(binary, 16, 4);
    }

    public String addBinaryNumbers(String binOne, String binTwo) {
        return this.addNumericalSystem(binOne, binTwo, 2);
    }

    public String subtractBinaryNumbers(String binOne, String binTwo) {
        return this.subtractNumericalSystem(binOne, binTwo, 2);
    }

    public String multiplyBinaryNumbers(String binaryOne, String binaryTwo) {
        return this.multiplyNumericalSystem(binaryOne, binaryTwo, 2);
    }

    public String divideInBinaryNumbers(String binaryOne, String binaryTwo) {
        return this.divideInNumericSystem(binaryOne, binaryTwo, 2);
    }

    public String decimalToBinary(long decimal) {
        int logBase2;
        String binary = "";

        logBase2 = (int) (Math.log(decimal) / Math.log(2));

        for (int j = logBase2; j >= 0; j--) {
            if (decimal - Math.pow(2, j) >= 0) {
                binary += "1";
                decimal -= Math.pow(2, j);
            } else {
                binary += "0";
            }
        }
        return binary;
    }

    public String decimalToOctal(long decimal) {
        String decimalToBinaryValue = this.decimalToBinary(decimal);
        return this.binaryToOctal(decimalToBinaryValue);
    }

    public String decimalToHexadecimal(long decimal) {
        String decimalToBinaryValue = this.decimalToBinary(decimal);
        return this.binaryToHexadecimal(decimalToBinaryValue);
    }

    public long octalToDecimal(String octal) {
        return somethingToDecimal(octal, 8);
    }

    public String octalToBinary(String octal) {
        return this.somethingToBinary(octal, 8);
    }

    public String octalToHexadecimal(String octal) {
        String octalToBinaryValue = this.somethingToBinary(octal, 8);

        // Para facilitar el algoritmo, aseguramos que el tamaño de la cadena sea multiplo de 4
        octalToBinaryValue = this.padBinaryToMultiple(octalToBinaryValue, 4);

        return this.binaryToSomething(octalToBinaryValue, 16, 4);
    }

    public String addOctalNumbers(String octalOne, String octalTwo) {
        return this.addNumericalSystem(octalOne, octalTwo, 8);
    }

    public String subtractOctalNumbers(String octalOne, String octalTwo) {
        return this.subtractNumericalSystem(octalOne, octalTwo, 8);
    }

    public String multiplyOctalNumbers(String octalOne, String octalTwo) {
        return this.multiplyNumericalSystem(octalOne, octalTwo, 8);
    }

    public String divideInOctalNumbers(String octalOne, String octalTwo) {
        return this.divideInNumericSystem(octalOne, octalTwo, 8);
    }

    public long hexadecimalToDecimal(String hexadecimal) {
        return somethingToDecimal(hexadecimal, 16);
    }

    public String hexadecimalToBinary(String hexadecimal) {
        return this.somethingToBinary(hexadecimal, 16);
    }

    public String hexadecimalToOctal(String hexadecimal) {
        String hexToBinaryValue = this.somethingToBinary(hexadecimal, 16);

        // Para facilitar el algoritmo, aseguramos que el tamaño de la cadena sea multiplo de 3
        hexToBinaryValue = this.padBinaryToMultiple(hexToBinaryValue, 3);

        return this.binaryToSomething(hexToBinaryValue, 8, 3);
    }

    public String addHexadecimalNumbers(String numOne, String numTwo) {
        return this.addNumericalSystem(numOne, numTwo, 16);
    }

    public String subtractHexadecimalNumbers(String hexaOne, String hexaTwo) {
        return this.subtractNumericalSystem(hexaOne, hexaTwo, 16);
    }

    public String multiplyHexadecimalNumbers(String hexaOne, String hexaTwo) {
        return this.multiplyNumericalSystem(hexaOne, hexaTwo, 16);
    }

    public String divideInHexadecimalNumbers(String hexaOne, String hexaTwo) {
        return this.divideInNumericSystem(hexaOne, hexaTwo, 16);
    }

    // Auxiliary Methods:
    private String binaryToSomething(String something, int base, int increase) {
        String binarySubstring, answer = "";

        for (int i = 0; i < something.length(); i += increase) {
            binarySubstring = something.substring(i, i + increase);

            if (base == 8) {
                answer += this.mapBinaryToOctal.get(binarySubstring);
            } else {
                answer += this.mapBinaryToHex.get(binarySubstring);
            }
        }
        return answer;
    }

    private long somethingToDecimal(String something, int base) {
        long decimal = 0, exponent = 0;
        int value;

        for (int i = something.length() - 1; i >= 0; i--) {
            value = this.convertToDecimal(something.charAt(i));
            decimal += value * (Math.pow(base, exponent));
            exponent += 1;
        }
        return decimal;
    }

    private int convertToDecimal(char caracter) {
        if (caracter >= '0' && caracter <= '9') {
            return caracter - '0';
        }
        return caracter - 'A' + 10;
    }

    private char convertToHexadecimal(int value) {
        char caracter = (char) (value + '0');

        // Convertimos un entero a su equivalente en char
        if (value >= 10 && value <= 15) {
            caracter = (char) (value + 55);
        }
        return caracter;
    }

    // Para pasar de Hexadecimal y Octal a Binary
    private String somethingToBinary(String something, int base) {
        int valueInt;
        String binary = "";
        char character;
        for (int i = 0; i < something.length(); i++) {
            character = something.charAt(i);
            valueInt = this.convertToDecimal(character);
            if (base == 8) {
                binary += this.mapOctalToBinary.get(valueInt + "");
            } else {
                binary += this.mapHexToBinary.get(character + "");
            }
        }
        return binary;
    }

    private String padBinaryToMultiple(String binary, int multiple) {
        while (binary.length() % multiple != 0) {
            binary = "0" + binary;
        }
        return binary;
    }

    private String addNumericalSystem(String numOne, String numTwo, int base) {
        int carry = 0;
        int remainder;
        int i = numOne.length() - 1, j = numTwo.length() - 1, numOneInt, numTwoInt;
        String answer = "";

        while (i >= 0 || j >= 0) {
            numOneInt = i >= 0 ? this.convertToDecimal(numOne.charAt(i)) : 0;
            numTwoInt = j >= 0 ? this.convertToDecimal(numTwo.charAt(j)) : 0;
            remainder = (int) ((numOneInt + numTwoInt + carry) % base);
            carry = (numOneInt + numTwoInt + carry) / base;
            answer = base == 16 ? this.convertToHexadecimal(remainder) + answer : remainder + answer;
            j--;
            i--;
        }

        answer = carry > 0 ? this.convertToHexadecimal(carry) + answer : answer;
        return answer;
    }

    private String multiplyNumericalSystem(String numOne, String numTwo, int base) {
        String answer = "0", max;
        long NumberOneToDecimal = this.somethingToDecimal(numOne, base);
        long NumberTwoToDecimal = this.somethingToDecimal(numTwo, base);
        long min = Math.min(NumberOneToDecimal, NumberTwoToDecimal);

        if (NumberOneToDecimal >= NumberTwoToDecimal) {
            max = numOne;
        } else {
            max = numTwo;
        }

        long temp = 1;
        while (temp <= min) {
            answer = this.addNumericalSystem(max, answer, base);
            temp++;
        }
        return answer;
    }

    private String divideInNumericSystem(String numOne, String numTwo, int base) {
        String quotient = "";
        if (this.somethingToDecimal(numOne, base) < this.somethingToDecimal(numTwo, base)) {
            return "0";
        }

        while (this.somethingToDecimal(numOne, base) >= this.somethingToDecimal(numTwo, base)) {
            numOne = this.subtractNumericalSystem(numOne, numTwo, base);
            quotient = this.addNumericalSystem(quotient, "1", base);
        }

        return quotient;
    }

    private String subtractNumericalSystem(String numOne, String numTwo, int base) {
        String subTotal = "", total = "";
        boolean change = false;
        numOne = "0" + numOne;
        numTwo = complementBase(numOne, numTwo, base);
        subTotal = this.addNumericalSystem(numOne, numTwo, base);

        if (subTotal.length() > numOne.length()) {
            for (int i = 1; i < subTotal.length(); i++) {
                total += subTotal.charAt(i);
            }
            change = true;
        }

        return change ? total : subTotal;
    }

    private String sameSize(String numOne, String numTwo, boolean number) {
        while (numOne.length() != numTwo.length()) {
            if (number) {
                numOne = "0" + numOne;
            } else {
                numTwo = "0" + numTwo;
            }
        }
        return number ? numOne : numTwo;
    }

    private String complementOne(String numOne, String numTwo, int base) {
        numOne = numOne.length() < numTwo.length() ? this.sameSize(numOne, numTwo, true) : numOne;
        numTwo = numTwo.length() < numOne.length() ? this.sameSize(numOne, numTwo, false) : numTwo;
        char[] numTwoArray = numTwo.toCharArray();

        for (int i = 0; i < numTwoArray.length; i++) {
            int digit = this.convertToDecimal(numTwoArray[i]);
            int newDigit = (base - 1) - digit;
            numTwoArray[i] = this.convertToHexadecimal(newDigit);
        }

        numTwo = new String(numTwoArray);
        return numTwo;
    }

    private String complementBase(String numOne, String numTwo, int base) {
        numTwo = this.complementOne(numOne, numTwo, base);

        return this.addNumericalSystem(numTwo, "1", base);
    }

    public boolean verify(String systemName, String number) {
        try {
            if ("Binario".equals(systemName)) {
                return number.matches("[01]+");
            } else if ("Hexadecimal".equals(systemName)) {
                return number.matches("[0-9A-Fa-f]+");
            } else if ("Octal".equals(systemName)) {
                return number.matches("[0-7]+");
            } else if ("Decimal".equals(systemName)) {
                return number.matches("[0-9]+");
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public String getNumericalSystem() {
        return numericalSystem;
    }

    public void setNumericalSystem(String numericalSystem) {
        this.numericalSystem = numericalSystem;
    }

    public String convert(String fromConvert, String toConvert, String number) {
        if ("Binario".equals(fromConvert)) {
            return convertFromBinary(toConvert, number);
        } else if ("Decimal".equals(fromConvert)) {
            return convertFromDecimal(toConvert, number);
        } else if ("Octal".equals(fromConvert)) {
            return convertFromOctal(toConvert, number);
        } else if ("Hexadecimal".equals(fromConvert)) {
            return convertFromHexadecimal(toConvert, number);
        }
        return number;
    }

    private String convertFromBinary(String toConvert, String number) {
        if ("Decimal".equals(toConvert)) {
            return String.valueOf(binaryToDecimal(number));
        } else if ("Octal".equals(toConvert)) {
            return binaryToOctal(number);
        } else if ("Hexadecimal".equals(toConvert)) {
            return binaryToHexadecimal(number);
        }
        return number;
    }

    private String convertFromDecimal(String toConvert, String number) {
        long decimalNumber = Long.parseLong(number);
        if ("Binario".equals(toConvert)) {
            return decimalToBinary(decimalNumber);
        } else if ("Octal".equals(toConvert)) {
            return decimalToOctal(decimalNumber);
        } else if ("Hexadecimal".equals(toConvert)) {
            return decimalToHexadecimal(decimalNumber);
        }
        return number;
    }

    private String convertFromOctal(String toConvert, String number) {
        if ("Decimal".equals(toConvert)) {
            return String.valueOf(octalToDecimal(number));
        } else if ("Binario".equals(toConvert)) {
            return octalToBinary(number);
        } else if ("Hexadecimal".equals(toConvert)) {
            return octalToHexadecimal(number);
        }
        return number;
    }

    private String convertFromHexadecimal(String toConvert, String number) {
        if ("Decimal".equals(toConvert)) {
            return String.valueOf(hexadecimalToDecimal(number));
        } else if ("Binario".equals(toConvert)) {
            return hexadecimalToBinary(number);
        } else if ("Octal".equals(toConvert)) {
            return hexadecimalToOctal(number);
        }
        return number;
    }

    public String operationNumericalSystem(String numSys, String numOne, String numTwo, String operator) {
        if (numSys.equals("Binario")) {
            return this.operationBinary(numOne, numTwo, operator);
        } else if (numSys.equals("Octal")) {
            return this.operationOctal(numOne, numTwo, operator);
        }
        return this.operationHexadecimal(numOne, numTwo, operator);
    }

    private String operationBinary(String numOne, String numTwo, String operator) {
        if (operator.equals("Suma")) {
            return this.addBinaryNumbers(numOne, numTwo);
        } else if (operator.equals("Resta")) {
            return this.subtractBinaryNumbers(numOne, numTwo);
        } else if (operator.equals("Multiplicación")) {
            return this.multiplyBinaryNumbers(numOne, numTwo);
        }
        return this.divideInBinaryNumbers(numOne, numTwo);
    }

    private String operationOctal(String numOne, String numTwo, String operator) {
        if (operator.equals("Suma")) {
            return this.addOctalNumbers(numOne, numTwo);
        } else if (operator.equals("Resta")) {
            return this.subtractOctalNumbers(numOne, numTwo);
        } else if (operator.equals("Multiplicación")) {
            return this.multiplyOctalNumbers(numOne, numTwo);
        }
        return this.divideInOctalNumbers(numOne, numTwo);
    }

    private String operationHexadecimal(String numOne, String numTwo, String operator) {
        if (operator.equals("Suma")) {
            return this.addHexadecimalNumbers(numOne, numTwo);
        } else if (operator.equals("Resta")) {
            return this.subtractHexadecimalNumbers(numOne, numTwo);
        } else if (operator.equals("Multiplicación")) {
            return this.multiplyHexadecimalNumbers(numOne, numTwo);
        }
        return this.divideInHexadecimalNumbers(numOne, numTwo);
    }

    public boolean divideByCero(String numOne, String numTwo, String operator) {
        if (operator.equals("División")) {
            if (Integer.parseInt(numOne) == 0) {
                return false;
            }
            if (Integer.parseInt(numTwo) == 0) {
                return false;
            }
        }
        return true;
    }

}
