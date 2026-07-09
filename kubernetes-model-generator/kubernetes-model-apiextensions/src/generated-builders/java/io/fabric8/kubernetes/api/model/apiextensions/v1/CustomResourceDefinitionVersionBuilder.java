package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceDefinitionVersionBuilder extends CustomResourceDefinitionVersionFluent<CustomResourceDefinitionVersionBuilder> implements VisitableBuilder<CustomResourceDefinitionVersion,CustomResourceDefinitionVersionBuilder>{

  CustomResourceDefinitionVersionFluent<?> fluent;

  public CustomResourceDefinitionVersionBuilder() {
    this(new CustomResourceDefinitionVersion());
  }
  
  public CustomResourceDefinitionVersionBuilder(CustomResourceDefinitionVersionFluent<?> fluent) {
    this(fluent, new CustomResourceDefinitionVersion());
  }
  
  public CustomResourceDefinitionVersionBuilder(CustomResourceDefinitionVersion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceDefinitionVersionBuilder(CustomResourceDefinitionVersionFluent<?> fluent,CustomResourceDefinitionVersion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceDefinitionVersion build() {
    CustomResourceDefinitionVersion buildable = new CustomResourceDefinitionVersion(fluent.buildAdditionalPrinterColumns(), fluent.getDeprecated(), fluent.getDeprecationWarning(), fluent.getName(), fluent.buildSchema(), fluent.buildSelectableFields(), fluent.getServed(), fluent.getStorage(), fluent.buildSubresources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}