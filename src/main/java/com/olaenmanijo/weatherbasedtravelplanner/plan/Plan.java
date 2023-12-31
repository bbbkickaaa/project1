package com.olaenmanijo.weatherbasedtravelplanner.plan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.olaenmanijo.weatherbasedtravelplanner.tourapi.domain.Place;
import com.olaenmanijo.weatherbasedtravelplanner.tourapi.dto.Item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@SessionScope
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Plan implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	private long memberNo;
	@JsonProperty
	String startDate;
	@JsonProperty
	String endDate;
	@JsonProperty
	String title;
	@JsonProperty
	List<PlanDTO2> places = new ArrayList<>();
	
	public Plan() {
	}
	
	public void add(PlanDTO2 place) {
		places.add(place);
	}
	
	public void sortPlaces() {
        places.sort(Comparator
                .comparing(PlanDTO2::getDate)
                .thenComparing(PlanDTO2::getStartHour));
    }
}
