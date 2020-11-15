package ru.surovtseva.hw4;

public class Triangle {

    public double calcTriangleArea (double a, double b, double c) throws TriangleException {
        double result;
        double p = (a+b+c)/2;
        double scale = Math.pow(10,3);
        if (a <= 0 | b<=0 | c<=0) {
            throw new TriangleException("Длина строны треугольника должна быть > 0");
        }
        if((a<b+c) && (b<a+c) && (c<a+b)) {
            double area =Math.sqrt(p*(p-a)*(p-b)*(p-c));
            result = Math.ceil(area*scale)/scale;
        } else {
            throw new TriangleException("Треуголника с указанными сторонами не существует!");
        }
        return result;
    }
}
