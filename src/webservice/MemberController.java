package webservice;

import io.member.Member;
import io.member.MemberRepository;
import was.httpServer.HttpRequest;
import was.httpServer.HttpResponse;
import was.httpServer.annotation.Mapping;

import java.util.List;

import static util.MyLogger.log;

public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Mapping("/")
    public void home(HttpResponse httpResponse) {
        String string ="<html><body>" +
                "<h1>Member Manager</h1>" +
                "<ul>" +
                "<li><a href='/members'>Member List</a></li>" +
                "<li><a href='/add-member-form'>Add New Member</a></li>" +
                "</ul>";
        httpResponse.writeBody(string);
    }

    @Mapping("/members")
    public void members(HttpResponse httpResponse) {
        List<Member> memberList = memberRepository.findAll();

        StringBuilder page = new StringBuilder();
        page.append("<html><body>");
        page.append("<h1>Member List</h1>");
        page.append("<ul>");
        for (Member member : memberList) {
            page.append("<li>")
                    .append("ID: ").append(member.getId())
                    .append(", Name: ").append(member.getName())
                    .append(", Age: ").append(member.getAge())
                    .append("</li>");
        }
        page.append("</ul>");
        page.append("<a href='/>Back to home</a>");
        page.append("</body></html>");
        httpResponse.writeBody(page.toString());
    }

    @Mapping("/add-member-form")
    public void addMemberForm(HttpResponse httpResponse) {
        String body = "<body><html>" +
                "<h1>Add New Member</h1>" +
                "<form method='POST' action=/add-member>" +
                "ID: <input type='text' name='id'><br>" +
                "NAME: <input type='text' name='name'><br>" +
                "AGE: <input type='text' name='age'><br>" +
                "<input type='submit' value='Add'>" +
                "</form>" +
                "<a href='/'>Back to home</a>" +
                "</body></html>";
    }

    @Mapping("/add-member")
    public void addMember(HttpRequest httpRequest, HttpResponse httpResponse) {
        log("MemberController.addMember");
        log("request = " + httpRequest);

        String id = httpRequest.getParameter("id");
        String name = httpRequest.getParameter("name");
        int age = Integer.parseInt(httpRequest.getParameter("age"));

        Member member = new Member(id, name, age);
        memberRepository.add(member);

        httpResponse.writeBody("<h1>save ok</h1>");
        httpResponse.writeBody("<a href='/'>Back to home</a>");
    }
}
