package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParallelListBuilder extends ParallelListFluent<ParallelListBuilder> implements VisitableBuilder<ParallelList,ParallelListBuilder>{

  ParallelListFluent<?> fluent;

  public ParallelListBuilder() {
    this(new ParallelList());
  }
  
  public ParallelListBuilder(ParallelListFluent<?> fluent) {
    this(fluent, new ParallelList());
  }
  
  public ParallelListBuilder(ParallelList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParallelListBuilder(ParallelListFluent<?> fluent,ParallelList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParallelList build() {
    ParallelList buildable = new ParallelList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}