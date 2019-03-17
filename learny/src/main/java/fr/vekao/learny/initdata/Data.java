package fr.vekao.learny.initdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.vekao.learny.model.Category;
import fr.vekao.learny.repository.ICategoryRepository;

@Component
public class Data implements CommandLineRunner{
	
	private final Logger logger = LoggerFactory.getLogger(Data.class);

	@Autowired
	private ICategoryRepository category;
	
	@Override
	public void run(String... strings) throws Exception {
		logger.info("Loading data from class Data...");
		if (category.count() == 0) {
			category.save(new Category("Tricot"));
			category.save(new Category("Crochet"));
			category.save(new Category("Couture"));
			category.save(new Category("Bracelet brésilien"));
		}
		
//		if (category.count() == 0) {
//			Category one = new Category("one");
//			Category two = new Category("two");
//			
//			category.save(one);
//			category.save(two);
//		}
//		if (user.count() == 0) {
//			User one = new User("Bob", "hash", "mail@mail.com", 0, "mail@mail.com", "token");
//			User two = new User("Bill", "hash", "mail@mail.com", 0, "mail@mail.com", "token");
//			User three = new User("John","hash", "mail@mail.com", 0, "mail@mail.com", "token");
//			User four = new User("Tom","hash", "mail@mail.com", 0, "mail@mail.com", "token");
//			
//			user.saveAll(Arrays.asList(one, two, three, four));
//		}
	}

}
