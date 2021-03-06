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
	public String country, stateProvince, county, countType ;
	public Double effortHours, effortDistance, effortArea;
	public Integer distFromWetFresh, distInWetFresh, distFromWetBrackish, distInWetBrackish;
	public Integer seenCount;
	public Byte isSeen;
	public Double housingPercentVacant;
	public String omernikL3Ecoregion;
	public Integer avgTempVal;
	
	public BirdData(){
		this.latitude = null;
		this.longitude = null;
		this.year = null;
		this.month = null;
		this.day = null;
		this.time = null;
		this.country = "";
		this.stateProvince = "";
		this.county = "";
		this.countType = "";
		this.effortHours = null;
		this.effortDistance = null;
		this.effortArea = null;
		this.seenCount = null;
		this.isSeen = null;
		this.distFromWetFresh = null;
		this.distInWetFresh = null;
		this.distFromWetBrackish = null;
		this.distInWetBrackish = null;
		this.housingPercentVacant = null;
		this.omernikL3Ecoregion ="";
		this.avgTempVal = null;
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
		this.countType = input[11];
		this.effortHours = Double.parseDouble(input[12]);
		this.effortDistance = Double.parseDouble(input[13]);
		this.effortArea = Double.parseDouble(input[14]);
		this.distFromWetFresh = Integer.parseInt(input[1094]);
		this.distInWetFresh = Integer.parseInt(input[1095]);
		this.distFromWetBrackish = Integer.parseInt(input[1100]);
		this.distInWetBrackish = Integer.parseInt(input[1101]);
		this.seenCount = parseSeenCount(input[26]);
		this.housingPercentVacant = Double.parseDouble(input[957]);
		this.omernikL3Ecoregion = input[962];
		if(this.seenCount > 0){
			this.isSeen = 1;
		} else {
			this.isSeen = 0;
		}
		
	}
	
	public Integer parseSeenCount(String s) {
		int count;
		if(s.equalsIgnoreCase("X")){
			return 1;
		}
		try{
			count = Integer.parseInt(s);
		} catch(NumberFormatException e) { 
	        return 0; 
	    } catch(NullPointerException e) {
	        return 0;
	    }
		if(count > 0) return count;
		else return 0;
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



	public String getCountType() {
		return countType;
	}



	public void setCountType(String countType) {
		this.countType = countType;
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



	public Integer getSeenCount() {
		return seenCount;
	}



	public void setSeenCount(Integer seenCount) {
		this.seenCount = seenCount;
	}



	public Byte getIsSeen() {
		return isSeen;
	}



	public void setIsSeen(Byte isSeen) {
		this.isSeen = isSeen;
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
        countType = WritableUtils.readCompressedString(datainput);
        effortHours = Double.parseDouble(WritableUtils.readString(datainput));
        effortDistance = Double.parseDouble(WritableUtils.readString(datainput));
        effortArea = Double.parseDouble(WritableUtils.readString(datainput));
        seenCount = Integer.parseInt(WritableUtils.readString(datainput));
        isSeen = Byte.parseByte(WritableUtils.readString(datainput));	
        housingPercentVacant = Double.parseDouble(WritableUtils.readString(datainput));
        omernikL3Ecoregion = WritableUtils.readCompressedString(datainput);
        avgTempVal = Integer.parseInt(WritableUtils.readString(datainput));
        distFromWetFresh = Integer.parseInt(WritableUtils.readString(datainput));
        distInWetFresh = Integer.parseInt(WritableUtils.readString(datainput));
        distFromWetBrackish = Integer.parseInt(WritableUtils.readString(datainput));
        distInWetBrackish = Integer.parseInt(WritableUtils.readString(datainput));
	}

//	public Double housingPercentVacant;
//	public String omernikL3Ecoregion;
//	public Integer avgTempVal;
//	public String distFromWetFresh, distInWetFresh, distFromWetBrackish, distInWetBrackish;
	
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
		WritableUtils.writeString(dataoutput, countType.toString());
		WritableUtils.writeString(dataoutput, effortHours.toString());
		WritableUtils.writeString(dataoutput, effortDistance.toString());
		WritableUtils.writeString(dataoutput, effortArea.toString());
		WritableUtils.writeString(dataoutput, seenCount.toString());
		WritableUtils.writeString(dataoutput, isSeen.toString());	
		WritableUtils.writeString(dataoutput, housingPercentVacant.toString());
		WritableUtils.writeString(dataoutput, omernikL3Ecoregion.toString());
		WritableUtils.writeString(dataoutput, avgTempVal.toString());
		WritableUtils.writeString(dataoutput, distFromWetFresh.toString());
		WritableUtils.writeString(dataoutput, distInWetFresh.toString());
		WritableUtils.writeString(dataoutput, distFromWetBrackish.toString());	
		WritableUtils.writeString(dataoutput, distInWetBrackish.toString());
	}

}
