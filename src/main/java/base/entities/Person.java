package base.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person", schema = "public")
public class Person implements Serializable{

	private static final long serialVersionUID = 4085084749928684310L;
	
	public static final String ID ="id";
	public static final String FIRST_NAME ="firstName";
	public static final String LAST_NAME ="lastName";
	public static final String USER ="user";
    public static final String ADDRESS ="address";

	public Long id;
	public String firstName;
	public String lastName;
	public User user;
    public Address address;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="first_name",nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="last_name",nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="users")	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "address", nullable = false)
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

	@Override
	public String toString() {
		return firstName +" " + lastName;
	}
}
