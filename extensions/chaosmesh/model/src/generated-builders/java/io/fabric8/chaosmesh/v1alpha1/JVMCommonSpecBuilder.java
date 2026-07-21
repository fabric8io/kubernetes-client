package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMCommonSpecBuilder extends JVMCommonSpecFluent<JVMCommonSpecBuilder> implements VisitableBuilder<JVMCommonSpec,JVMCommonSpecBuilder>{

  JVMCommonSpecFluent<?> fluent;

  public JVMCommonSpecBuilder() {
    this(new JVMCommonSpec());
  }
  
  public JVMCommonSpecBuilder(JVMCommonSpecFluent<?> fluent) {
    this(fluent, new JVMCommonSpec());
  }
  
  public JVMCommonSpecBuilder(JVMCommonSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMCommonSpecBuilder(JVMCommonSpecFluent<?> fluent,JVMCommonSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMCommonSpec build() {
    JVMCommonSpec buildable = new JVMCommonSpec(fluent.getPid(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}