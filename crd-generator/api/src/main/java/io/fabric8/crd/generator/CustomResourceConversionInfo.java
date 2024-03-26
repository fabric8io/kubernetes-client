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
package io.fabric8.crd.generator;

import io.fabric8.crd.generator.annotation.NoneConversion;
import io.fabric8.crd.generator.annotation.WebhookConversion;
import io.fabric8.kubernetes.client.CustomResource;
import io.sundr.utils.Strings;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringJoiner;

import javax.lang.model.element.TypeElement;

public class CustomResourceConversionInfo {
  private final Strategy strategy;
  private final String[] conversionReviewVersions;
  private final String url;
  private final String serviceName;
  private final String serviceNamespace;
  private final String servicePath;
  private final Integer servicePort;

  private CustomResourceConversionInfo(Strategy strategy,
      String[] conversionReviewVersions,
      String url,
      String serviceName,
      String serviceNamespace,
      String servicePath,
      Integer servicePort) {
    this.strategy = strategy;
    this.conversionReviewVersions = conversionReviewVersions;
    this.url = url;
    this.serviceName = serviceName;
    this.serviceNamespace = serviceNamespace;
    this.servicePath = servicePath;
    this.servicePort = servicePort;
  }

  public Strategy getStrategy() {
    return strategy;
  }

  public String[] getConversionReviewVersions() {
    return conversionReviewVersions;
  }

  public String getUrl() {
    return url;
  }

  public String getServiceName() {
    return serviceName;
  }

  public String getServiceNamespace() {
    return serviceNamespace;
  }

  public String getServicePath() {
    return servicePath;
  }

  public Integer getServicePort() {
    return servicePort;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", CustomResourceConversionInfo.class.getSimpleName() + "[", "]")
        .add("strategy:'" + strategy + "'")
        .add("conversionsReviewVersions:" + Arrays.toString(conversionReviewVersions))
        .add("url: '" + url + "'")
        .add("serviceName: '" + serviceName + "'")
        .add("serviceNamespace: '" + serviceNamespace + "'")
        .add("servicePath: '" + servicePath + "'")
        .add("servicePort: " + servicePort)
        .toString();
  }

  public static Optional<CustomResourceConversionInfo> from(Class<? extends CustomResource<?, ?>> customResource) {
    return from(customResource.getAnnotation(NoneConversion.class),
        customResource.getAnnotation(WebhookConversion.class));
  }

  public static Optional<CustomResourceConversionInfo> from(TypeElement customResource) {
    return from(customResource.getAnnotation(NoneConversion.class),
        customResource.getAnnotation(WebhookConversion.class));
  }

  public static Optional<CustomResourceConversionInfo> from(
      NoneConversion noneConversion, WebhookConversion webhookConversion) {
    return Optional.ofNullable(Optional.ofNullable(noneConversion)
        .map(CustomResourceConversionInfo::from)
        .orElseGet(() -> Optional.ofNullable(webhookConversion)
            .map(CustomResourceConversionInfo::from)
            .orElse(null)));
  }

  public static CustomResourceConversionInfo from(NoneConversion noneConversion) {
    return new CustomResourceConversionInfo(Strategy.None,
        null, null, null, null, null, null);
  }

  public static CustomResourceConversionInfo from(WebhookConversion webhookConversion) {
    final String[] versions = webhookConversion.versions();
    final String url = mapNotEmpty(webhookConversion.url());
    final String serviceName = mapNotEmpty(webhookConversion.svcName());
    final String serviceNamespace = mapNotEmpty(webhookConversion.svcNamespace());
    final String servicePath = mapNotEmpty(webhookConversion.svcPath());
    final Integer servicePort = webhookConversion.svcPort() != 443 ? webhookConversion.svcPort() : null;

    assertUniqueConversionReviewVersions(versions);
    assertUrlOrService(url, serviceName, serviceNamespace, servicePath, servicePort);
    assertValidServicePort(servicePort);
    assertValidUrl(url);

    return new CustomResourceConversionInfo(Strategy.Webhook,
        versions,
        url,
        serviceName,
        serviceNamespace,
        servicePath,
        servicePort);
  }

  public enum Strategy {
    None,
    Webhook
  }

  private static void assertUniqueConversionReviewVersions(String[] versions) {
    if (Arrays.stream(versions).distinct().count() != versions.length) {
      throw new IllegalArgumentException(
          String.format("ConversionReviewVersions values must be distinct: %s", Arrays.toString(versions)));
    }
  }

  private static void assertUrlOrService(String url,
      String serviceName,
      String serviceNamespace,
      String servicePath,
      Integer servicePort) {
    if (url == null) {
      if (serviceName == null || serviceNamespace == null) {
        throw new IllegalArgumentException(String.format("Invalid WebhookConversion configuration: "
            + "Exactly one of URL or serviceNamespace/serviceName must be specified. "
            + "serviceNamespace: %s, serviceName: %s, servicePath: %s, servicePort: %s, URL: null",
            serviceNamespace, serviceName, servicePath, servicePort));
      }
    }

    if (url != null) {
      if (serviceName != null || serviceNamespace != null || servicePath != null || servicePort != null) {
        throw new IllegalArgumentException(String.format(
            "Invalid WebhookConversion configuration: "
                + "Exactly one of URL or serviceNamespace/serviceName must be specified. "
                + "serviceNamespace: %s, serviceName: %s, servicePath: %s, servicePort: %s, URL: %s",
            serviceNamespace, serviceName, servicePath, servicePort, url));
      }
    }
  }

  private static void assertValidServicePort(Integer servicePort) {
    if (servicePort != null) {
      if (servicePort < 1 || servicePort > 65535) {
        throw new IllegalArgumentException("Invalid WebhookConversion configuration: "
            + "Service port must be a valid port number (1-65535, inclusive). ServicePort: " + servicePort);
      }
    }
  }

  private static void assertValidUrl(String urlString) {
    if (urlString != null) {
      try {
        final URL url = new URL(urlString);
        if (!"https".equals(url.getProtocol())) {
          throw new IllegalArgumentException(
              String.format("Invalid WebhookConversion configuration: URL schema of %s is invalid. "
                  + "Only https:// is allowed.", urlString));
        }
        if (url.getQuery() != null) {
          throw new IllegalArgumentException(
              String.format("Invalid WebhookConversion configuration: URL %s contains query parameters "
                  + "which are not allowed.", urlString));
        }
        if (url.getRef() != null) {
          throw new IllegalArgumentException(
              String.format("Invalid WebhookConversion configuration: URL %s contains fragment(s) "
                  + "which is not allowed.", urlString));
        }
      } catch (MalformedURLException e) {
        throw new IllegalArgumentException(
            String.format("Invalid WebhookConversion configuration. Malformed URL: %s", e.getMessage()));
      }
    }
  }

  private static String mapNotEmpty(String s) {
    if (Strings.isNullOrEmpty(s)) {
      return null;
    }
    return s;
  }

}
