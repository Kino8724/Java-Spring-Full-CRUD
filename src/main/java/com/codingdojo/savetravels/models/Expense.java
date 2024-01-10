package com.codingdojo.savetravels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 2, max = 100)
	private String name;
	@NotBlank
	@Size(min = 2, max = 100)
	private String vendor;
	@NotNull
	@Min(value=1, message="Must be greater than or equal to 1")
	private float amount;
	@NotBlank
	@Size(min = 5, max = 500)
	private String description;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Expense() {
	}
	public Expense(String name, String vendor, float amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	// Getters
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getVendor() {
		return vendor;
	}
	public float getAmount() {
		return amount;
	}
	public String getDescription() {
		return description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	//Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
