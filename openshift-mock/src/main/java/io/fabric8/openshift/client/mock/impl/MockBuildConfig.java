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

package io.fabric8.openshift.client.mock.impl;

import io.fabric8.kubernetes.client.dsl.Instantiateable;
import io.fabric8.kubernetes.client.dsl.Secretable;
import io.fabric8.kubernetes.client.dsl.Triggerable;
import io.fabric8.kubernetes.client.dsl.Typeable;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.WebHookTrigger;
import io.fabric8.openshift.client.dsl.BuildConfigOperation;
import io.fabric8.openshift.client.dsl.ClientBuildConfigResource;
import io.fabric8.openshift.client.mock.MockBuildConfigResource;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableBuildConfig;
import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.easymock.IExpectationSetters;

import java.util.HashMap;
import java.util.Map;

import static io.fabric8.kubernetes.client.mock.util.MockUtils.getArgument;
import static org.easymock.EasyMock.expect;


public class MockBuildConfig extends BaseMockOperation<BuildConfig, BuildConfigList, DoneableBuildConfig,
  MockDoneableBuildConfig, ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Void>,
  MockBuildConfigResource>
  implements MockBuildConfigResource {

  private Map<IArgumentMatcher, MockBuildConfig> secretMap = new HashMap<>();
  private Map<IArgumentMatcher, MockBuildConfig> typeMap = new HashMap<>();


  public MockBuildConfig() {
    super(EasyMock.createMock(BuildConfigOperation.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockBuildConfig();
  }

  @Override
  public IExpectationSetters<Void> instantiate(BuildRequest request) {
    return expect(((Instantiateable<BuildRequest, Void>) getDelegate()).instantiate(request));
  }

  @Override
  public Typeable<Triggerable<WebHookTrigger, IExpectationSetters<Void>>> withSecret(String secret) {
    IArgumentMatcher matcher = getArgument(secret);
    MockBuildConfig op = secretMap.get(matcher);
    if (op == null) {
      op = new MockBuildConfig();
      expect(((Secretable) getDelegate()).withSecret(secret)).andReturn((Typeable) op.getDelegate()).anyTimes();
      getNested().add(op);
      secretMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public IExpectationSetters<Void> trigger(WebHookTrigger trigger) {
    return expect(((Triggerable<WebHookTrigger, Void>) getDelegate()).trigger(trigger));
  }

  @Override
  public Triggerable<WebHookTrigger, IExpectationSetters<Void>> withType(String type) {
    IArgumentMatcher matcher = getArgument(type);
    MockBuildConfig op = typeMap.get(matcher);
    if (op == null) {
      op = new MockBuildConfig();
      expect(((Typeable) getDelegate()).withType(type)).andReturn(op.getDelegate()).anyTimes();
      getNested().add(op);
      typeMap.put(matcher, op);
    }
    return op;
  }
}
