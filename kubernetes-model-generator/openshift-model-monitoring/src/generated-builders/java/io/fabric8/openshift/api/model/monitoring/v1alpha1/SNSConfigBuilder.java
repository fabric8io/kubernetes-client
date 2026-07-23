package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SNSConfigBuilder extends SNSConfigFluent<SNSConfigBuilder> implements VisitableBuilder<SNSConfig,SNSConfigBuilder>{

  SNSConfigFluent<?> fluent;

  public SNSConfigBuilder() {
    this(new SNSConfig());
  }
  
  public SNSConfigBuilder(SNSConfigFluent<?> fluent) {
    this(fluent, new SNSConfig());
  }
  
  public SNSConfigBuilder(SNSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SNSConfigBuilder(SNSConfigFluent<?> fluent,SNSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SNSConfig build() {
    SNSConfig buildable = new SNSConfig(fluent.getApiURL(), fluent.getAttributes(), fluent.buildHttpConfig(), fluent.getMessage(), fluent.getPhoneNumber(), fluent.getSendResolved(), fluent.buildSigv4(), fluent.getSubject(), fluent.getTargetARN(), fluent.getTopicARN());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}