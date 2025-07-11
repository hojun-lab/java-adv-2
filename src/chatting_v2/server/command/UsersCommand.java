package chatting_v2.server.command;

import chatting_v2.server.Session;
import chatting_v2.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command {

    private final SessionManager sessionManager;

    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<String> usernames = sessionManager.getAllUsername();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("전체 접속자 : ").append(usernames.size()).append("\n");
        usernames.forEach(username -> stringBuilder.append(" - ").append(username).append("\n"));
        session.send(stringBuilder.toString());
    }
}
