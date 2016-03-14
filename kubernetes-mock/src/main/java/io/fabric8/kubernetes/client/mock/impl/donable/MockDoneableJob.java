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

package io.fabric8.kubernetes.client.mock.impl.donable;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.extensions.DoneableJob;
import io.fabric8.kubernetes.api.model.extensions.Job;
import io.fabric8.kubernetes.api.model.extensions.JobBuilder;
import io.fabric8.kubernetes.api.model.extensions.JobFluent;
import io.fabric8.kubernetes.api.model.extensions.JobFluentImpl;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableJob extends JobFluentImpl<MockDoneableJob> implements MockDoneable<Job> {

  private interface DelegateInterface extends Doneable<Job>, JobFluent<DoneableJob> {}
  private final Function<Job, Job> visitor = new Function<Job, Job>() {
    @Override
    public Job apply(Job item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableJob() {
    super(new JobBuilder()
      .withNewMetadata().endMetadata()
      .withNewSpec().endSpec()
      .withNewStatus().endStatus()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface .class);
  }

  @Override
  public IExpectationSetters<Job> done() {
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
  public Doneable<Job> getDelegate() {
    return new DoneableJob(new JobBuilder(this).build(), visitor) {
      @Override
      public Job done() {
        return delegate.done();
      }
    };
  }
}
