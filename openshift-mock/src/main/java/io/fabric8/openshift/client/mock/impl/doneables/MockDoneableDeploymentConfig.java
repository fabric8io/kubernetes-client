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

package io.fabric8.openshift.client.mock.impl.doneables;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigFluent;
import io.fabric8.openshift.api.model.DeploymentConfigFluentImpl;
import io.fabric8.openshift.api.model.DoneableDeploymentConfig;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableDeploymentConfig extends DeploymentConfigFluentImpl<MockDoneableDeploymentConfig> implements MockDoneable<DeploymentConfig> {

  private interface DelegateInterface extends Doneable<DeploymentConfig>, DeploymentConfigFluent<DoneableDeploymentConfig> {}
  private final Function<DeploymentConfig, DeploymentConfig> visitor = new Function<DeploymentConfig, DeploymentConfig>() {
    @Override
    public DeploymentConfig apply(DeploymentConfig item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableDeploymentConfig() {
    super(new DeploymentConfigBuilder()
      .withNewMetadata().endMetadata()
      .withNewSpec().endSpec()
      .withNewStatus().endStatus()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface.class);
  }

  @Override
  public IExpectationSetters<DeploymentConfig> done() {
    return EasyMock.expect(delegate.done());
  }

  @Override
  public Void replay() {
    EasyMock.replay(delegate);
    return null;
  }

  @Override
  public void verify() {
    EasyMock.verify(delegate);
  }

  @Override
  public Doneable<DeploymentConfig> getDelegate() {
    return new DoneableDeploymentConfig(new DeploymentConfigBuilder(this).build(), visitor) {
      @Override
      public DeploymentConfig done() {
        return delegate.done();
      }
    };
  }
}
