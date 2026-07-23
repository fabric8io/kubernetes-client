package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SessionAffinityConfigBuilder extends SessionAffinityConfigFluent<SessionAffinityConfigBuilder> implements VisitableBuilder<SessionAffinityConfig,SessionAffinityConfigBuilder>{

  SessionAffinityConfigFluent<?> fluent;

  public SessionAffinityConfigBuilder() {
    this(new SessionAffinityConfig());
  }
  
  public SessionAffinityConfigBuilder(SessionAffinityConfigFluent<?> fluent) {
    this(fluent, new SessionAffinityConfig());
  }
  
  public SessionAffinityConfigBuilder(SessionAffinityConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SessionAffinityConfigBuilder(SessionAffinityConfigFluent<?> fluent,SessionAffinityConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SessionAffinityConfig build() {
    SessionAffinityConfig buildable = new SessionAffinityConfig(fluent.buildClientIP());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}