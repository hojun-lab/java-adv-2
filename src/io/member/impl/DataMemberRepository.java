package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members=data.dat";

    @Override
    public void add(Member member) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_PATH, true))) {
            out.writeUTF(member.getId());
            out.writeUTF(member.getName());
            out.writeInt(member.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new FileInputStream(FILE_PATH))) {
            while (in.available() > 0) {
                Member member = new Member(in.readUTF(), in.readUTF(), in.readInt());
                members.add(member);
            }
            return members;
        } catch (FileNotFoundException e) {
            return Collections.emptyList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
