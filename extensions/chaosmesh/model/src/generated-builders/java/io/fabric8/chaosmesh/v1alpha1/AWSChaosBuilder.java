package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSChaosBuilder extends AWSChaosFluent<AWSChaosBuilder> implements VisitableBuilder<AWSChaos,AWSChaosBuilder>{

  AWSChaosFluent<?> fluent;

  public AWSChaosBuilder() {
    this(new AWSChaos());
  }
  
  public AWSChaosBuilder(AWSChaosFluent<?> fluent) {
    this(fluent, new AWSChaos());
  }
  
  public AWSChaosBuilder(AWSChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSChaosBuilder(AWSChaosFluent<?> fluent,AWSChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSChaos build() {
    AWSChaos buildable = new AWSChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}