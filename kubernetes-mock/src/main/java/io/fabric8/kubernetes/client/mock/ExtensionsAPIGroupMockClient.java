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

import io.fabric8.kubernetes.api.model.extensions.DaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DaemonSetList;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.extensions.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.extensions.IngressList;
import io.fabric8.kubernetes.api.model.extensions.Job;
import io.fabric8.kubernetes.api.model.extensions.JobList;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResource;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResourceList;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.mock.impl.MockDaemonSet;
import io.fabric8.kubernetes.client.mock.impl.MockDeployment;
import io.fabric8.kubernetes.client.mock.impl.MockHorizontalPodAutoscaler;
import io.fabric8.kubernetes.client.mock.impl.MockIngress;
import io.fabric8.kubernetes.client.mock.impl.MockJob;
import io.fabric8.kubernetes.client.mock.impl.MockReplicaSet;
import io.fabric8.kubernetes.client.mock.impl.MockThirdPartyResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableDaemonSet;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableDeployment;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableHorizontalPodAutoscaler;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableIngress;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableJob;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableReplicaSet;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableThirdPartyResource;
import org.easymock.EasyMock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class ExtensionsAPIGroupMockClient implements Replayable<ExtensionsAPIGroupDSL>, Verifiable {

    private final ExtensionsAPIGroupDSL client = createMock(ExtensionsAPIGroupDSL.class);

    private MockJob jobs = new MockJob();
    private MockDeployment deployments = new MockDeployment();
    private MockIngress ingresses = new MockIngress();
    private MockDaemonSet daemonSets = new MockDaemonSet();
    private MockThirdPartyResource thirdPartyResources = new MockThirdPartyResource();
    private MockReplicaSet replicaSets = new MockReplicaSet();
    private MockHorizontalPodAutoscaler horizontalPodAutoscalers = new MockHorizontalPodAutoscaler();

    public ExtensionsAPIGroupMockClient() {
        expect(client.jobs()).andReturn(jobs.getDelegate()).anyTimes();
        expect(client.deployments()).andReturn(deployments.getDelegate()).anyTimes();
        expect(client.ingress()).andReturn(ingresses.getDelegate()).anyTimes();
        expect(client.ingresses()).andReturn(ingresses.getDelegate()).anyTimes();
        expect(client.daemonSets()).andReturn(daemonSets.getDelegate()).anyTimes();
        expect(client.thirdPartyResources()).andReturn(thirdPartyResources.getDelegate()).anyTimes();
        expect(client.replicaSets()).andReturn(replicaSets.getDelegate()).anyTimes();
        expect(client.horizontalPodAutoscalers()).andReturn(horizontalPodAutoscalers.getDelegate()).anyTimes();
        client.close();
        EasyMock.expectLastCall().anyTimes();
    }

    public ExtensionsAPIGroupDSL replay() {
        jobs.replay();
        deployments.replay();
        ingresses.replay();
        daemonSets.replay();
        thirdPartyResources.replay();
        replicaSets.replay();
        horizontalPodAutoscalers.replay();
        EasyMock.replay(client);
        return client;
    }

    @Override
    public void verify() {
        jobs.verify();
        deployments.verify();
        ingresses.verify();
        daemonSets.verify();
        thirdPartyResources.verify();
        replicaSets.verify();
        horizontalPodAutoscalers.verify();
        EasyMock.verify(client);
    }

    public MockOperation<Job, JobList, MockDoneableJob, MockScaleableResource<Job, MockDoneableJob, Boolean>> jobs() {
        return jobs;
    }

    public MockOperation<Deployment, DeploymentList, MockDoneableDeployment, MockScaleableResource<Deployment, MockDoneableDeployment, Boolean>> deployments() {
        return deployments;
    }

    @Deprecated
    public MockOperation<Ingress, IngressList, MockDoneableIngress, MockResource<Ingress, MockDoneableIngress, Boolean>> ingress() {
        return ingresses;
    }

    public MockOperation<Ingress, IngressList, MockDoneableIngress, MockResource<Ingress, MockDoneableIngress, Boolean>> ingresses() {
        return ingresses;
    }

    public MockOperation<DaemonSet, DaemonSetList, MockDoneableDaemonSet, MockResource<DaemonSet, MockDoneableDaemonSet, Boolean>> daemonSets() {
        return daemonSets;
    }

    public MockOperation<ThirdPartyResource, ThirdPartyResourceList, MockDoneableThirdPartyResource, MockResource<ThirdPartyResource, MockDoneableThirdPartyResource, Boolean>> thirdPartyResources() {
        return thirdPartyResources;
    }

    public MockOperation<ReplicaSet, ReplicaSetList, MockDoneableReplicaSet, MockRollableScaleableResource<ReplicaSet, MockDoneableReplicaSet, Boolean>> replicaSets() {
        return replicaSets;
    }

    public MockOperation<HorizontalPodAutoscaler, HorizontalPodAutoscalerList, MockDoneableHorizontalPodAutoscaler, MockResource<HorizontalPodAutoscaler, MockDoneableHorizontalPodAutoscaler, Boolean>> horizontalPodAutoscalers() {
        return horizontalPodAutoscalers;
    }

    public ExtensionsAPIGroupDSL getDelegate() {
        return client;
    }
}
