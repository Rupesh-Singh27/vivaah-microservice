package com.vivaah.caterer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Caterer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catererId;
	
	@Column(name = "caterer_name")
	@Length(min = 2, max = 50, message="Name's length must not be more then 50 character")
	@NotBlank(message="Must contain atleast one non-space character")
	private String catererName;
	
	@Column(name = "caterer_description")
	@Length(min = 2, max = 100, message="Description's length must not be more then 100 character")
	@NotBlank(message="Must contain atleast one non-space character")
	private String catererDescription;
	
	@Column(name = "caterer_imagepath")
	@Length(min = 2, max = 255, message="Lenght of the imagepath must not be more than 255 characters")
	@NotBlank(message = "Field cannot be left blank")
	private String imagepath;
	
	
	
	public Caterer() {
		super();
	}

	public Caterer(String catererName, String catererDescription, String imagepath) {
		super();
		this.catererName = catererName;
		this.catererDescription = catererDescription;
		this.imagepath = imagepath;
	}

	public String getCatererName() {
		return catererName;
	}

	public void setCatererName(String catererName) {
		this.catererName = catererName;
	}

	public String getCatererDescription() {
		return catererDescription;
	}

	public void setCatererDiscription(String catererDescription) {
		this.catererDescription = catererDescription;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
}
