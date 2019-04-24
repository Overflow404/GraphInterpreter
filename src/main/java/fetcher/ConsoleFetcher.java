package fetcher;

import results.FetchResult;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleFetcher implements Fetcher {
    private Scanner scanner;

    public ConsoleFetcher() {
        scanner = new Scanner(System.in);
    }

    @Override
    public FetchResult fetch() {
        try {
            String content = scanner.nextLine();

            if (content.isBlank()) {
                return FetchResult.createUnsuccessfulFetchResult();
            }

            return FetchResult.createSuccessFetchResult(content);
        } catch (NoSuchElementException e) {
            return FetchResult.createUnsuccessfulFetchResult();
        }
    }

}
