package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMExceptionSpecBuilder extends JVMExceptionSpecFluent<JVMExceptionSpecBuilder> implements VisitableBuilder<JVMExceptionSpec,JVMExceptionSpecBuilder>{

  JVMExceptionSpecFluent<?> fluent;

  public JVMExceptionSpecBuilder() {
    this(new JVMExceptionSpec());
  }
  
  public JVMExceptionSpecBuilder(JVMExceptionSpecFluent<?> fluent) {
    this(fluent, new JVMExceptionSpec());
  }
  
  public JVMExceptionSpecBuilder(JVMExceptionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMExceptionSpecBuilder(JVMExceptionSpecFluent<?> fluent,JVMExceptionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMExceptionSpec build() {
    JVMExceptionSpec buildable = new JVMExceptionSpec(fluent.getClassName(), fluent.getException(), fluent.getMethod(), fluent.getPid(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}