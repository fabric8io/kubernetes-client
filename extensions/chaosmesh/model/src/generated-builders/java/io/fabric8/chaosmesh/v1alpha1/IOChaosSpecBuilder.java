package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IOChaosSpecBuilder extends IOChaosSpecFluent<IOChaosSpecBuilder> implements VisitableBuilder<IOChaosSpec,IOChaosSpecBuilder>{

  IOChaosSpecFluent<?> fluent;

  public IOChaosSpecBuilder() {
    this(new IOChaosSpec());
  }
  
  public IOChaosSpecBuilder(IOChaosSpecFluent<?> fluent) {
    this(fluent, new IOChaosSpec());
  }
  
  public IOChaosSpecBuilder(IOChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IOChaosSpecBuilder(IOChaosSpecFluent<?> fluent,IOChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IOChaosSpec build() {
    IOChaosSpec buildable = new IOChaosSpec(fluent.getAction(), fluent.buildAttr(), fluent.getContainerNames(), fluent.getDelay(), fluent.getDuration(), fluent.getErrno(), fluent.getMethods(), fluent.buildMistake(), fluent.getMode(), fluent.getPath(), fluent.getPercent(), fluent.getRemoteCluster(), fluent.buildSelector(), fluent.getValue(), fluent.getVolumePath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}