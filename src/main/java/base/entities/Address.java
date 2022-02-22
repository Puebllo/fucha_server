package base.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "address", schema = "public")
public class Address implements Serializable{

	private static final long serialVersionUID = -6258097696620376642L;

	public static final String ID ="id";
	public static final String STREET ="street";
	public static final String BUILDING_NR ="buildingNr";
	public static final String FLAT_NR ="flatNr";
	public static final String CITY ="city";
	public static final String POSTAL_CODE ="postalCode";
    public static final String LAT ="lat";
    public static final String LNG ="lng";

	public Long id;
	public String street;
	public String buildingNr;
	public String flatNr;
	public String city;
	public String postalCode;
    public Double lat;
    public Double lng;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="street",nullable = false)
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name="building_nr",nullable = false)
	public String getBuildingNr() {
		return buildingNr;
	}
	public void setBuildingNr(String buildingNr) {
		this.buildingNr = buildingNr;
	}

	@Column(name="flat_nr")
	public String getFlatNr() {
		return flatNr;
	}
	public void setFlatNr(String flatNr) {
		this.flatNr = flatNr;
	}

	@Column(name="city",nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="postal_code",nullable = false)
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	

    @Column(name = "lat")
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Column(name = "lng")
    public Double getLng() {
        return lng;
    }
    public void setLng(Double lng) {
        this.lng = lng;
    }

	@Override
	public String toString() {
		String string = street + " " + buildingNr;
		
		if(flatNr!=null) {
			string += "/" + flatNr;
		}
		string +=  " " + postalCode + " " + city;
		
		return string;
	}

}
