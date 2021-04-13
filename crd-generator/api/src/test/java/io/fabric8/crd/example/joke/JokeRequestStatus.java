package io.fabric8.crd.example.joke;

public class JokeRequestStatus {
    public enum State {
        CREATED,
        ALREADY_PRESENT,
        PROCESSING,
        ERROR,
        UNKNOWN
    }

    private State state = State.UNKNOWN;
    private boolean error;
    private String message;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
