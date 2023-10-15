package v2;

import java.util.Stack;

public final class HistoryCommand {

    private static HistoryCommand instance = null;

    private Stack<Command> historicStack = new Stack<>();

    public static HistoryCommand getInstance() {
        if (instance == null) {
            instance = new HistoryCommand();
        }
        return instance;
    }

    private HistoryCommand(){}

    public void push(Command command){
        historicStack.push(command);
    }

    public Command pop(){
        return historicStack.pop();
    }

    public boolean isEmpty(){
        return historicStack.isEmpty();
    }

    public Command replay(){
        return historicStack.lastElement();
    }

    public String toString(){
        return "History : " + historicStack.toString();
    }
}

// [j'aime les patatesssssssssssssss]
// action qui ecrit "J'aime les patates"
// 1 action pour le s en plus
