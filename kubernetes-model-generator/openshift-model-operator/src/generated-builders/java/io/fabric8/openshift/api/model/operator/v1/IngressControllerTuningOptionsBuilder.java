package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerTuningOptionsBuilder extends IngressControllerTuningOptionsFluent<IngressControllerTuningOptionsBuilder> implements VisitableBuilder<IngressControllerTuningOptions,IngressControllerTuningOptionsBuilder>{

  IngressControllerTuningOptionsFluent<?> fluent;

  public IngressControllerTuningOptionsBuilder() {
    this(new IngressControllerTuningOptions());
  }
  
  public IngressControllerTuningOptionsBuilder(IngressControllerTuningOptionsFluent<?> fluent) {
    this(fluent, new IngressControllerTuningOptions());
  }
  
  public IngressControllerTuningOptionsBuilder(IngressControllerTuningOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerTuningOptionsBuilder(IngressControllerTuningOptionsFluent<?> fluent,IngressControllerTuningOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerTuningOptions build() {
    IngressControllerTuningOptions buildable = new IngressControllerTuningOptions(fluent.getClientFinTimeout(), fluent.getClientTimeout(), fluent.getConnectTimeout(), fluent.getHeaderBufferBytes(), fluent.getHeaderBufferMaxRewriteBytes(), fluent.getHealthCheckInterval(), fluent.getHttpKeepAliveTimeout(), fluent.getMaxConnections(), fluent.getReloadInterval(), fluent.getServerFinTimeout(), fluent.getServerTimeout(), fluent.getThreadCount(), fluent.getTlsInspectDelay(), fluent.getTunnelTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}