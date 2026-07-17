package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleAuthenticationBuilder extends ConsoleAuthenticationFluent<ConsoleAuthenticationBuilder> implements VisitableBuilder<ConsoleAuthentication,ConsoleAuthenticationBuilder>{

  ConsoleAuthenticationFluent<?> fluent;

  public ConsoleAuthenticationBuilder() {
    this(new ConsoleAuthentication());
  }
  
  public ConsoleAuthenticationBuilder(ConsoleAuthenticationFluent<?> fluent) {
    this(fluent, new ConsoleAuthentication());
  }
  
  public ConsoleAuthenticationBuilder(ConsoleAuthentication instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleAuthenticationBuilder(ConsoleAuthenticationFluent<?> fluent,ConsoleAuthentication instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleAuthentication build() {
    ConsoleAuthentication buildable = new ConsoleAuthentication(fluent.getLogoutRedirect());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}