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
package com.example.mitiappbackend.apitest;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

//TODO
//change ID to UUID for persistent db testing
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@SpringBootTest
public class UpdateMitiApiTest {

    @Autowired
    private MockMvc mvc;

    @DisplayName("Employee wants to update all information on an existing lunch table")
    @Test
    void testUpdateMitiValueObjectsAll() throws Exception {

        String jsonBody =
            """
                {
                   "place":
                       {
                           "locality":"Metzger",
                           "location":"Hannover"
                       },
                   "employee":
                       {
                           "firstName":"Karl",
                           "lastName":"Heinz"
                       },
                   "time":"12:00"
                },
            """;

        String jsonBodySecond =
            """
                {
                   "place":
                       {
                            "locality":"Immergrün",
                            "location":"Oldenburg"
                        },
                    "employee":
                        {
                            "firstName":"Hannelore",
                            "lastName":"Kranz"
                        },
                    "time":"14:30"
                },
            """;

        mvc.perform(post("/miti")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(put("/miti/{mitiId}", 1)
                .content(jsonBodySecond)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get("/miti")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].place.locality.value", is("Immergrün")))
                .andExpect(jsonPath("$.[0].place.location.value", is("Oldenburg")))
                .andExpect(jsonPath("$.[0].employee.firstName.value", is("Hannelore")))
                .andExpect(jsonPath("$.[0].employee.lastName.value", is("Kranz")))
                .andExpect(jsonPath("$.[0].time.value", is("14:30")));
    }

    @DisplayName("Employee wants to update the locality on an existing lunch table")
    @Test
    void testUpdateMitiValueObjectLocality() throws Exception {

        String jsonBody =
            """
                {
                   "place":
                       {
                           "locality":"Metzger",
                           "location":"Hannover"
                       },
                   "employee":
                       {
                           "firstName":"Karl",
                           "lastName":"Heinz"
                       },
                   "time":"12:00"
                },
            """;

        String jsonBodySecond =
            """
                {
                   "place":
                       {
                            "locality":"Immergrün",
                            "location":"Hannover"
                        },
                    "employee":
                        {
                            "firstName":"Karl",
                            "lastName":"Heinz"
                        },
                    "time":"12:00"
                },
            """;

        mvc.perform(post("/miti")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(put("/miti/{mitiId}", 1)
                        .content(jsonBodySecond)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get("/miti")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].place.locality.value", is("Immergrün")))
                .andExpect(jsonPath("$.[0].place.location.value", is("Hannover")))
                .andExpect(jsonPath("$.[0].employee.firstName.value", is("Karl")))
                .andExpect(jsonPath("$.[0].employee.lastName.value", is("Heinz")))
                .andExpect(jsonPath("$.[0].time.value", is("12:00")));
    }

    @DisplayName("Employee wants to update the location on an existing lunch table")
    @Test
    void testUpdateMitiValueObjectLocation() throws Exception {

        String jsonBody =
            """
                {
                   "place":
                       {
                           "locality":"Metzger",
                           "location":"Hannover"
                       },
                   "employee":
                       {
                           "firstName":"Karl",
                           "lastName":"Heinz"
                       },
                   "time":"12:00"
                },
            """;

        String jsonBodySecond =
            """
                {
                   "place":
                       {
                            "locality":"Metzger",
                            "location":"Oldenburg"
                        },
                    "employee":
                        {
                            "firstName":"Karl",
                            "lastName":"Heinz"
                        },
                    "time":"12:00"
                },
            """;

        mvc.perform(post("/miti")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(put("/miti/{mitiId}", 1)
                        .content(jsonBodySecond)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get("/miti")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].place.locality.value", is("Metzger")))
                .andExpect(jsonPath("$.[0].place.location.value", is("Oldenburg")))
                .andExpect(jsonPath("$.[0].employee.firstName.value", is("Karl")))
                .andExpect(jsonPath("$.[0].employee.lastName.value", is("Heinz")))
                .andExpect(jsonPath("$.[0].time.value", is("12:00")));
    }

    @DisplayName("Employee wants to update thier first name on an existing lunch table")
    @Test
    void testUpdateMitiValueObjectFirstName() throws Exception {

        String jsonBody =
            """
                {
                   "place":
                       {
                           "locality":"Metzger",
                           "location":"Hannover"
                       },
                   "employee":
                       {
                           "firstName":"Karl",
                           "lastName":"Heinz"
                       },
                   "time":"12:00"
                },
            """;

        String jsonBodySecond =
            """
                {
                   "place":
                       {
                           "locality":"Metzger",
                           "location":"Hannover"
                       },
                   "employee":
                       {
                           "firstName":"Hannelore",
                           "lastName":"Heinz"
                       },
                   "time":"12:00"
                },
            """;

        mvc.perform(post("/miti")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(put("/miti/{mitiId}", 1)
                        .content(jsonBodySecond)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get("/miti")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].place.locality.value", is("Metzger")))
                .andExpect(jsonPath("$.[0].place.location.value", is("Hannover")))
                .andExpect(jsonPath("$.[0].employee.firstName.value", is("Hannelore")))
                .andExpect(jsonPath("$.[0].employee.lastName.value", is("Heinz")))
                .andExpect(jsonPath("$.[0].time.value", is("12:00")));
    }

    @DisplayName("Employee wants to update their last name on an existing lunch table")
    @Test
    void testUpdateMitiValueObjectLastName() throws Exception {

        String jsonBody =
            """
                {
                   "place":
                       {
                           "locality":"Metzger",
                           "location":"Hannover"
                       },
                   "employee":
                       {
                           "firstName":"Karl",
                           "lastName":"Heinz"
                       },
                   "time":"12:00"
                },
            """;

        String jsonBodySecond =
            """
                {
                   "place":
                       {
                            "locality":"Metzger",
                            "location":"Hannover"
                        },
                    "employee":
                        {
                            "firstName":"Karl",
                            "lastName":"Kranz"
                        },
                    "time":"12:00"
                },
            """;

        mvc.perform(post("/miti")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(put("/miti/{mitiId}", 1)
                        .content(jsonBodySecond)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get("/miti")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].place.locality.value", is("Metzger")))
                .andExpect(jsonPath("$.[0].place.location.value", is("Hannover")))
                .andExpect(jsonPath("$.[0].employee.firstName.value", is("Karl")))
                .andExpect(jsonPath("$.[0].employee.lastName.value", is("Kranz")))
                .andExpect(jsonPath("$.[0].time.value", is("12:00")));
    }

    @DisplayName("Employee wants to update the time on an existing lunch table")
    @Test
    void testUpdateMitiValueObjectTime() throws Exception {

        String jsonBody =
            """
                {
                   "place":
                       {
                           "locality":"Metzger",
                           "location":"Hannover"
                       },
                   "employee":
                       {
                           "firstName":"Karl",
                           "lastName":"Heinz"
                       },
                   "time":"12:00"
                },
            """;

        String jsonBodySecond =
            """
                {
                   "place":
                       {
                            "locality":"Metzger",
                            "location":"Hannover"
                        },
                    "employee":
                        {
                            "firstName":"Karl",
                            "lastName":"Heinz"
                        },
                    "time":"14:30"
                },
            """;

        mvc.perform(post("/miti")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(put("/miti/{mitiId}", 1)
                        .content(jsonBodySecond)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get("/miti")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].place.locality.value", is("Metzger")))
                .andExpect(jsonPath("$.[0].place.location.value", is("Hannover")))
                .andExpect(jsonPath("$.[0].employee.firstName.value", is("Karl")))
                .andExpect(jsonPath("$.[0].employee.lastName.value", is("Heinz")))
                .andExpect(jsonPath("$.[0].time.value", is("14:30")));
    }
}