package fetcher;

import interpreter.Result;

import java.util.Objects;

public class FetchResult {
    private Result result;
    private String command;

    private FetchResult() {
    }

    public static FetchResult createSuccessResult(String command) {
        return new FetchResult().add(command).add(Result.SUCCESSFUL);
    }

    public static FetchResult createUnsuccessfulResult(String reason) {
        return new FetchResult().add(reason).add(Result.UNSUCCESSFUL);
    }

    private FetchResult add(Result result) {
        this.result = result;
        return this;
    }

    private FetchResult add(String content) {
        this.command = content;
        return this;
    }

    public String getCommand() {
        return command;
    }

    public boolean isSuccessful() {
        return result == Result.SUCCESSFUL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FetchResult that = (FetchResult) o;
        return result == that.result &&
                Objects.equals(command, that.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, command);
    }

    @Override
    public String toString() {
        return "FetchResult{" +
                "result=" + result +
                ", command='" + command + '\'' +
                '}';
    }
}
