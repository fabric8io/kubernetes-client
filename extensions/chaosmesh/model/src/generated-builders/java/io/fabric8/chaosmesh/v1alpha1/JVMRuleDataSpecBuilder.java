package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMRuleDataSpecBuilder extends JVMRuleDataSpecFluent<JVMRuleDataSpecBuilder> implements VisitableBuilder<JVMRuleDataSpec,JVMRuleDataSpecBuilder>{

  JVMRuleDataSpecFluent<?> fluent;

  public JVMRuleDataSpecBuilder() {
    this(new JVMRuleDataSpec());
  }
  
  public JVMRuleDataSpecBuilder(JVMRuleDataSpecFluent<?> fluent) {
    this(fluent, new JVMRuleDataSpec());
  }
  
  public JVMRuleDataSpecBuilder(JVMRuleDataSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMRuleDataSpecBuilder(JVMRuleDataSpecFluent<?> fluent,JVMRuleDataSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMRuleDataSpec build() {
    JVMRuleDataSpec buildable = new JVMRuleDataSpec(fluent.getPid(), fluent.getPort(), fluent.getRuleData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}