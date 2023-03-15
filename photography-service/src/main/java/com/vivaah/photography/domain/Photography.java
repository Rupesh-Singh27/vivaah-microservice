package com.vivaah.photography.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Photography {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long photographyId;
	
	@Column(name ="photography_name")
	@Length(min = 2, max = 50, message="Name's length must not be more then 50 character")
	@NotBlank(message="Must contain atleast one non-space character")
	private String photographyName;
	
	@Column(name ="photography_description")
	@Length(min = 2, max = 400, message="Description's length must not be more then 100 character")
	@NotBlank(message="Must contain atleast one non-space character")
	private String photographyDescription;
	
	@Column(name ="photography_imagepath")
	@Length(min = 2, max = 255, message="Lenght of the imagepath must not be more than 255 characters")
	@NotBlank(message = "Field cannot be left blank")
	private String imagepath;
	
	public Photography() {
		super();
	}

	public Photography(String photographyName, String photographyDescription, String imagepath) {
		super();
		this.photographyName = photographyName;
		this.photographyDescription = photographyDescription;
		this.imagepath = imagepath;
	}

	public String getPhotographyName() {
		return photographyName;
	}

	public void setPhotographyName(String photographyName) {
		this.photographyName = photographyName;
	}

	public String getPhotographyDescription() {
		return photographyDescription;
	}

	public void setPhotographyDescription(String photographyDescription) {
		this.photographyDescription = photographyDescription;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
}
