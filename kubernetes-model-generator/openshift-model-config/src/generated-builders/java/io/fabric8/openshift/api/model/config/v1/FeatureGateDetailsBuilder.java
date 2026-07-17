package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureGateDetailsBuilder extends FeatureGateDetailsFluent<FeatureGateDetailsBuilder> implements VisitableBuilder<FeatureGateDetails,FeatureGateDetailsBuilder>{

  FeatureGateDetailsFluent<?> fluent;

  public FeatureGateDetailsBuilder() {
    this(new FeatureGateDetails());
  }
  
  public FeatureGateDetailsBuilder(FeatureGateDetailsFluent<?> fluent) {
    this(fluent, new FeatureGateDetails());
  }
  
  public FeatureGateDetailsBuilder(FeatureGateDetails instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureGateDetailsBuilder(FeatureGateDetailsFluent<?> fluent,FeatureGateDetails instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureGateDetails build() {
    FeatureGateDetails buildable = new FeatureGateDetails(fluent.buildDisabled(), fluent.buildEnabled(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}