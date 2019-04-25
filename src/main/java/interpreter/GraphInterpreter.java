package interpreter;

import executor.Executor;
import executor.ExecutorResult;
import executor.SimpleExecutor;
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
    private Executor executor;

    private boolean stopped = false;

    public GraphInterpreter() {
        fetcher = new ConsoleFetcher();
        validator = new GraphValidator();
        tokenizer = new SimpleTokenizer();
        executor = new SimpleExecutor();
    }

    public static void main(String[] args) {
        GraphInterpreter graphInterpreter = new GraphInterpreter();
        graphInterpreter.run();
    }

    public void run() {
        while (!stopped) {
            FetchResult fetching = fetcher.fetch();
            if (fetching.isSuccessful()) {
                TokenizerResult tokenization = tokenizer.tokenize(fetching);
                if (tokenization.isSuccessful()) {
                    ValidatorResult validation = validator.validate(tokenization);
                    if (validation.isSuccessful()) {
                        ExecutorResult execution = executor.execute(validation);
                        System.out.println(execution);
                    }
                }
            }
        }
    }

}
