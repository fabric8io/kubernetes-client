package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostPortBuilder extends HostPortFluent<HostPortBuilder> implements VisitableBuilder<HostPort,HostPortBuilder>{

  HostPortFluent<?> fluent;

  public HostPortBuilder() {
    this(new HostPort());
  }
  
  public HostPortBuilder(HostPortFluent<?> fluent) {
    this(fluent, new HostPort());
  }
  
  public HostPortBuilder(HostPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostPortBuilder(HostPortFluent<?> fluent,HostPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostPort build() {
    HostPort buildable = new HostPort(fluent.getHost(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}