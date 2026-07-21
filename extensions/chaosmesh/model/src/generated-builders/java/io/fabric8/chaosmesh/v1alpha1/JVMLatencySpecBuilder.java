package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMLatencySpecBuilder extends JVMLatencySpecFluent<JVMLatencySpecBuilder> implements VisitableBuilder<JVMLatencySpec,JVMLatencySpecBuilder>{

  JVMLatencySpecFluent<?> fluent;

  public JVMLatencySpecBuilder() {
    this(new JVMLatencySpec());
  }
  
  public JVMLatencySpecBuilder(JVMLatencySpecFluent<?> fluent) {
    this(fluent, new JVMLatencySpec());
  }
  
  public JVMLatencySpecBuilder(JVMLatencySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMLatencySpecBuilder(JVMLatencySpecFluent<?> fluent,JVMLatencySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMLatencySpec build() {
    JVMLatencySpec buildable = new JVMLatencySpec(fluent.getClassName(), fluent.getLatency(), fluent.getMethod(), fluent.getPid(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}