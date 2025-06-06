package nestedtests;

import junittesting.nestedtests.GymMembership;
import junittesting.nestedtests.MembershipType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GymMembershipTest {

    private GymMembership membership;
    private String memberName = "John Doe";
    private String memberEmail = "john.doe@gmail.com";


    @Nested
    class BasicMembershipTests {

        @BeforeEach
        void setUp() {
            membership = new GymMembership(MembershipType.BASIC, memberName, memberEmail);
        }

        @Test
        void upgradeToPremium() {
            membership.upgradeMembership();
            assertEquals(MembershipType.PREMIUM, membership.getMembershipType());
            assertEquals(50, membership.calculateMonthlyFee());
        }

        @Test
        void cancelMembershipTest() {
            membership.cancelMembership();
            assertFalse(membership.isActive());
        }
    }

    @Nested
    class PremiumMembershipTests {

        @BeforeEach
        void setUp() {
            membership = new GymMembership(MembershipType.PREMIUM, memberName, memberEmail);
        }

        @Test
        void upgradeToVipTest() {
            membership.upgradeMembership();
            assertEquals(MembershipType.VIP, membership.getMembershipType());
            assertEquals(80, membership.calculateMonthlyFee());
        }

        @Test
        void cancelMembershipTest() {
            membership.cancelMembership();
            assertFalse(membership.isActive());
        }
    }

    @Nested
    class VipMembershipTests {

        @BeforeEach
        void setUp() {
            membership = new GymMembership(MembershipType.VIP, memberName, memberEmail);
        }

        @Test
        void attemptToUpgradeMembershipTest() {
            membership.upgradeMembership();
            assertEquals(MembershipType.VIP, membership.getMembershipType());
            assertEquals(80, membership.calculateMonthlyFee());
        }

        @Test
        void cancelMembershipTest() {
            membership.cancelMembership();
            assertFalse(membership.isActive());
        }
    }
}
