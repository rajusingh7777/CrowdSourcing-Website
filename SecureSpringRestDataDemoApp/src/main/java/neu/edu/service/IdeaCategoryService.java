package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.controller.category.IdeaCategoryModel;
import neu.edu.dao.IdeaCategoryDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.IdeaCategory;
import neu.edu.entity.User;

@Service
public class IdeaCategoryService {
	
	@Autowired
	private IdeaCategoryDao ideaCategoryDao;
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public List<IdeaCategoryModel> findAll() {
		// TODO Auto-generated method stub
		
		return ideaCategoryDao.findAll().stream().map(x -> {
			IdeaCategoryModel temp = new IdeaCategoryModel();
			temp.setCategoryId(String.valueOf(x.getCategoryId()));
			temp.setCategoryName(x.getCategoryName());
			return temp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public Integer createCategory(IdeaCategoryModel ideaCategoryModel) {
			
			IdeaCategory category=new IdeaCategory();
			category.setCategoryName(ideaCategoryModel.getCategoryName());;
			category=ideaCategoryDao.save(category);
			System.out.println("ID Created " + category.getCategoryId());
			return category.getCategoryId();

	}
	
	@Transactional
	public boolean deleteIdeaCategory(Integer categoryId) {
		
		IdeaCategory toBeDeleted = ideaCategoryDao.findOne(categoryId);
		if (toBeDeleted!=null){
			ideaCategoryDao.delete(toBeDeleted);
			return true;
		}
		return false;
		
	}
	
	@Transactional
	public boolean updateCategory(Integer categoryId, IdeaCategoryModel newCategory, Integer userId) {
		
		IdeaCategory toBeUpdated = ideaCategoryDao.findOne(categoryId);
		User user = userDao.findOne(userId);
		if (user!=null && "Admin".equals(user.getRole().getRoleName()) && toBeUpdated!=null){
			toBeUpdated.setCategoryName(newCategory.getCategoryName());
			ideaCategoryDao.save(toBeUpdated);
			return true;
		}
		return false;
		
	}

}
