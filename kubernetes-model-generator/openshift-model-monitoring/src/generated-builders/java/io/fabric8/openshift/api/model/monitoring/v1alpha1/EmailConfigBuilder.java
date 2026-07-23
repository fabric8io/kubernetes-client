package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmailConfigBuilder extends EmailConfigFluent<EmailConfigBuilder> implements VisitableBuilder<EmailConfig,EmailConfigBuilder>{

  EmailConfigFluent<?> fluent;

  public EmailConfigBuilder() {
    this(new EmailConfig());
  }
  
  public EmailConfigBuilder(EmailConfigFluent<?> fluent) {
    this(fluent, new EmailConfig());
  }
  
  public EmailConfigBuilder(EmailConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmailConfigBuilder(EmailConfigFluent<?> fluent,EmailConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmailConfig build() {
    EmailConfig buildable = new EmailConfig(fluent.getAuthIdentity(), fluent.getAuthPassword(), fluent.getAuthSecret(), fluent.getAuthUsername(), fluent.getForceImplicitTLS(), fluent.getFrom(), fluent.buildHeaders(), fluent.getHello(), fluent.getHtml(), fluent.getRequireTLS(), fluent.getSendResolved(), fluent.getSmarthost(), fluent.getText(), fluent.buildThreading(), fluent.buildTlsConfig(), fluent.getTo());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}