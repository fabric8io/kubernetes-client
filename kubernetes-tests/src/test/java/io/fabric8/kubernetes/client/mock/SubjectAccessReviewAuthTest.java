/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.api.model.authorization.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.LocalSubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.ResourceRuleBuilder;
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectRulesReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.SubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.SubjectAccessReviewBuilder;
import io.fabric8.kubernetes.api.model.authorization.SubjectAccessReviewStatus;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
public class SubjectAccessReviewAuthTest {

    @Rule
    public KubernetesServer server = new KubernetesServer();

    @Test
    public void createSubjectRulesReviewTest() {
        KubernetesClient client = server.getClient();

        createSubjectAccessReviewTest();

        SelfSubjectRulesReview selfSubjectRulesReview = new SelfSubjectRulesReviewBuilder()
                .withNewSpec()
                .withNamespace("test")
                .endSpec()
                .withNewStatus()
                .withResourceRules(new ResourceRuleBuilder()
                        .withResourceNames("pod")
                        .withVerbs("create", "list", "get", "delete").build()).endStatus().build();

        SelfSubjectRulesReview rulesReviewResponse = client.subjectAccessReviewAuth().list().create(selfSubjectRulesReview);

        assertNotNull(rulesReviewResponse);
    }

    @Test
    public void createSubjectRulesReviewFromFileTest() {
        KubernetesClient client = server.getClient();

        createSubjectAccessReviewTest();

        SelfSubjectRulesReview reviewFromFile = Serialization.unmarshal(getClass().getResourceAsStream("/test-selfsubjectrulesreview.yml"), SelfSubjectRulesReview.class);

        SelfSubjectRulesReview rulesReviewFromFileResponse = client.subjectAccessReviewAuth().list().create(reviewFromFile);

        assertAll(() -> {
            assertNotNull(reviewFromFile);
            assertNotNull(rulesReviewFromFileResponse);
        });
    }

    @Test
    public void createSubjectAccessReviewTest() {
        KubernetesClient client = server.getClient();

        SubjectAccessReview review = new SubjectAccessReviewBuilder().withNewSpec()
                .withUser("admin-user")
                .withNewResourceAttributes()
                .withResource("pod")
                .withVerb("create")
                .endResourceAttributes()
                .endSpec()
                .build();

        server.expect().post().withPath("/apis/authorization.k8s.io/v1/subjectaccessreviews").andReply(200, recordedRequest -> {
            SubjectAccessReview reviewResponse = Serialization.unmarshal(recordedRequest.getBody().readString(Charset.defaultCharset()), SubjectAccessReview.class);

            reviewResponse.setStatus(new SubjectAccessReviewStatus(true, false, "", ""));

            return reviewResponse;
        }).always();

        SubjectAccessReview reviewResponse = client.subjectAccessReviewAuth().create(review);

        assertAll(() -> {
            assertNotNull(reviewResponse);
            assertEquals(true, reviewResponse.getStatus().getAllowed());
        });
    }

    @Test
    public void createLocalSubjectAccessReviewTest() {
        KubernetesClient client = server.getClient();

        LocalSubjectAccessReview review = new LocalSubjectAccessReviewBuilder().withNewSpec()
                .withUser("admin-user")
                .withNewResourceAttributes()
                .withResource("pod")
                .withVerb("create")
                .endResourceAttributes()
                .endSpec()
                .build();

        server.expect().post().withPath("/apis/authorization.k8s.io/v1/namespaces/test/localsubjectaccessreviews").andReply(200, recordedRequest -> {
            LocalSubjectAccessReview reviewResponse = Serialization.unmarshal(recordedRequest.getBody().readString(Charset.defaultCharset()), LocalSubjectAccessReview.class);
            reviewResponse.setStatus(new SubjectAccessReviewStatus(true, false, "", ""));

            return reviewResponse;
        }).once();

        LocalSubjectAccessReview reviewResponse = client.subjectAccessReviewAuth()
                .inNamespace("test").create(review);

        assertAll(() -> {
            assertNotNull(reviewResponse);
            assertNotNull(reviewResponse.getMetadata());
            assertEquals("test", reviewResponse.getMetadata().getNamespace());
            assertEquals("test", reviewResponse.getSpec().getResourceAttributes().getNamespace());
            assertEquals(true, reviewResponse.getStatus().getAllowed());
        });
    }
}