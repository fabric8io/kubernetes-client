package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceParamBuilder extends ResourceParamFluent<ResourceParamBuilder> implements VisitableBuilder<ResourceParam,ResourceParamBuilder>{

  ResourceParamFluent<?> fluent;

  public ResourceParamBuilder() {
    this(new ResourceParam());
  }
  
  public ResourceParamBuilder(ResourceParamFluent<?> fluent) {
    this(fluent, new ResourceParam());
  }
  
  public ResourceParamBuilder(ResourceParam instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceParamBuilder(ResourceParamFluent<?> fluent,ResourceParam instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceParam build() {
    ResourceParam buildable = new ResourceParam(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}