package neu.edu.controller.Idea;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Idea {
	private Integer ideaId;
	private Integer categoryId;
	private Integer userId;
	private String ideaName;
	private String ideaDesc;
	private Integer targetAmount;
	public Integer getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getIdeaName() {
		return ideaName;
	}
	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}
	public String getIdeaDesc() {
		return ideaDesc;
	}
	public void setIdeaDesc(String ideaDesc) {
		this.ideaDesc = ideaDesc;
	}
	public Integer getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(Integer targetAmount) {
		this.targetAmount = targetAmount;
	}
	
	
	
}
