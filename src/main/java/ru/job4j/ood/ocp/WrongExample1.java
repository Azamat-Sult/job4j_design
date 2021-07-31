package ru.job4j.ood.ocp;

public class WrongExample1 {

    // new shape - new draw method and new if construction

    public class Shape {
        protected int type = 0;
        public int getType() {
            return type;
        }
    }

    public class Circle extends Shape {
        public Circle() {
            super.type = 2;
        }
    }

    public class Rectangle extends Shape {
        public Rectangle() {
            super.type = 1;
        }
    }

    public class GraphicEditor {

        public void drawCircle(Circle c) {
            System.out.println("Circle");
        }

        public void drawRectangle(Rectangle r) {
            System.out.println("Rectangle");
        }

        public void drawShape(Shape s) {
            if (s.getType() == 1) {
                this.drawRectangle((Rectangle) s);
            } else if (s.getType() == 2) {
                this.drawCircle((Circle) s);
            }
        }
    }
}
