import junittesting.UserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRoleTest {

    /**
     * Using parameterized test with EnumSource to make tests more concise
     * */

    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = {"ADMIN", "MODERATOR"})
    public void rolesWithWritePermission(UserRole role){
        assertTrue(role.hasWritePermission());
    }

    @ParameterizedTest
    @EnumSource(value = UserRole.class, names = {"USER", "GUEST"})
    public void rolesWithoutWritePermission(UserRole role){
        assertFalse(role.hasWritePermission());
    }

//    @Test
//    void adminHasWritePermission() {
//        UserRole role = UserRole.ADMIN;
//        assertTrue(role.hasWritePermission());
//    }
//
//    @Test
//    void moderatorHasWritePermission() {
//        UserRole role = UserRole.MODERATOR;
//        assertTrue(role.hasWritePermission());
//    }
//
//    @Test
//    void userHasNoWritePermission() {
//        UserRole role = UserRole.USER;
//        assertFalse(role.hasWritePermission());
//    }
//
//    @Test
//    void guestHasNoWritePermission() {
//        UserRole role = UserRole.GUEST;
//        assertFalse(role.hasWritePermission());
//    }

}
