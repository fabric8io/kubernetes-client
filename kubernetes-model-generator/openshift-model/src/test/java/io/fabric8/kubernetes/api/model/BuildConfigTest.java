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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openshift.api.model.BinaryBuildSourceBuilder;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildPostCommitSpecBuilder;
import io.fabric8.openshift.api.model.BuildTriggerPolicyBuilder;
import io.fabric8.openshift.api.model.GitBuildSourceBuilder;
import io.fabric8.openshift.api.model.GitSourceRevisionBuilder;
import io.fabric8.openshift.api.model.ImageChangeTriggerBuilder;
import io.fabric8.openshift.api.model.ImageLabelBuilder;
import io.fabric8.openshift.api.model.ImageSourceBuilder;
import io.fabric8.openshift.api.model.ImageSourcePathBuilder;
import io.fabric8.openshift.api.model.SecretBuildSourceBuilder;
import io.fabric8.openshift.api.model.SourceBuildStrategyBuilder;
import io.fabric8.openshift.api.model.SourceControlUserBuilder;
import io.fabric8.openshift.api.model.WebHookTriggerBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuildConfigTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void buildConfigTest() throws Exception {
    // given
    final String originalJson = Helper.loadJson("/valid-buildConfig.json");

    // when
    final BuildConfig buildConfig = mapper.readValue(originalJson, BuildConfig.class);
    final String serializedJson = mapper.writeValueAsString(buildConfig);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  public void buildConfigBuilderTest() {

    BuildConfig buildConfig = new BuildConfigBuilder()
        .withNewMetadata()
        .withName("ruby-sample-build")
        .endMetadata()
        .withNewSpec()
        .addToTriggers(0,
            new BuildTriggerPolicyBuilder()
                .withType("Github")
                .withGithub(new WebHookTriggerBuilder()
                    .withSecret("secret101")
                    .build())
                .build())
        .addToTriggers(1,
            new BuildTriggerPolicyBuilder()
                .withType("Generic")
                .withGithub(new WebHookTriggerBuilder()
                    .withSecret("secret101")
                    .withAllowEnv(true)
                    .build())
                .build())
        .addToTriggers(2,
            new BuildTriggerPolicyBuilder()
                .withType("ImageChange")
                .withImageChange(new ImageChangeTriggerBuilder()
                    .withLastTriggeredImageID("triggeredID")
                    .withFrom(new io.fabric8.kubernetes.api.model.ObjectReferenceBuilder()
                        .withKind("ImageStreamTag")
                        .withName("custom-image:latest")
                        .withApiVersion("v1")
                        .withNamespace("default")
                        .withUid("16161")
                        .withFieldPath("/path/field")
                        .build())
                    .build())
                .build())
        .withRunPolicy("Parallel")
        .withServiceAccount("build-ServiceAccount")
        .withNewSource()
        .withType("Git")
        .withBinary(new BinaryBuildSourceBuilder()
            .withAsFile("webapp.war")
            .build())
        .withGit(new GitBuildSourceBuilder()
            .withUri("https://github.com/openshift/ruby-hello-world")
            .withRef("master")
            .withHttpProxy("http://proxy.example.com")
            .withHttpsProxy("http://proxy.example.com")
            .withNoProxy("http://proxy.example2.com")
            .build())
        .withDockerfile("FROM openshift/ruby-22-centos7\nUSER example")
        .withContextDir("app/dir")
        .withSourceSecret(new io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder()
            .withName("basicsecret")
            .build())
        .withImages(new ImageSourceBuilder()
            .withFrom(new io.fabric8.kubernetes.api.model.ObjectReferenceBuilder()
                .withNamespace("mynamespace")
                .withName("myinputimage:latest")
                .withKind("ImageStreamTag")
                .build())
            .withPaths(new ImageSourcePathBuilder()
                .withDestinationDir("app/dir/injected/dir")
                .withSourcePath("/usr/lib/somefile.jar")
                .build())
            .withPullSecret(new io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder()
                .withName("pullsecret")
                .build())
            .build())
        .addToSecrets(0, new SecretBuildSourceBuilder()
            .withSecret(new io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder()
                .withName("secret-npmrc")
                .build())
            .withDestinationDir("app/dir/secret/dir")
            .build())
        .endSource()
        .withNewRevision()
        .withType("Source")
        .withGit(new GitSourceRevisionBuilder()
            .withCommit("d75775")
            .withAuthor(new SourceControlUserBuilder()
                .withName("Author")
                .withEmail("author@gmail.com")
                .build())
            .withCommitter(new SourceControlUserBuilder()
                .withName("Committer")
                .withEmail("commiter@gmail.com")
                .build())
            .withMessage("Commit Git")
            .build())
        .endRevision()
        .withNewStrategy()
        .withType("Source")
        .withSourceStrategy(new SourceBuildStrategyBuilder()
            .withFrom(new io.fabric8.kubernetes.api.model.ObjectReferenceBuilder()
                .withKind("ImageStreamTag")
                .withName("ruby-20-centos7:latest")
                .build())
            .withPullSecret(new io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder()
                .withName("pullsecret")
                .build())
            .addToEnv(0, new io.fabric8.kubernetes.api.model.EnvVarBuilder()
                .withName("BUILD_LOGLEVEL")
                .withValue("2")
                .build())
            .withScripts("/scripts")
            .withIncremental(true)
            .withForcePull(true)
            .build())
        .endStrategy()
        .withNewOutput()
        .withTo(new io.fabric8.kubernetes.api.model.ObjectReferenceBuilder()
            .withKind("Docker Image")
            .withName("private.registry.com/org/private-image:latest")
            .build())
        .withPushSecret(new io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder()
            .withName("dockerhub")
            .build())
        .addToImageLabels(0, new ImageLabelBuilder()
            .withName("imageLabelName")
            .withValue("imageLabelValue")
            .build())
        .endOutput()
        .withNewResources()
        .withLimits(new HashMap<String, Quantity>() {
          {
            put("cpu", new io.fabric8.kubernetes.api.model.QuantityBuilder()
                .withAmount("100")
                .withFormat("m")
                .build());
            put("memory", new io.fabric8.kubernetes.api.model.QuantityBuilder()
                .withAmount("256")
                .withFormat("Mi")
                .build());
          }
        })
        .withRequests(new HashMap<String, Quantity>() {
          {
            put("cpu", new io.fabric8.kubernetes.api.model.QuantityBuilder()
                .withAmount("50")
                .withFormat("m")
                .build());
            put("memory", new io.fabric8.kubernetes.api.model.QuantityBuilder()
                .withAmount("128")
                .withFormat("Mi")
                .build());
          }
        })
        .endResources()
        .withPostCommit(new BuildPostCommitSpecBuilder()
            .withScript("bundle exec rake test")
            .addToArgs(0, "bundle")
            .addToArgs(1, "exec")
            .addToArgs(2, "rake")
            .addToArgs(3, "test")
            .addToArgs(4, "--verbose")
            .build())
        .withCompletionDeadlineSeconds(1000L)
        .withNodeSelector(new HashMap<String, String>() {
          {
            put("key1", "value1");
            put("key2", "value2");
          }
        })
        .withSuccessfulBuildsHistoryLimit(5)
        .withFailedBuildsHistoryLimit(5)
        .endSpec()
        .build();

    assertNotNull(buildConfig);
    assertEquals("ruby-sample-build", buildConfig.getMetadata().getName());
    assertNotNull(buildConfig.getSpec().getTriggers());
    assertEquals(3, buildConfig.getSpec().getTriggers().size());
    assertEquals("Github", buildConfig.getSpec().getTriggers().get(0).getType());
    assertEquals("secret101", buildConfig.getSpec().getTriggers().get(0).getGithub().getSecret());
    assertEquals("Generic", buildConfig.getSpec().getTriggers().get(1).getType());
    assertEquals("secret101", buildConfig.getSpec().getTriggers().get(1).getGithub().getSecret());
    assertTrue(buildConfig.getSpec().getTriggers().get(1).getGithub().getAllowEnv());
    assertEquals("ImageChange", buildConfig.getSpec().getTriggers().get(2).getType());
    assertEquals("triggeredID",
        buildConfig.getSpec().getTriggers().get(2).getImageChange().getLastTriggeredImageID());
    assertEquals("v1",
        buildConfig.getSpec().getTriggers().get(2).getImageChange().getFrom().getApiVersion());
    assertEquals("custom-image:latest",
        buildConfig.getSpec().getTriggers().get(2).getImageChange().getFrom().getName());
    assertEquals("default",
        buildConfig.getSpec().getTriggers().get(2).getImageChange().getFrom().getNamespace());
    assertEquals("ImageStreamTag",
        buildConfig.getSpec().getTriggers().get(2).getImageChange().getFrom().getKind());
    assertEquals("16161",
        buildConfig.getSpec().getTriggers().get(2).getImageChange().getFrom().getUid());
    assertEquals("/path/field",
        buildConfig.getSpec().getTriggers().get(2).getImageChange().getFrom().getFieldPath());
    assertEquals("Parallel", buildConfig.getSpec().getRunPolicy());
    assertEquals("build-ServiceAccount", buildConfig.getSpec().getServiceAccount());
    assertEquals("Git", buildConfig.getSpec().getSource().getType());
    assertNotNull(buildConfig.getSpec().getSource().getGit());
    assertEquals("https://github.com/openshift/ruby-hello-world", buildConfig.getSpec()
        .getSource().getGit().getUri());
    assertEquals("master", buildConfig.getSpec().getSource().getGit().getRef());
    assertEquals("http://proxy.example.com", buildConfig.getSpec().getSource().getGit().getHttpProxy());
    assertEquals("http://proxy.example.com", buildConfig.getSpec().getSource().getGit().getHttpsProxy());
    assertEquals("http://proxy.example2.com", buildConfig.getSpec().getSource().getGit().getNoProxy());
    assertEquals("FROM openshift/ruby-22-centos7\nUSER example", buildConfig
        .getSpec().getSource().getDockerfile());
    assertEquals("app/dir", buildConfig.getSpec().getSource().getContextDir());
    assertNotNull(buildConfig.getSpec().getSource().getSourceSecret());
    assertEquals("basicsecret", buildConfig.getSpec().getSource().getSourceSecret().getName());
    assertNotNull(buildConfig.getSpec().getSource().getImages());
    assertEquals(1, buildConfig.getSpec().getSource().getImages().size());
    assertNotNull(buildConfig.getSpec().getSource().getImages().get(0).getFrom());
    assertEquals("ImageStreamTag", buildConfig.getSpec().getSource().getImages()
        .get(0).getFrom().getKind());
    assertEquals("mynamespace", buildConfig.getSpec().getSource().getImages()
        .get(0).getFrom().getNamespace());
    assertEquals("myinputimage:latest", buildConfig.getSpec().getSource().getImages().get(0)
        .getFrom().getName());
    assertNotNull(buildConfig.getSpec().getSource().getImages().get(0).getPaths());
    assertEquals(1, buildConfig.getSpec().getSource().getImages().get(0).getPaths().size());
    assertEquals("app/dir/injected/dir", buildConfig.getSpec().getSource().getImages()
        .get(0).getPaths().get(0).getDestinationDir());
    assertEquals("/usr/lib/somefile.jar", buildConfig.getSpec().getSource().getImages()
        .get(0).getPaths().get(0).getSourcePath());
    assertNotNull(buildConfig.getSpec().getSource().getImages().get(0).getPullSecret());
    assertEquals("pullsecret", buildConfig.getSpec().getSource().getImages()
        .get(0).getPullSecret().getName());
    assertNotNull(buildConfig.getSpec().getSource().getSecrets());
    assertEquals(1, buildConfig.getSpec().getSource().getSecrets().size());
    assertNotNull(buildConfig.getSpec().getSource().getSecrets().get(0).getSecret());
    assertEquals("secret-npmrc", buildConfig.getSpec().getSource().getSecrets()
        .get(0).getSecret().getName());
    assertEquals("app/dir/secret/dir", buildConfig.getSpec().getSource()
        .getSecrets().get(0).getDestinationDir());
    assertNotNull(buildConfig.getSpec().getRevision());
    assertEquals("Source", buildConfig.getSpec().getRevision().getType());
    assertNotNull(buildConfig.getSpec().getRevision().getGit());
    assertEquals("d75775", buildConfig.getSpec().getRevision().getGit().getCommit());
    assertNotNull(buildConfig.getSpec().getRevision().getGit().getAuthor());
    assertEquals("Author", buildConfig.getSpec().getRevision().getGit().getAuthor().getName());
    assertEquals("author@gmail.com", buildConfig.getSpec().getRevision().getGit().getAuthor().getEmail());
    assertNotNull(buildConfig.getSpec().getRevision().getGit().getCommit());
    assertEquals("Committer", buildConfig.getSpec().getRevision().getGit().getCommitter().getName());
    assertEquals("commiter@gmail.com", buildConfig.getSpec().getRevision().getGit()
        .getCommitter().getEmail());
    assertEquals("Commit Git", buildConfig.getSpec().getRevision().getGit().getMessage());
    assertNotNull(buildConfig.getSpec().getStrategy());
    assertEquals("Source", buildConfig.getSpec().getStrategy().getType());
    assertNotNull(buildConfig.getSpec().getStrategy().getSourceStrategy());
    assertNotNull(buildConfig.getSpec().getStrategy().getSourceStrategy().getFrom());
    assertEquals("ImageStreamTag", buildConfig.getSpec().getStrategy().getSourceStrategy()
        .getFrom().getKind());
    assertEquals("ruby-20-centos7:latest", buildConfig.getSpec().getStrategy().getSourceStrategy()
        .getFrom().getName());
    assertNotNull(buildConfig.getSpec().getStrategy().getSourceStrategy().getPullSecret());
    assertEquals("pullsecret", buildConfig.getSpec().getStrategy().getSourceStrategy().getPullSecret()
        .getName());
    assertNotNull(buildConfig.getSpec().getStrategy().getSourceStrategy().getEnv());
    assertEquals(1, buildConfig.getSpec().getStrategy().getSourceStrategy().getEnv().size());
    assertEquals("BUILD_LOGLEVEL", buildConfig.getSpec().getStrategy().getSourceStrategy().getEnv()
        .get(0).getName());
    assertEquals("2", buildConfig.getSpec().getStrategy().getSourceStrategy().getEnv().get(0).getValue());
    assertEquals("/scripts", buildConfig.getSpec().getStrategy().getSourceStrategy().getScripts());
    assertEquals(true, buildConfig.getSpec().getStrategy().getSourceStrategy().getIncremental());
    assertEquals(true, buildConfig.getSpec().getStrategy().getSourceStrategy().getForcePull());
    assertNotNull(buildConfig.getSpec().getOutput());
    assertNotNull(buildConfig.getSpec().getOutput().getTo());
    assertEquals("Docker Image", buildConfig.getSpec().getOutput().getTo().getKind());
    assertEquals("private.registry.com/org/private-image:latest", buildConfig.getSpec()
        .getOutput().getTo().getName());
    assertNotNull(buildConfig.getSpec().getOutput().getPushSecret());
    assertEquals("dockerhub", buildConfig.getSpec().getOutput().getPushSecret().getName());
    assertNotNull(buildConfig.getSpec().getOutput().getImageLabels());
    assertEquals(1, buildConfig.getSpec().getOutput().getImageLabels().size());
    assertNotNull(buildConfig.getSpec().getOutput().getImageLabels().get(0));
    assertEquals("imageLabelName", buildConfig.getSpec().getOutput().getImageLabels().get(0).getName());
    assertEquals("imageLabelValue", buildConfig.getSpec().getOutput().getImageLabels().get(0).getValue());
    assertNotNull(buildConfig.getSpec().getResources());
    assertNotNull(buildConfig.getSpec().getResources().getLimits());
    assertEquals("100", buildConfig.getSpec().getResources().getLimits().get("cpu").getAmount());
    assertEquals("m", buildConfig.getSpec().getResources().getLimits().get("cpu").getFormat());
    assertEquals("256", buildConfig.getSpec().getResources().getLimits().get("memory").getAmount());
    assertEquals("Mi", buildConfig.getSpec().getResources().getLimits().get("memory").getFormat());
    assertNotNull(buildConfig.getSpec().getResources().getRequests());
    assertEquals("50", buildConfig.getSpec().getResources().getRequests().get("cpu").getAmount());
    assertEquals("m", buildConfig.getSpec().getResources().getRequests().get("cpu").getFormat());
    assertEquals("128", buildConfig.getSpec().getResources().getRequests().get("memory").getAmount());
    assertEquals("Mi", buildConfig.getSpec().getResources().getRequests().get("memory").getFormat());
    assertNotNull(buildConfig.getSpec().getPostCommit());
    assertEquals("bundle exec rake test", buildConfig.getSpec().getPostCommit().getScript());
    assertNotNull(buildConfig.getSpec().getPostCommit().getArgs());
    assertEquals(5, buildConfig.getSpec().getPostCommit().getArgs().size());
    assertEquals("bundle", buildConfig.getSpec().getPostCommit().getArgs().get(0));
    assertEquals("exec", buildConfig.getSpec().getPostCommit().getArgs().get(1));
    assertEquals("rake", buildConfig.getSpec().getPostCommit().getArgs().get(2));
    assertEquals("test", buildConfig.getSpec().getPostCommit().getArgs().get(3));
    assertEquals("--verbose", buildConfig.getSpec().getPostCommit().getArgs().get(4));
    assertEquals(1000L, buildConfig.getSpec().getCompletionDeadlineSeconds().intValue());
    assertEquals(2, buildConfig.getSpec().getNodeSelector().size());
    assertEquals("value1", buildConfig.getSpec().getNodeSelector().get("key1"));
    assertEquals("value2", buildConfig.getSpec().getNodeSelector().get("key2"));
    assertEquals(5, buildConfig.getSpec().getSuccessfulBuildsHistoryLimit().intValue());
    assertEquals(5, buildConfig.getSpec().getFailedBuildsHistoryLimit().intValue());
  }
}
