package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CrossVersionObjectReferenceBuilder extends CrossVersionObjectReferenceFluent<CrossVersionObjectReferenceBuilder> implements VisitableBuilder<CrossVersionObjectReference,CrossVersionObjectReferenceBuilder>{

  CrossVersionObjectReferenceFluent<?> fluent;

  public CrossVersionObjectReferenceBuilder() {
    this(new CrossVersionObjectReference());
  }
  
  public CrossVersionObjectReferenceBuilder(CrossVersionObjectReferenceFluent<?> fluent) {
    this(fluent, new CrossVersionObjectReference());
  }
  
  public CrossVersionObjectReferenceBuilder(CrossVersionObjectReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CrossVersionObjectReferenceBuilder(CrossVersionObjectReferenceFluent<?> fluent,CrossVersionObjectReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CrossVersionObjectReference build() {
    CrossVersionObjectReference buildable = new CrossVersionObjectReference(fluent.getApiVersion(), fluent.getKind(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}