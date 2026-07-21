package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMChaosSpecBuilder extends JVMChaosSpecFluent<JVMChaosSpecBuilder> implements VisitableBuilder<JVMChaosSpec,JVMChaosSpecBuilder>{

  JVMChaosSpecFluent<?> fluent;

  public JVMChaosSpecBuilder() {
    this(new JVMChaosSpec());
  }
  
  public JVMChaosSpecBuilder(JVMChaosSpecFluent<?> fluent) {
    this(fluent, new JVMChaosSpec());
  }
  
  public JVMChaosSpecBuilder(JVMChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMChaosSpecBuilder(JVMChaosSpecFluent<?> fluent,JVMChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMChaosSpec build() {
    JVMChaosSpec buildable = new JVMChaosSpec(fluent.getAction(), fluent.getClassName(), fluent.getContainerNames(), fluent.getCpuCount(), fluent.getDatabase(), fluent.getDuration(), fluent.getException(), fluent.getLatency(), fluent.getMemType(), fluent.getMethod(), fluent.getMode(), fluent.getMysqlConnectorVersion(), fluent.getName(), fluent.getPid(), fluent.getPort(), fluent.getRemoteCluster(), fluent.getReturnValue(), fluent.getRuleData(), fluent.buildSelector(), fluent.getSqlType(), fluent.getTable(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}