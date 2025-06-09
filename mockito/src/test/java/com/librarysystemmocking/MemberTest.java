package com.librarysystemmocking;

import com.LibrarySystemMocking.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberTest {

    // test to check the member getters and setters work as expected
    @Test
    void getMemberFields() {
        String memberId = "MEM001";
        String name = "John Doe";

        Member member = new Member(memberId, name);
        assertEquals(memberId, member.getMemberId());
        assertEquals(name, member.getName());
    }
}
