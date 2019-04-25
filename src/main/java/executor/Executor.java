package executor;

import syntaxvalidator.ValidatorResult;

public interface Executor {
    ExecutorResult execute(ValidatorResult result);
}
