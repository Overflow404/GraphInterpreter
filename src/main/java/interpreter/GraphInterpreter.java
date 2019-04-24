package interpreter;

import fetcher.ConsoleFetcher;
import fetcher.FetchResult;
import fetcher.Fetcher;
import tokenizer.SimpleTokenizer;
import tokenizer.Tokenizer;
import tokenizer.TokenizerResult;
import validator.GraphValidator;
import validator.Validator;
import validator.ValidatorResult;

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
        while (!stopped) {
            FetchResult fetchingResult = fetcher.fetch();
            if (fetchingResult.isSuccessful()) {
                TokenizerResult tokenizationResult = tokenizer.tokenize(fetchingResult);
                if (tokenizationResult.isSuccessful()) {
                    ValidatorResult validationResult = validator.validate(tokenizationResult);
                    System.out.println(validationResult);
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