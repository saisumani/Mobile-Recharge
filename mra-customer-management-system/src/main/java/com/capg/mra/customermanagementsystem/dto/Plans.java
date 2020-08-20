package com.capg.mra.customermanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Boola Rohan
 * @author Sumani
 *
 */
/**
 * The @Entity annotation specifies that the class is an entity and is mapped to a database table.
 * inside package of  javax.persistence.Entity
 *
 */
@Entity
/**
 * 
 * The @Table annotation specifies the name of the database table to be used for mapping.
 * inside package of javax.persistence.Table
 */
@Table(name = "Plans_Table")
public class Plans {
	
	/**
	 * This annotation is declared to determine where the 
	 * primary key attribute of the entity corresponds to 
	 * the primary key column in the table.
	 */
		@Id
		/**
		 * The GeneratedValue annotation may be applied to a primary key property or 
		 * field of an entity or mapped superclass in conjunction with the Id annotation. 
		 * The use of the GeneratedValue annotation is only required to be supported for simple primary keys.
		 * 
		 */
		@GeneratedValue(strategy = GenerationType.AUTO)
		/**
		 * Is used to specify the mapped column for a persistent property or field. 
		 * If no Column annotation is specified, the default values apply.
		 */
		@Column(name = "Plans_Id")
		private Long plansId;
		@Column(name = "Plans_Name")
		private String plansName;
		@Column(name = "Plans_Price")
		private Long plansPrice;
		@Column(name = "Plans_Validity")
		private Long validity;
		@Column(name = "operator")
		private String operator;
		@Column(name = "circle")
		private String circle;

		public Plans() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Plans(Long plansId, String plansName, Long plansPrice, Long validity, String operator, String circle) {
			super();
			this.plansId = plansId;
			this.plansName = plansName;
			this.plansPrice = plansPrice;
			this.validity = validity;
			this.operator = operator;
			this.circle = circle;
		}

		public Long getPlansId() {
			return plansId;
		}

		public void setPlansId(Long plansId) {
			this.plansId = plansId;
		}

		public String getPlansName() {
			return plansName;
		}

		public void setPlansName(String plansName) {
			this.plansName = plansName;
		}

		public Long getPlansPrice() {
			return plansPrice;
		}

		public void setPlansPrice(Long plansPrice) {
			this.plansPrice = plansPrice;
		}

		public Long getValidity() {
			return validity;
		}

		public void setValidity(Long validity) {
			this.validity = validity;
		}

		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}

		public String getCircle() {
			return circle;
		}

		public void setCircle(String circle) {
			this.circle = circle;
		}

		@Override
		public String toString() {
			return "Plans [plansId=" + plansId + ", plansName=" + plansName + ", plansPrice=" + plansPrice + ", validity="
					+ validity + ", operator=" + operator + ", circle=" + circle + "]";
		}


}


