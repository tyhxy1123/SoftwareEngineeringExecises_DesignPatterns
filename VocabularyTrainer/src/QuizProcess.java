import java.io.PrintStream;
import java.util.Scanner;

public class QuizProcess {

    private Scanner in;
    private PrintStream out;
    private State currentState;
    private QuizData data;

    public void initialize(QuizData data){
        if(data == null) throw new NullPointerException();
        currentState = new StartState();
        this.data = data;
        updateUI();
    }

    public void updateUI(){
        System.out.println("Welcom!");
    }

    public void update(){
        currentState.update();
    }

    public void input(){

    }

    private void setSolution(String solution){
        if(currentState instanceof SolutionState){
            currentState.setSolution(solution);
        }
    }

    private void drawNext(){

    }

    private VocabCard getCurrentVocabCard(){
        return null;
    }

    private abstract class State{
        public void updateUI(){

        }

        public void update(){

        }

        public void setSolution(String solution){

        }
    }

    private class StartState extends State{
        public void updateUI(){

        }

        public void update(){
            currentState = new AskingState();
        }
    }

    private class AskingState extends State{
        public void updateUI(){

        }

        public void input(){

        }
    }

    private class SolutionState extends State{
        private String solution;

        public void updateUI(){

        }

        public void updateUI(){

        }

        public void update(){

        }

        public void setSolution(String solution){

        }
    }




}
