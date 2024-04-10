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
package io.fabric8.crd.generator.v1.decorator;

import io.fabric8.crd.generator.CustomResourceConversionInfo;
import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceConversion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionFluent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetCustomResourceConversionDecorator
    extends CustomResourceDefinitionDecorator<CustomResourceDefinitionFluent<?>> {

  private static final Logger LOGGER = LoggerFactory.getLogger(SetCustomResourceConversionDecorator.class);

  private final CustomResourceConversionInfo conversionInfo;

  public SetCustomResourceConversionDecorator(String name, CustomResourceConversionInfo conversionInfo) {
    super(name);
    this.conversionInfo = conversionInfo;
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionFluent<?> item, ObjectMeta resourceMeta) {
    assertConversionNotYetConfigured(item.buildSpec().getConversion(), resourceMeta);

    switch (conversionInfo.getStrategy()) {
      case None:
        item.editSpec().withNewConversion()
            .withStrategy(conversionInfo.getStrategy().name())
            .endConversion()
            .endSpec();
        break;
      case Webhook:
        item.editSpec().withNewConversion()
            .withStrategy(conversionInfo.getStrategy().name())
            .withNewWebhook()
            .withConversionReviewVersions(conversionInfo.getConversionReviewVersions())
            .withNewClientConfig()
            .withUrl(conversionInfo.getUrl())
            .withNewService()
            .withName(conversionInfo.getServiceName())
            .withNamespace(conversionInfo.getServiceNamespace())
            .withPath(conversionInfo.getServicePath())
            .withPort(conversionInfo.getServicePort())
            .endService()
            .endClientConfig()
            .endWebhook()
            .endConversion()
            .endSpec();
        break;
      default:
        LOGGER.warn("Unknown CustomResourceConversion strategy: {}", conversionInfo.getStrategy());
        break;
    }
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[] { CustomResourceDefinitionDecorator.class };
  }

  private void assertConversionNotYetConfigured(CustomResourceConversion existing, ObjectMeta resourceMeta) {
    if (existing != null) {
      throw new IllegalStateException(String.format(
          "'%s' custom resource contains a conversion configuration and it has already been configured. " +
              "CustomResourceConversion must be configured only once.",
          resourceMeta.getName()));
    }
  }

  @Override
  public String toString() {
    return getClass().getName() + " [name:" + getName() + ", conversionInfo:" + conversionInfo + "]";
  }
}
