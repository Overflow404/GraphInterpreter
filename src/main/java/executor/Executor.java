package executor;

import validator.ValidatorResult;

public interface Executor {
    ExecutorResult execute(ValidatorResult result);
}
