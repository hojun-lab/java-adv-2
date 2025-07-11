package chatting_v2.server.command;

import chatting_v2.server.Session;
import chatting_v2.server.SessionManager;

import java.io.IOException;

public class ChangeCommand implements Command {

    private final SessionManager sessionManager;

    public ChangeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        String changeName = args[1];
        sessionManager.sendAll(session.getUsername() + " 님이 " + changeName + " 로 이름을 변경했습니다.");
        session.setUsername(changeName);
    }
}
