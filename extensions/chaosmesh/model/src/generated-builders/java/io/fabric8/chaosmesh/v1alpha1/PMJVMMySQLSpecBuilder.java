package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PMJVMMySQLSpecBuilder extends PMJVMMySQLSpecFluent<PMJVMMySQLSpecBuilder> implements VisitableBuilder<PMJVMMySQLSpec,PMJVMMySQLSpecBuilder>{

  PMJVMMySQLSpecFluent<?> fluent;

  public PMJVMMySQLSpecBuilder() {
    this(new PMJVMMySQLSpec());
  }
  
  public PMJVMMySQLSpecBuilder(PMJVMMySQLSpecFluent<?> fluent) {
    this(fluent, new PMJVMMySQLSpec());
  }
  
  public PMJVMMySQLSpecBuilder(PMJVMMySQLSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PMJVMMySQLSpecBuilder(PMJVMMySQLSpecFluent<?> fluent,PMJVMMySQLSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PMJVMMySQLSpec build() {
    PMJVMMySQLSpec buildable = new PMJVMMySQLSpec(fluent.getDatabase(), fluent.getException(), fluent.getLatency(), fluent.getMysqlConnectorVersion(), fluent.getPid(), fluent.getPort(), fluent.getSqlType(), fluent.getTable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}