package fetcher;

import java.util.Scanner;

import static interpreter.Constant.ERROR_EMPTY_COMMAND;

public class ConsoleFetcher implements Fetcher {

    private Scanner scanner;

    public ConsoleFetcher() {
        scanner = new Scanner(System.in);
    }

    @Override
    public FetchResult fetch() {
        try {
            String command = scanner.nextLine();

            if (command.isBlank()) {
                return FetchResult.createUnsuccessfulResult(ERROR_EMPTY_COMMAND);
            }

            return FetchResult.createSuccessResult(command);
        } catch (Exception e) {
            return FetchResult.createUnsuccessfulResult(e.getMessage());
        }
    }

}
