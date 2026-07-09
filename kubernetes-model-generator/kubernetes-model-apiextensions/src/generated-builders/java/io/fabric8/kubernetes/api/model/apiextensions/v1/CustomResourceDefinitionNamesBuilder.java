package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceDefinitionNamesBuilder extends CustomResourceDefinitionNamesFluent<CustomResourceDefinitionNamesBuilder> implements VisitableBuilder<CustomResourceDefinitionNames,CustomResourceDefinitionNamesBuilder>{

  CustomResourceDefinitionNamesFluent<?> fluent;

  public CustomResourceDefinitionNamesBuilder() {
    this(new CustomResourceDefinitionNames());
  }
  
  public CustomResourceDefinitionNamesBuilder(CustomResourceDefinitionNamesFluent<?> fluent) {
    this(fluent, new CustomResourceDefinitionNames());
  }
  
  public CustomResourceDefinitionNamesBuilder(CustomResourceDefinitionNames instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceDefinitionNamesBuilder(CustomResourceDefinitionNamesFluent<?> fluent,CustomResourceDefinitionNames instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceDefinitionNames build() {
    CustomResourceDefinitionNames buildable = new CustomResourceDefinitionNames(fluent.getCategories(), fluent.getKind(), fluent.getListKind(), fluent.getPlural(), fluent.getShortNames(), fluent.getSingular());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}