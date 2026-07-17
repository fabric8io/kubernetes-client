package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureGatesEnabledBuilder extends FeatureGatesEnabledFluent<FeatureGatesEnabledBuilder> implements VisitableBuilder<FeatureGatesEnabled,FeatureGatesEnabledBuilder>{

  FeatureGatesEnabledFluent<?> fluent;

  public FeatureGatesEnabledBuilder() {
    this(new FeatureGatesEnabled());
  }
  
  public FeatureGatesEnabledBuilder(FeatureGatesEnabledFluent<?> fluent) {
    this(fluent, new FeatureGatesEnabled());
  }
  
  public FeatureGatesEnabledBuilder(FeatureGatesEnabled instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureGatesEnabledBuilder(FeatureGatesEnabledFluent<?> fluent,FeatureGatesEnabled instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureGatesEnabled build() {
    FeatureGatesEnabled buildable = new FeatureGatesEnabled(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}