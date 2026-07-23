package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomResourceDefinitionsBuilder extends CustomResourceDefinitionsFluent<CustomResourceDefinitionsBuilder> implements VisitableBuilder<CustomResourceDefinitions,CustomResourceDefinitionsBuilder>{

  CustomResourceDefinitionsFluent<?> fluent;

  public CustomResourceDefinitionsBuilder() {
    this(new CustomResourceDefinitions());
  }
  
  public CustomResourceDefinitionsBuilder(CustomResourceDefinitionsFluent<?> fluent) {
    this(fluent, new CustomResourceDefinitions());
  }
  
  public CustomResourceDefinitionsBuilder(CustomResourceDefinitions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomResourceDefinitionsBuilder(CustomResourceDefinitionsFluent<?> fluent,CustomResourceDefinitions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomResourceDefinitions build() {
    CustomResourceDefinitions buildable = new CustomResourceDefinitions(fluent.buildOwned(), fluent.buildRequired());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}