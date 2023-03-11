package com.example.ZyaPaarTest.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "Inventory")
public class InventoryEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		  private int id;
		
		  private String item;
		  private int stock;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		public int getstock() {
			return stock;
		}
		public void setstock(int stock) {
			this.stock = stock;
		}
		public InventoryEntity(int id, String item, int stock) {
			super();
			this.id = id;
			this.item = item;
			this.stock = stock;
		}
		public InventoryEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "InventoryEntity [id=" + id + ", item=" + item + ", stock=" + stock + ", getId()=" + getId()
					+ ", getItem()=" + getItem() + ", getstock()=" + getstock() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		
		  
		  


}

