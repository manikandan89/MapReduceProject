package edu.neu.mr.project;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

public class BirdData implements Writable {
	
	public Double latitude, longitude;
	public Integer year, month, day;
	public Double time;
	public String country, stateProvince, county, countyType ;
	public Double effortHours, effortDistance, effortArea;
	public String seenCount;
	public Integer isSeen;
	
	public BirdData(){
		this.latitude = 0.00;
		this.longitude = 0.00;
		this.year = 0;
		this.month = 0;
		this.day = 0;
		this.time = 0.00;
		this.country = "";
		this.stateProvince = "";
		this.county = "";
		this.countyType = "";
		this.effortHours = 0.00;
		this.effortDistance = 0.00;
		this.effortArea = 0.00;
		this.seenCount = "0";
		this.isSeen = 0;
	}
	
	public BirdData(String[] input){
		this.latitude = Double.parseDouble(input[2]);
		this.longitude = Double.parseDouble(input[3]);
		this.year = Integer.parseInt(input[4]);
		this.month = Integer.parseInt(input[5]);
		this.day = Integer.parseInt(input[6]);
		this.time = Double.parseDouble(input[7]);
		this.country = input[8];
		this.stateProvince = input[9];
		this.county = input[10];
		this.countyType = input[11];
		this.effortHours = Double.parseDouble(input[12]);
		this.effortDistance = Double.parseDouble(input[13]);
		this.effortArea = Double.parseDouble(input[14]);
		this.seenCount = input[26];
		if(seenCount.equals("0") || seenCount.equalsIgnoreCase("NA") || seenCount.equalsIgnoreCase("?")){
			this.isSeen = 0;
		} else if(seenCount.equalsIgnoreCase("X")){
			this.isSeen = 1;
		} else {
			this.isSeen = isValidCount(seenCount);
		}
		
	}
	
	
	public Double getLatitude() {
		return latitude;
	}



	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}



	public Double getLongitude() {
		return longitude;
	}



	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}



	public Integer getMonth() {
		return month;
	}



	public void setMonth(Integer month) {
		this.month = month;
	}



	public Integer getDay() {
		return day;
	}



	public void setDay(Integer day) {
		this.day = day;
	}



	public Double getTime() {
		return time;
	}



	public void setTime(Double time) {
		this.time = time;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getStateProvince() {
		return stateProvince;
	}



	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}



	public String getCounty() {
		return county;
	}



	public void setCounty(String county) {
		this.county = county;
	}



	public String getCountyType() {
		return countyType;
	}



	public void setCountyType(String countyType) {
		this.countyType = countyType;
	}



	public Double getEffortHours() {
		return effortHours;
	}



	public void setEffortHours(Double effortHours) {
		this.effortHours = effortHours;
	}



	public Double getEffortDistance() {
		return effortDistance;
	}



	public void setEffortDistance(Double effortDistance) {
		this.effortDistance = effortDistance;
	}



	public Double getEffortArea() {
		return effortArea;
	}



	public void setEffortArea(Double effortArea) {
		this.effortArea = effortArea;
	}



	public String getSeenCount() {
		return seenCount;
	}



	public void setSeenCount(String seenCount) {
		this.seenCount = seenCount;
	}



	public Integer getIsSeen() {
		return isSeen;
	}



	public void setIsSeen(Integer isSeen) {
		this.isSeen = isSeen;
	}



	public Integer isValidCount(String s){
		int count;
		try{
			count = Integer.parseInt(s);
		} catch(NumberFormatException e) { 
	        return 0; 
	    } catch(NullPointerException e) {
	        return 0;
	    }
		if(count > 0) return 1;
		else return 0;
	}

	@Override
	public void readFields(DataInput datainput) throws IOException { 
        latitude = Double.parseDouble(WritableUtils.readString(datainput));
        longitude = Double.parseDouble(WritableUtils.readString(datainput));
        year = Integer.parseInt(WritableUtils.readString(datainput));
        month = Integer.parseInt(WritableUtils.readString(datainput));
        day = Integer.parseInt(WritableUtils.readString(datainput));
        time = Double.parseDouble(WritableUtils.readString(datainput));
        country = WritableUtils.readCompressedString(datainput);
        stateProvince = WritableUtils.readCompressedString(datainput);
        county = WritableUtils.readCompressedString(datainput);
        countyType = WritableUtils.readCompressedString(datainput);
        effortHours = Double.parseDouble(WritableUtils.readString(datainput));
        effortDistance = Double.parseDouble(WritableUtils.readString(datainput));
        effortArea = Double.parseDouble(WritableUtils.readString(datainput));
        seenCount = WritableUtils.readString(datainput);
        isSeen = Integer.parseInt(WritableUtils.readString(datainput));	
	}

	@Override
	public void write(DataOutput dataoutput) throws IOException {
		WritableUtils.writeString(dataoutput, latitude.toString());
		WritableUtils.writeString(dataoutput, longitude.toString());
		WritableUtils.writeString(dataoutput, year.toString());
		WritableUtils.writeString(dataoutput, month.toString());
		WritableUtils.writeString(dataoutput, day.toString());
		WritableUtils.writeString(dataoutput, time.toString());
		WritableUtils.writeString(dataoutput, country.toString());
		WritableUtils.writeString(dataoutput, stateProvince.toString());
		WritableUtils.writeString(dataoutput, county.toString());
		WritableUtils.writeString(dataoutput, countyType.toString());
		WritableUtils.writeString(dataoutput, effortHours.toString());
		WritableUtils.writeString(dataoutput, effortDistance.toString());
		WritableUtils.writeString(dataoutput, effortArea.toString());
		WritableUtils.writeString(dataoutput, seenCount.toString());
		WritableUtils.writeString(dataoutput, isSeen.toString());	
	}

}
