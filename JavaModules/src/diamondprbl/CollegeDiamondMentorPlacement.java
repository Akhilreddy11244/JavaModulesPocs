package diamondprbl;
interface Mentor {
    default void updateStudentRecord() {
        System.out.println("Mentor: Updating student's academic performance record.");
    }
}
interface PlacementOfficer {
    default void updateStudentRecord() {
        System.out.println("PlacementOfficer: Updating student's placement status record.");
    }
}
class FacultyMember implements Mentor, PlacementOfficer {
    @Override
    public void updateStudentRecord() {
        System.out.println("FacultyMember: Managing both academic and placement records...");
        Mentor.super.updateStudentRecord();           
        PlacementOfficer.super.updateStudentRecord();
    }
}
public class CollegeDiamondMentorPlacement {
    public static void main(String[] args) {
        FacultyMember fm = new FacultyMember();
        fm.updateStudentRecord();
    }
}
