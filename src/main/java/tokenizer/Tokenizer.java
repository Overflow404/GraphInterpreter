package tokenizer;

import results.FetchResult;
import results.TokenizerResult;

public interface Tokenizer {

    TokenizerResult tokenize(FetchResult result);
}
