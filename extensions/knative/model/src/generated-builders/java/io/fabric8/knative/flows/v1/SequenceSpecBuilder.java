package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SequenceSpecBuilder extends SequenceSpecFluent<SequenceSpecBuilder> implements VisitableBuilder<SequenceSpec,SequenceSpecBuilder>{

  SequenceSpecFluent<?> fluent;

  public SequenceSpecBuilder() {
    this(new SequenceSpec());
  }
  
  public SequenceSpecBuilder(SequenceSpecFluent<?> fluent) {
    this(fluent, new SequenceSpec());
  }
  
  public SequenceSpecBuilder(SequenceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SequenceSpecBuilder(SequenceSpecFluent<?> fluent,SequenceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SequenceSpec build() {
    SequenceSpec buildable = new SequenceSpec(fluent.buildChannelTemplate(), fluent.buildReply(), fluent.buildSteps());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}