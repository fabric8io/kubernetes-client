package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PingSourceListBuilder extends PingSourceListFluent<PingSourceListBuilder> implements VisitableBuilder<PingSourceList,PingSourceListBuilder>{

  PingSourceListFluent<?> fluent;

  public PingSourceListBuilder() {
    this(new PingSourceList());
  }
  
  public PingSourceListBuilder(PingSourceListFluent<?> fluent) {
    this(fluent, new PingSourceList());
  }
  
  public PingSourceListBuilder(PingSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PingSourceListBuilder(PingSourceListFluent<?> fluent,PingSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PingSourceList build() {
    PingSourceList buildable = new PingSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}