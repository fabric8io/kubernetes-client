package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BootstrapKubeConfigsBuilder extends BootstrapKubeConfigsFluent<BootstrapKubeConfigsBuilder> implements VisitableBuilder<BootstrapKubeConfigs,BootstrapKubeConfigsBuilder>{

  BootstrapKubeConfigsFluent<?> fluent;

  public BootstrapKubeConfigsBuilder() {
    this(new BootstrapKubeConfigs());
  }
  
  public BootstrapKubeConfigsBuilder(BootstrapKubeConfigsFluent<?> fluent) {
    this(fluent, new BootstrapKubeConfigs());
  }
  
  public BootstrapKubeConfigsBuilder(BootstrapKubeConfigs instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BootstrapKubeConfigsBuilder(BootstrapKubeConfigsFluent<?> fluent,BootstrapKubeConfigs instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BootstrapKubeConfigs build() {
    BootstrapKubeConfigs buildable = new BootstrapKubeConfigs(fluent.buildLocalSecretsConfig(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}