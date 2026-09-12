package Deadlocks.Deadlockprevention.trylock.Lion;

public class Deal {
    public static void main(String[] args) {
        People people1 = new People();
        Jogger jogger2 = new Jogger();
        Tariq tariq1 = new Tariq();
        people1.peoplesPerson();
        jogger2.peoplesPerson();
        tariq1.peoplesPerson();
    }
}
