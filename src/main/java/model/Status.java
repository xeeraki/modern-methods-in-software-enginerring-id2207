package model;

public enum Status {
    Created("Created by Customer Officer"),
    AcceptedBySCS("Accepted by Senior Customer Service Officer"),
    AcceptedByFM("Accepted by Financial Manager"),
    AcceptedByAM("Accepted by Administration Manager"),
    Finalized("Finalized");

    private final String text;

    private Status(final String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString(){
        return text;
    }
}