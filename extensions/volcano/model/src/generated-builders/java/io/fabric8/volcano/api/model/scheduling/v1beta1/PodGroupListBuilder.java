package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupListBuilder extends PodGroupListFluent<PodGroupListBuilder> implements VisitableBuilder<PodGroupList,PodGroupListBuilder>{

  PodGroupListFluent<?> fluent;

  public PodGroupListBuilder() {
    this(new PodGroupList());
  }
  
  public PodGroupListBuilder(PodGroupListFluent<?> fluent) {
    this(fluent, new PodGroupList());
  }
  
  public PodGroupListBuilder(PodGroupList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupListBuilder(PodGroupListFluent<?> fluent,PodGroupList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupList build() {
    PodGroupList buildable = new PodGroupList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}