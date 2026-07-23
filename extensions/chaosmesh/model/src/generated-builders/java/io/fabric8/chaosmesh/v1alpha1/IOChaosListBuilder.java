package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IOChaosListBuilder extends IOChaosListFluent<IOChaosListBuilder> implements VisitableBuilder<IOChaosList,IOChaosListBuilder>{

  IOChaosListFluent<?> fluent;

  public IOChaosListBuilder() {
    this(new IOChaosList());
  }
  
  public IOChaosListBuilder(IOChaosListFluent<?> fluent) {
    this(fluent, new IOChaosList());
  }
  
  public IOChaosListBuilder(IOChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IOChaosListBuilder(IOChaosListFluent<?> fluent,IOChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IOChaosList build() {
    IOChaosList buildable = new IOChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}