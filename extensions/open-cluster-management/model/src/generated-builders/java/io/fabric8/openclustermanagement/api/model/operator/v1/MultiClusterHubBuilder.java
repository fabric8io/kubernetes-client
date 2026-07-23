package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MultiClusterHubBuilder extends MultiClusterHubFluent<MultiClusterHubBuilder> implements VisitableBuilder<MultiClusterHub,MultiClusterHubBuilder>{

  MultiClusterHubFluent<?> fluent;

  public MultiClusterHubBuilder() {
    this(new MultiClusterHub());
  }
  
  public MultiClusterHubBuilder(MultiClusterHubFluent<?> fluent) {
    this(fluent, new MultiClusterHub());
  }
  
  public MultiClusterHubBuilder(MultiClusterHub instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MultiClusterHubBuilder(MultiClusterHubFluent<?> fluent,MultiClusterHub instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MultiClusterHub build() {
    MultiClusterHub buildable = new MultiClusterHub(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}