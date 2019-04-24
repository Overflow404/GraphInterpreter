package validator;

import tokenizer.TokenizerResult;

public interface Validator {

    ValidatorResult validate(TokenizerResult result);
}
