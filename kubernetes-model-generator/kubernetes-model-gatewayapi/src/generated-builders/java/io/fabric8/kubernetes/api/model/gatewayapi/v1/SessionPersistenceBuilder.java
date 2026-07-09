package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SessionPersistenceBuilder extends SessionPersistenceFluent<SessionPersistenceBuilder> implements VisitableBuilder<SessionPersistence,SessionPersistenceBuilder>{

  SessionPersistenceFluent<?> fluent;

  public SessionPersistenceBuilder() {
    this(new SessionPersistence());
  }
  
  public SessionPersistenceBuilder(SessionPersistenceFluent<?> fluent) {
    this(fluent, new SessionPersistence());
  }
  
  public SessionPersistenceBuilder(SessionPersistence instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SessionPersistenceBuilder(SessionPersistenceFluent<?> fluent,SessionPersistence instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SessionPersistence build() {
    SessionPersistence buildable = new SessionPersistence(fluent.getAbsoluteTimeout(), fluent.buildCookieConfig(), fluent.getIdleTimeout(), fluent.getSessionName(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}