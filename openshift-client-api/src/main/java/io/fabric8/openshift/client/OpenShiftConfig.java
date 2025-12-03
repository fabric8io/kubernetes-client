/*
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
package io.fabric8.openshift.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.SundrioConfig;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.client.readiness.OpenShiftReadiness;

import java.net.MalformedURLException;
import java.net.URL;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true, allowSetters = true)
public class OpenShiftConfig extends Config {

  public static final String KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY = "kubernetes.oapi.version";
  public static final String OPENSHIFT_URL_SYSTEM_PROPERTY = "openshift.url";
  public static final String OPENSHIFT_BUILD_TIMEOUT_SYSTEM_PROPERTY = "openshift.build.timeout";

  public static final String DISABLE_API_GROUP_CHECK = "disableApiGroupCheck";
  public static final String OPENSHIFT_URL = "openShiftUrl";
  public static final String BUILD_TIMEOUT = "buildTimeout";
  public static final String OAPI_VERSION = "oapiVersion";

  public static final Long DEFAULT_BUILD_TIMEOUT = 5 * 60 * 1000L;

  //This is not meant to be used. This constructor is used only by the generated builder.
  OpenShiftConfig() {
    super(!disableAutoConfig());
  }

  @JsonCreator(mode = Mode.DELEGATING)
  public OpenShiftConfig(SundrioConfig config) {
    this(config, null, null, null, null);
  }

  public OpenShiftConfig(Config kubernetesConfig) {
    this(kubernetesConfig, null, null, null, null);
  }

  OpenShiftConfig(SundrioConfig kubernetesConfig, String openShiftUrl, String oapiVersion, Long buildTimeout,
      Boolean disableApiGroupCheck) {
    super(kubernetesConfig); // init the base state - including setting defaults
    if (oapiVersion == null) {
      oapiVersion = getDefaultOapiVersion(getApiVersion());
    }

    this.setOapiVersion(oapiVersion);
    this.setBuildTimeout(buildTimeout);
    this.setDisableApiGroupCheck(disableApiGroupCheck);

    if (openShiftUrl == null) {
      openShiftUrl = getDefaultOpenShiftUrl(getMasterUrl(), oapiVersion);
    }

    if (openShiftUrl == null || openShiftUrl.isEmpty()) {
      openShiftUrl = URLUtils.join(getMasterUrl(), "oapi", oapiVersion);
    }
    if (!openShiftUrl.endsWith("/")) {
      openShiftUrl += "/";
    }
    this.setOpenShiftUrl(openShiftUrl);
  }

  public static OpenShiftConfig wrap(Config config) {
    return config instanceof OpenShiftConfig ? (OpenShiftConfig) config : new OpenShiftConfig(config);
  }

  private static String getDefaultOapiVersion(String apiVersion) {
    return Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY, apiVersion);
  }

  private static String getDefaultOpenShiftUrl(String masterUrl, String oapiVersion) {
    String openshiftUrl = Utils.getSystemPropertyOrEnvVar(OPENSHIFT_URL_SYSTEM_PROPERTY);
    if (openshiftUrl != null) {
      // The OPENSHIFT_URL environment variable may be set to the root url (i.e. without the '/oapi/version' path) in some configurations
      if (isRootURL(openshiftUrl)) {
        openshiftUrl = URLUtils.join(openshiftUrl, "oapi", oapiVersion);
      }
      return openshiftUrl;
    } else {
      return URLUtils.join(masterUrl, "oapi", oapiVersion);
    }
  }

  private static boolean isRootURL(String url) {
    try {
      String path = new URL(url).getPath();
      return "".equals(path) || "/".equals(path);
    } catch (MalformedURLException e) {
      return false;
    }
  }

  @JsonIgnore
  public String getOapiVersion() {
    return (String) this.getAdditionalProperties().getOrDefault(OAPI_VERSION, "v1");
  }

  public void setOapiVersion(String oapiVersion) {
    this.getAdditionalProperties().put(OAPI_VERSION, oapiVersion);
  }

  @JsonIgnore
  public String getOpenShiftUrl() {
    return (String) this.getAdditionalProperties().get(OPENSHIFT_URL);
  }

  public void setOpenShiftUrl(String openShiftUrl) {
    this.getAdditionalProperties().put(OPENSHIFT_URL, openShiftUrl);
  }

  public Long getBuildTimeout() {
    return (Long) this.getAdditionalProperties().getOrDefault(BUILD_TIMEOUT, DEFAULT_BUILD_TIMEOUT);
  }

  public void setBuildTimeout(long buildTimeout) {
    setBuildTimeout(Long.valueOf(buildTimeout));
  }

  public void setBuildTimeout(Long buildTimeout) {
    if (buildTimeout == null) {
      this.getAdditionalProperties().remove(BUILD_TIMEOUT);
    } else {
      this.getAdditionalProperties().put(BUILD_TIMEOUT, buildTimeout);
    }
  }

  @JsonIgnore
  public boolean isDisableApiGroupCheck() {
    return Boolean.TRUE.equals(getAdditionalProperties().get(DISABLE_API_GROUP_CHECK));
  }

  public void setDisableApiGroupCheck(boolean disableApiGroupCheck) {
    setDisableApiGroupCheck(Boolean.valueOf(disableApiGroupCheck));
  }

  public void setDisableApiGroupCheck(Boolean disableApiGroupCheck) {
    if (disableApiGroupCheck == null) {
      this.getAdditionalProperties().remove(DISABLE_API_GROUP_CHECK);
    } else {
      this.getAdditionalProperties().put(DISABLE_API_GROUP_CHECK, disableApiGroupCheck);
    }
  }

  @Override
  public Readiness getReadiness() {
    return OpenShiftReadiness.getInstance();
  }

}
