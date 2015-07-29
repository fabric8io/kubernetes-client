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

package io.fabric8.kubernetes.client.mock.impl;

import io.fabric8.kubernetes.client.dsl.BuildConfigResource;
import io.fabric8.kubernetes.client.dsl.Instantiateable;
import io.fabric8.kubernetes.client.dsl.Secretable;
import io.fabric8.kubernetes.client.dsl.Triggerable;
import io.fabric8.kubernetes.client.dsl.Typeable;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockBuildConfigResource;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.WebHookTrigger;
import org.easymock.IExpectationSetters;

import java.util.Map;

import static org.easymock.EasyMock.*;

public class MockBuildConfig extends BaseMockOperation<BuildConfig, BuildConfigList, DoneableBuildConfig,
  BuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Boolean, Void, Void>,
  MockBuildConfigResource>
  implements MockBuildConfigResource {

  private final String secret;
  private final String type;

  public MockBuildConfig() {
    this(null, null, null, null);
  }

  public MockBuildConfig(String name, String namespace, String secret, String type) {
    super(name, namespace);
    this.secret = secret;
    this.type = type;
  }

  public MockBuildConfig(String name, String namespace, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, String secret, String type) {
    super(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    this.secret = secret;
    this.type = type;
  }

  @Override
  public IExpectationSetters<Void> instantiate(BuildRequest request) {
    return expect(((Instantiateable<BuildRequest, Void>)getDelegate()).instantiate(request));
  }

  @Override
  public Typeable<Triggerable<WebHookTrigger, Void>> withSecret(String secret) {
    MockBuildConfig op = new MockBuildConfig(getName(), getNamespace(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, type);
    expect(((Secretable)getDelegate()).withSecret(secret)).andReturn((Typeable) op.getDelegate()).once();
    getNested().add(op);
    return op;
  }

  @Override
  public Void trigger(WebHookTrigger trigger) {
    return null;
  }

  @Override
  public Triggerable<WebHookTrigger, Void> withType(String type) {
    MockBuildConfig op = new MockBuildConfig(getName(), getNamespace(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, type);
    expect(((Typeable)getDelegate()).withType(type)).andReturn((Typeable) op.getDelegate()).once();
    getNested().add(op);
    return op;
  }
}
