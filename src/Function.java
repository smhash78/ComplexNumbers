public class Function {
    public static void addNumbers(String poly) {
        System.out.println("Result: \nCartesian representation: ");
        System.out.println(Polynomial.carPolyRecognizer(poly));
        System.out.println("\nPolar representation: ");
        System.out.println(Polynomial.polPolyRecognizer(poly));
    }

    public static void mulNumbers() {
    }

    public static void divNumbers() {
    }

    public static void sin(String num) {
        Complex x = Polynomial.recognizer(num);
        System.out.println("sin(" + x + ") = " + Complex.toStringSin(x)
                + " \n= " + Complex.toCartesianSin(x)
                + " \n= " + Complex.toPolarSin(x));
    }

    public static void cos(String num) {
        Complex x = Polynomial.recognizer(num);
        System.out.println("cos(" + x + ") = " + Complex.toStringCos(x)
                + " \n= " + Complex.toCartesianCos(x)
                + " \n= " + Complex.toPolarCos(x));
    }

    public static void len(String num, int k) {
        Complex x = Polynomial.recognizer(num);
        System.out.println("Len(" + x + ") = " + Complex.toStringPLen(x)
                + " \n= " + Complex.len(x, k));
    }

    public static void power(String num, int n) {
        Complex x = Polynomial.recognizer(num);
        System.out.println("(" + x + ")^" + n + " = " + x.toPolar().power(n));
    }

    public static void radical(String num, int n) {
        Complex x = Polynomial.recognizer(num);
        System.out.println("(" + n + ")radical(" + x + ") = " + x.toPolar().power(1/n));
    }

}
