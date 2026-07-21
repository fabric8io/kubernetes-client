package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMGCSpecBuilder extends JVMGCSpecFluent<JVMGCSpecBuilder> implements VisitableBuilder<JVMGCSpec,JVMGCSpecBuilder>{

  JVMGCSpecFluent<?> fluent;

  public JVMGCSpecBuilder() {
    this(new JVMGCSpec());
  }
  
  public JVMGCSpecBuilder(JVMGCSpecFluent<?> fluent) {
    this(fluent, new JVMGCSpec());
  }
  
  public JVMGCSpecBuilder(JVMGCSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMGCSpecBuilder(JVMGCSpecFluent<?> fluent,JVMGCSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMGCSpec build() {
    JVMGCSpec buildable = new JVMGCSpec(fluent.getPid(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}