package com.tut;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.Transient;

@Entity
@Table(name = "student_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

	@Column(length = 50, name = "STREET")
	private String street;

	@Column(name = "CITY", length = 100)
	private String city;

	@Column(name = "is_open")
	private boolean isOpen;

	@Transient
	private double x;

	@Column(name = "added_date")
	@Temporal(jakarta.persistence.TemporalType.DATE)
	private Date addeDate;

	@Lob
	@Column(length = 1000000)
	private int[] image;

	public Address() {
		super();
	}

	public Address(int addressId, String street, String city, boolean isOpen, double x, Date addeDate, int[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addeDate = addeDate;
		this.image = image;
	}

	public int getaddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddeDate() {
		return addeDate;
	}

	public void setAddeDate(Date addeDate) {
		this.addeDate = addeDate;
	}

	public int[] getImage() {
		return image;
	}

	public void setImage(int[] data) {
		this.image = data;
	}

	@Override
	public String toString() {
		return "Address [sddressId=" + addressId + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen
				+ ", x=" + x + ", addeDate=" + addeDate + ", image=" + Arrays.toString(image) + "]";
	}

}
