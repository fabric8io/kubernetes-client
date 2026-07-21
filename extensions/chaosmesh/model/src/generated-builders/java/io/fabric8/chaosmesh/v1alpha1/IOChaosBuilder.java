package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IOChaosBuilder extends IOChaosFluent<IOChaosBuilder> implements VisitableBuilder<IOChaos,IOChaosBuilder>{

  IOChaosFluent<?> fluent;

  public IOChaosBuilder() {
    this(new IOChaos());
  }
  
  public IOChaosBuilder(IOChaosFluent<?> fluent) {
    this(fluent, new IOChaos());
  }
  
  public IOChaosBuilder(IOChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IOChaosBuilder(IOChaosFluent<?> fluent,IOChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IOChaos build() {
    IOChaos buildable = new IOChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}