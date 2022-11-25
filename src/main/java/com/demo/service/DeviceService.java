package com.demo.service;

import java.io.IOException;
import java.util.List;

import com.demo.domain.Device;

public interface DeviceService {

	List<Device> getAllDevice();

	List<Device> filterAllDeviceByCategory(String type) throws IOException;

}
