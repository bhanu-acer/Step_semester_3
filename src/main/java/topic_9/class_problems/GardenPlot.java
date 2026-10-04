import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();

    abstract String shape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    String shape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length;
    double width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    String shape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base;
    double height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }

    String shape() {
        return "TRIANGLE";
    }
}

public class GardenPlot {

    static Plot createPlot(String type, String owner, double a, double b) {

        if (type.equals("CIRCLE")) {
            return new Circle(owner, a);
        }

        if (type.equals("RECTANGLE")) {
            return new Rectangle(owner, a, b);
        }

        return new Triangle(owner, a, b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String owner = sc.next();

            double a = sc.nextDouble();
            double b = 0;

            if (type.equals("RECTANGLE") || type.equals("TRIANGLE")) {
                b = sc.nextDouble();
            }

            Plot plot = createPlot(type, owner, a, b);

            double area = plot.area();

            System.out.printf(
                "%s (%s): %.2f%n",
                plot.owner,
                plot.shape(),
                area
            );

            total += area;
        }

        System.out.printf(
            "Total Area: %.2f%n",
            total
        );

        sc.close();
    }
}