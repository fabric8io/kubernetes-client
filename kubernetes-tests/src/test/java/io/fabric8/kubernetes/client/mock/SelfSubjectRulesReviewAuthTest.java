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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.fabric8.kubernetes.api.model.authorization.ResourceRuleBuilder;
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectRulesReview;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@EnableRuleMigrationSupport
public class SelfSubjectRulesReviewAuthTest {

    @Rule
    public KubernetesServer server = new KubernetesServer();

    @Test
    @Order(1)
    public void testList() {
        KubernetesClient client = server.getClient();

        SelfSubjectRulesReview rulesReviewResponse = client.subjectAccessReviewAuth().list().createNew()
                .withNewSpec()
                .withNamespace("test")
                .endSpec()
                .withNewStatus()
                .withResourceRules(new ResourceRuleBuilder()
                        .withVerbs("list").build()).endStatus().done();

        assertNotNull(rulesReviewResponse);
        assertFalse(rulesReviewResponse.getStatus().getIncomplete());
        assertTrue(rulesReviewResponse.getStatus().getResourceRules().get(0).getVerbs().contains("list"));
    }

    @Test
    @Order(2)
    public void testGet() {
        KubernetesClient client = server.getClient();

        SelfSubjectRulesReview rulesReviewResponse = client.subjectAccessReviewAuth().list().createNew()
                .withNewSpec()
                .withNamespace("test")
                .endSpec()
                .withNewStatus()
                .withResourceRules(new ResourceRuleBuilder()
                        .withVerbs("get").build()).endStatus().done();

        assertNotNull(rulesReviewResponse);
        assertFalse(rulesReviewResponse.getStatus().getIncomplete());
        assertTrue(rulesReviewResponse.getStatus().getResourceRules().get(0).getVerbs().contains("get"));
    }

    @Test
    @Order(3)
    public void testDelete() {
        KubernetesClient client = server.getClient();

        SelfSubjectRulesReview rulesReviewResponse = client.subjectAccessReviewAuth().list().createNew()
                .withNewSpec()
                .withNamespace("test")
                .endSpec()
                .withNewStatus()
                .withResourceRules(new ResourceRuleBuilder()
                        .withVerbs("delete").build()).endStatus().done();

        assertNotNull(rulesReviewResponse);
        assertFalse(rulesReviewResponse.getStatus().getIncomplete());
        assertTrue(rulesReviewResponse.getStatus().getResourceRules().get(0).getVerbs().contains("delete"));
    }

    @Test
    @Order(4)
    public void testLoadFromFile() {
        KubernetesClient client = server.getClient();

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        SelfSubjectRulesReview review = null;

        try {
            review = mapper.readValue(getClass().getResourceAsStream("/test-selfsubjectrulesreview.yml"), SelfSubjectRulesReview.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(review);

        SelfSubjectRulesReview rulesReviewResponse = client.subjectAccessReviewAuth().list().create(review);

        assertNotNull(rulesReviewResponse);
        assertFalse(rulesReviewResponse.getStatus().getIncomplete());
        assertTrue(rulesReviewResponse.getStatus().getResourceRules().get(0).getVerbs().contains("*"));
    }

    @BeforeEach
    private void initializeCreateRequestHandler() {
        server.expect().post().withPath("/apis/authorization.k8s.io/v1/subjectaccessreviews").andReply(200, recordedRequest -> {
            ObjectMapper mapper = new ObjectMapper();

            SelfSubjectRulesReview reviewResponse = null;

            try {
                reviewResponse = mapper.readValue(recordedRequest.getBody().readString(Charset.defaultCharset()), SelfSubjectRulesReview.class);
                reviewResponse.getStatus().setIncomplete(false);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return reviewResponse;
        }).always();
    }

}