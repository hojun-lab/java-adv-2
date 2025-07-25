package chatting_v2.server;

import chatting_v2.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandManagerV3 implements CommandManager {
    
    private static final String DELIMITER = "\\|";
    private final Command defaultCommand = new DefaultCommand();
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManagerV3(SessionManager sessionManager) {
        commands.put("/join", new JoinCommand(sessionManager));
        commands.put("/message", new MessageCommand(sessionManager));
        commands.put("/change", new ChangeCommand(sessionManager));
        commands.put("/users", new UsersCommand(sessionManager));
        commands.put("/exit", new ExitCommand());
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER);
        String key = args[0];

        // NullObject Pattern
        Command command = commands.getOrDefault(key, defaultCommand);
        command.execute(args, session);
    }
}
