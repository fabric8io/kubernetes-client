package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SidecarStateBuilder extends SidecarStateFluent<SidecarStateBuilder> implements VisitableBuilder<SidecarState,SidecarStateBuilder>{

  SidecarStateFluent<?> fluent;

  public SidecarStateBuilder() {
    this(new SidecarState());
  }
  
  public SidecarStateBuilder(SidecarStateFluent<?> fluent) {
    this(fluent, new SidecarState());
  }
  
  public SidecarStateBuilder(SidecarState instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SidecarStateBuilder(SidecarStateFluent<?> fluent,SidecarState instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SidecarState build() {
    SidecarState buildable = new SidecarState(fluent.getContainer(), fluent.getImageID(), fluent.getName(), fluent.getRunning(), fluent.getTerminated(), fluent.getWaiting());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}