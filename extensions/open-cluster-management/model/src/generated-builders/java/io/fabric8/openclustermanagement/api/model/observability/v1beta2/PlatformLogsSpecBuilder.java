package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformLogsSpecBuilder extends PlatformLogsSpecFluent<PlatformLogsSpecBuilder> implements VisitableBuilder<PlatformLogsSpec,PlatformLogsSpecBuilder>{

  PlatformLogsSpecFluent<?> fluent;

  public PlatformLogsSpecBuilder() {
    this(new PlatformLogsSpec());
  }
  
  public PlatformLogsSpecBuilder(PlatformLogsSpecFluent<?> fluent) {
    this(fluent, new PlatformLogsSpec());
  }
  
  public PlatformLogsSpecBuilder(PlatformLogsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformLogsSpecBuilder(PlatformLogsSpecFluent<?> fluent,PlatformLogsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlatformLogsSpec build() {
    PlatformLogsSpec buildable = new PlatformLogsSpec(fluent.buildCollection());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}