package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMStressCfgSpecBuilder extends JVMStressCfgSpecFluent<JVMStressCfgSpecBuilder> implements VisitableBuilder<JVMStressCfgSpec,JVMStressCfgSpecBuilder>{

  JVMStressCfgSpecFluent<?> fluent;

  public JVMStressCfgSpecBuilder() {
    this(new JVMStressCfgSpec());
  }
  
  public JVMStressCfgSpecBuilder(JVMStressCfgSpecFluent<?> fluent) {
    this(fluent, new JVMStressCfgSpec());
  }
  
  public JVMStressCfgSpecBuilder(JVMStressCfgSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMStressCfgSpecBuilder(JVMStressCfgSpecFluent<?> fluent,JVMStressCfgSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMStressCfgSpec build() {
    JVMStressCfgSpec buildable = new JVMStressCfgSpec(fluent.getCpuCount(), fluent.getMemType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}