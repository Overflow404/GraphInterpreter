package fetcher;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class ConsoleFetcherTest {
	private final static String ERROR_EMPTY_COMMAND = "Command is empty.";

    @Test
    public void successfulFetchTest() {
        String toRead = "Hello, World!";

        FetchResult actual = FetchResult.createSuccessResult(toRead);
        System.setIn(new ByteArrayInputStream(toRead.getBytes()));

        ConsoleFetcher fetcher = new ConsoleFetcher();
        FetchResult expected = fetcher.fetch();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void unsuccessfulFetchTest() {
        FetchResult actual = FetchResult.createUnsuccessfulResult(ERROR_EMPTY_COMMAND);
        System.setIn(new ByteArrayInputStream(" ".getBytes()));

        ConsoleFetcher fetcher = new ConsoleFetcher();
        FetchResult expected = fetcher.fetch();

        Assert.assertEquals(expected, actual);
    }

}
