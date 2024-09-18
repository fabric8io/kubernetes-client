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
package io.fabric8.mockwebserver.utils;

import okhttp3.Headers;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;

/**
 * A class that allows returning a response given a certain request.
 */
public interface ResponseProvider<T> extends BodyProvider<T> {

  int getStatusCode(RecordedRequest request);

  Headers getHeaders();

  void setHeaders(Headers headers);

  default SocketPolicy getSocketPolicy(RecordedRequest request) {
    return SocketPolicy.KEEP_OPEN;
  }

}
