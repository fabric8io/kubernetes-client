package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProbeListBuilder extends ProbeListFluent<ProbeListBuilder> implements VisitableBuilder<ProbeList,ProbeListBuilder>{

  ProbeListFluent<?> fluent;

  public ProbeListBuilder() {
    this(new ProbeList());
  }
  
  public ProbeListBuilder(ProbeListFluent<?> fluent) {
    this(fluent, new ProbeList());
  }
  
  public ProbeListBuilder(ProbeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProbeListBuilder(ProbeListFluent<?> fluent,ProbeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProbeList build() {
    ProbeList buildable = new ProbeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}