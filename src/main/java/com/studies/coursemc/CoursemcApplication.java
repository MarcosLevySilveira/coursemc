package com.studies.coursemc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studies.coursemc.domain.Category;
import com.studies.coursemc.domain.City;
import com.studies.coursemc.domain.Product;
import com.studies.coursemc.domain.Province;
import com.studies.coursemc.repositories.CategoryRepository;
import com.studies.coursemc.repositories.CityRepository;
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
	}

}
