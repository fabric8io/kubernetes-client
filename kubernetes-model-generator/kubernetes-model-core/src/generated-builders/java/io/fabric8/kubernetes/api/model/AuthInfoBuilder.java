package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuthInfoBuilder extends AuthInfoFluent<AuthInfoBuilder> implements VisitableBuilder<AuthInfo,AuthInfoBuilder>{

  AuthInfoFluent<?> fluent;

  public AuthInfoBuilder() {
    this(new AuthInfo());
  }
  
  public AuthInfoBuilder(AuthInfoFluent<?> fluent) {
    this(fluent, new AuthInfo());
  }
  
  public AuthInfoBuilder(AuthInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuthInfoBuilder(AuthInfoFluent<?> fluent,AuthInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuthInfo build() {
    AuthInfo buildable = new AuthInfo(fluent.getAs(), fluent.getAsGroups(), fluent.getAsUid(), fluent.getAsUserExtra(), fluent.buildAuthProvider(), fluent.getClientCertificate(), fluent.getClientCertificateData(), fluent.getClientKey(), fluent.getClientKeyData(), fluent.buildExec(), fluent.buildExtensions(), fluent.getPassword(), fluent.getToken(), fluent.getTokenFile(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}