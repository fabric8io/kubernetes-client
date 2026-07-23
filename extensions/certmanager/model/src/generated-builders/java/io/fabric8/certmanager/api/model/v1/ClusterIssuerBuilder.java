package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterIssuerBuilder extends ClusterIssuerFluent<ClusterIssuerBuilder> implements VisitableBuilder<ClusterIssuer,ClusterIssuerBuilder>{

  ClusterIssuerFluent<?> fluent;

  public ClusterIssuerBuilder() {
    this(new ClusterIssuer());
  }
  
  public ClusterIssuerBuilder(ClusterIssuerFluent<?> fluent) {
    this(fluent, new ClusterIssuer());
  }
  
  public ClusterIssuerBuilder(ClusterIssuer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterIssuerBuilder(ClusterIssuerFluent<?> fluent,ClusterIssuer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterIssuer build() {
    ClusterIssuer buildable = new ClusterIssuer(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}