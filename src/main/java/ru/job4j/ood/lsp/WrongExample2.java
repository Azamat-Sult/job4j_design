package ru.job4j.ood.lsp;

public class WrongExample2 {

    static class Rectangle {
        int width;
        int height;

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getArea() {
            return this.width * this.height;
        }
    }

    static class Square extends Rectangle {

        @Override
        public void setWidth(int width) {
            this.width = width;
            this.height = width;
        }

        @Override
        public void setHeight(int height) {
            this.height = height;
            this.width = height;
        }
    }

    static void resize(Rectangle r, int newWidth, int newHeight) {
        r.setWidth(newWidth);
        r.setHeight(newHeight);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        Rectangle s = new Square();
        resize(r, 2, 3);
        resize(s, 2, 3);
        System.out.println(r.getArea()); //2*3=6
        System.out.println(s.getArea()); //2*3!=9 ошибка
    }

}
