package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionRequestPodReferenceBuilder extends EvictionRequestPodReferenceFluent<EvictionRequestPodReferenceBuilder> implements VisitableBuilder<EvictionRequestPodReference,EvictionRequestPodReferenceBuilder>{

  EvictionRequestPodReferenceFluent<?> fluent;

  public EvictionRequestPodReferenceBuilder() {
    this(new EvictionRequestPodReference());
  }
  
  public EvictionRequestPodReferenceBuilder(EvictionRequestPodReferenceFluent<?> fluent) {
    this(fluent, new EvictionRequestPodReference());
  }
  
  public EvictionRequestPodReferenceBuilder(EvictionRequestPodReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionRequestPodReferenceBuilder(EvictionRequestPodReferenceFluent<?> fluent,EvictionRequestPodReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionRequestPodReference build() {
    EvictionRequestPodReference buildable = new EvictionRequestPodReference(fluent.getName(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}