package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceDefinitionListBuilder extends CustomResourceDefinitionListFluent<CustomResourceDefinitionListBuilder> implements VisitableBuilder<CustomResourceDefinitionList,CustomResourceDefinitionListBuilder>{

  CustomResourceDefinitionListFluent<?> fluent;

  public CustomResourceDefinitionListBuilder() {
    this(new CustomResourceDefinitionList());
  }
  
  public CustomResourceDefinitionListBuilder(CustomResourceDefinitionListFluent<?> fluent) {
    this(fluent, new CustomResourceDefinitionList());
  }
  
  public CustomResourceDefinitionListBuilder(CustomResourceDefinitionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceDefinitionListBuilder(CustomResourceDefinitionListFluent<?> fluent,CustomResourceDefinitionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceDefinitionList build() {
    CustomResourceDefinitionList buildable = new CustomResourceDefinitionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}