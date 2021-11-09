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
package io.fabric8.volumesnapshot.server.mock;

import io.fabric8.kubernetes.client.server.mock.KubernetesMixedDispatcher;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.dsl.MockServerExpectation;
import io.fabric8.volumesnapshot.client.VolumeSnapshotClient;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.rules.ExternalResource;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class VolumeSnapshotServer extends ExternalResource {

  protected VolumeSnapshotMockServer mock;
  private VolumeSnapshotClient client;

  private final boolean https;
  private final boolean crudMode;

  public VolumeSnapshotServer() {
    this(true, false);
  }

  public VolumeSnapshotServer(boolean https) {
    this(https, false);
  }

  public VolumeSnapshotServer(boolean https, boolean crudMode) {
    this.https = https;
    this.crudMode = crudMode;
  }

  @Override
  public void before() {
    final Map<ServerRequest, Queue<ServerResponse>> responses = new HashMap<>();
    mock = crudMode
      ? new VolumeSnapshotMockServer(new Context(), new MockWebServer(), responses, new KubernetesMixedDispatcher(responses), true)
      : new VolumeSnapshotMockServer(https);
    mock.init();
    client = mock.createVolumeSnapshot();
  }

  @Override
  public void after() {
    mock.destroy();
    client.close();
  }

  public VolumeSnapshotClient get() {
    return client;
  }

  public MockServerExpectation expect() {
    return mock.expect();
  }
}
