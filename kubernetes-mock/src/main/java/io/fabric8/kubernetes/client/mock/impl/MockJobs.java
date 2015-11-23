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
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableJob;
import org.easymock.EasyMock;

public class MockJobs<C extends Client>  extends BaseMockOperation<Job, JobList, DoneableJob, MockDoneableJob,
        ClientResource<Job, DoneableJob>,
        MockResource<Job, MockDoneableJob, Boolean>>
  implements MockResource<Job, MockDoneableJob, Boolean> {

  //Dummy interface to use for mocking.
  private interface JobDelegate
    extends ClientMixedOperation<Job, JobList, DoneableJob, ClientRollableScallableResource<Job, DoneableJob>>,
    ClientResource<Job, DoneableJob> {

  }

  public MockJobs() {
    super(EasyMock.createMock(JobDelegate.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockJobs();
  }
}
