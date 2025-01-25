package junittesting;

public enum UserRole {

    ADMIN, USER, MODERATOR, GUEST;

    public boolean hasWritePermission(){
        switch(this){
            case ADMIN:
            case MODERATOR:
                return true;
            case USER:
            case GUEST:
                return false;
            default:
                throw new IllegalArgumentException("Unknown role: " + this);
        }
    }


}
