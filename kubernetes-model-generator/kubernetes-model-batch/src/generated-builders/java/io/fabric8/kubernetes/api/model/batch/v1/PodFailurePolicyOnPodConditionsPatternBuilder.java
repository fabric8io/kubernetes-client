package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodFailurePolicyOnPodConditionsPatternBuilder extends PodFailurePolicyOnPodConditionsPatternFluent<PodFailurePolicyOnPodConditionsPatternBuilder> implements VisitableBuilder<PodFailurePolicyOnPodConditionsPattern,PodFailurePolicyOnPodConditionsPatternBuilder>{

  PodFailurePolicyOnPodConditionsPatternFluent<?> fluent;

  public PodFailurePolicyOnPodConditionsPatternBuilder() {
    this(new PodFailurePolicyOnPodConditionsPattern());
  }
  
  public PodFailurePolicyOnPodConditionsPatternBuilder(PodFailurePolicyOnPodConditionsPatternFluent<?> fluent) {
    this(fluent, new PodFailurePolicyOnPodConditionsPattern());
  }
  
  public PodFailurePolicyOnPodConditionsPatternBuilder(PodFailurePolicyOnPodConditionsPattern instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodFailurePolicyOnPodConditionsPatternBuilder(PodFailurePolicyOnPodConditionsPatternFluent<?> fluent,PodFailurePolicyOnPodConditionsPattern instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodFailurePolicyOnPodConditionsPattern build() {
    PodFailurePolicyOnPodConditionsPattern buildable = new PodFailurePolicyOnPodConditionsPattern(fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}