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
package com.example.mitiappbackend.domain.miti;

import java.util.List;

import com.example.mitiappbackend.domain.employee.Employee;
import com.example.mitiappbackend.domain.place.Place;

public class MitiValues {

    private Place place;

    private Employee mitiCreator;

    private List<Employee> employee;

    private Time time;

    private Date date;

    public MitiValues(Miti miti) {
        place = miti.getPlace();
        mitiCreator = miti.getMitiCreator();
        employee = miti.getEmployeeParticipants();
        time = miti.getTime();
        date = miti.getDate();
    }

    protected MitiValues() {
    }

    public Place getPlace() {
        return place;
    }

    public Employee getMitiCreator() {
        return mitiCreator;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public Time getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }
}
