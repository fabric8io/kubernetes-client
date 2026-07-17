package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GrpcPodConfigBuilder extends GrpcPodConfigFluent<GrpcPodConfigBuilder> implements VisitableBuilder<GrpcPodConfig,GrpcPodConfigBuilder>{

  GrpcPodConfigFluent<?> fluent;

  public GrpcPodConfigBuilder() {
    this(new GrpcPodConfig());
  }
  
  public GrpcPodConfigBuilder(GrpcPodConfigFluent<?> fluent) {
    this(fluent, new GrpcPodConfig());
  }
  
  public GrpcPodConfigBuilder(GrpcPodConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GrpcPodConfigBuilder(GrpcPodConfigFluent<?> fluent,GrpcPodConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GrpcPodConfig build() {
    GrpcPodConfig buildable = new GrpcPodConfig(fluent.getAffinity(), fluent.buildExtractContent(), fluent.getMemoryTarget(), fluent.getNodeSelector(), fluent.getPriorityClassName(), fluent.getSecurityContextConfig(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}