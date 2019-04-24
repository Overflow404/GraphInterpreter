package fetcher;

import org.junit.Assert;
import org.junit.Test;
import results.FetchResult;

import java.io.ByteArrayInputStream;

public class ConsoleFetcherTest {

    @Test
    public void successfulFetchTest() {
        String toRead = "Hello, World!";
        FetchResult actual = FetchResult.createSuccessFetchResult(toRead);
        System.setIn(new ByteArrayInputStream(toRead.getBytes()));

        ConsoleFetcher fetcher = new ConsoleFetcher();
        FetchResult expected = fetcher.fetch();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void unsuccessfulFetchTest() {
        FetchResult actual = FetchResult.createUnsuccessfulFetchResult();
        System.setIn(new ByteArrayInputStream(" ".getBytes()));

        ConsoleFetcher fetcher = new ConsoleFetcher();
        FetchResult expected = fetcher.fetch();

        Assert.assertEquals(expected, actual);
    }

}
