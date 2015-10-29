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
package io.fabric8.openshift.client.dsl.internal;

import com.squareup.okhttp.Request;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.internal.OperationSupport;
import io.fabric8.openshift.api.model.DoneableProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.dsl.ClientProjectRequestOperation;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class ProjectRequestsOperationImpl extends OperationSupport<OpenShiftClient> implements ClientProjectRequestOperation {

    private final ProjectRequest item;

    public ProjectRequestsOperationImpl(OpenShiftClient client) {
        this(client, null);
    }

    public ProjectRequestsOperationImpl(OpenShiftClient client, ProjectRequest item) {
        super(client, "projectrequests", null, null);
        this.item = item;
    }

    @Override
    public boolean isNamespaceRequired() {
        return false;
    }

    @Override
    public URL getRootUrl() {
        return getClient().getOpenshiftUrl();
    }


    @Override
    public ProjectRequest create(ProjectRequest... resources) {
        try {
            if (resources.length > 1) {
                throw new IllegalArgumentException("Too many items to create.");
            } else if (resources.length == 1) {
                return handleCreate(resources[0], ProjectRequest.class);
            } else if (getItem() == null) {
                throw new IllegalArgumentException("Nothing to create.");
            } else {
                return handleCreate(getItem(), ProjectRequest.class);
            }
        } catch (InterruptedException | ExecutionException | IOException e) {
            throw KubernetesClientException.launderThrowable(e);
        }
    }

    @Override
    public DoneableProjectRequest createNew() {
        final Visitor<ProjectRequest> visitor = new Visitor<ProjectRequest>() {
            @Override
            public void visit(ProjectRequest resource) {
                try {
                    create(resource);
                } catch (Exception e) {
                    throw KubernetesClientException.launderThrowable(e);
                }
            }
        };
        return new DoneableProjectRequest(visitor);
    }

    @Override
    public Status list() {
        try {
            URL requestUrl = getNamespacedUrl();
            Request.Builder requestBuilder = new Request.Builder().get().url(requestUrl);
            return handleResponse(requestBuilder, 200, Status.class);
        } catch (InterruptedException | ExecutionException | IOException e) {
            throw KubernetesClientException.launderThrowable(e);
        }
    }

    public ProjectRequest getItem() {
        return item;
    }
}
