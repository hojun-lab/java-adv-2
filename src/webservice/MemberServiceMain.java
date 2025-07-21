package webservice;

import io.member.MemberRepository;
import io.member.impl.FileMemberRepository;
import was.httpServer.HttpServer;
import was.httpServer.HttpServlet;
import was.httpServer.ServletManager;
import was.httpServer.annotation.AnnotationServletV3;
import was.httpServer.servlet.DiscardServlet;

import java.io.IOException;
import java.util.List;

public class MemberServiceMain {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        MemberRepository memberRepository = new FileMemberRepository();
        MemberController memberController = new MemberController(memberRepository);
        HttpServlet servlet = new AnnotationServletV3(List.of(memberController));
        ServletManager servletManager = new ServletManager();
        servletManager.add("/favicon.ico", new DiscardServlet());
        servletManager.setDefaultServlet(servlet);

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
