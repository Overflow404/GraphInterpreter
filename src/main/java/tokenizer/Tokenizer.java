package tokenizer;

import fetcher.FetchResult;

public interface Tokenizer {

    TokenizerResult tokenize(FetchResult result);
}
