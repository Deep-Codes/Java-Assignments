public interface Vehicle {
    public void start();

    public void stop();


    class Bicycle implements Vehicle {
        @Override
        public void start() {
            System.out.println("Bicycle has Started Moving");
        }
        @Override
        public void stop() {
            System.out.println("Bicycle has Stopped Moving");
        }
    }
    class Bike implements Vehicle {
        @Override
        public void start() {
            System.out.println("Bike has Started Moving");
        }
        @Override
        public void stop() {
            System.out.println("Bike has Stopped Moving");
        }
    }

    class Car implements Vehicle {
        @Override
        public void start() {
            System.out.println("Car has Started Moving");
        }
        @Override
        public void stop() {
            System.out.println("Car has Stopped Moving");
        }
    }
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.start();

        Bike bike = new Bike();
        bike.start();

        Car car = new Car();
        car.start();

        bicycle.stop();
        bike.stop();
        car.stop();
    }

}


