package chatting_v2.server.command;

import chatting_v2.server.Session;

import java.io.IOException;

public interface Command {
    void execute(String[] args, Session session) throws IOException;
}
