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

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notBlank;

import javax.persistence.Embeddable;

import com.example.mitiappbackend.infrastructure.AbstractSimpleValueObject;

@Embeddable
public class Time extends AbstractSimpleValueObject<String> {

    public Time(String time) {
        super(time);
    }

    protected Time() {
    }

    @Override
    protected String validateAndNormalize(String time) {
        isTrue(time.matches("^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$"),
            "Time must only contain numbers in 24h time format,"
            + " if its a single digit number please add a leading zero, minutes 00-59, hours 00-23");
        return notBlank(time);
    }
}
