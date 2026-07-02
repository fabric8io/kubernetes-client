package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodListBuilder extends PodListFluent<PodListBuilder> implements VisitableBuilder<PodList,PodListBuilder>{

  PodListFluent<?> fluent;

  public PodListBuilder() {
    this(new PodList());
  }
  
  public PodListBuilder(PodListFluent<?> fluent) {
    this(fluent, new PodList());
  }
  
  public PodListBuilder(PodList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodListBuilder(PodListFluent<?> fluent,PodList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodList build() {
    PodList buildable = new PodList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}