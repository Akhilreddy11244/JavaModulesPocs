package stringmethods;

import java.util.*;

public class DynamicNoticeGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("College Notice Generation System\n");

        System.out.print("Enter Event Name: ");
        String event = sc.nextLine();

        System.out.print("Enter Venue: ");
        String venue = sc.nextLine();

        System.out.print("Enter Date (e.g. 30th October 2025): ");
        String date = sc.nextLine();

        System.out.print("Enter Time (e.g. 10:00 AM): ");
        String time = sc.nextLine();

        System.out.print("\nEnter number of students to generate notice for: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] studentNames = new String[n];
        String[] departments = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.print("Enter Student Name: ");
            studentNames[i] = sc.nextLine();

            System.out.print("Enter Department: ");
            departments[i] = sc.nextLine();
        }
        System.out.println("\nGenerated Notices\n");
        for (int i = 0; i < n; i++) {
            generateNotice(studentNames[i], departments[i], event, venue, date, time);
        }
        sc.close();
    }
    private static void generateNotice(String name, String dept, String event,
                                       String venue, String date, String time) {
        StringBuilder notice = new StringBuilder();
        notice.append("CMR TECHNICAL CAMPUS\n");
        notice.append("Department: ").append(dept).append("\n\n");
        notice.append("Dear ").append(name).append(",\n");
        notice.append("You are cordially invited to participate in the upcoming event:\n");
        notice.append(event).append("\n\n");
        notice.append("Date: ").append(date).append("\n");
        notice.append("Time: ").append(time).append("\n");
        notice.append("Venue: ").append(venue).append("\n\n");
        notice.append("Please confirm your participation through the student portal.\n");
        notice.append("We look forward to your active involvement!\n\n");
        notice.append("Regards,\n");
        notice.append("Event Coordination Committee\n");
        System.out.println(notice.toString());
    }
}
