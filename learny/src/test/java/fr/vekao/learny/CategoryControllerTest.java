package fr.vekao.learny;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import fr.vekao.learny.model.Category;
import fr.vekao.learny.repository.ICategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ICategoryRepository categories;
	
	@Autowired
	private Category category;
	
	@Test
	public void createCategory() throws Exception {
		
		List<Category> fausseCategory = new ArrayList<>();
		fausseCategory.add(new Category("truc"));
//		
//		when(Category.allCategories()).thenReturn(fausseCategory);
//		mvc.perform(get("/api/categories"))
//					.contentType(MediaType.APPLICATION_JSON)
//					.andExpect(status().isOk())
//					.andExpect(jsonPath("$[0].name, is(truc")));
	}
//	@TestConfiguration
//	static class CategoryControllerTestConfiguration {
//		
//		@Bean
//		public CategoryController categoryController() {
//			return new CategoryController();
//		}
//	}
//	
//	@Autowired
//	private CategoryController categoryController;
//	
//	@MockBean
//	private ICategoryRepository categories;
//	
//	@Before
//	public void setUp() {
//		Category test1 = new Category("test1");
//		
//		
//		Mockito.when(categories.findByLabel(test1.getLabel()))
//			.thenReturn(test1);
//	}
//	
//	@Test
//	public void whenValidLabel_thenCategoryShouldBeFound() {
//		String label = "test1";
//		ResponseEntity<?> response = categoryController.getOneCategory((long) 1);
//		Category found = (Category) response.getBody();
//		assertThat(found.getLabel()).isEqualTo(label);
//	}
}
