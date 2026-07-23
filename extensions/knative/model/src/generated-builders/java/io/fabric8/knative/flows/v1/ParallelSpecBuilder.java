package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParallelSpecBuilder extends ParallelSpecFluent<ParallelSpecBuilder> implements VisitableBuilder<ParallelSpec,ParallelSpecBuilder>{

  ParallelSpecFluent<?> fluent;

  public ParallelSpecBuilder() {
    this(new ParallelSpec());
  }
  
  public ParallelSpecBuilder(ParallelSpecFluent<?> fluent) {
    this(fluent, new ParallelSpec());
  }
  
  public ParallelSpecBuilder(ParallelSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParallelSpecBuilder(ParallelSpecFluent<?> fluent,ParallelSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParallelSpec build() {
    ParallelSpec buildable = new ParallelSpec(fluent.buildBranches(), fluent.buildChannelTemplate(), fluent.buildReply());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}