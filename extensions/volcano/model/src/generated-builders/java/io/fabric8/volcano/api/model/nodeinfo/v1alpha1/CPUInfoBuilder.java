package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CPUInfoBuilder extends CPUInfoFluent<CPUInfoBuilder> implements VisitableBuilder<CPUInfo,CPUInfoBuilder>{

  CPUInfoFluent<?> fluent;

  public CPUInfoBuilder() {
    this(new CPUInfo());
  }
  
  public CPUInfoBuilder(CPUInfoFluent<?> fluent) {
    this(fluent, new CPUInfo());
  }
  
  public CPUInfoBuilder(CPUInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CPUInfoBuilder(CPUInfoFluent<?> fluent,CPUInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CPUInfo build() {
    CPUInfo buildable = new CPUInfo(fluent.getCore(), fluent.getNuma(), fluent.getSocket());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}