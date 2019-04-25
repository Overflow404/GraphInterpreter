package syntaxvalidator;

import tokenizer.TokenizerResult;

public interface SyntaxValidator {

    ValidatorResult validate(TokenizerResult result);
}
