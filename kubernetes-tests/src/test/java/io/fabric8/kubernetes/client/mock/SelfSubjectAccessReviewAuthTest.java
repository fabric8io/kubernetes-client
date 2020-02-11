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
import io.fabric8.kubernetes.api.model.authorization.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.SubjectAccessReviewStatus;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@EnableRuleMigrationSupport
public class SelfSubjectAccessReviewAuthTest {

    @Rule
    public KubernetesServer server = new KubernetesServer();

    @Test
    @Order(1)
    public void testList() {
        KubernetesClient client = server.getClient();

        SelfSubjectAccessReview reviewResponse = client.subjectAccessReviewAuth().inAnyNamespace().createNew()
                .withNewSpec()
                .withNewResourceAttributes()
                .withResource("pod")
                .withResource("pod2")
                .withVerb("list")
                .endResourceAttributes()
                .endSpec().done();

        assertNotNull(reviewResponse);
        assertTrue(reviewResponse.getStatus().getAllowed());
    }

    @Test
    @Order(2)
    public void testLoadFromFile() throws IOException {
        KubernetesClient client = server.getClient();

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        SelfSubjectAccessReview review = mapper.readValue(getClass().getResourceAsStream("/test-selfsubjectaccessreview.yml"), SelfSubjectAccessReview.class);

        assertNotNull(review);

        SelfSubjectAccessReview reviewResponse = client.subjectAccessReviewAuth().inAnyNamespace().create(review);

        assertNotNull(reviewResponse);
        assertTrue(reviewResponse.getStatus().getAllowed());
    }

    @Test
    @Order(3)
    public void testGet() {
        KubernetesClient client = server.getClient();

        SelfSubjectAccessReview reviewResponse = client.subjectAccessReviewAuth().inAnyNamespace().createNew()
                .withNewSpec()
                .withNewResourceAttributes()
                .withResource("pod")
                .withVerb("get")
                .endResourceAttributes()
                .endSpec().done();

        assertNotNull(reviewResponse);
        assertTrue(reviewResponse.getStatus().getAllowed());
    }

    @Test
    @Order(4)
    public void testDelete() {
        KubernetesClient client = server.getClient();

        SelfSubjectAccessReview reviewResponse = client.subjectAccessReviewAuth().inAnyNamespace().createNew()
                .withNewSpec()
                .withNewResourceAttributes()
                .withResource("pod")
                .withVerb("delete")
                .endResourceAttributes()
                .endSpec().done();

        assertNotNull(reviewResponse);
        assertTrue(reviewResponse.getStatus().getAllowed());
    }

    @BeforeEach
    private void initializeCreateRequestHandler() {
        server.expect().post().withPath("/apis/authorization.k8s.io/v1/namespaces/test/selfsubjectaccessreviews").andReply(200, recordedRequest -> {
            SelfSubjectAccessReview reviewResponse = Serialization.unmarshal(recordedRequest.getBody().readString(Charset.defaultCharset()), SelfSubjectAccessReview.class);
            reviewResponse.setStatus(new SubjectAccessReviewStatus(true, false, "",""));

            return reviewResponse;
        }).always();
    }
}
