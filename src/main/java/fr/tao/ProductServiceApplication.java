package fr.tao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import fr.tao.dao.ProductRepository;
import fr.tao.entities.Product;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		
		productRepository.save(new Product(null, "Phone Samsung", 800, 7));
		productRepository.save(new Product(null, "Phone Huawei P40", 500, 24));
		productRepository.save(new Product(null, "TV Sony", 2600, 15));
		productRepository.save(new Product(null, "PC IBM", 4500, 10));
		
		productRepository.findAll().forEach(p -> {
			System.out.println(p.toString());
		});
	}

}
