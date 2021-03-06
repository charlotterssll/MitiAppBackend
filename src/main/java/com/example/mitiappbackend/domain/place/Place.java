/*
 * Copyright \(C\) open knowledge GmbH\.
 *
 * Licensed under the Apache License, Version 2\.0 \(the "License"\);
 * you may not use this file except in compliance with the License\.
 * You may obtain a copy of the License at
 *
 *     http://www\.apache\.org/licenses/LICENSE-2\.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied\.
 * See the License for the specific language governing permissions and
 * limitations under the License\.
 */
package com.example.mitiappbackend.domain.place;

import static org.apache.commons.lang3.Validate.notNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "PLACE")
@NamedQueries({
    @NamedQuery(name = Place.READ_ALL, query = "SELECT p FROM Place p ORDER BY p.placeId"),
    @NamedQuery(name = Place.READ_BY_PLACE_STREET, query = "SELECT p FROM Place p"
            + " WHERE p.street = :street")
})
public class Place {

    public static final String READ_ALL = "Place.readAll";

    public static final String READ_BY_PLACE_STREET = "Place.readByPlaceStreet";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLACE_ID")
    private Long placeId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "PLACE_LOCALITY"))
    private Locality locality;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "PLACE_LOCATION"))
    private Location location;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "PLACE_STREET"))
    private Street street;

    @JsonCreator
    public Place(@JsonProperty("locality") Locality locality,
        @JsonProperty("location") Location location,
        @JsonProperty("street") Street street) {
        this.locality = notNull(locality, "null in locality is disallowed");
        this.location = notNull(location, "null in location is disallowed");
        this.street = notNull(street, "null in street is disallowed");
    }

    protected Place() {
    }

    public Long getPlaceId() {
        return placeId;
    }

    public Locality getLocality() {
        return locality;
    }

    public Location getLocation() {
        return location;
    }

    public Street getStreet() {
        return street;
    }

    public String placeAlreadyExists() {
        String concatString = locality.getValue()
            .concat(location.getValue().concat(street.getValue()));
        return concatString;
    }
}
