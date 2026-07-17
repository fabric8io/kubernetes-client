package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BasicAuthBuilder extends BasicAuthFluent<BasicAuthBuilder> implements VisitableBuilder<BasicAuth,BasicAuthBuilder>{

  BasicAuthFluent<?> fluent;

  public BasicAuthBuilder() {
    this(new BasicAuth());
  }
  
  public BasicAuthBuilder(BasicAuthFluent<?> fluent) {
    this(fluent, new BasicAuth());
  }
  
  public BasicAuthBuilder(BasicAuth instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BasicAuthBuilder(BasicAuthFluent<?> fluent,BasicAuth instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BasicAuth build() {
    BasicAuth buildable = new BasicAuth(fluent.getPassword(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}