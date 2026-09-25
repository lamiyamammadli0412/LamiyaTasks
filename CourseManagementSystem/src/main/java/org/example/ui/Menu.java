package org.example.ui;
import org.example.balance.BalanceService;
import org.example.exception.*;
import org.example.model.User;
import org.example.service.CourseService;
import java.util.Scanner;
public class Menu {

    private Scanner scanner;
    private User user;
    private CourseService courseService;
    private BalanceService balanceService;

    public Menu(
            Scanner scanner,
            User user,
            CourseService courseService,
            BalanceService balanceService
    ) {
        this.scanner = scanner;
        this.user = user;
        this.courseService = courseService;
        this.balanceService = balanceService;
    }

    public void start() {

        boolean running = true;

        while (running) {

            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> courseService.showCourses();

                case 2 -> buyCourse();

                case 3 -> courseService.showMyCourses(user);

                case 4 -> balanceService.showBalance(user);

                case 5 -> addBalance();

                case 6 -> {
                    running = false;
                    System.out.println("Exited the program.");
                }

                default -> System.out.println("Wrong choice!");
            }
        }
    }

    private void showMenu() {

        System.out.println("\n===== COURSE MANAGEMENT SYSTEM =====");
        System.out.println("1. View Courses");
        System.out.println("2. Buy course");
        System.out.println("3. Courses I have taken");
        System.out.println("4. Show my balance");
        System.out.println("5. Balance is increasing");
        System.out.println("6. Output");
        System.out.print("Your choice: ");
    }

    private void buyCourse() {

        courseService.showCourses();

        System.out.print(
                "Almaq istədiyiniz kursun sıra nömrəsi: "
        );

        int courseId = scanner.nextInt();

        try {

            courseService.buyCourse(
                    user,
                    courseId
            );

        } catch (CourseQuotaExceededException e) {

            Response response =
                    ExceptionHandler.handleCourseQuotaExceeded(e);

            System.out.println(response);

        } catch (BalanceNotEnoughException e) {

            Response response =
                    ExceptionHandler.handleBalanceNotEnough(e);

            System.out.println(response);

        } catch (CourseAlreadyPurchasedException e) {

            Response response =
                    ExceptionHandler.handleCourseAlreadyPurchased(e);

            System.out.println(response);
        }
    }

    private void addBalance() {
        System.out.print("Amount you wish to add: ");

        double amount = scanner.nextDouble();

        balanceService.addBalance(user, amount);
    }
}
