package com.agency04.sbss.pizza.dao.impl;

import com.agency04.sbss.pizza.dao.CustomerDatabaseHandler;
import com.agency04.sbss.pizza.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Repository
public class CustomerDatabaseHandlerImpl implements CustomerDatabaseHandler {

	@Value("${database.customer.filename}")
	private String databaseFilename;

	private File database;

	@PostConstruct
	private void database() {
		database = new File(databaseFilename);
		if (!database.exists()) {
			try {
				if(!database.createNewFile()) {
					throw new IOException("Can not create file: " + database.getName());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean existsByUsername(String username) {

		Scanner sc = null;
		try {
			sc = new Scanner(database);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (sc == null)
			return false;

		while (sc.hasNext()) {
			if (sc.nextLine().startsWith(username + ";")) {
				sc.close();
				return true;
			}
		}

		sc.close();
		return false;
	}

	@Override
	public Customer getCustomerByUsername(String username) {

		Scanner sc = null;
		try {
			sc = new Scanner(database);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (sc == null)
			return null;

		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.startsWith(username + ";")) {
				sc.close();
				try {
					return new Customer(
							line.split(";")[0],
							line.split(";")[1],
							line.split(";")[2]);
				} catch (IndexOutOfBoundsException exc) {
					exc.printStackTrace();
				}
			}
		}

		sc.close();

		return null;
	}

	@Override
	public boolean registerCustomer(Customer customer) {

		if (existsByUsername(customer.getUsername())) {
			return false;
		}
		else {
			String line = customer.getUsername() + ";"
					+ customer.getAddress() + ";"
					+ customer.getPhone()
					+ "\n";

			OutputStream os;
			try {
				os = new FileOutputStream(database, true);
				os.write(line.getBytes());
				os.close();
			} catch (IOException e) {
				return false;
			}

			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return true;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		if (!existsByUsername(customer.getUsername()))
			return false;

		if (!deleteCustomer(customer.getUsername()))
			return false;

		return registerCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(String username) {

		if (!existsByUsername(username))
			return false;

		File newDatabase = new File(databaseFilename + "tmp");
		if (!newDatabase.exists()) {
			try {
				if(!newDatabase.createNewFile()) {
					return false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		List<String> out = new LinkedList<>();
		try {
			out = Files.lines(database.toPath())
					.filter(line -> !line.startsWith(username + ";"))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		OutputStream os = null;
		try {
			os = new FileOutputStream(newDatabase, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (String s : out) {
			s += System.lineSeparator();
			try {
				os.write(s.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!database.delete()) {
			System.out.println("Could not delete file: " + database.getName());
			return false;
		}

		if (!newDatabase.renameTo(database)) {
			System.out.println("Could not rename file: " + newDatabase.getName());
			return false;
		}

		return true;
	}
}
