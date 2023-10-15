package v2;

import java.util.Stack;


public final class HistoryCommand {

    private static HistoryCommand instance = null;

    private Stack<Pair<Command, String>> historicStack = new Stack<>();

    private int currentId = 0;

    public static HistoryCommand getInstance() {
        if (instance == null) {
            instance = new HistoryCommand();
        }
        return instance;
    }

    private HistoryCommand() {
    }

    public Pair<Command, String> undo() {
        if (currentId >= 0) {
            currentId--;
            System.out.println("Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());

            return historicStack.elementAt(currentId+1);
        } else {
            System.out.println("NULLLLLLPTN Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());

            return null;
        }
    }

    public Pair<Command, String> redo() {
        if (currentId < historicStack.size()) {
            currentId++;
            System.out.println("Historique : " + historicStack.toString() + "currentId : " + currentId + " historicStack.size() : " + historicStack.size());

            return historicStack.elementAt(currentId-1);
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
        if (currentId == historicStack.size()) {
            historicStack.push(command);
        } else {
            // on efface les commandes qui ont été annulées
            while (currentId < historicStack.size()) {
                historicStack.pop();
            }
            historicStack.push(command);
        }
        currentId++;
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
}