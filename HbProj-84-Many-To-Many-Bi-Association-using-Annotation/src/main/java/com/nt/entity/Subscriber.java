package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Table(name="SUBSCRIBER_MTM")
@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Subscriber implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "sub_id_seq",allocationSize = 5456,initialValue = 1)
	@GeneratedValue(generator = "gen1")
	private Integer subscriberId;
	@NonNull
	@Type(type = "string")
	@Column(length = 25)
	private String subscriberName;
	@NonNull
	@Type(type = "string")
	@Column(length = 25)
	private String subscriberType;
	@NonNull
	@Type(type = "string")
	@Column(length = 25)
	private String subscriberLocation;
	@ManyToMany(targetEntity = TvChannels.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy ="subscribers" )
	private Set<TvChannels> chanels;
	
	public Subscriber() {
		System.out.println("Subscriber::zero param contructor");
	}

	@Override
	public String toString() {
		return "Subscriber [subscriberId=" + subscriberId + ", subscriberName=" + subscriberName + ", subscriberType="
				+ subscriberType + ", subscriberLocation=" + subscriberLocation + "]";
	}

}
