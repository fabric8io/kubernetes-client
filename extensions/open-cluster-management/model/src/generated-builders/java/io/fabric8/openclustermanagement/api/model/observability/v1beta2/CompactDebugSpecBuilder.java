package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompactDebugSpecBuilder extends CompactDebugSpecFluent<CompactDebugSpecBuilder> implements VisitableBuilder<CompactDebugSpec,CompactDebugSpecBuilder>{

  CompactDebugSpecFluent<?> fluent;

  public CompactDebugSpecBuilder() {
    this(new CompactDebugSpec());
  }
  
  public CompactDebugSpecBuilder(CompactDebugSpecFluent<?> fluent) {
    this(fluent, new CompactDebugSpec());
  }
  
  public CompactDebugSpecBuilder(CompactDebugSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompactDebugSpecBuilder(CompactDebugSpecFluent<?> fluent,CompactDebugSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompactDebugSpec build() {
    CompactDebugSpec buildable = new CompactDebugSpec(fluent.getBlockMetaFetchConcurrency(), fluent.getDownsampleConcurrency(), fluent.getLogLevel(), fluent.getWaitInterval());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}