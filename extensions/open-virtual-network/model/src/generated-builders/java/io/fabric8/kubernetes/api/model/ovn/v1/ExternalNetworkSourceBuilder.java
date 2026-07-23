package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalNetworkSourceBuilder extends ExternalNetworkSourceFluent<ExternalNetworkSourceBuilder> implements VisitableBuilder<ExternalNetworkSource,ExternalNetworkSourceBuilder>{

  ExternalNetworkSourceFluent<?> fluent;

  public ExternalNetworkSourceBuilder() {
    this(new ExternalNetworkSource());
  }
  
  public ExternalNetworkSourceBuilder(ExternalNetworkSourceFluent<?> fluent) {
    this(fluent, new ExternalNetworkSource());
  }
  
  public ExternalNetworkSourceBuilder(ExternalNetworkSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalNetworkSourceBuilder(ExternalNetworkSourceFluent<?> fluent,ExternalNetworkSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalNetworkSource build() {
    ExternalNetworkSource buildable = new ExternalNetworkSource(fluent.buildNamespaceSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}