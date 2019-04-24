package validator;

import results.FetchResult;
import results.ValidatorResult;

public interface Validator {

    ValidatorResult validate(FetchResult result);
}
