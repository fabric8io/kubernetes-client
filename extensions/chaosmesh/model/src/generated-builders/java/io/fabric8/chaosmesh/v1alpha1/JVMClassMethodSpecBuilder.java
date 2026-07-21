package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMClassMethodSpecBuilder extends JVMClassMethodSpecFluent<JVMClassMethodSpecBuilder> implements VisitableBuilder<JVMClassMethodSpec,JVMClassMethodSpecBuilder>{

  JVMClassMethodSpecFluent<?> fluent;

  public JVMClassMethodSpecBuilder() {
    this(new JVMClassMethodSpec());
  }
  
  public JVMClassMethodSpecBuilder(JVMClassMethodSpecFluent<?> fluent) {
    this(fluent, new JVMClassMethodSpec());
  }
  
  public JVMClassMethodSpecBuilder(JVMClassMethodSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMClassMethodSpecBuilder(JVMClassMethodSpecFluent<?> fluent,JVMClassMethodSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMClassMethodSpec build() {
    JVMClassMethodSpec buildable = new JVMClassMethodSpec(fluent.getClassName(), fluent.getMethod());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}