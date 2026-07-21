package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterIssuerListBuilder extends ClusterIssuerListFluent<ClusterIssuerListBuilder> implements VisitableBuilder<ClusterIssuerList,ClusterIssuerListBuilder>{

  ClusterIssuerListFluent<?> fluent;

  public ClusterIssuerListBuilder() {
    this(new ClusterIssuerList());
  }
  
  public ClusterIssuerListBuilder(ClusterIssuerListFluent<?> fluent) {
    this(fluent, new ClusterIssuerList());
  }
  
  public ClusterIssuerListBuilder(ClusterIssuerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterIssuerListBuilder(ClusterIssuerListFluent<?> fluent,ClusterIssuerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterIssuerList build() {
    ClusterIssuerList buildable = new ClusterIssuerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}