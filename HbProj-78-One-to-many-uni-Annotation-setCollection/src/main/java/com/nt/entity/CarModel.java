package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class CarModel implements Serializable {
	@Id
	@GeneratedValue(generator = "gen1" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gen1" ,initialValue = 100,allocationSize = 1)
	private Integer modelId;
	@Type(type = "string")
	@Column(length = 20)
	@NonNull
	private String modelName;
	@Type(type = "string")
	@Column(length = 20)
	@NonNull
	private String type;
	@Type(type = "string")
	@Column(length = 20)
	@NonNull
	private String fuel_Type;
	
	public CarModel() {
		System.out.println("CarModel::zero param constructor");
	}

	@Override
	public String toString() {
		return "CarModel [modelId=" + modelId + ", modelName=" + modelName + ", type=" + type + ", fuel_Type="
				+ fuel_Type + "]";
	}
	
	

}
