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
import io.fabric8.openshift.api.model.DoneableProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.api.model.ProjectRequestFluent;
import io.fabric8.openshift.api.model.ProjectRequestFluentImpl;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableProjectRequest extends ProjectRequestFluentImpl<MockDoneableProjectRequest> implements MockDoneable<ProjectRequest> {

    private interface DelegateInterface extends Doneable<ProjectRequest>, ProjectRequestFluent<DoneableProjectRequest> {
    }

    private final Function<ProjectRequest, ProjectRequest> visitor = new Function<ProjectRequest, ProjectRequest>() {
        @Override
        public ProjectRequest apply(ProjectRequest item) {return item;}
    };

    private final DelegateInterface delegate;

    public MockDoneableProjectRequest() {
        super(new ProjectRequestBuilder()
                .withNewMetadata().endMetadata()
                .build());
        this.delegate = EasyMock.createMock(DelegateInterface.class);
    }

    @Override
    public IExpectationSetters<ProjectRequest> done() {
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
    public Doneable<ProjectRequest> getDelegate() {
        return new DoneableProjectRequest(new ProjectRequestBuilder(this).build(), visitor) {
            @Override
            public ProjectRequest done() {
                return delegate.done();
            }
        };
    }
}
