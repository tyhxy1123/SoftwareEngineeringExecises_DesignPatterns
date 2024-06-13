package Classes_and_Objects;

public class Main{

    public static void main(String[] args){
        new Main().run();
    }

    public void run(){
        Human aHuman = new Human("Maximilian", "Huber");
        Human firstDriver = new Human("Juergen","Staub");
        Human passenger1 = new Human("Julius", "Caeser");
        Human passenger2 = new Human("Albert", "Einstein");
        Human passenger3 = new Human("Yuchiha", "Itachi");
        Human passenger4 = new Human("黄", "渤");
        Taxi firstTaxi = new Taxi(firstDriver);
        firstTaxi.add(aHuman);
        firstTaxi.add(passenger1);
        firstTaxi.add(passenger2);
        firstTaxi.add(passenger3);
        firstTaxi.add(passenger4);
        System.out.println(firstTaxi.toString());
        Human[] passengers = firstTaxi.allGetOut();
        for(Human a : passengers){
            System.out.println(a.toString());
        }
        System.out.println(firstTaxi.toString());

    }
}
