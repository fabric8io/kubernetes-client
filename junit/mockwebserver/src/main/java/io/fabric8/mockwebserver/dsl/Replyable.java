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

package io.fabric8.mockwebserver.dsl;

import io.fabric8.mockwebserver.utils.BodyProvider;
import io.fabric8.mockwebserver.utils.ResponseProvider;

import java.util.List;

public interface Replyable<T> {

  T andReply(int statusCode, BodyProvider<Object> contentSupplier);

  T andReply(ResponseProvider<Object> contentSupplier);

  T andReplyChunked(int statusCode, BodyProvider<List<Object>> content);

  T andReplyChunked(ResponseProvider<List<Object>> content);

}
