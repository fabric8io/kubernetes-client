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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.Job;
import io.fabric8.kubernetes.api.model.extensions.JobList;
import io.fabric8.kubernetes.client.ExtensionsAPIGroupClient;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.mock.impl.MockDeployment;
import io.fabric8.kubernetes.client.mock.impl.MockJobs;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableDeployment;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableJob;
import org.easymock.EasyMock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class ExtensionsAPIGroupMockClient implements Replayable<ExtensionsAPIGroupDSL>, Verifiable {

    private final ExtensionsAPIGroupDSL client = createMock(ExtensionsAPIGroupDSL.class);

    private MockJobs jobs = new MockJobs();
    private MockDeployment deployments = new MockDeployment();

    public ExtensionsAPIGroupMockClient() {
        expect(client.jobs()).andReturn(jobs.getDelegate()).anyTimes();
        expect(client.deployments()).andReturn(deployments.getDelegate()).anyTimes();
        client.close();
        EasyMock.expectLastCall().anyTimes();
    }

    public ExtensionsAPIGroupDSL replay() {
        jobs.replay();
        deployments.replay();
        EasyMock.replay(client);
        return client;
    }

    @Override
    public void verify() {
        jobs.verify();
        deployments.verify();
        EasyMock.verify(client);
    }

    public MockOperation<Job, JobList, MockDoneableJob, MockResource<Job, MockDoneableJob, Boolean>> jobs() {
        return jobs;
    }

    public MockOperation<Deployment, DeploymentList, MockDoneableDeployment, MockResource<Deployment, MockDoneableDeployment, Boolean>> deployments() {
        return jobs;
    }

    public ExtensionsAPIGroupDSL getDelegate() {
        return client;
    }
}
