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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.Reaper;
import io.fabric8.kubernetes.client.dsl.Triggerable;
import io.fabric8.kubernetes.client.dsl.Typeable;
import io.fabric8.kubernetes.client.dsl.Watchable;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.WebHookTrigger;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.BuildConfigOperation;
import io.fabric8.openshift.client.dsl.ClientBuildConfigResource;
import io.fabric8.openshift.client.dsl.InputStreamable;
import io.fabric8.openshift.client.dsl.TimeoutInputStreamable;
import io.fabric8.openshift.client.dsl.buildconfig.AsFileTimeoutInputStreamable;
import io.fabric8.openshift.client.dsl.buildconfig.AuthorEmailable;
import io.fabric8.openshift.client.dsl.buildconfig.AuthorMessageAsFileTimeoutInputStreamable;
import io.fabric8.openshift.client.dsl.buildconfig.CommitterAuthorMessageAsFileTimeoutInputStreamable;
import io.fabric8.openshift.client.dsl.buildconfig.CommitterEmailable;
import io.fabric8.openshift.client.dsl.buildconfig.MessageAsFileTimeoutInputStreamable;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class BuildConfigOperationsImpl extends OpenShiftOperation<BuildConfig, BuildConfigList, DoneableBuildConfig,
        ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Build>>
        implements BuildConfigOperation {

  public static final String BUILD_CONFIG_LABEL = "openshift.io/build-config.name";
  public static final String BUILD_CONFIG_ANNOTATION = "openshift.io/build-config.name";

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

  public BuildConfigOperationsImpl(OkHttpClient client, OpenShiftConfig config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>(), null, null, null, null, null, null, null, null, null, config.getBuildTimeout(), TimeUnit.MILLISECONDS);
  }

  public BuildConfigOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, BuildConfig item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    this(client, config, apiVersion, namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields, null, null, null, null, null, null, null, null, null, config.getBuildTimeout(), TimeUnit.MILLISECONDS);
  }

  public BuildConfigOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, BuildConfig item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields, String secret, String triggerType, String authorName, String authorEmail, String committerName, String committerEmail, String commit, String message, String asFile, long timeout, TimeUnit timeoutUnit) {
    super(client, config, null, apiVersion, "buildconfigs", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
    this.triggerType = triggerType;
    this.secret = secret;
    this.authorName = authorName;
    this.authorEmail = authorEmail;
    this.committerName = committerName;
    this.committerEmail = committerEmail;
    this.commit = commit;
    this.message = message;
    this.asFile = asFile;
    reaper = new BuildConfigReaper(this);
    this.timeout = timeout;
    this.timeoutUnit = timeoutUnit;
  }

  @Override
  public ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Build> withName(String name) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name must be provided.");
    }
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), name, isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public OpenShiftOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Build>> inNamespace(String namespace) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public Gettable<BuildConfig> fromServer() {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), getResourceVersion(), true, getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public Typeable<Triggerable<WebHookTrigger, Void>> withSecret(String secret) {
    return new BuildConfigOperationsImpl(client,getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Build> load(InputStream is) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), unmarshal(is, getType()), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public Build instantiate(BuildRequest request) {
    try {
      URL instantiationUrl = new URL(URLUtils.join(getResourceUrl().toString(), "instantiate"));
      RequestBody requestBody = RequestBody.create(JSON, BaseOperation.JSON_MAPPER.writer().writeValueAsString(request));
      Request.Builder requestBuilder = new Request.Builder().post(requestBody).url(instantiationUrl);
      return handleResponse(requestBuilder, 201, Build.class);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public CommitterAuthorMessageAsFileTimeoutInputStreamable<Build> instantiateBinary() {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }


  @Override
  public Void trigger(WebHookTrigger trigger) {
    try {
      //TODO: This needs some attention.
      String triggerUrl = URLUtils.join(getResourceUrl().toString(), "webhooks", secret, triggerType);
      RequestBody requestBody = RequestBody.create(JSON, BaseOperation.JSON_MAPPER.writer().writeValueAsBytes(trigger));
      Request.Builder requestBuilder = new Request.Builder()
        .post(requestBody)
        .url(triggerUrl)
        .addHeader("X-Github-Event", "push");
      handleResponse(requestBuilder, 200, null);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    return null;
  }

  @Override
  public Triggerable<WebHookTrigger, Void> withType(String type) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, type, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public Watchable<Watch, Watcher<BuildConfig>> withResourceVersion(String resourceVersion) {
    BuildConfigOperationsImpl buildConfigOperations = new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), namespace, getName(), isCascading(), getItem(), resourceVersion, isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);

    return buildConfigOperations;
  }

  /*
   * Labels are limited to 63 chars so need to first truncate the build config name (if required), retrieve builds with matching label,
   * then check the build config name against the builds' build config annotation which have no such length restriction (but
   * aren't usable for searching). Would be better if referenced build config was available via fields but it currently isn't...
   */
  private void deleteBuilds() {
    if (getName() == null) {
        return;
    }
    String buildConfigLabelValue = getName().substring(0, Math.min(getName().length(), 63));
    BuildList matchingBuilds = new BuildOperationsImpl(client, (OpenShiftConfig) config, namespace).inNamespace(namespace).withLabel(BUILD_CONFIG_LABEL, buildConfigLabelValue).list();

    if (matchingBuilds.getItems() != null) {

      for (Build matchingBuild : matchingBuilds.getItems()) {

        if (matchingBuild.getMetadata() != null &&
          matchingBuild.getMetadata().getAnnotations() != null &&
          getName().equals(matchingBuild.getMetadata().getAnnotations().get(BUILD_CONFIG_ANNOTATION))) {

          new BuildOperationsImpl(client, (OpenShiftConfig) config, namespace).inNamespace(matchingBuild.getMetadata().getNamespace()).withName(matchingBuild.getMetadata().getName()).delete();

        }

      }

    }
  }

  @Override
  public Build fromInputStream(final InputStream inputStream) {
    try {

      RequestBody requestBody = new RequestBody() {
        @Override
        public MediaType contentType() {
          return MediaType.parse("application/octet-stream");
        }

        @Override
        public void writeTo(BufferedSink sink) throws IOException {
          Source source = null;
          try {
            source = Okio.source(inputStream);
            sink.writeAll(source);
          } catch (IOException e) {
            throw KubernetesClientException.launderThrowable("Can't instantiate binary build, due to error reading/writing stream. "
              + "Can be caused if output is stream closed by the server.", e);
          }
        }
      };

      OkHttpClient newClient = client.newBuilder()
        .readTimeout(timeout, timeoutUnit)
        .writeTimeout(timeout, timeoutUnit)
        .build();
      Request.Builder requestBuilder = new Request.Builder().post(requestBody).url(getQueryParameters());
      return handleResponse(newClient, requestBuilder, 201, Build.class);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public Build fromFile(final File file) {
    if (!file.exists()) {
      throw new IllegalArgumentException("Can't instantiate binary build from the specified file. The file does not exists");
    }
    try (InputStream is = new FileInputStream(file)) {
      return fromInputStream(is);
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  private String getQueryParameters() throws MalformedURLException {
    StringBuilder sb = new StringBuilder();
    sb.append(URLUtils.join(getResourceUrl().toString(), "instantiatebinary"));

    if (Utils.isNullOrEmpty(message)) {
      sb.append("?commit=");
    } else {
      sb.append("?commit=").append(message);
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
  public TimeoutInputStreamable<Build> asFile(String s) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public MessageAsFileTimeoutInputStreamable<Build> withAuthorEmail(String email) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }



  @Override
  public AuthorMessageAsFileTimeoutInputStreamable<Build> withCommitterEmail(String committerEmail) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }



  @Override
  public AsFileTimeoutInputStreamable<Build> withMessage(String message) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public AuthorEmailable<MessageAsFileTimeoutInputStreamable<Build>> withAuthorName(String authorName) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public CommitterEmailable<AuthorMessageAsFileTimeoutInputStreamable<Build>> withCommitterName(String committerName) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, timeoutUnit);
  }

  @Override
  public InputStreamable<Build> withTimeout(long timeout, TimeUnit unit) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeout, unit);
  }

  @Override
  public InputStreamable<Build> withTimeoutInMillis(long timeoutInMillis) {
    return new BuildConfigOperationsImpl(client, getConfig(), getAPIVersion(), getNamespace(), getName(), isCascading(), getItem(), getResourceVersion(), isReloadingFromServer(), getGracePeriodSeconds(), getLabels(), getLabelsNot(), getLabelsIn(), getLabelsNotIn(), getFields(), secret, triggerType, authorName, authorEmail, committerName, committerEmail, commit, message, asFile, timeoutInMillis, TimeUnit.MILLISECONDS);
  }

  private static class BuildConfigReaper implements Reaper {
    private BuildConfigOperationsImpl oper;

    public BuildConfigReaper(BuildConfigOperationsImpl oper) {
      this.oper = oper;
    }

    @Override
    public boolean reap() {
      oper.deleteBuilds();
      return false;
    }
  }
}
