package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PortMapEntryBuilder extends PortMapEntryFluent<PortMapEntryBuilder> implements VisitableBuilder<PortMapEntry,PortMapEntryBuilder>{

  PortMapEntryFluent<?> fluent;

  public PortMapEntryBuilder() {
    this(new PortMapEntry());
  }
  
  public PortMapEntryBuilder(PortMapEntryFluent<?> fluent) {
    this(fluent, new PortMapEntry());
  }
  
  public PortMapEntryBuilder(PortMapEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PortMapEntryBuilder(PortMapEntryFluent<?> fluent,PortMapEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PortMapEntry build() {
    PortMapEntry buildable = new PortMapEntry(fluent.getContainerPort(), fluent.getHostIP(), fluent.getHostPort(), fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}