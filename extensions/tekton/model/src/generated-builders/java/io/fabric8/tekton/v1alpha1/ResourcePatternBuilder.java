package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourcePatternBuilder extends ResourcePatternFluent<ResourcePatternBuilder> implements VisitableBuilder<ResourcePattern,ResourcePatternBuilder>{

  ResourcePatternFluent<?> fluent;

  public ResourcePatternBuilder() {
    this(new ResourcePattern());
  }
  
  public ResourcePatternBuilder(ResourcePatternFluent<?> fluent) {
    this(fluent, new ResourcePattern());
  }
  
  public ResourcePatternBuilder(ResourcePattern instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourcePatternBuilder(ResourcePatternFluent<?> fluent,ResourcePattern instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourcePattern build() {
    ResourcePattern buildable = new ResourcePattern(fluent.getPattern());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}