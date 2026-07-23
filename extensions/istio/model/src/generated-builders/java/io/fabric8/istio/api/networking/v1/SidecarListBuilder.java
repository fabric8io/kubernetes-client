package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SidecarListBuilder extends SidecarListFluent<SidecarListBuilder> implements VisitableBuilder<SidecarList,SidecarListBuilder>{

  SidecarListFluent<?> fluent;

  public SidecarListBuilder() {
    this(new SidecarList());
  }
  
  public SidecarListBuilder(SidecarListFluent<?> fluent) {
    this(fluent, new SidecarList());
  }
  
  public SidecarListBuilder(SidecarList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SidecarListBuilder(SidecarListFluent<?> fluent,SidecarList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SidecarList build() {
    SidecarList buildable = new SidecarList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}