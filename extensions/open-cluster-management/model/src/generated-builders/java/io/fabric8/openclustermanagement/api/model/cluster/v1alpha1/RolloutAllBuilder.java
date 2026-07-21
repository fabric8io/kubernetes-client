package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RolloutAllBuilder extends RolloutAllFluent<RolloutAllBuilder> implements VisitableBuilder<RolloutAll,RolloutAllBuilder>{

  RolloutAllFluent<?> fluent;

  public RolloutAllBuilder() {
    this(new RolloutAll());
  }
  
  public RolloutAllBuilder(RolloutAllFluent<?> fluent) {
    this(fluent, new RolloutAll());
  }
  
  public RolloutAllBuilder(RolloutAll instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RolloutAllBuilder(RolloutAllFluent<?> fluent,RolloutAll instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RolloutAll build() {
    RolloutAll buildable = new RolloutAll(fluent.buildMaxFailures(), fluent.getMinSuccessTime(), fluent.getProgressDeadline());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}