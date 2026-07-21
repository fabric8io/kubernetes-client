package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMParameterBuilder extends JVMParameterFluent<JVMParameterBuilder> implements VisitableBuilder<JVMParameter,JVMParameterBuilder>{

  JVMParameterFluent<?> fluent;

  public JVMParameterBuilder() {
    this(new JVMParameter());
  }
  
  public JVMParameterBuilder(JVMParameterFluent<?> fluent) {
    this(fluent, new JVMParameter());
  }
  
  public JVMParameterBuilder(JVMParameter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMParameterBuilder(JVMParameterFluent<?> fluent,JVMParameter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMParameter build() {
    JVMParameter buildable = new JVMParameter(fluent.getClassName(), fluent.getCpuCount(), fluent.getDatabase(), fluent.getException(), fluent.getLatency(), fluent.getMemType(), fluent.getMethod(), fluent.getMysqlConnectorVersion(), fluent.getName(), fluent.getPid(), fluent.getPort(), fluent.getReturnValue(), fluent.getRuleData(), fluent.getSqlType(), fluent.getTable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}