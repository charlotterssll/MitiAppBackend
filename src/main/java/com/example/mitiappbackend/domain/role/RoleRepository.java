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
package com.example.mitiappbackend.domain.role;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void createRole(Role role) {
        entityManager.persist(role);
    }

    @Transactional
    public List<Role> readRole() {
        return entityManager.createNamedQuery(Role.READ_ALL, Role.class).getResultList();
    }

    @Transactional
    public Role readRoleByRolename(Erole roleName) {
        return entityManager.find(Role.class, roleName);
    }
}
