package com.expedia.www.sos.sb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
class RoutesAPIController{
	@RequestMapping("/get_routes")
	public List<Route> getRoutes(){
		String csvFile = "src/main/resources/config-files/lcc-decision-rules-tfonly.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ":";
		List<Route> routes = new ArrayList<Route>();

		try {
			br = new BufferedReader(new FileReader(csvFile));
			line = br.readLine();
			while ((line = br.readLine()) != null) {

			        // use colon as separator
				String[] cur = line.split(cvsSplitBy);
				Route route = new Route(Integer.parseInt(cur[0]), cur[1],
						Integer.parseInt(cur[2]), Integer.parseInt(cur[3]),
						cur[4], cur[5]);
				System.out.println(route.toString());
				routes.add(route);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close(); //we have to close the Reader
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return routes;
	}

	private class Route {
		private final Integer travelProductID;
		private final String segmentationRuleName;
		private final Integer biDirectionalBool;
		private final Integer excludeBool;
		private final String originAirportSet;
		private final String destinationAirportSet;

		public Route(Integer travelProductID, String segmentationRuleName, Integer biDirectionalBool, Integer excludeBool,
				String originAirportSet, String destinationAirportSet) {
			super();
			this.travelProductID = travelProductID;
			this.segmentationRuleName = segmentationRuleName;
			this.biDirectionalBool = biDirectionalBool;
			this.excludeBool = excludeBool;
			this.originAirportSet = originAirportSet;
			this.destinationAirportSet = destinationAirportSet;
		}

		public Integer getTravelProductID() {
			return travelProductID;
		}

		public String getSegmentationRuleName() {
			return segmentationRuleName;
		}

		public Integer getBiDirectionalBool() {
			return biDirectionalBool;
		}

		public Integer getExcludeBool() {
			return excludeBool;
		}

		public String getOriginAirportSet() {
			return originAirportSet;
		}

		public String getDestinationAirportSet() {
			return destinationAirportSet;
		}

		@Override
		public String toString() {
			return "Route [travelProductID=" + travelProductID + ", segmentationRuleName=" + segmentationRuleName
					+ ", biDirectionalBool=" + biDirectionalBool + ", excludeBool=" + excludeBool + ", originAirportSet="
					+ originAirportSet + ", destinationAirportSet=" + destinationAirportSet + "]";
		}

	}
}
