public class Car {
        String color;
        String transmission;
        int make;
        int tyres;
        int doors;

         Car(){
            tyres=4;
            doors=4;
        }
        public void displayCharacteristics(){
            System.out.println("color of Car is:" + color);
            System.out.println("Transmission of Car is:" + transmission);
            System.out.println("Make of Car is:" + make);
            System.out.println("Tyres of Car are:" + tyres);
            System.out.println("Doors of Car are:" + doors);

        }
        public void accelarate(){
            System.out.println("Car is moving forward");
        }
        public void brake(){
            System.out.println("Car has stopped");
        }
    }


