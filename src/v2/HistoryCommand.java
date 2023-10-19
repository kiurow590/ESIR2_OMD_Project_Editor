package v2;

import java.util.Stack;

/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */

public final class HistoryCommand {

    private static HistoryCommand instance = null;

    private static Stack<Pair<Command, String>> historicStack = new Stack<>(); // stack of commands

    private int currentId = 0; // position in the stack

    /**
     * Singleton
     * @return return Instance
     */
    public static HistoryCommand getInstance() {
        if (instance == null) {
            instance = new HistoryCommand();
            historicStack.push(new Pair<>(new CharacterReleaseCommand(null, ' ', ' '), ""));
        }
        return instance;
    }

    /**
     * constructor of HistoryCommand
     */
    private HistoryCommand() {
    }

    /**
     * Undo
     * @return return to the previous state of the text
     */
    public Pair<Command, String> undo() {
        if (currentId > 0) {
            currentId--;
            return historicStack.elementAt(currentId);
        } else {
            return null;
        }
    }

    /**
     * Redo
     * @return return to the next state of the text
     */
    public Pair<Command, String> redo() {
        if (currentId <= historicStack.size()-1) {
            currentId++;
            return historicStack.elementAt(currentId);
        } else {
            return null;
        }
    }

    /**
     * get the current id
     * @return current id
     */
    public int getCurrentId() {
        return currentId;
    }

    /**
     * set the current id
     * @param id
     */
    public void setCurrentId(int id) {
        this.currentId = id;
    }

    /**
     * push a command in the stack
     * @param command
     */
    public void push(Pair<Command, String> command) {
        // si la pile est vide
        if (historicStack.empty()){
            historicStack.push(command);
        }
        // si on est à la fin de la pile
        else if (currentId == historicStack.size()-1) {
            historicStack.push(command);
            currentId++;
        } else {
            // on efface les commandes qui ont été annulées pour les remplacer par la nouvelle
            while (currentId < historicStack.size()-1) {
                historicStack.pop();
            }
            historicStack.push(command);
            currentId++;
        }
    }

    /**
     * pop a command from the stack
     * @return the command
     */
    public Pair<Command, String> pop() {
        currentId--;
        return historicStack.pop();
    }

    /**
     * check if the stack is empty
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return historicStack.isEmpty();
    }

    /**
     * replay
     * @return the last command
     */
    public Pair<Command, String> replay() {
        return historicStack.lastElement();
    }

    /**
     * toString
     * @return the string of the stack
     */
    public String toString() {
        return "History : " + historicStack.toString();
    }

    /**
     * get the stack
     * @return the stack
     */
    public Stack<Pair<Command, String>> getHistoricStack(){
        return historicStack;
    }
}