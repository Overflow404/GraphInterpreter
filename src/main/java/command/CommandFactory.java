package command;

import java.util.List;

public interface CommandFactory {

    boolean isSupported(String command);
    Command parse(List<String> tokens);
}
