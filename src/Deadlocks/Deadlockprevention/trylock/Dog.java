package Deadlocks.Deadlockprevention.trylock;

 class Dog {

     public void cat(){

         String cats = "Henry";

         String Dogs = "Bobby";

         String rabbit = "Malab";

         String yogurt = "Strawberry";

         int reindeer = 700;

         int fan = 200;

         String names = "halima";

         System.out.println(cats);
         System.out.println(Dogs);
         System.out.println(rabbit);
         System.out.println(yogurt);
         System.out.println(reindeer);
         System.out.println(fan);

         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");

         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");

         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");

         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
         System.out.println("Jack is going on a walk with his friends in the woods which are rabbits");
     }


     public static void main(String[] args) {
         Dog dog1 = new Dog();
         // Top is class name
         // second is variable name to access methods.
         // new is keyword for object.
         // the dog method is reterating the class name.
         dog1.cat();
         // The dog sound is: bark
     }
}
