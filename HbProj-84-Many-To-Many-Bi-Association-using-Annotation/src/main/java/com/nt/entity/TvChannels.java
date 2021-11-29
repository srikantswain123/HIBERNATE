package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name="TV_CHANNELS_MTM")
@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class TvChannels implements Serializable {
	@Id	
	@GeneratedValue
	private Integer chanelId;
	@NonNull
	@Type(type = "string")
	@Column(length = 25)
	private String chanelName;
	@NonNull
	@Type(type = "string")
	@Column(length = 25)
	private String company;
	@NonNull
	@Type(type = "string")
	@Column(length = 25)
	private String location;
	@ManyToMany(targetEntity = Subscriber.class,cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	@JoinTable(name="TV_CHANELS_SUB_ID",
	                                    joinColumns = @JoinColumn(name="CHANEL_ID",referencedColumnName = "chanelId"),
	                                    inverseJoinColumns = @JoinColumn(name="SUB_ID",referencedColumnName = "subscriberId")
	                                    )
	private Set<Subscriber> subscribers;
	
	public TvChannels() {
		System.out.println("TvChannels::zero param constructors");
	}

	@Override
	public String toString() {
		return "TvChannels [chanelId=" + chanelId + ", chanelName=" + chanelName + ", company=" + company
				+ ", location=" + location + "]";
	}

	
	
	
	
	
	
	

}
