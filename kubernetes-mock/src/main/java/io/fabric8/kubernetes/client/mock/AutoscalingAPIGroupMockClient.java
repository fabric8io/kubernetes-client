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


import io.fabric8.kubernetes.api.model.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.mock.impl.MockHorizontalPodAutoscaler;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableHorizontalPodAutoscaler;
import org.easymock.EasyMock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class AutoscalingAPIGroupMockClient implements Replayable<AutoscalingAPIGroupDSL>, Verifiable {

    private final AutoscalingAPIGroupDSL client = createMock(AutoscalingAPIGroupDSL.class);

    private MockHorizontalPodAutoscaler horizontalPodAutoscalers = new MockHorizontalPodAutoscaler();

    public AutoscalingAPIGroupMockClient() {
        expect(client.horizontalPodAutoscalers()).andReturn(horizontalPodAutoscalers.getDelegate()).anyTimes();
        client.close();
        EasyMock.expectLastCall().anyTimes();
    }

    public AutoscalingAPIGroupDSL replay() {
        horizontalPodAutoscalers.replay();
        EasyMock.replay(client);
        return client;
    }

    @Override
    public void verify() {
        horizontalPodAutoscalers.verify();
        EasyMock.verify(client);
    }

    public MockOperation<HorizontalPodAutoscaler, HorizontalPodAutoscalerList, MockDoneableHorizontalPodAutoscaler, MockResource<HorizontalPodAutoscaler, MockDoneableHorizontalPodAutoscaler, Boolean>> horizontalPodAutoscalers() {
        return horizontalPodAutoscalers;
    }

    public AutoscalingAPIGroupDSL getDelegate() {
        return client;
    }
}
