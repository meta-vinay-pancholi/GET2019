package com.metacube.parking.model;

import javax.validation.constraints.NotBlank;

public class VehicleDetails {
	private int id;
	//@NotBlank(message = "Vehicle name is must")
	private String vehicleName;
	//@NotBlank(message = "Vehicle type is must")
	private String vehicleType;
	//@NotBlank(message = "Vehicle number is must")
	private String vehicleNumber;
	//@NotBlank(message = "Employee id is must")
	private String empId;
	//@NotBlank(message = "Vehicle identification is must")
	private String identification;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public VehicleDetails() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VehicleDetails [id=" + id + ", vehicleName=" + vehicleName
				+ ", vehicleType=" + vehicleType + ", vehicleNumber="
				+ vehicleNumber + ", empId=" + empId + ", identification="
				+ identification + "]";
	}
	public VehicleDetails(int id, String vehicleName, String vehicleType,
			String vehicleNumber, String empId, String identification) {
		super();
		this.id = id;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.empId = empId;
		this.identification = identification;
	}
	
}
