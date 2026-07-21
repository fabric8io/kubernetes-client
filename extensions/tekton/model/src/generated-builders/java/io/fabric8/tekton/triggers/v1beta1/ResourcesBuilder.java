package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourcesBuilder extends ResourcesFluent<ResourcesBuilder> implements VisitableBuilder<Resources,ResourcesBuilder>{

  ResourcesFluent<?> fluent;

  public ResourcesBuilder() {
    this(new Resources());
  }
  
  public ResourcesBuilder(ResourcesFluent<?> fluent) {
    this(fluent, new Resources());
  }
  
  public ResourcesBuilder(Resources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourcesBuilder(ResourcesFluent<?> fluent,Resources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Resources build() {
    Resources buildable = new Resources(fluent.buildCustomResource(), fluent.buildKubernetesResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}