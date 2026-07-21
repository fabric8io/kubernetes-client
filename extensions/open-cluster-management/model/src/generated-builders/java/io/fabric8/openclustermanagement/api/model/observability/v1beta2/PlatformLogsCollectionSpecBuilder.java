package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformLogsCollectionSpecBuilder extends PlatformLogsCollectionSpecFluent<PlatformLogsCollectionSpecBuilder> implements VisitableBuilder<PlatformLogsCollectionSpec,PlatformLogsCollectionSpecBuilder>{

  PlatformLogsCollectionSpecFluent<?> fluent;

  public PlatformLogsCollectionSpecBuilder() {
    this(new PlatformLogsCollectionSpec());
  }
  
  public PlatformLogsCollectionSpecBuilder(PlatformLogsCollectionSpecFluent<?> fluent) {
    this(fluent, new PlatformLogsCollectionSpec());
  }
  
  public PlatformLogsCollectionSpecBuilder(PlatformLogsCollectionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformLogsCollectionSpecBuilder(PlatformLogsCollectionSpecFluent<?> fluent,PlatformLogsCollectionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformLogsCollectionSpec build() {
    PlatformLogsCollectionSpec buildable = new PlatformLogsCollectionSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}