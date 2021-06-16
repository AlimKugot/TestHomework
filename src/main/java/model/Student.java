package model;

public class Student {
    String name;

    String isCrudPassed = "-";
    String isUserPassed = "-";
    String isGiftPassed = "-";

    public Student(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public void setIsCrudPassed(String isCrudPassed) {
        this.isCrudPassed = isCrudPassed;
    }

    @SuppressWarnings("unused")
    public void setIsUserPassed(String isUserPassed) {
        this.isUserPassed = isUserPassed;
    }

    @SuppressWarnings("unused")
    public void setIsGiftPassed(String isGiftPassed) {
        this.isGiftPassed = isGiftPassed;
    }
}
