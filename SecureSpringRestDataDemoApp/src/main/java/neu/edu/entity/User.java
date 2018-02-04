package neu.edu.entity;
// Generated Dec 10, 2017 9:50:59 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

	private Integer userId;
	private Person person;
	private Role role;
	private Date createdOn;
	private String username;
	private String password;
	private Set<StartupServices> startupServiceses = new HashSet<StartupServices>(0);
	private Set<FunderPayment> funderPayments = new HashSet<FunderPayment>(0);
	private Set<CreatorIdea> creatorIdeas = new HashSet<CreatorIdea>(0);

	public User() {
	}

	public User(Person person, Role role, Date createdOn, String username, String password) {
		this.person = person;
		this.role = role;
		this.createdOn = createdOn;
		this.username = username;
		this.password = password;
	}

	public User(Person person, Role role, Date createdOn, String username, String password,
			Set<StartupServices> startupServiceses, Set<FunderPayment> funderPayments, Set<CreatorIdea> creatorIdeas) {
		this.person = person;
		this.role = role;
		this.createdOn = createdOn;
		this.username = username;
		this.password = password;
		this.startupServiceses = startupServiceses;
		this.funderPayments = funderPayments;
		this.creatorIdeas = creatorIdeas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false)
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "username", nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 256)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<StartupServices> getStartupServiceses() {
		return this.startupServiceses;
	}

	public void setStartupServiceses(Set<StartupServices> startupServiceses) {
		this.startupServiceses = startupServiceses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<FunderPayment> getFunderPayments() {
		return this.funderPayments;
	}

	public void setFunderPayments(Set<FunderPayment> funderPayments) {
		this.funderPayments = funderPayments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<CreatorIdea> getCreatorIdeas() {
		return this.creatorIdeas;
	}

	public void setCreatorIdeas(Set<CreatorIdea> creatorIdeas) {
		this.creatorIdeas = creatorIdeas;
	}

}
