package fr.vekao.learny;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import fr.vekao.learny.controller.CategoryController;
import fr.vekao.learny.model.Category;
import fr.vekao.learny.repository.ICategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryControllerTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ICategoryRepository categories;
	
	private CategoryController controller;

	@Test
	public void whenFindByLabel_thenReturnCategory() {
		//given
		Category test = new Category ("test");
		entityManager.persist(test);
		entityManager.flush();
		
		//when
		Category found = categories.findByLabel(test.getLabel());
		
		//then
		assertThat(found.getLabel()).isEqualTo(test.getLabel());
	}

	@Test
	public void testGetAllCategories() {
		Category cat1 = new Category("category 1");
		Category cat2 = new Category("category 2");
		entityManager.persist(cat1);
		entityManager.persist(cat2);
		entityManager.flush();
		
		List<Category> cats = controller.allCategories();
		
		assertThat(cats.size()).isEqualTo(2);
		assertThat(cats.get(0).getLabel()).isEqualTo(cat1.getLabel());
		assertThat(cats.get(1).getLabel()).isEqualTo(cat2.getLabel());
	}
	

	
	
	
}
