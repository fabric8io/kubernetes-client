package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMStressSpecBuilder extends JVMStressSpecFluent<JVMStressSpecBuilder> implements VisitableBuilder<JVMStressSpec,JVMStressSpecBuilder>{

  JVMStressSpecFluent<?> fluent;

  public JVMStressSpecBuilder() {
    this(new JVMStressSpec());
  }
  
  public JVMStressSpecBuilder(JVMStressSpecFluent<?> fluent) {
    this(fluent, new JVMStressSpec());
  }
  
  public JVMStressSpecBuilder(JVMStressSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMStressSpecBuilder(JVMStressSpecFluent<?> fluent,JVMStressSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMStressSpec build() {
    JVMStressSpec buildable = new JVMStressSpec(fluent.getCpuCount(), fluent.getMemType(), fluent.getPid(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}