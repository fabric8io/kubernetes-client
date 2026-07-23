package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClientConnectionOverridesBuilder extends ClientConnectionOverridesFluent<ClientConnectionOverridesBuilder> implements VisitableBuilder<ClientConnectionOverrides,ClientConnectionOverridesBuilder>{

  ClientConnectionOverridesFluent<?> fluent;

  public ClientConnectionOverridesBuilder() {
    this(new ClientConnectionOverrides());
  }
  
  public ClientConnectionOverridesBuilder(ClientConnectionOverridesFluent<?> fluent) {
    this(fluent, new ClientConnectionOverrides());
  }
  
  public ClientConnectionOverridesBuilder(ClientConnectionOverrides instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClientConnectionOverridesBuilder(ClientConnectionOverridesFluent<?> fluent,ClientConnectionOverrides instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClientConnectionOverrides build() {
    ClientConnectionOverrides buildable = new ClientConnectionOverrides(fluent.getAcceptContentTypes(), fluent.getBurst(), fluent.getContentType(), fluent.getQps());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}