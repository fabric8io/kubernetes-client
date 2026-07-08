package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SysctlBuilder extends SysctlFluent<SysctlBuilder> implements VisitableBuilder<Sysctl,SysctlBuilder>{

  SysctlFluent<?> fluent;

  public SysctlBuilder() {
    this(new Sysctl());
  }
  
  public SysctlBuilder(SysctlFluent<?> fluent) {
    this(fluent, new Sysctl());
  }
  
  public SysctlBuilder(Sysctl instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SysctlBuilder(SysctlFluent<?> fluent,Sysctl instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Sysctl build() {
    Sysctl buildable = new Sysctl(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}