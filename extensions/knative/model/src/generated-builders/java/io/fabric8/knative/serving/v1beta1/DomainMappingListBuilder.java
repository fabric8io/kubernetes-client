package io.fabric8.knative.serving.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DomainMappingListBuilder extends DomainMappingListFluent<DomainMappingListBuilder> implements VisitableBuilder<DomainMappingList,DomainMappingListBuilder>{

  DomainMappingListFluent<?> fluent;

  public DomainMappingListBuilder() {
    this(new DomainMappingList());
  }
  
  public DomainMappingListBuilder(DomainMappingListFluent<?> fluent) {
    this(fluent, new DomainMappingList());
  }
  
  public DomainMappingListBuilder(DomainMappingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DomainMappingListBuilder(DomainMappingListFluent<?> fluent,DomainMappingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DomainMappingList build() {
    DomainMappingList buildable = new DomainMappingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}