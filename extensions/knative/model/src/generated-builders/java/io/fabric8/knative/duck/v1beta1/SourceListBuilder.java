package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SourceListBuilder extends SourceListFluent<SourceListBuilder> implements VisitableBuilder<SourceList,SourceListBuilder>{

  SourceListFluent<?> fluent;

  public SourceListBuilder() {
    this(new SourceList());
  }
  
  public SourceListBuilder(SourceListFluent<?> fluent) {
    this(fluent, new SourceList());
  }
  
  public SourceListBuilder(SourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SourceListBuilder(SourceListFluent<?> fluent,SourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SourceList build() {
    SourceList buildable = new SourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}