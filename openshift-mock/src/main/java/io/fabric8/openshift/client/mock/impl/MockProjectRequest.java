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

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.Listable;
import io.fabric8.kubernetes.client.mock.Mockable;
import io.fabric8.openshift.api.model.DoneableProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.client.dsl.ClientProjectRequestOperation;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableProjectRequest;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.easymock.EasyMock.expect;

public class MockProjectRequest implements
        Createable<ProjectRequest, IExpectationSetters<ProjectRequest>, MockDoneableProjectRequest>,
        Listable<IExpectationSetters<Status>>,
        Mockable {

    private interface Delegate extends ClientProjectRequestOperation, Doneable<ProjectRequest>{}

    private final Set<Mockable> nested = new LinkedHashSet<>();
    private final Delegate delegate;

    public MockProjectRequest() {
        this.delegate = EasyMock.createMock(Delegate.class);
    }

    public Delegate getDelegate() {
        return delegate;
    }

    @Override
    public IExpectationSetters<ProjectRequest> create(ProjectRequest... item) {
        return expect(delegate.create(item));
    }

    @Override
    public MockDoneableProjectRequest createNew() {
        MockDoneableProjectRequest mock = new MockDoneableProjectRequest();
        try {
            expect(delegate.createNew()).andReturn((DoneableProjectRequest) mock.getDelegate()).once();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
        nested.add(mock);
        return mock;
    }

    @Override
    public IExpectationSetters<Status> list() {
        return expect(delegate.list());
    }

    public Void replay() {
        for (Mockable mockable : nested) {
            mockable.replay();
        }
        EasyMock.replay(delegate);
        return null;
    }

    public void verify() {
        for (Mockable mockable : nested) {
            mockable.verify();
        }

        EasyMock.verify(delegate);
    }
}
