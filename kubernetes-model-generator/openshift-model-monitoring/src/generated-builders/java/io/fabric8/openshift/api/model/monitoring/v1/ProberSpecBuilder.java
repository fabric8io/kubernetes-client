package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProberSpecBuilder extends ProberSpecFluent<ProberSpecBuilder> implements VisitableBuilder<ProberSpec,ProberSpecBuilder>{

  ProberSpecFluent<?> fluent;

  public ProberSpecBuilder() {
    this(new ProberSpec());
  }
  
  public ProberSpecBuilder(ProberSpecFluent<?> fluent) {
    this(fluent, new ProberSpec());
  }
  
  public ProberSpecBuilder(ProberSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProberSpecBuilder(ProberSpecFluent<?> fluent,ProberSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProberSpec build() {
    ProberSpec buildable = new ProberSpec(fluent.getNoProxy(), fluent.getPath(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.getScheme(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}