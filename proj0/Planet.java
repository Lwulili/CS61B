public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double NetForceX = 0;
        for (Planet p : allPlanets) {
            if (p.equals(this)) {
            } else {
                NetForceX += calcForceExertedByX(p);
            }
        }
        return NetForceX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double NetForceY = 0;
        for (Planet p : allPlanets) {
            if (p.equals(this)) {
                continue;
            } else {
                NetForceY += calcForceExertedByY(p);
            }
        }
        return NetForceY;
    }

    public void update(double dt, double fx, double fy) {
        double aX = fx / mass;
        double aY = fy / mass;
        xxVel += aX * dt;
        yyVel +=aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
