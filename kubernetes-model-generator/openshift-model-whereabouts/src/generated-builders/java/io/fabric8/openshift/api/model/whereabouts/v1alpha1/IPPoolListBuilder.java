package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPPoolListBuilder extends IPPoolListFluent<IPPoolListBuilder> implements VisitableBuilder<IPPoolList,IPPoolListBuilder>{

  IPPoolListFluent<?> fluent;

  public IPPoolListBuilder() {
    this(new IPPoolList());
  }
  
  public IPPoolListBuilder(IPPoolListFluent<?> fluent) {
    this(fluent, new IPPoolList());
  }
  
  public IPPoolListBuilder(IPPoolList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPPoolListBuilder(IPPoolListFluent<?> fluent,IPPoolList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPPoolList build() {
    IPPoolList buildable = new IPPoolList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}