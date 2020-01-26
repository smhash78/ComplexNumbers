public class Cartesian extends Complex {
    private double x;
    private double y;

    public Cartesian() {
    }

    public Cartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        if (this.y < 0) {
            return this.x + " " + this.y + "i";
        }
        return this.x + " + " + this.y + "i";
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Cartesian conj() {
        return new Cartesian(this.x, -this.y);
    }

    public Polar toPolar() {
        double r = this.length();
        double teta = Math.atan(this.y / this.x);
        Polar p = new Polar(r, teta);
        return p;
    }

    public Cartesian add(Cartesian other) {
        double x = this.x + other.x;
        double y = this.y + other.y;
        return new Cartesian(x, y);
    }

    public Cartesian sub(Cartesian other) {
        double x = this.x - other.x;
        double y = this.y - other.y;
        return new Cartesian(x, y);
    }

    public Cartesian mul(Cartesian other) {
        double x = this.x * other.x - this.y * other.y;
        double y = this.x * other.y + other.x * this.y;
        return new Cartesian(x, y);
    }

    public Cartesian div(Cartesian other) {
        Polar a = this.toPolar();
        Polar b = other.toPolar();
        Polar result = a.div(b);
        return result.toCartesian();
    }

    @Override
    protected Cartesian toCartesian() {
        return this;
    }
}
