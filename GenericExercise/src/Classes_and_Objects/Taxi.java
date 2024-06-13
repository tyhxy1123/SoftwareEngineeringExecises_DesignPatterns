package Classes_and_Objects;

import java.util.ArrayList;

public class Taxi {

    Human driver;

    ArrayList<Human> passengerList;

    public Taxi (Human driver){
        this.driver = driver;
        passengerList = new ArrayList<>();
    }

    final int MaximumPassenger = 4;

    public String getDriverName(){
        return driver.toString();
    }

    public void add(Human passenger){
        if(passengerList.size() >= MaximumPassenger){
            System.out.println("We are sorry, " + passenger.toString() + ". The taxi is full.");
            return;
        }
        else{
            passengerList.add(passenger);
            System.out.println(passenger.toString() + " gets in.");

        }
    }

    public Human[] allGetOut(){
        Human[] pL = passengerList.toArray(new Human[passengerList.size()]);
//        int i = 0;
//        for (Human a : passengerList
//             ) {
//            pL[i] = a;
//            i++;
//        }
//        pL = passengerList.toArray(pL);
        passengerList.clear();
        return pL;

    }

    @Override
    public String toString() {
        String msg;
        if(passengerList.isEmpty()){
            msg = "This is the taxi of " + getDriverName() + ". He takes nobody along.";
        }

        else if(passengerList.size() == 1){

            msg = "This is the taxi of " + getDriverName() + ". He takes " + passengerList.get(0) + " along.";

        }

        else{
            msg = "This is the taxi of " + getDriverName() + ". He takes";
            for(int i = 0; i < passengerList.size() - 1; i++){
                msg += " " + passengerList.get(i).toString() + ",";
            }
        char[] newMsg;
        newMsg = msg.toCharArray();
        newMsg[msg.length() - 1] = ' ';
        String msgFinal = new String(newMsg);
        msg = msgFinal + "and " + passengerList.get(passengerList.size()-1) + " along.";
        }

        return msg;

    }
}