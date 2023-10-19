package v2;

import java.util.Stack;


public final class HistoryCommand {

    private static HistoryCommand instance = null;

    private static Stack<Pair<Command, String>> historicStack = new Stack<>();

    private int currentId = 0;

    public static HistoryCommand getInstance() {
        if (instance == null) {
            instance = new HistoryCommand();
            historicStack.push(new Pair<>(new CharacterReleaseCommand(null, ' ', ' '), ""));
        }
        return instance;
    }

    private HistoryCommand() {
    }

    public Pair<Command, String> undo() {
        if (currentId > 0) {
            currentId--;
            System.out.println("PreUndo " + historicStack.elementAt(currentId));
            System.out.println("Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());
            System.out.println("current ID Undo" + historicStack.elementAt(currentId));

            return historicStack.elementAt(currentId);
        } else {
            System.out.println("NULLLLLLPTN Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());

            return null;
        }
    }

    public Pair<Command, String> redo() {
        if (currentId <= historicStack.size()-1) {
            //System.out.println("PreUndo " + historicStack.elementAt(currentId));
            currentId++;
            System.out.println("Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());
            System.out.println("current ID Redo" + historicStack.elementAt(currentId));

            return historicStack.elementAt(currentId);
        } else {
            System.out.println("NULLLLLLPTN Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());

            return null;
        }
    }

    public int getCurrentId() {
        return currentId;
    }

    public void setCurrentId(int id) {
        this.currentId = id;
    }


    public void push(Pair<Command, String> command) {
        if (historicStack.empty()){
            historicStack.push(command);
            //currentId++;

            System.out.println("taille if 1 " + historicStack.size());
            System.out.println("Before Push ID " + historicStack.elementAt(currentId) + "currentId : " + currentId);
        }
        else if (currentId == historicStack.size()-1) {
            historicStack.push(command);
            currentId++;
            System.out.println("taille if 2 " + historicStack.size());
            System.out.println("Before Push ID " + historicStack.elementAt(currentId) + "currentId : " + currentId);

        } else {
            // on efface les commandes qui ont été annulées
            while (currentId < historicStack.size()-1) {
                historicStack.pop();
            }
            historicStack.push(command);
            currentId++;
            System.out.println("taille if 3 " + historicStack.size());
            System.out.println("Before Push ID " + historicStack.elementAt(currentId));
        }

        //System.out.println("After Push ID " + historicStack.elementAt(currentId));
        System.out.println("Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());
    }

    public Pair<Command, String> pop() {
        currentId--;
        System.out.println("Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());

        return historicStack.pop();

    }

    public boolean isEmpty() {
        return historicStack.isEmpty();
    }

    public Pair<Command, String> replay() {
        System.out.println("Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());

        return historicStack.lastElement();
    }

    public String toString() {
        return "History : " + historicStack.toString();
    }

    public Stack<Pair<Command, String>> getHistoricStack(){
        return historicStack;
    }
}