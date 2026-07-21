package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JWTHeaderBuilder extends JWTHeaderFluent<JWTHeaderBuilder> implements VisitableBuilder<JWTHeader,JWTHeaderBuilder>{

  JWTHeaderFluent<?> fluent;

  public JWTHeaderBuilder() {
    this(new JWTHeader());
  }
  
  public JWTHeaderBuilder(JWTHeaderFluent<?> fluent) {
    this(fluent, new JWTHeader());
  }
  
  public JWTHeaderBuilder(JWTHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JWTHeaderBuilder(JWTHeaderFluent<?> fluent,JWTHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JWTHeader build() {
    JWTHeader buildable = new JWTHeader(fluent.getName(), fluent.getPrefix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}