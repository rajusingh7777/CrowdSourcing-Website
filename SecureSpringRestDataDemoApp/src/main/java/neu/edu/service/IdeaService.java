package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.controller.Idea.Idea;
import neu.edu.dao.IdeaCategoryDao;
import neu.edu.dao.IdeaDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.CreatorIdea;
import neu.edu.entity.IdeaCategory;
import neu.edu.entity.User;

@Service
public class IdeaService {
	
	@Autowired
	private IdeaDao ideaDao;
	
	@Autowired
	private IdeaCategoryDao categoryDao;
	
	
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public List<Idea> findAll() {
		// TODO Auto-generated method stub
		
		return ideaDao.findAll().stream().map(x -> {
			Idea temp = new Idea();
			temp.setIdeaId(x.getIdeaId());
			temp.setCategoryId(x.getCategoryId());
			temp.setIdeaDesc(x.getIdeaDesc());
			temp.setIdeaName(x.getIdeaName());
			temp.setTargetAmount(x.getTargetAmount());
			temp.setUserId(x.getUser().getUserId());
			
			return temp;
		}).collect(Collectors.toList());
		
	}		
		
	@Transactional
	public Idea createProject(Idea idea) {
			
			
//			IdeaCategory cat = categoryDao.findOne(idea.getCategoryId());
			User user = userDao.findOne(idea.getUserId());
			
			
			Idea projectProfile = null;

			if (user != null) {
				CreatorIdea ic = new CreatorIdea();
				ic.setUser(user);
				ic.setIdeaName(idea.getIdeaName());
				ic.setIdeaDesc(idea.getIdeaDesc());
				ic.setTargetAmount(idea.getTargetAmount());
				ic.setCategoryId(idea.getCategoryId());
				
				ic = ideaDao.save(ic);
				
				projectProfile = new Idea();
				projectProfile.setIdeaId(ic.getIdeaId());;
				projectProfile.setIdeaName(ic.getIdeaName());
//				projectProfile.setUserId(ic.getUser().getUserId());
			} else {
				return projectProfile;
			}

			return projectProfile;

		}
		
		@Transactional
		public boolean updateProject(Integer ideaId,Idea idea) {
			CreatorIdea updateIdea=ideaDao.findOne(ideaId);
			if(updateIdea != null){
				
				if(idea.getIdeaName()!=null){
					updateIdea.setIdeaName(idea.getIdeaName());
					updateIdea.setCategoryId(idea.getCategoryId());
					//updateIdea.setCategoryId(idea.getCategoryId());//to add for category name, table to be updated
					updateIdea.setIdeaDesc(idea.getIdeaDesc());
					updateIdea.setTargetAmount(idea.getTargetAmount());
				}
				ideaDao.save(updateIdea);
				return true;
			}else{
				return false;
			}
		}
	 
			 @Transactional
			 public boolean deleteProject(Integer ideaId) {
				 CreatorIdea toBeDeleted=ideaDao.findOne(ideaId);
				 	if(toBeDeleted!=null){
				 		
				 		ideaDao.delete(toBeDeleted);
						return true;
				 	}
					return false;
			 }
	
	
}
