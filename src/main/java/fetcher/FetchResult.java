package fetcher;

import results.Result;

import java.util.Objects;

public class FetchResult {

    private static final String EMPTY_STRING = "";
    private Result result;
    private String content;

    public static  FetchResult createSuccessFetchResult(String content) {
        return new FetchResult().addContent(content).addResult(Result.SUCCESSFUL);
    }

    public static FetchResult createUnsuccessfulFetchResult() {
        return new FetchResult().addContent(EMPTY_STRING).addResult(Result.UNSUCCESSFUL);
    }

    private FetchResult() {}

    private FetchResult addResult(Result result) {
        this.result = result;
        return this;
    }

    private FetchResult addContent(String content) {
        this.content = content;
        return this;
    }

    public String getContent() {
        return content;
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
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, content);
    }

    @Override
    public String toString() {
        return "FetchResult{" +
                "result=" + result +
                ", content='" + content + '\'' +
                '}';
    }
}
