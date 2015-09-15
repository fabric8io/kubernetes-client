/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;

import java.io.IOException;

/**
 */
public class HttpUtils {
    /**
     * Checks if the response status code is the expected and throws the appropriate KubernetesClientException if not.
     * @param r                           The {@link com.ning.http.client.Response} object.
     * @param expectedStatusCode          The expected status code.
     * @throws KubernetesClientException  When the response code is not the expected.
     */
    public static void assertResponseCode(Response r, int expectedStatusCode, KubernetesClient client, ObjectMapper mapper) {
      int statusCode = r.getStatusCode();
      String customMessage = client.getConfiguration().getErrorMessages().get(statusCode);

      if (statusCode == expectedStatusCode) {
        return;
      } else if (customMessage != null) {
        throw new KubernetesClientException("Error accessing: " + r.getUri().toString() + ",due to:" + customMessage);
      } else {
        try {
          Status status = mapper.readerFor(Status.class).readValue(r.getResponseBodyAsStream());
          throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
        } catch (IOException e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    }
}
