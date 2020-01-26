public abstract class Complex {

    protected abstract Cartesian toCartesian();
    protected abstract Polar toPolar();

    public static Cartesian toCartesianSin(Complex z) {
        Cartesian tmp;
        if (z instanceof Polar) {
            tmp = ((Polar) z).toCartesian();
        }
        else
            tmp = (Cartesian) z;
        Cartesian res = new Cartesian();
        res.setX(Math.sin(tmp.getX()) * Math.cosh(tmp.getY()));
        res.setY(Math.sinh(tmp.getY()) * Math.cos(tmp.getX()));
        return res;
    }

    public static Polar toPolarSin(Complex z) {
        return toCartesianSin(z).toPolar();
    }

    public static String toStringSin(Complex z) {
        Cartesian zz;

        if (z instanceof Polar) {
            zz = z.toCartesian();
        } else {
            zz = (Cartesian) z;
        }

        return "sin(" + zz.getX() + ")cosh(" + zz.getY()
                + ") + isinh(" + zz.getY() + ")cos(" + zz.getX() + ")";
    }

    public static Cartesian toCartesianCos(Complex z) {
        Cartesian tmp;
        if (z instanceof Polar) {
            tmp = ((Polar) z).toCartesian();
        }
        else
            tmp = (Cartesian) z;
        Cartesian res = new Cartesian();
        res.setX(Math.cos(tmp.getX()) * Math.cosh(tmp.getY()));
        res.setY(Math.sin(tmp.getX()) * Math.sinh(tmp.getY()));
        return res;
    }

    public static Polar toPolarCos(Complex z) {
        return toCartesianCos(z).toPolar();
    }

    public static String toStringCos(Complex z) {
        Cartesian zz;

        if (z instanceof Polar) {
            zz = z.toCartesian();
        } else {
            zz = (Cartesian) z;
        }

        return "cos(" + zz.getX() + ")cosh(" + zz.getY()
                + ") + isin(" + zz.getX() + ")sinh(" + zz.getY() + ")";
    }

    public static Cartesian len(Complex c, int k) {
        Polar p;
        if (c instanceof Cartesian) {
            p = c.toPolar();
        }
        else {
            p = (Polar) c;
        }
        return new Cartesian(Math.log(p.getR()), p.getTeta() + (k * 360));
    }

    public static String toStringPLen(Complex x) {
        if (x instanceof Polar) {
            return "ln(" + ((Polar) x).getR() + ") + i(" + ((Polar) x).getTeta() + " + 360k)";
        }
        else if (x instanceof Cartesian) {
            return "ln(" + x.toPolar().getR() + ") + i(" + x.toPolar().getTeta() + " + 360k)";
        }
        return null;
    }

}
