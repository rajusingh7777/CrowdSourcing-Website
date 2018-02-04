package neu.edu.controller.funder;

import neu.edu.controller.Idea.Idea;

public class FunderModel {
	
	Integer fundpayId;
	Integer userId;
	Integer amountContribution;
	Integer ideaId;
	
	
	public Integer getFundpayId() {
		return fundpayId;
	}
	public void setFundpayId(Integer fundpayId) {
		this.fundpayId = fundpayId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAmountContribution() {
		return amountContribution;
	}
	public void setAmountContribution(Integer amountContribution) {
		this.amountContribution = amountContribution;
	}
	public Integer getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}

	

}
