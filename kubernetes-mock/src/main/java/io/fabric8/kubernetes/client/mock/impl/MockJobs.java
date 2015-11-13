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

import io.fabric8.kubernetes.api.model.extensions.DoneableJob;
import io.fabric8.kubernetes.api.model.extensions.Job;
import io.fabric8.kubernetes.api.model.extensions.JobList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.ClientLoggableResource;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockLoggableResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableJob;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import static org.easymock.EasyMock.expect;

public class MockJobs<C extends Client>  extends BaseMockOperation<Job, JobList, DoneableJob, MockDoneableJob,
  ClientLoggableResource<Job, DoneableJob>,
  MockLoggableResource<Job, MockDoneableJob, Boolean>>
  implements MockLoggableResource<Job, MockDoneableJob, Boolean> {

  //Dummy interface to use for mocking.
  private interface JobDelegate
    extends ClientMixedOperation<Job, JobList, DoneableJob, ClientRollableScallableResource<Job, DoneableJob>>,
    ClientLoggableResource<Job, DoneableJob> {

  }

  public MockJobs() {
    super(EasyMock.createMock(JobDelegate.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockJobs();
  }

  @Override
  public IExpectationSetters<String> getLog() {
    return expect(((ClientLoggableResource<Job, DoneableJob>) getDelegate()).getLog());
  }

  @Override
  public IExpectationSetters<String> getLog(String id) {
    return expect(((ClientLoggableResource<Job, DoneableJob>) getDelegate()).getLog(id));
  }

  @Override
  public IExpectationSetters<String> getLog(Boolean isPretty) {
    return expect(((ClientLoggableResource<Job, DoneableJob>) getDelegate()).getLog(isPretty));
  }

  @Override
  public IExpectationSetters<String> getLog(String id, Boolean isPretty) {
    return expect(((ClientLoggableResource<Job, DoneableJob>) getDelegate()).getLog(id, isPretty));
  }
}
