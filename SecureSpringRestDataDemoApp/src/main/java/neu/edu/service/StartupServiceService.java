package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.controller.Idea.Idea;
import neu.edu.controller.startup.StartupController;
import neu.edu.controller.startup.StartupModel;
import neu.edu.dao.StartupDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.CreatorIdea;
import neu.edu.entity.StartupServices;
import neu.edu.entity.User;

@Service
public class StartupServiceService {
	
	@Autowired
	private StartupDao startupDao;
	
	@Autowired
	private UserDao userDao;
	
//	@Autowired
//	private StartupController startupController;
//	
//	@Autowired
//	private Startup
	
	@Transactional
	public List<StartupModel> findAll() {
		return startupDao.findAll().stream().map(x -> {
			
			StartupModel temp = new StartupModel();
			temp.setServiceId(x.getServiceId());
			temp.setServiceDesc(x.getServiceDesc());
			temp.setServiceName(x.getServiceName());
			temp.setIdeaId(x.getIdeaId());
			temp.setUserId(x.getUser().getUserId());
			return temp;
			
			}).collect(Collectors.toList());
		}
	
	@Transactional
	public StartupModel createStartup(StartupModel startupModel) {
			
			
//			IdeaCategory cat = categoryDao.findOne(idea.getCategoryId());
			User user = userDao.findOne(startupModel.getUserId());
			
			
			StartupModel startup = null;

			if (user != null) {
				StartupServices ss = new StartupServices();
				ss.setUser(user);
				ss.setServiceName(startupModel.getServiceName());
				ss.setServiceDesc(startupModel.getServiceDesc());
				ss.setIdeaId(startupModel.getIdeaId());
				ss = startupDao.save(ss);
				
				startup = new StartupModel();
				startup.setServiceId(ss.getServiceId());;
				startup.setServiceName(ss.getServiceName());
//				projectProfile.setUserId(ic.getUser().getUserId());
			} else {
				return startup;
			}

			return startup;

		}
		
		@Transactional
		public boolean updateStartup(Integer startupId,StartupModel startupModel) {
			StartupServices ss=startupDao.findOne(startupId);
			if(ss != null){
				
				if(startupModel.getServiceName()!=null){
					ss.setServiceName(startupModel.getServiceName());
					ss.setServiceDesc(startupModel.getServiceDesc());
					ss.setIdeaId(startupModel.getServiceId());
				}
				startupDao.save(ss);
				return true;
			}else{
				return false;
			}
		}
	 
			 @Transactional
			 public boolean deleteStartup(Integer startupId) {
				 StartupServices toBeDeleted=startupDao.findOne(startupId);
				 	if(toBeDeleted!=null){
				 		
				 		startupDao.delete(toBeDeleted);
						return true;
				 	}
					return false;
			 }
	
	
	

}
