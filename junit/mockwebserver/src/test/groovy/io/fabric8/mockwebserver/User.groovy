/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.mockwebserver

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class User {

    @JsonProperty("id")
    private Long id

    @JsonProperty("username")
    private String username

    @JsonProperty("enabled")
    private Boolean enabled

    private User() {
    }

    public User(Long id, String username, Boolean enabled) {
        this.id = id
        this.username = username
        this.enabled = enabled
    }

    public Long getId() {
        return id
    }

    public void setId(Long id) {
        this.id = id
    }

    public String getUsername() {
        return username
    }

    public void setUsername(String username) {
        this.username = username
    }

    public Boolean getEnabled() {
        return enabled
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true
        if (o == null || getClass() != o.getClass()) return false

        User user = (User) o

        if (id != null ? !id.equals(user.id) : user.id != null) return false
        if (username != null ? !username.equals(user.username) : user.username != null) return false
        return enabled != null ? enabled.equals(user.enabled) : user.enabled == null

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0
        result = 31 * result + (username != null ? username.hashCode() : 0)
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0)
        return result
    }
}
