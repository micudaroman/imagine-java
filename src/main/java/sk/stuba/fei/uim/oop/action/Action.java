package sk.stuba.fei.uim.oop.action;

public enum Action {
    MOVE("Akcia"),
    COLOR("Farba");

    private String action;

    Action(String action){
        this.action = action;
    }

    @Override
    public String toString() {
        return action;
    }
}
