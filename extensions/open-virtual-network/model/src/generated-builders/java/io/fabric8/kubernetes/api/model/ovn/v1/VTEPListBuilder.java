package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VTEPListBuilder extends VTEPListFluent<VTEPListBuilder> implements VisitableBuilder<VTEPList,VTEPListBuilder>{

  VTEPListFluent<?> fluent;

  public VTEPListBuilder() {
    this(new VTEPList());
  }
  
  public VTEPListBuilder(VTEPListFluent<?> fluent) {
    this(fluent, new VTEPList());
  }
  
  public VTEPListBuilder(VTEPList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VTEPListBuilder(VTEPListFluent<?> fluent,VTEPList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VTEPList build() {
    VTEPList buildable = new VTEPList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}