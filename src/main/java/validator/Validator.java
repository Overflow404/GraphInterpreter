package validator;

import fetcher.FetchResult;

public interface Validator {

    ValidatorResult validate(FetchResult result);
}
