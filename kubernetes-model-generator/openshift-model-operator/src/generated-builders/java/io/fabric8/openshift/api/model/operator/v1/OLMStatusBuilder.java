package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OLMStatusBuilder extends OLMStatusFluent<OLMStatusBuilder> implements VisitableBuilder<OLMStatus,OLMStatusBuilder>{

  OLMStatusFluent<?> fluent;

  public OLMStatusBuilder() {
    this(new OLMStatus());
  }
  
  public OLMStatusBuilder(OLMStatusFluent<?> fluent) {
    this(fluent, new OLMStatus());
  }
  
  public OLMStatusBuilder(OLMStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OLMStatusBuilder(OLMStatusFluent<?> fluent,OLMStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OLMStatus build() {
    OLMStatus buildable = new OLMStatus(fluent.buildConditions(), fluent.buildGenerations(), fluent.getLatestAvailableRevision(), fluent.getObservedGeneration(), fluent.getReadyReplicas(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}