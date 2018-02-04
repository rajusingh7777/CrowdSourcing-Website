package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.controller.funder.FunderModel;
import neu.edu.controller.startup.StartupModel;
import neu.edu.dao.FunderDao;
import neu.edu.dao.IdeaDao;
import neu.edu.dao.StartupDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.CreatorIdea;
import neu.edu.entity.FunderPayment;
import neu.edu.entity.StartupServices;
import neu.edu.entity.User;

@Service
public class FunderService {
	@Autowired
	private FunderDao funderDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private IdeaDao ideaDao;
	
	@Transactional
	public List<FunderModel> findAll() {
		return funderDao.findAll().stream().map(x -> {
			
			FunderModel temp = new FunderModel();
			temp.setFundpayId(x.getFundpayId());
			temp.setAmountContribution(x.getAmountContribution());
			temp.setIdeaId(x.getIdeaId());
			temp.setUserId(x.getUser().getUserId());
			return temp;
			
			}).collect(Collectors.toList());
		}
	
	@Transactional
	public FunderModel createFunder(FunderModel funderModel) {
			
			
//			IdeaCategory cat = categoryDao.findOne(idea.getCategoryId());
			User user = userDao.findOne(funderModel.getUserId());
			CreatorIdea i=ideaDao.findOne(funderModel.getIdeaId());
			
			FunderModel funder = null;

			if (user != null) {
				FunderPayment fp = new FunderPayment();
				fp.setUser(user);
				fp.setAmountContribution(funderModel.getAmountContribution());
				fp.setIdeaId(funderModel.getIdeaId());
				fp = funderDao.save(fp);
				
				funder = new FunderModel();
				funder.setFundpayId(fp.getFundpayId());
			} else {
				return funder;
			}

			return funder;

		}
		
		@Transactional
		public boolean updateFunder(Integer funderId,FunderModel funderModel) {
			FunderPayment fp=funderDao.findOne(funderId);
			if(fp != null){
				
				
					fp.setAmountContribution(funderModel.getAmountContribution());
					fp.setIdeaId(funderModel.getIdeaId());

				funderDao.save(fp);
				return true;
			}else{
				return false;
			}
		}
	 
			 @Transactional
			 public boolean deleteFunder(Integer funderId) {
				 FunderPayment toBeDeleted=funderDao.findOne(funderId);
				 	if(toBeDeleted!=null){
				 		
				 		funderDao.delete(toBeDeleted);
						return true;
				 	}
					return false;
			 }

}
