package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureGateSpecBuilder extends FeatureGateSpecFluent<FeatureGateSpecBuilder> implements VisitableBuilder<FeatureGateSpec,FeatureGateSpecBuilder>{

  FeatureGateSpecFluent<?> fluent;

  public FeatureGateSpecBuilder() {
    this(new FeatureGateSpec());
  }
  
  public FeatureGateSpecBuilder(FeatureGateSpecFluent<?> fluent) {
    this(fluent, new FeatureGateSpec());
  }
  
  public FeatureGateSpecBuilder(FeatureGateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureGateSpecBuilder(FeatureGateSpecFluent<?> fluent,FeatureGateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureGateSpec build() {
    FeatureGateSpec buildable = new FeatureGateSpec(fluent.buildCustomNoUpgrade(), fluent.getFeatureSet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}