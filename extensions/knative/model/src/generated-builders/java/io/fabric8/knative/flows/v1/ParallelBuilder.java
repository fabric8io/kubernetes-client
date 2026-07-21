package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParallelBuilder extends ParallelFluent<ParallelBuilder> implements VisitableBuilder<Parallel,ParallelBuilder>{

  ParallelFluent<?> fluent;

  public ParallelBuilder() {
    this(new Parallel());
  }
  
  public ParallelBuilder(ParallelFluent<?> fluent) {
    this(fluent, new Parallel());
  }
  
  public ParallelBuilder(Parallel instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParallelBuilder(ParallelFluent<?> fluent,Parallel instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Parallel build() {
    Parallel buildable = new Parallel(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}