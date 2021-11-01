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
package io.fabric8.openshift.client.dsl.internal.build;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventList;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Triggerable;
import io.fabric8.kubernetes.client.dsl.Typeable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.WebHookTrigger;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.BuildConfigOperation;
import io.fabric8.openshift.client.dsl.BuildConfigResource;
import io.fabric8.openshift.client.dsl.InputStreamable;
import io.fabric8.openshift.client.dsl.TimeoutInputStreamable;
import io.fabric8.openshift.client.dsl.buildconfig.AsFileTimeoutInputStreamable;
import io.fabric8.openshift.client.dsl.buildconfig.AuthorEmailable;
import io.fabric8.openshift.client.dsl.buildconfig.AuthorMessageAsFileTimeoutInputStreamable;
import io.fabric8.openshift.client.dsl.buildconfig.CommitterAuthorMessageAsFileTimeoutInputStreamable;
import io.fabric8.openshift.client.dsl.buildconfig.CommitterEmailable;
import io.fabric8.openshift.client.dsl.buildconfig.MessageAsFileTimeoutInputStreamable;
import io.fabric8.openshift.client.dsl.internal.BuildConfigOperationContext;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.BUILD;

public class BuildConfigOperationsImpl extends OpenShiftOperation<BuildConfig, BuildConfigList, BuildConfigResource<BuildConfig, Void, Build>>
        implements BuildConfigOperation {

  private static final Logger logger = LoggerFactory.getLogger(BuildConfigOperationsImpl.class);
  public static final String BUILD_CONFIG_LABEL = "openshift.io/build-config.name";
  public static final String BUILD_CONFIG_ANNOTATION = "openshift.io/build-config.name";

  private final BuildConfigOperationContext buildConfigOperationContext;
  private final String secret;
  private final String triggerType;

  private final String authorName;
  private final String authorEmail;
  private final String committerName;
  private final String committerEmail;
  private final String commit;
  private final String message;
  private final String asFile;

  private final long timeout;
  private final TimeUnit timeoutUnit;

  public BuildConfigOperationsImpl(HttpClient client, OpenShiftConfig config) {
    this(new BuildConfigOperationContext(), new OperationContext().withHttpClient(client).withConfig(config));
  }

  public BuildConfigOperationsImpl(BuildConfigOperationContext context, OperationContext superContext) {
    super(superContext.withApiGroupName(BUILD)
      .withPlural("buildconfigs"), BuildConfig.class, BuildConfigList.class);
    this.buildConfigOperationContext = context;
    this.triggerType = context.getTriggerType();
    this.secret = context.getSecret();
    this.authorName = context.getAuthorName();
    this.authorEmail = context.getAuthorEmail() ;
    this.committerName = context.getCommitterName();
    this.committerEmail = context.getCommitterEmail();
    this.commit = context.getCommit();
    this.message = context.getMessage();
    this.asFile = context.getAsFile();
    this.timeout = context.getTimeout();
    this.timeoutUnit = context.getTimeoutUnit();
  }

  @Override
  public BuildConfigOperationsImpl newInstance(OperationContext context) {
    return new BuildConfigOperationsImpl(buildConfigOperationContext, context);
  }

  public  BuildConfigOperationContext getContext() {
    return buildConfigOperationContext;
  }

  @Override
  public Build instantiate(BuildRequest request) {
    try {
      updateApiVersion(request);
      URL instantiationUrl = new URL(URLUtils.join(getResourceUrl().toString(), "instantiate"));
      HttpRequest.Builder requestBuilder = client.newHttpRequestBuilder().post(JSON, OperationSupport.JSON_MAPPER.writer().writeValueAsString(request)).url(instantiationUrl);
      return handleResponse(requestBuilder, Build.class);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public CommitterAuthorMessageAsFileTimeoutInputStreamable<Build> instantiateBinary() {
    return this;
  }


  @Override
  public Void trigger(WebHookTrigger trigger) {
    try {
      //TODO: This needs some attention.
      String triggerUrl = URLUtils.join(getResourceUrl().toString(), "webhooks", secret, triggerType);
      HttpRequest.Builder requestBuilder = client.newHttpRequestBuilder()
        .post(JSON, OperationSupport.JSON_MAPPER.writer().writeValueAsBytes(trigger))
        .uri(triggerUrl)
        .header("X-Github-Event", "push");
      handleResponse(requestBuilder, null);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    return null;
  }

  @Override
  public Triggerable<WebHookTrigger, Void> withType(String triggerType) {
    return new BuildConfigOperationsImpl(getContext().withTriggerType(triggerType), context);
  }

  @Override
  public Build fromInputStream(final InputStream inputStream) {
    return submitToApiServer(inputStream, -1L);
  }

  @Override
  public Build fromFile(final File file) {
    if (!file.exists()) {
      throw new IllegalArgumentException("Can't instantiate binary build from the specified file. The file does not exists");
    }
    try (InputStream is = new FileInputStream(file)) {
      // Use a length to prevent chunked encoding with OkHttp, which in turn
      // doesn't work with 'Expect: 100-continue' negotiation with the OpenShift API server
      logger.debug("Uploading archive file \"{}\" as binary input for the build ...", file.getAbsolutePath());
      return submitToApiServer(is, file.length());
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private String getQueryParameters() throws MalformedURLException {
    StringBuilder sb = new StringBuilder();
    sb.append(URLUtils.join(getResourceUrl().toString(), "instantiatebinary"));
    if (Utils.isNotNullOrEmpty(name)) {
      sb.append("?name=").append(name);
    }

    if (Utils.isNotNullOrEmpty(namespace)) {
      sb.append("&namespace=").append(namespace);
    }

    if (Utils.isNotNullOrEmpty(message)) {
      sb.append("&commit=").append(message);
    }

    if (!Utils.isNullOrEmpty(authorName)) {
      sb.append("&revision.authorName=").append(authorName);
    }

    if (!Utils.isNullOrEmpty(authorEmail)) {
      sb.append("&revision.authorEmail=").append(authorEmail);
    }

    if (!Utils.isNullOrEmpty(committerName)) {
      sb.append("&revision.committerName=").append(committerName);
    }

    if (!Utils.isNullOrEmpty(committerEmail)) {
      sb.append("&revision.committerEmail=").append(committerEmail);
    }

    if (!Utils.isNullOrEmpty(commit)) {
      sb.append("&revision.commit=").append(commit);
    }

    if (!Utils.isNullOrEmpty(asFile)) {
      sb.append("&asFile=").append(asFile);
    }
    return sb.toString();
  }

  @Override
  public TimeoutInputStreamable<Build> asFile(String fileName) {
    return new BuildConfigOperationsImpl(getContext().withAsFile(fileName), context);
  }

  @Override
  public MessageAsFileTimeoutInputStreamable<Build> withAuthorEmail(String email) {
    return new BuildConfigOperationsImpl(getContext().withAuthorEmail(email), context);
  }

  @Override
  public AuthorMessageAsFileTimeoutInputStreamable<Build> withCommitterEmail(String committerEmail) {
    return new BuildConfigOperationsImpl(getContext().withCommitterEmail(committerEmail), context);
  }

  @Override
  public AsFileTimeoutInputStreamable<Build> withMessage(String message) {
    return new BuildConfigOperationsImpl(getContext().withMessage(message), context);
  }

  @Override
  public AuthorEmailable<MessageAsFileTimeoutInputStreamable<Build>> withAuthorName(String authorName) {
    return new BuildConfigOperationsImpl(getContext().withAuthorName(authorName), context);
  }

  @Override
  public CommitterEmailable<AuthorMessageAsFileTimeoutInputStreamable<Build>> withCommitterName(String committerName) {
    return new BuildConfigOperationsImpl(getContext().withCommitterName(committerName), context);
  }

  @Override
  public InputStreamable<Build> withTimeout(long timeout, TimeUnit unit) {
    return new BuildConfigOperationsImpl(getContext().withTimeout(timeout).withTimeoutUnit(unit), context);
  }

  @Override
  public InputStreamable<Build> withTimeoutInMillis(long timeoutInMillis) {
    return withTimeout(timeoutInMillis, TimeUnit.MILLISECONDS);
  }

  @Override
  public Typeable<Triggerable<WebHookTrigger, Void>> withSecret(String secret) {
    return new BuildConfigOperationsImpl(getContext().withSecret(secret), context);
  }

  @Override
  protected VisitableBuilder<BuildConfig, ?> createVisitableBuilder(BuildConfig item) {
      return new BuildConfigBuilder(item);
  }

  protected Build submitToApiServer(InputStream inputStream, long contentLength) {
    try {
      HttpClient newClient = client.newBuilder()
        .readTimeout(timeout, timeoutUnit)
        .writeTimeout(timeout, timeoutUnit)
        .build();
      HttpRequest.Builder requestBuilder =
        client.newHttpRequestBuilder().post("application/octet-stream", inputStream, contentLength)
          .header("Expect", "100-continue")
          .uri(getQueryParameters());
      return handleResponse(newClient, requestBuilder, Build.class);
    } catch (Throwable e) {
      // TODO: better determine which exception this should occur on
      // otherwise we need to have the httpclient api open up to the notion
      // of a RequestBody/BodyPublisher
      logger.error("Failed to upload archive file for the build: {}", name);
      logger.error("Please check cluster events via `oc get events` to see what could have possibly gone wrong");
      throw new KubernetesClientException("Can't instantiate binary build, due to error reading/writing stream. "
        + "Can be caused if the output stream was closed by the server." +
        "See if something's wrong in recent events in Cluster = " + getRecentEvents(), e);
    }
  }

  protected String getRecentEvents() {
    StringBuilder eventsAsStrBuilder = new StringBuilder();
    List<Event> recentEventList = Handlers.getOperation(Event.class, EventList.class, client, config).inNamespace(namespace).list().getItems();
    KubernetesResourceUtil.sortEventListBasedOnTimestamp(recentEventList);
    for (int i = 0; i < 10 && i < recentEventList.size(); i++) {
      Event event = recentEventList.get(i);
      eventsAsStrBuilder.append(event.getReason()).append(" ")
        .append(event.getMetadata().getName()).append(" ")
        .append(event.getMessage()).append("\n");
    }
    return eventsAsStrBuilder.toString();
  }
}
