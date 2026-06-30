package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BootstrapBuilder extends BootstrapFluent<BootstrapBuilder> implements VisitableBuilder<Bootstrap,BootstrapBuilder>{

  BootstrapFluent<?> fluent;

  public BootstrapBuilder() {
    this(new Bootstrap());
  }
  
  public BootstrapBuilder(BootstrapFluent<?> fluent) {
    this(fluent, new Bootstrap());
  }
  
  public BootstrapBuilder(Bootstrap instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BootstrapBuilder(BootstrapFluent<?> fluent,Bootstrap instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Bootstrap build() {
    Bootstrap buildable = new Bootstrap(fluent.buildConfigRef(), fluent.getDataSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}