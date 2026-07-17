package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DefaultNetworkDefinitionBuilder extends DefaultNetworkDefinitionFluent<DefaultNetworkDefinitionBuilder> implements VisitableBuilder<DefaultNetworkDefinition,DefaultNetworkDefinitionBuilder>{

  DefaultNetworkDefinitionFluent<?> fluent;

  public DefaultNetworkDefinitionBuilder() {
    this(new DefaultNetworkDefinition());
  }
  
  public DefaultNetworkDefinitionBuilder(DefaultNetworkDefinitionFluent<?> fluent) {
    this(fluent, new DefaultNetworkDefinition());
  }
  
  public DefaultNetworkDefinitionBuilder(DefaultNetworkDefinition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DefaultNetworkDefinitionBuilder(DefaultNetworkDefinitionFluent<?> fluent,DefaultNetworkDefinition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DefaultNetworkDefinition build() {
    DefaultNetworkDefinition buildable = new DefaultNetworkDefinition(fluent.buildOpenshiftSDNConfig(), fluent.buildOvnKubernetesConfig(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}