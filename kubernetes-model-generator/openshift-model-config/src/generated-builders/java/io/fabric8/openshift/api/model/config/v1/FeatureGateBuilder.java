package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureGateBuilder extends FeatureGateFluent<FeatureGateBuilder> implements VisitableBuilder<FeatureGate,FeatureGateBuilder>{

  FeatureGateFluent<?> fluent;

  public FeatureGateBuilder() {
    this(new FeatureGate());
  }
  
  public FeatureGateBuilder(FeatureGateFluent<?> fluent) {
    this(fluent, new FeatureGate());
  }
  
  public FeatureGateBuilder(FeatureGate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureGateBuilder(FeatureGateFluent<?> fluent,FeatureGate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureGate build() {
    FeatureGate buildable = new FeatureGate(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}