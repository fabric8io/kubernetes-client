package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JVMMySQLSpecBuilder extends JVMMySQLSpecFluent<JVMMySQLSpecBuilder> implements VisitableBuilder<JVMMySQLSpec,JVMMySQLSpecBuilder>{

  JVMMySQLSpecFluent<?> fluent;

  public JVMMySQLSpecBuilder() {
    this(new JVMMySQLSpec());
  }
  
  public JVMMySQLSpecBuilder(JVMMySQLSpecFluent<?> fluent) {
    this(fluent, new JVMMySQLSpec());
  }
  
  public JVMMySQLSpecBuilder(JVMMySQLSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JVMMySQLSpecBuilder(JVMMySQLSpecFluent<?> fluent,JVMMySQLSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JVMMySQLSpec build() {
    JVMMySQLSpec buildable = new JVMMySQLSpec(fluent.getDatabase(), fluent.getMysqlConnectorVersion(), fluent.getSqlType(), fluent.getTable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}