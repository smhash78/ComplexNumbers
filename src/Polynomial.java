public class Polynomial {




    public static int findIndex(String s, char c) {
        char chars[] = new char[30];
        int i;
        chars = s.toCharArray();
        //s.getChars(0, s.length(), chars, 0); // Converting String s into char[]
        for (i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                break;
            }
        }
        return i;
    }

    public static int returnPower(String s) {
        int index = findIndex(s, '^');
        String result = s.substring(index);
        return Integer.parseInt(result);
    }

    public static double returnCoef(String s, char z) {
        int sign;
        if (z != '\n') {
            // s = "4+2i"
            // z = 'i'
            int index = findIndex(s, z); // = 3
            String result;
            if (s.startsWith("-")) {
                sign = -1;
                result = s.substring(1, index);
            }
            else if (s.startsWith("+")) {
                sign = +1;
                result = s.substring(1, index);
            }
            else {
                sign = +1;
                result = s.substring(0, index);
            }
            return sign * Double.parseDouble(result);
        }
        String result;
        if (s.startsWith("-")) {
            sign = -1;
            result = s.substring(1);
        }
        else if (s.startsWith("+")) {
            sign = +1;
            result = s.substring(1);
        }
        else {
            sign = -1;
            result = s.substring(0);
        }
        return sign * Double.parseDouble(result);
    }

    public static int sign(String s) {
        char chars[] = new char[30];
        s.getChars(0, s.length() - 1, chars, 0); // Converting String s into char[]
        if (chars[0] == '-') {
            return 1;
        }
        return -1;
    }
    public static Complex recognizer(String num) {
        if (num.contains("i")) { // Cartesian
            Cartesian c = new Cartesian();
            int indexOfYSign = -1;
            if (num.startsWith("+") || num.startsWith("-")) {
                if (num.substring(1).contains("-")) {
                    indexOfYSign = findIndex(num.substring(1), '-') + 1;
                    c.setX(returnCoef(num, '-'));
                } else if (num.substring(1).contains("+")) {
                    indexOfYSign = findIndex(num.substring(1), '+') + 1;
                    c.setX(returnCoef(num, '+'));
                } else {
                    return null;
                }
                c.setY(returnCoef(num.substring(indexOfYSign), 'i'));
                return c;
            }
            else {
                if (num.contains("-")) {
                    indexOfYSign = findIndex(num, '-');
                    c.setX(returnCoef(num, '-'));
                } else if (num.contains("+")) {
                    indexOfYSign = findIndex(num, '+');
                    c.setX(returnCoef(num, '+'));
                } else {
                    return null;
                }
                c.setY(returnCoef(num.substring(indexOfYSign), 'i'));
                return c;
            }
        }
        if (num.contains("e^")) { // Polar
            Polar p = new Polar();
            p.setR(returnCoef(num, 'e'));
            int indexOfTetaSign;
            if (num.substring(1).contains("-")) {
                indexOfTetaSign = findIndex(num.substring(1), '-') + 1;
            }
            else if (num.substring(1).contains("+")) {
                indexOfTetaSign = findIndex(num.substring(1), '+') + 1;
            }
            else {
                return null;
            }
            p.setTeta(returnCoef(num.substring(findIndex(num, '^') + 1), '\n'));

            return p;
        }
        else {
            return null;
        }
    }
    //"4+2i +3-3i"
    public static Cartesian carPolyRecognizer(String poly) {
        Cartesian res = new Cartesian(0, 0);
        for (String num : poly.split(" ")) {
            Complex number = recognizer(num);

            if (number instanceof Cartesian) {
                res = res.add((Cartesian) number);
            }
            else if (number instanceof Polar){
                res = res.add(number.toCartesian());
            }
            else {
                return null;
            }
        }
        return res;
    }

    public static Polar polPolyRecognizer(String poly) {
        Polar res = new Polar();
        for (String num : poly.split(" ")) {
            Complex number = recognizer(num);
            if (number instanceof Polar) {
                res = res.add((Polar) number);
            }
            else {
                res = res.add(number.toPolar());
            }
        }
        return res;
    }
}
