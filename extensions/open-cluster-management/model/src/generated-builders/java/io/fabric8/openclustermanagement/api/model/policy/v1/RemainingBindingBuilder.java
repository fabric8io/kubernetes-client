package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemainingBindingBuilder extends RemainingBindingFluent<RemainingBindingBuilder> implements VisitableBuilder<RemainingBinding,RemainingBindingBuilder>{

  RemainingBindingFluent<?> fluent;

  public RemainingBindingBuilder() {
    this(new RemainingBinding());
  }
  
  public RemainingBindingBuilder(RemainingBindingFluent<?> fluent) {
    this(fluent, new RemainingBinding());
  }
  
  public RemainingBindingBuilder(RemainingBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemainingBindingBuilder(RemainingBindingFluent<?> fluent,RemainingBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemainingBinding build() {
    RemainingBinding buildable = new RemainingBinding(fluent.getPlacementBinding());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}