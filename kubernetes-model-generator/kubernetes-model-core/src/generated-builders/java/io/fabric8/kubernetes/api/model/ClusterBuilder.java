package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterBuilder extends ClusterFluent<ClusterBuilder> implements VisitableBuilder<Cluster,ClusterBuilder>{

  ClusterFluent<?> fluent;

  public ClusterBuilder() {
    this(new Cluster());
  }
  
  public ClusterBuilder(ClusterFluent<?> fluent) {
    this(fluent, new Cluster());
  }
  
  public ClusterBuilder(Cluster instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterBuilder(ClusterFluent<?> fluent,Cluster instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Cluster build() {
    Cluster buildable = new Cluster(fluent.getCertificateAuthority(), fluent.getCertificateAuthorityData(), fluent.getDisableCompression(), fluent.buildExtensions(), fluent.getInsecureSkipTlsVerify(), fluent.getProxyUrl(), fluent.getServer(), fluent.getTlsServerName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}