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
package io.fabric8.crd.generator.v1beta1.decorator;

import io.fabric8.crd.generator.CustomResourceConversionInfo;
import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceConversion;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionFluent;

public class SetCustomResourceConversionDecorator
    extends CustomResourceDefinitionDecorator<CustomResourceDefinitionFluent<?>> {

  private final CustomResourceConversionInfo conversionInfo;

  public SetCustomResourceConversionDecorator(String name, CustomResourceConversionInfo conversionInfo) {
    super(name);
    this.conversionInfo = conversionInfo;
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionFluent<?> item, ObjectMeta resourceMeta) {
    assertConversionNotYetConfigured(item, resourceMeta);

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
            .withConversionReviewVersions(conversionInfo.getConversionReviewVersions())
            .withNewWebhookClientConfig()
            .withUrl(conversionInfo.getUrl())
            .withNewService()
            .withName(conversionInfo.getServiceName())
            .withNamespace(conversionInfo.getServiceNamespace())
            .withPath(conversionInfo.getServicePath())
            .withPort(conversionInfo.getServicePort())
            .endService()
            .endWebhookClientConfig()
            .endConversion()
            .endSpec();
        break;
    }
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[] { CustomResourceDefinitionDecorator.class };
  }

  private void assertConversionNotYetConfigured(CustomResourceDefinitionFluent<?> item, ObjectMeta resourceMeta) {
    CustomResourceConversion existing = item.buildSpec().getConversion();
    if (existing != null) {
      throw new IllegalStateException(String.format(
          "'%s' custom resource contains a conversion configuration and it has already been configured. " +
              "The CustomResourceConversion can be configured only once.",
          resourceMeta.getName()));
    }
  }
}
