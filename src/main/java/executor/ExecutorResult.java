package executor;

import results.Result;

import java.util.Objects;

public class ExecutorResult {

    private Result result;
    private boolean quit;

    private ExecutorResult() {
        this.quit = false;
    }

    static ExecutorResult createSuccessfulResult() {
        return new ExecutorResult().add(Result.SUCCESSFUL);
    }

    static ExecutorResult createQuitResult() {
        return new ExecutorResult().add(Result.SUCCESSFUL).add(true);
    }

    static ExecutorResult createUnsuccessfulResult() {
        return new ExecutorResult().add(Result.UNSUCCESSFUL);
    }

    private ExecutorResult add(Result result) {
        this.result = result;
        return this;
    }

    public boolean isSuccessful() {
        return result.equals(Result.SUCCESSFUL);
    }

    private ExecutorResult add(boolean val) {
        quit = val;
        return this;
    }

    public boolean getQuit() {
        return quit;
    }



    @Override
    public String toString() {
        return result.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutorResult that = (ExecutorResult) o;
        return result == that.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

}
