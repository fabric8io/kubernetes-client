package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RolloutConfigBuilder extends RolloutConfigFluent<RolloutConfigBuilder> implements VisitableBuilder<RolloutConfig,RolloutConfigBuilder>{

  RolloutConfigFluent<?> fluent;

  public RolloutConfigBuilder() {
    this(new RolloutConfig());
  }
  
  public RolloutConfigBuilder(RolloutConfigFluent<?> fluent) {
    this(fluent, new RolloutConfig());
  }
  
  public RolloutConfigBuilder(RolloutConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RolloutConfigBuilder(RolloutConfigFluent<?> fluent,RolloutConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RolloutConfig build() {
    RolloutConfig buildable = new RolloutConfig(fluent.buildMaxFailures(), fluent.getMinSuccessTime(), fluent.getProgressDeadline());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}