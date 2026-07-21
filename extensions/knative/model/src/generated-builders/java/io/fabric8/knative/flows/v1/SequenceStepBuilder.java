package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SequenceStepBuilder extends SequenceStepFluent<SequenceStepBuilder> implements VisitableBuilder<SequenceStep,SequenceStepBuilder>{

  SequenceStepFluent<?> fluent;

  public SequenceStepBuilder() {
    this(new SequenceStep());
  }
  
  public SequenceStepBuilder(SequenceStepFluent<?> fluent) {
    this(fluent, new SequenceStep());
  }
  
  public SequenceStepBuilder(SequenceStep instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SequenceStepBuilder(SequenceStepFluent<?> fluent,SequenceStep instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SequenceStep build() {
    SequenceStep buildable = new SequenceStep(fluent.getCACerts(), fluent.getAudience(), fluent.buildDelivery(), fluent.buildRef(), fluent.getUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}