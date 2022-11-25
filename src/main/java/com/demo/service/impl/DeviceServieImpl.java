package com.demo.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.Device;
import com.demo.service.DeviceService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class DeviceServieImpl implements DeviceService {

	@Override
	public List<Device> getAllDevice() {
		InputStream inputStream = getClass().getResourceAsStream("./Device.json");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		ObjectMapper objectMapper = new ObjectMapper();
		List<Device> devices = new ArrayList<>();
		try {
			Device[] device = objectMapper.readValue(reader, Device[].class);
			devices = Arrays.asList(device);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return devices;
	}

	@Override
	public List<Device> filterAllDeviceByCategory(String type) throws IOException {
		InputStream inputStream = getClass().getResourceAsStream("./Device.json");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		ObjectMapper objectMapper = new ObjectMapper();
		Device[] device = objectMapper.readValue(reader, Device[].class);
		List<Device> devices = Arrays.asList(device);
		List<Device> deviceList = new ArrayList<>();
		for (int i = 0; i < devices.size(); i++) {
			if (type.equalsIgnoreCase(devices.get(i).getType())) {
				deviceList.add(devices.get(i));

			} else {
				deviceList.addAll(Collections.emptyList());
			}
		}
		return deviceList;
	}

}
