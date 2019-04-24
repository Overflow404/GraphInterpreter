package interpreter;

import fetcher.ConsoleFetcher;
import results.FetchResult;
import fetcher.Fetcher;
import tokenizer.SimpleTokenizer;
import tokenizer.Tokenizer;
import results.TokenizerResult;
import validator.GraphValidator;
import validator.Validator;

public class GraphInterpreter implements Runnable {

    private Fetcher fetcher;
    private Validator validator;
    private Tokenizer tokenizer;

    private boolean stopped = false;

    public GraphInterpreter() {
        fetcher = new ConsoleFetcher();
        validator = new GraphValidator();
        tokenizer = new SimpleTokenizer();
    }

    public static void main(String[] args) {
        GraphInterpreter graphInterpreter = new GraphInterpreter();
        graphInterpreter.run();
    }

    public void run() {
        FetchResult fetchingResult;
        //ValidatorResult result;

        while (!stopped) {
            fetchingResult = fetcher.fetch();
            if (fetchingResult.isSuccessful()) {
                TokenizerResult tokenizationResult = tokenizer.tokenize(fetchingResult);
                if (tokenizationResult.isSuccessful()) {
                    System.out.println(tokenizationResult);
                }
                //validator.validate(fetchingResult);
                //System.out.println(result);
                //execut1e();
            }
        }
    }

    public void stop() {
        stopped = true;
    }

}
