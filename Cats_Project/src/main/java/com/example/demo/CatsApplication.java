package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
@Component

public class CatsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CatsApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("\nTesting Postman Actions");
			System.out.println("1Test GET Adopters");
			System.out.println("2 Test POST New Adopter");
			System.out.println("3 Test PUT Update Adopter");
			System.out.println("4.Test delete");
			System.out.println("0. Exit");
			System.out.print("Enter num ");

			String choice = scanner.nextLine();

			if (choice.equals("1")) {
				System.out.println("Testing GET Adopters...");

			}
			else if (choice.equals("2")) {
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter email: ");
				String email = scanner.nextLine();

			}
			else if (choice.equals("3")) {
				System.out.print("ID: ");
				String id = scanner.nextLine();
				System.out.print("name: ");
				String updateName = scanner.nextLine();
				System.out.print("email: ");
				String updateEmail = scanner.nextLine();

			}
			else if (choice.equals("4")) {
				System.out.print("ID to delete ");
				String deleteId = scanner.nextLine();

			}
			else if (choice.equals("0")) {
				running = false;

			}
		}
		scanner.close();
	}
}