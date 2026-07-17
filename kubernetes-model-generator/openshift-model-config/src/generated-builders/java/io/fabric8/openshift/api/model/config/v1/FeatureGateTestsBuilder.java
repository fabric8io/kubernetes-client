package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureGateTestsBuilder extends FeatureGateTestsFluent<FeatureGateTestsBuilder> implements VisitableBuilder<FeatureGateTests,FeatureGateTestsBuilder>{

  FeatureGateTestsFluent<?> fluent;

  public FeatureGateTestsBuilder() {
    this(new FeatureGateTests());
  }
  
  public FeatureGateTestsBuilder(FeatureGateTestsFluent<?> fluent) {
    this(fluent, new FeatureGateTests());
  }
  
  public FeatureGateTestsBuilder(FeatureGateTests instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureGateTestsBuilder(FeatureGateTestsFluent<?> fluent,FeatureGateTests instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureGateTests build() {
    FeatureGateTests buildable = new FeatureGateTests(fluent.getFeatureGate(), fluent.buildTests());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}