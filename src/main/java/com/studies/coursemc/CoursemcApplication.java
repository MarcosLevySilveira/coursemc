package com.studies.coursemc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studies.coursemc.domain.Address;
import com.studies.coursemc.domain.Category;
import com.studies.coursemc.domain.CheckPayment;
import com.studies.coursemc.domain.City;
import com.studies.coursemc.domain.Client;
import com.studies.coursemc.domain.ClientOrder;
import com.studies.coursemc.domain.CreditCardPayment;
import com.studies.coursemc.domain.OrderedItem;
import com.studies.coursemc.domain.Payment;
import com.studies.coursemc.domain.Product;
import com.studies.coursemc.domain.Province;
import com.studies.coursemc.domain.enums.ClientType;
import com.studies.coursemc.domain.enums.PaymentStatus;
import com.studies.coursemc.repositories.AddressRepository;
import com.studies.coursemc.repositories.CategoryRepository;
import com.studies.coursemc.repositories.CityRepository;
import com.studies.coursemc.repositories.ClientOrderRepository;
import com.studies.coursemc.repositories.ClientRepository;
import com.studies.coursemc.repositories.OrderedItemRepository;
import com.studies.coursemc.repositories.PaymentRepository;
import com.studies.coursemc.repositories.ProductRepository;
import com.studies.coursemc.repositories.ProvinceRepository;

@SpringBootApplication
public class CoursemcApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ClientOrderRepository clientOrderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderedItemRepository orderedItemRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CoursemcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null,"Computing");
		Category cat2 = new Category(null,"Office");
		
		Product p1 = new Product(null,"Computer",2000.0);
		Product p2 = new Product(null,"Printer",800.0);
		Product p3 = new Product(null,"Mouse",80.0);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		
		
		categoryRepository.saveAll((Arrays.asList(cat1,cat2)));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Province province1 = new Province(null,"Ontario");
		Province province2 = new Province(null, "Quebec");
		
		City city1 = new City(null, "Toronto", province1);
		City city2 = new City(null, "Montreal", province2);
		City city3 = new City(null, "Quebec city", province2);
		
		province1.getCities().addAll(Arrays.asList(city1));
		province2.getCities().addAll(Arrays.asList(city2,city3));
		
		provinceRepository.saveAll((Arrays.asList(province1,province2)));
		cityRepository.saveAll((Arrays.asList(city1,city2,city3)));
		
		Client client1 = new Client(null, "Maria", "maria@gmail.com", "36378912377", ClientType.PERSON);
		client1.getPhoneNumber().addAll(Arrays.asList("6472225465", "6476549885"));
		
		Address address1 = new Address(null, "Courton", "64", "unit 02", "Gardens", "38250546", client1, city1);
		Address address2 = new Address(null, "Blechley", "64", "unit 15", "Park", "382741546", client1, city2);
	
		client1.getAddress().addAll(Arrays.asList(address1,address2));
		
		clientRepository.saveAll(Arrays.asList(client1));
		addressRepository.saveAll(Arrays.asList(address1,address2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		ClientOrder order1 = new ClientOrder(null, sdf.parse("20/09/2023 10:32"), client1, address1);
		ClientOrder order2 = new ClientOrder(null, sdf.parse("19/09/2023 10:36"), client1, address2);
		
		Payment payment1 = new CreditCardPayment(null, PaymentStatus.PAID, order1, 6);
		order1.setPayment(payment1);
		Payment payment2 = new CheckPayment(null, PaymentStatus.PENDING, order2, sdf.parse("20/10/2023 00:00"),null);
		order2.setPayment(payment2);
		
		client1.getOrders().addAll(Arrays.asList(order1,order2));
		
		clientOrderRepository.saveAll(Arrays.asList(order1,order2));
		paymentRepository.saveAll(Arrays.asList(payment1,payment2));
		
		OrderedItem orderedItem1 = new OrderedItem(order1, p1, 0.00, 1, 2000.0);
		OrderedItem orderedItem2 = new OrderedItem(order2, p3, 0.00, 2, 80.0);
		OrderedItem orderedItem3 = new OrderedItem(order2, p2, 100.0, 1, 800.0);
		
		order1.getItens().addAll(Arrays.asList(orderedItem1,orderedItem2));
		order2.getItens().addAll(Arrays.asList(orderedItem3));
		
		p1.getItens().addAll(Arrays.asList(orderedItem1));
		p2.getItens().addAll(Arrays.asList(orderedItem3));
		p3.getItens().addAll(Arrays.asList(orderedItem2));
		
		orderedItemRepository.saveAll(Arrays.asList(orderedItem1,orderedItem2,orderedItem3));
		
	}
	
	

}
