package Utility;

public enum Operation {

    ADD("1"), REMOVE("2"), QUIT("q");

    String operationType;

    Operation(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }
}
