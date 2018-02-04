package neu.edu.entity;
// Generated Dec 10, 2017 9:50:59 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StartupServices generated by hbm2java
 */
@Entity
@Table(name = "startupservices")
public class StartupServices implements java.io.Serializable {

	private Integer serviceId;
	private User user;
	private String serviceName;
	private String serviceDesc;
	private int ideaId;

	public StartupServices() {
	}

	public StartupServices(User user, String serviceName, int ideaId) {
		this.user = user;
		this.serviceName = serviceName;
		this.ideaId = ideaId;
	}

	public StartupServices(User user, String serviceName, String serviceDesc, int ideaId) {
		this.user = user;
		this.serviceName = serviceName;
		this.serviceDesc = serviceDesc;
		this.ideaId = ideaId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "service_id", unique = true, nullable = false)
	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "service_name", nullable = false, length = 45)
	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column(name = "service_desc", length = 100)
	public String getServiceDesc() {
		return this.serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	@Column(name = "idea_id", nullable = false)
	public int getIdeaId() {
		return this.ideaId;
	}

	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}

}
