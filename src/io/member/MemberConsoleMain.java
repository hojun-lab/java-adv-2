package io.member;

import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {
//    private static final MemberRepository repository = new MemoryMemberRepository();
    private static final MemberRepository repository = new FileMemberRepository();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 회원등록 | 2. 회원 목록 조회 | 3. 종료");
            System.out.println("선택 : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerMember(sc);
                    break;
                case 2:
                    displayMembers();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
    }

    private static void registerMember(Scanner sc) {
        System.out.println("ID 입력: ");
        String id = sc.nextLine();

        System.out.println("Name 입력: ");
        String name = sc.nextLine();

        System.out.println("Age 입력: ");
        int age = sc.nextInt();
        sc.nextLine();

        Member newMember = new Member(id, name, age);
        repository.add(newMember);
        System.out.println("회원이 성공적으로 등록되었습니다.");
    }

    private static void displayMembers() {
        List<Member> memberList = repository.findAll();
        System.out.println("회원목록 : ");
        memberList.forEach(member -> System.out.printf("[ID: %s, Name: %s, Age: %d]\n", member.getId(), member.getName(), member.getAge()));
    }
}
