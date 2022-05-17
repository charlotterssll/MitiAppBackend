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
package com.example.mitiappbackend.dbtest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.mitiappbackend.domain.employee.Employee;
import com.example.mitiappbackend.domain.employee.FirstName;
import com.example.mitiappbackend.domain.employee.LastName;
import com.example.mitiappbackend.domain.miti.Miti;
import com.example.mitiappbackend.domain.miti.Time;
import com.example.mitiappbackend.domain.place.Locality;
import com.example.mitiappbackend.domain.place.Location;
import com.example.mitiappbackend.domain.place.Place;
import com.example.mitiappbackend.infrastructuretest.AbstractPersistenceTest;

public class DeleteMitiDbTest extends AbstractPersistenceTest {

    private Miti miti;

    @BeforeEach
    public void beforeDbTestInsertMitiTestDataIntoDb() {
        entityManager.getTransaction().begin();
        miti = new Miti(
            new Place(new Locality("Immergrün"), new Location("Oldenburg")),
            new Employee(new FirstName("Hannelore"), new LastName("Kranz")),
            new Time("14:30"));
        entityManager.persist(miti);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    @DisplayName("Employee wants to delete an existing lunch table")
    @Test
    public void testDbDeleteMiti() {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(miti));
        entityManager.getTransaction().commit();
        entityManager.clear();

        MatcherAssert.assertThat(entityManager.find(Miti.class, miti.getMitiId()), is(nullValue()));
    }
}
