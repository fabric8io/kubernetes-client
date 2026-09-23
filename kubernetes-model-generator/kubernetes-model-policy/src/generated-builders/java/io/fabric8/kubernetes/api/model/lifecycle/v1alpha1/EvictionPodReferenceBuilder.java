package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionPodReferenceBuilder extends EvictionPodReferenceFluent<EvictionPodReferenceBuilder> implements VisitableBuilder<EvictionPodReference,EvictionPodReferenceBuilder>{

  EvictionPodReferenceFluent<?> fluent;

  public EvictionPodReferenceBuilder() {
    this(new EvictionPodReference());
  }
  
  public EvictionPodReferenceBuilder(EvictionPodReferenceFluent<?> fluent) {
    this(fluent, new EvictionPodReference());
  }
  
  public EvictionPodReferenceBuilder(EvictionPodReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionPodReferenceBuilder(EvictionPodReferenceFluent<?> fluent,EvictionPodReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionPodReference build() {
    EvictionPodReference buildable = new EvictionPodReference(fluent.getName(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}