package chatting_v2.server;

import java.io.IOException;
import java.util.List;

public class CommandManagerV2 implements CommandManager {

    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {

        if (totalMessage.startsWith("/join")) {
            String[] split = totalMessage.split(DELIMITER);
            String username = split[1];
            session.setUsername(username);
            sessionManager.sendAll(username + " 님이 입장했습니다.");
        } else if (totalMessage.startsWith("/message")) {
            String[] split = totalMessage.split(DELIMITER);
            String message = split[1];
            sessionManager.sendAll("[" + session.getUsername() + "] " + message);
        } else if (totalMessage.startsWith("/change")) {
            String[] split = totalMessage.split(DELIMITER);
            String changeName = split[1];
            sessionManager.sendAll(session.getUsername() + " 님이 " + changeName + " 로 이름을 변경했습니다.");
            session.setUsername(changeName);
        } else if (totalMessage.startsWith("/users")) {
            List<String> usernames = sessionManager.getAllUsername();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("전체 접속자 : ").append(usernames.size()).append("\n");
            usernames.forEach(username -> stringBuilder.append(" - ").append(username).append("\n"));
            session.send(stringBuilder.toString());
        } else if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("처리할 수 없는 메시지 입니다 : " +  totalMessage);
        }
//        sessionManager.sendAll(totalMessage);
    }
}
