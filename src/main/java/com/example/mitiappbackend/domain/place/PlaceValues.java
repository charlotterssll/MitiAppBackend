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

public class PlaceValues {

    private Locality locality;

    private Location location;

    private Street street;

    public PlaceValues(Place place) {
        this.locality = place.getLocality();
        this.location = place.getLocation();
        this.street = place.getStreet();
    }

    protected PlaceValues() {
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
}
