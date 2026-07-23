package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureGateSelectionBuilder extends FeatureGateSelectionFluent<FeatureGateSelectionBuilder> implements VisitableBuilder<FeatureGateSelection,FeatureGateSelectionBuilder>{

  FeatureGateSelectionFluent<?> fluent;

  public FeatureGateSelectionBuilder() {
    this(new FeatureGateSelection());
  }
  
  public FeatureGateSelectionBuilder(FeatureGateSelectionFluent<?> fluent) {
    this(fluent, new FeatureGateSelection());
  }
  
  public FeatureGateSelectionBuilder(FeatureGateSelection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureGateSelectionBuilder(FeatureGateSelectionFluent<?> fluent,FeatureGateSelection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureGateSelection build() {
    FeatureGateSelection buildable = new FeatureGateSelection(fluent.buildCustomNoUpgrade(), fluent.getFeatureSet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}