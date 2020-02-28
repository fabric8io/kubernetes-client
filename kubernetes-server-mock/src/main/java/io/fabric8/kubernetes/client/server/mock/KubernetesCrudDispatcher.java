/**
 * Copyright (C) 2015 Fabric8 Authors.
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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.crud.AttributeExtractor;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.mockwebserver.crud.CrudDispatcher;
import io.fabric8.mockwebserver.crud.ResponseComposer;
import okhttp3.mockwebserver.MockResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KubernetesCrudDispatcher extends CrudDispatcher {

  private static final Logger LOGGER = LoggerFactory.getLogger(KubernetesCrudDispatcher.class);

  public KubernetesCrudDispatcher() {
    this(new KubernetesAttributesExtractor(), new KubernetesResponseComposer());
  }

  public KubernetesCrudDispatcher(AttributeExtractor attributeExtractor, ResponseComposer responseComposer) {
    super(new Context(Serialization.jsonMapper()), attributeExtractor, responseComposer);
  }


  /**
   * Performs a get for the corresponding object from the in-memory db.
   *
   * @param path The path.
   * @return The {@link MockResponse}
   */
  public MockResponse handleGet(String path) {
    MockResponse response = new MockResponse();
    List<String> items = new ArrayList<>();
    AttributeSet query = attributeExtractor.extract(path);

    for (Map.Entry<AttributeSet, String> entry : map.entrySet()) {
      if (entry.getKey().matches(query)) {
        LOGGER.debug("Entry found for query {} : {}", query, entry);
        items.add(entry.getValue());
      }
    }

    if (query.containsKey(KubernetesAttributesExtractor.NAME)) {
      if (!items.isEmpty()) {
        response.setBody(items.get(0));
        response.setResponseCode(200);
      } else {
        response.setResponseCode(404);
      }
    } else {
      response.setBody(responseComposer.compose(items));
      response.setResponseCode(200);
    }
    return response;
  }

}
