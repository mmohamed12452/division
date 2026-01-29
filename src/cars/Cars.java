package cars;

import Caring.Chevy;

public class Cars extends Chevy {
    private double cars;

    protected void cars(double a, double b){
    double adds = a * b;
        System.out.println(adds);
    }

    public static void main(String[] args) {

        Cars mycars = new Cars();
        mycars.cars(40,90);
        final int cars = 35;
        System.out.println(cars);
        System.out.println("My kia is f1 made in 2002");
        final int cat = 20;
        System.out.println(cat);
    }

}
