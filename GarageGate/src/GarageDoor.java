public class GarageDoor {
    private DoorState currentState;
    private Motor motor;

    public GarageDoor(){
        motor = new Motor();
        currentState = new Closed();
    }

    public void closeDoor(){
        currentState.closeDoor();
    }

    public void stopper(){
        currentState.stopper();
    }

    public void openDoor(){
        currentState.openDoor();
    }

    public Motor getMotor() {
        return motor;
    }

    public void setState(DoorState ds){
        if(ds == null) throw new IllegalStateException();
        currentState = ds;
    }

    public abstract class DoorState{
        public void openDoor(){
            throw new IllegalStateException();
        }

        public void closeDoor(){
            throw new IllegalStateException();
        }

        public void stopper(){
            throw new IllegalStateException();
        }
    }

    private class Open extends DoorState {


        @Override
        public void closeDoor() {
            currentState = new Closing();
            motor.downwards();
        }
    }

    private class Opening extends DoorState {

        @Override
        public void stopper() {
            currentState = new Open();
            motor.stop();
        }

        @Override
        public void closeDoor() {
            currentState = new Closing();
            motor.downwards();
        }
    }

    private class Closing extends DoorState {
        @Override
        public void stopper() {
            currentState = new Closed();
            motor.stop();
        }

        @Override
        public void openDoor() {
            currentState = new Opening();
            motor.upwards();
        }
    }

    private class Closed extends DoorState {
        @Override
        public void openDoor() {
            currentState = new Opening();
            motor.upwards();
        }


    }
}
