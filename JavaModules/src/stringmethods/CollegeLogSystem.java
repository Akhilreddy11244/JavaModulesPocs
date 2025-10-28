package stringmethods;
import java.util.*;

import java.util.Scanner;

class AttendanceModule extends Thread {
    StringBuffer log;

    AttendanceModule(StringBuffer log) {
        this.log = log;
    }

    public void run() {
        synchronized (log) {
            for (int i = 1; i <= 3; i++) {
                log.append("Attendance Module: Student " + i + " marked present.\n");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ExamModule extends Thread {
    StringBuffer log;

    ExamModule(StringBuffer log) {
        this.log = log;
    }

    public void run() {
        synchronized (log) {
            for (int i = 1; i <= 3; i++) {
                log.append("Exam Module: Student " + i + " marks updated.\n");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class CollegeLogSystem {
    public static void main(String[] args) {
        StringBuffer logBuffer = new StringBuffer("=== College Management Log ===\n");

        AttendanceModule attendance = new AttendanceModule(logBuffer);
        ExamModule exam = new ExamModule(logBuffer);

        attendance.start();
        exam.start();

        try {
            attendance.join();
            exam.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(logBuffer);
    }
}
