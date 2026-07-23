package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPPoolSpecAllocationsBuilder extends IPPoolSpecAllocationsFluent<IPPoolSpecAllocationsBuilder> implements VisitableBuilder<IPPoolSpecAllocations,IPPoolSpecAllocationsBuilder>{

  IPPoolSpecAllocationsFluent<?> fluent;

  public IPPoolSpecAllocationsBuilder() {
    this(new IPPoolSpecAllocations());
  }
  
  public IPPoolSpecAllocationsBuilder(IPPoolSpecAllocationsFluent<?> fluent) {
    this(fluent, new IPPoolSpecAllocations());
  }
  
  public IPPoolSpecAllocationsBuilder(IPPoolSpecAllocations instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPPoolSpecAllocationsBuilder(IPPoolSpecAllocationsFluent<?> fluent,IPPoolSpecAllocations instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPPoolSpecAllocations build() {
    IPPoolSpecAllocations buildable = new IPPoolSpecAllocations(fluent.getId(), fluent.getIfname(), fluent.getPodref());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}