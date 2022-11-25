package com.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Data;

@Data
public class Device {
	@Id
	private String deviceID;
	@Indexed(unique = true)
	private String deviceName;
	private String capacity;
	private String type;
	private String latitude;
	private String longitude;
	private String deviceStatus;
	private String project;
	private Long availableDate;
	private String operatorName;
}