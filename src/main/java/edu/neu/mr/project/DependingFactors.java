package edu.neu.mr.project;

import java.util.ArrayList;

import weka.core.Attribute;

public class DependingFactors {
	
	public static ArrayList<Attribute>  setWekaAttributes(){
		
		ArrayList<Attribute> wekaAttributes = new ArrayList<>();
		wekaAttributes.add(new Attribute("MONTH", Attribute.NUMERIC));
		wekaAttributes.add(new Attribute("TIME", Attribute.NUMERIC));
		wekaAttributes.add(new Attribute("STATE_PROVINCE", Attribute.STRING));
		wekaAttributes.add(new Attribute("L3_ECOREGION", Attribute.STRING));
		wekaAttributes.add(new Attribute("AVERAGE_TEMP", Attribute.NUMERIC));
		wekaAttributes.add(new Attribute("HOUSING_PERCENT_VACANT", Attribute.NUMERIC));
		wekaAttributes.add(new Attribute("DIST_FROM_WET_FRESH", Attribute.NUMERIC));
		wekaAttributes.add(new Attribute("DIST_IN_WET_FRESH", Attribute.NUMERIC));
		wekaAttributes.add(new Attribute("DIST_FROM_WET_BRACKISH", Attribute.NUMERIC));
		wekaAttributes.add(new Attribute("DIST_IN_WET_BRACKISH", Attribute.NUMERIC));
		
		ArrayList<String> isSeenValues = new ArrayList<String>();
		isSeenValues.add("0");
		isSeenValues.add("1");	
		wekaAttributes.add(new Attribute("IS_SEEN", isSeenValues));
		
		return wekaAttributes;
		
	}

}
