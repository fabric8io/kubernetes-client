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

package io.fabric8.openshift.client.mock;

import io.fabric8.kubernetes.server.mock.MockServerExpectation;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.server.mock.OpenShiftMockServer;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

public class OpenShiftMockServerTestBase {

  private OpenShiftMockServer mock = new OpenShiftMockServer();
  private OpenShiftClient client;

  @Before
  public void setUp() throws IOException {
    mock.init();
    client = mock.createOpenShiftClient();
  }

  @After
  public void tearDown() throws IOException {
    client.close();
    mock.destroy();
  }


  public OpenShiftClient getOpenshiftClient() {
    return client;
  }

  public MockServerExpectation expect() {
    return mock.expect();
  }

  @Deprecated
  public <T> void expectAndReturnAsJson(String path, int code, T body) {
    expect().withPath(path).andReturn(code, body).always();
  }

  @Deprecated
  public void expectAndReturnAsString(String path, int code, String body) {
    expect().withPath(path).andReturn(code, body).always();
  }
}
