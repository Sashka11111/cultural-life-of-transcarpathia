package com.lopit.culturallifeoftranscarpathia.persistence.repository.contract;
import com.lopit.culturallifeoftranscarpathia.domain.exception.EntityNotFoundException;
import com.lopit.culturallifeoftranscarpathia.persistence.entity.Category;
import java.util.List;

public interface CategoryRepository {

  void addCategory(Category category) throws EntityNotFoundException;

  List<Category> getAllCategories();

  void updateCategory(Category category) throws EntityNotFoundException;

  void deleteCategory(int id) throws EntityNotFoundException;

  // Методи для звязку багато до багатьох
  void addCategoryToEvent(int categoryId, int eventId);

  void removeCategoryFromEvent(int categoryId, int eventId) throws EntityNotFoundException;

  List<Integer> getCategoriesByEventId(int eventId);

  List<Integer> getEventByCategoryId(int categoryId);
}
