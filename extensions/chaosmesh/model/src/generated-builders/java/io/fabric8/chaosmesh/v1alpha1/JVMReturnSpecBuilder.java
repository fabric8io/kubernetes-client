package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMReturnSpecBuilder extends JVMReturnSpecFluent<JVMReturnSpecBuilder> implements VisitableBuilder<JVMReturnSpec,JVMReturnSpecBuilder>{

  JVMReturnSpecFluent<?> fluent;

  public JVMReturnSpecBuilder() {
    this(new JVMReturnSpec());
  }
  
  public JVMReturnSpecBuilder(JVMReturnSpecFluent<?> fluent) {
    this(fluent, new JVMReturnSpec());
  }
  
  public JVMReturnSpecBuilder(JVMReturnSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMReturnSpecBuilder(JVMReturnSpecFluent<?> fluent,JVMReturnSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMReturnSpec build() {
    JVMReturnSpec buildable = new JVMReturnSpec(fluent.getClassName(), fluent.getMethod(), fluent.getPid(), fluent.getPort(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}