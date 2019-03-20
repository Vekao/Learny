package fr.vekao.learny;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import fr.vekao.learny.controller.CategoryController;
import fr.vekao.learny.model.Category;
import fr.vekao.learny.repository.ICategoryRepository;


@RunWith(SpringRunner.class)
public class CategoryControllerTest {
	
	@TestConfiguration
	static class CategoryControllerTestConfiguration {
		
		@Bean
		public CategoryController categoryController() {
			return new CategoryController();
		}
	}
	
	@Autowired
	private CategoryController categoryController;
	
	@MockBean
	private ICategoryRepository categories;
	
	@Before
	public void setUp() {
		Category test1 = new Category("test1");
		
		
		Mockito.when(categories.findByLabel(test1.getLabel()))
			.thenReturn(test1);
	}
	
	@Test
	public void whenValidLabel_thenCategoryShouldBeFound() {
		String label = "test1";
		ResponseEntity<?> response = categoryController.getOneCategory((long) 1);
		Category found = (Category) response.getBody();
		assertThat(found.getLabel()).isEqualTo(label);
	}
}
