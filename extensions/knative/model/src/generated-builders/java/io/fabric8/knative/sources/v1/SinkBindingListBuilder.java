package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SinkBindingListBuilder extends SinkBindingListFluent<SinkBindingListBuilder> implements VisitableBuilder<SinkBindingList,SinkBindingListBuilder>{

  SinkBindingListFluent<?> fluent;

  public SinkBindingListBuilder() {
    this(new SinkBindingList());
  }
  
  public SinkBindingListBuilder(SinkBindingListFluent<?> fluent) {
    this(fluent, new SinkBindingList());
  }
  
  public SinkBindingListBuilder(SinkBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SinkBindingListBuilder(SinkBindingListFluent<?> fluent,SinkBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SinkBindingList build() {
    SinkBindingList buildable = new SinkBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}