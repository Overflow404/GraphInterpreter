package interpreter;

import command.Command;
import command.CommandExecutor;
import command.CommandParser;
import fetcher.ConsoleFetcher;
import fetcher.FetchResult;
import fetcher.Fetcher;
import tokenizer.SpaceTokenizer;
import tokenizer.Tokenizer;
import tokenizer.TokenizerResult;

public class GraphInterpreter {
	private Fetcher fetcher;
	private Tokenizer tokenizer;
	private CommandParser parser;
	private CommandExecutor executor;

	private GraphInterpreter() {
		fetcher = new ConsoleFetcher();
		tokenizer = new SpaceTokenizer();
		parser = new CommandParser();
		executor = new CommandExecutor();
	}

	public static void main(String[] args) {
		GraphInterpreter graphInterpreter = new GraphInterpreter();
		graphInterpreter.run();
	}

	private void run() {
		while (true) {
			FetchResult fetching = fetcher.fetch();
			if (fetching.isSuccessful()) {
				TokenizerResult tokenization = tokenizer.tokenize(fetching);
				if (tokenization.isSuccessful()) {
					try {
						Command command = parser.parse(tokenization.getTokens());
						executor.execute(command);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
}
