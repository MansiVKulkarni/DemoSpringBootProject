package com.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Device;
import com.demo.service.DeviceService;

@RestController
@RequestMapping("/api/pri/poc/device")
@CrossOrigin
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping("/getAllData")
	public List<Device> getAllDevice() {
		return deviceService.getAllDevice();
	}

	@GetMapping("/filterByType/{type}")
	public List<Device> FindDeviceBycategory(@PathVariable("type") String type) throws IOException {
		return deviceService.filterAllDeviceByCategory(type);
	}

}
