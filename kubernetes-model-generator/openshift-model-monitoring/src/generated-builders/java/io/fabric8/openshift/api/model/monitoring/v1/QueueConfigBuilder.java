package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QueueConfigBuilder extends QueueConfigFluent<QueueConfigBuilder> implements VisitableBuilder<QueueConfig,QueueConfigBuilder>{

  QueueConfigFluent<?> fluent;

  public QueueConfigBuilder() {
    this(new QueueConfig());
  }
  
  public QueueConfigBuilder(QueueConfigFluent<?> fluent) {
    this(fluent, new QueueConfig());
  }
  
  public QueueConfigBuilder(QueueConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QueueConfigBuilder(QueueConfigFluent<?> fluent,QueueConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QueueConfig build() {
    QueueConfig buildable = new QueueConfig(fluent.getBatchSendDeadline(), fluent.getCapacity(), fluent.getMaxBackoff(), fluent.getMaxRetries(), fluent.getMaxSamplesPerSend(), fluent.getMaxShards(), fluent.getMinBackoff(), fluent.getMinShards(), fluent.getRetryOnRateLimit(), fluent.getSampleAgeLimit());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}