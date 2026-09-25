package org.example.validator;

import org.example.balance.*;
import org.example.exception.*;
import org.example.model.User;
import org.example.service.*;
import org.example.ui.Menu;

import java.util.Scanner;

public class Validator {

    public static void start() {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            if (name == null || name.trim().isEmpty()) {
                throw new InvalidUserDataException(
                        "The name cannot be empty!"
                );
            }

            System.out.print("Enter your surname: ");
            String surname = scanner.nextLine();

            if (surname == null || surname.trim().isEmpty()) {
                throw new InvalidUserDataException(
                        "The surname cannot be empty!"
                );
            }

            System.out.print("Enter your opening balance: ");
            double balance = scanner.nextDouble();

            if (balance < 0) {
                throw new InvalidUserDataException(
                        "The opening balance cannot be negative!"
                );
            }

            User user = new User(
                    name,
                    surname,
                    balance
            );

            CourseService courseService =
                    new CourseServiceImpl();

            BalanceService balanceService =
                    new BalanceServiceImpl();

            Menu menu = new Menu(
                    scanner,
                    user,
                    courseService,
                    balanceService
            );

            menu.start();

        } catch (InvalidUserDataException e) {

            Response response =
                    ExceptionHandler.handleInvalidUserData(e);

            System.out.println(response);

        } finally {

            scanner.close();
        }
    }
}