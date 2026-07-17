package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureGateStatusBuilder extends FeatureGateStatusFluent<FeatureGateStatusBuilder> implements VisitableBuilder<FeatureGateStatus,FeatureGateStatusBuilder>{

  FeatureGateStatusFluent<?> fluent;

  public FeatureGateStatusBuilder() {
    this(new FeatureGateStatus());
  }
  
  public FeatureGateStatusBuilder(FeatureGateStatusFluent<?> fluent) {
    this(fluent, new FeatureGateStatus());
  }
  
  public FeatureGateStatusBuilder(FeatureGateStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureGateStatusBuilder(FeatureGateStatusFluent<?> fluent,FeatureGateStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureGateStatus build() {
    FeatureGateStatus buildable = new FeatureGateStatus(fluent.getConditions(), fluent.buildFeatureGates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}