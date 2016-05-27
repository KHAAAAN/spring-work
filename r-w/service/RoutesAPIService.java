package com.expedia.www.rulestore.common.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;

public class RoutesAPIService{

    public List<Route> getRoutes(){
        RestTemplate restTemplate = new RestTemplate();
        List<Route> rc = restTemplate.getForObject("http://localhost:8080/get_routes",
         ArrayList.class);

        return rc;
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
