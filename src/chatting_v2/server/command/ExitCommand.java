package chatting_v2.server.command;

import chatting_v2.server.Session;

import java.io.IOException;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}
