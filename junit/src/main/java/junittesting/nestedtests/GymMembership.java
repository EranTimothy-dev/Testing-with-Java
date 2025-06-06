package junittesting.nestedtests;

public class GymMembership {
    private MembershipType membershipType;
    private boolean active;
    private String memberName;
    private String memberEmail;

    public GymMembership(MembershipType membershipType, String memberName, String memberEmail) {
        this.membershipType = membershipType;
        this.active = true;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public boolean isActive() {
        return active;
    }

    public void cancelMembership() {
        this.active = false;
    }

    public void upgradeMembership() {
        switch (membershipType) {
            case BASIC:
                this.membershipType = MembershipType.PREMIUM;
                break;
            case PREMIUM:
                this.membershipType = MembershipType.VIP;
                break;
            default:
                break;
        }
    }

    public double calculateMonthlyFee() {
        return switch (membershipType) {
            case BASIC -> 30.0;
            case PREMIUM -> 50.0;
            case VIP -> 80.0;
            default -> 0.0;
        };
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }
}
