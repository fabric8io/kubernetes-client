package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSChaosListBuilder extends AWSChaosListFluent<AWSChaosListBuilder> implements VisitableBuilder<AWSChaosList,AWSChaosListBuilder>{

  AWSChaosListFluent<?> fluent;

  public AWSChaosListBuilder() {
    this(new AWSChaosList());
  }
  
  public AWSChaosListBuilder(AWSChaosListFluent<?> fluent) {
    this(fluent, new AWSChaosList());
  }
  
  public AWSChaosListBuilder(AWSChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSChaosListBuilder(AWSChaosListFluent<?> fluent,AWSChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSChaosList build() {
    AWSChaosList buildable = new AWSChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}