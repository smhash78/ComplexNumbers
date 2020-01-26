public class Polar extends Complex {
    private double r;
    private double teta;

    public Polar() {
    }

    public Polar(double r, double teta) {
        this.r = r;
        this.teta = teta;
    }

    public String toString() {
        return "(" + this.r + ", " + this.teta + ")";
    }

    public double getR() {
        return this.r;
    }

    public double getTeta() {
        return this.teta;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setTeta(double teta) {
        this.teta = teta;
    }

    public double length() {
        return this.r;
    }

    public Polar conj() {
        return new Polar(this.r, -this.teta);
    }

    public Cartesian toCartesian() {
        double x = this.r * Math.cos(this.teta);
        double y = this.r * Math.sin(this.teta);
        return new Cartesian(x, y);
    }

    @Override
    protected Polar toPolar() {
        return this;
    }

    public Polar add(Polar other) {
        Cartesian a = this.toCartesian();
        Cartesian b = other.toCartesian();
        Cartesian result = a.add(b);
        return result.toPolar();
    }

    public Polar sub(Polar other) {
        Cartesian a = this.toCartesian();
        Cartesian b = other.toCartesian();
        Cartesian result = a.sub(b);
        return result.toPolar();
    }

    public Polar mul(Polar other) {
        double r = this.r * other.r;
        double teta = this.teta + other.teta;
        return new Polar(r, teta);
    }

    public Polar div(Polar other) {
        double r = this.r / other.r;
        double teta = this.teta - other.teta;
        return new Polar(r, teta);
    }

    public Polar power(double exponent) {
        Polar p = new Polar();
        p.setR(Math.pow(this.r, exponent));
        p.setTeta(this.teta * exponent);
        return p;
    }
}