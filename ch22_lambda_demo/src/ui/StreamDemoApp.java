package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import business.Contact;

public class StreamDemoApp {

	public static void main(String[] args) {
		List<Contact> contacts = new ArrayList<>();
		
		System.out.println("Hello");
		contacts.add(new Contact("Mike Murach", null, "800-221-5528"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));

		// filter using Predicate interface p. 717
		contacts.stream().filter(c -> c.getPhone() == null)
						 .forEach(c -> System.out.println(c.getName()));
		
		// filter and collect - p. 717
		List<Contact> contactsNoPhone = contacts.stream()
					.filter(c -> c.getPhone() == null)
					.collect(Collectors.toList());
		System.out.println("There are "+ contactsNoPhone.size() +
						   " contacts with no phone number.");
		
		// transform a list using map method - p. 719
		System.out.println("transform using map");
		List<String> contactNames = contacts.stream()
				.map(Contact::getName)
				.collect(Collectors.toList());
		contactNames.stream()
				.forEach(System.out::println);
		
		// map and reduce - p. 721
		String csv = contacts.stream()
				.map(c -> c.getName())
				.reduce("", (a, b) -> a + b + ", ");
		csv = csv.substring(0, csv.length() - 2);
		System.out.println("All contacts = "+csv);
		
		// map and reduce w/ Math.max - p. 721
		List<Double> invoices = new ArrayList<>();
		invoices.add(567.34);
		invoices.add(1234.56);
		invoices.add(45.12);
		invoices.add(1111.11);
		invoices.add(3425.82);
		
		// we didn't have to use map because our list just contains
		// #s, not inoice objects
		double maxInvoiceTotal = invoices.stream()
				.reduce(0.0, (a,b) -> Math.max(a, b));
		System.out.println("Max invoice total:  "+maxInvoiceTotal);
		
		// map and reduce w/ Math.max + method reference - p. 721
		double maxInvoiceTotal2 = invoices.stream()
				.reduce(0.0, Math::max);
		System.out.println("Max invoice total 2: "+maxInvoiceTotal2);
		
		
		
		System.out.println("Bye");
	}

	
	
	
	
	
}
