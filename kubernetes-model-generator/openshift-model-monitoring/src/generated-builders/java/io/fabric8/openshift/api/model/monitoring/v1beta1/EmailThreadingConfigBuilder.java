package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EmailThreadingConfigBuilder extends EmailThreadingConfigFluent<EmailThreadingConfigBuilder> implements VisitableBuilder<EmailThreadingConfig,EmailThreadingConfigBuilder>{

  EmailThreadingConfigFluent<?> fluent;

  public EmailThreadingConfigBuilder() {
    this(new EmailThreadingConfig());
  }
  
  public EmailThreadingConfigBuilder(EmailThreadingConfigFluent<?> fluent) {
    this(fluent, new EmailThreadingConfig());
  }
  
  public EmailThreadingConfigBuilder(EmailThreadingConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EmailThreadingConfigBuilder(EmailThreadingConfigFluent<?> fluent,EmailThreadingConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EmailThreadingConfig build() {
    EmailThreadingConfig buildable = new EmailThreadingConfig(fluent.getThreadByDate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}