/*
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

import io.fabric8.mockwebserver.crud.Attribute
import io.fabric8.mockwebserver.crud.AttributeExtractor
import io.fabric8.mockwebserver.crud.AttributeSet
import tools.jackson.databind.json.JsonMapper

class UserAttributeExtractor implements AttributeExtractor {

	static def mapper = new JsonMapper()

	@Override
	AttributeSet fromPath(String path) {
		if (path.trim().isBlank() || path.trim() == "/") {
			return new AttributeSet();
		}
		return new AttributeSet(new Attribute("id", path.substring(1)))
	}

	@Override
	AttributeSet fromResource(String resource) {
		def user = mapper.readValue(resource, User)
		return new AttributeSet(new Attribute("id", user.getId().toString()))
	}
}
