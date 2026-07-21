package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RetentionConfigBuilder extends RetentionConfigFluent<RetentionConfigBuilder> implements VisitableBuilder<RetentionConfig,RetentionConfigBuilder>{

  RetentionConfigFluent<?> fluent;

  public RetentionConfigBuilder() {
    this(new RetentionConfig());
  }
  
  public RetentionConfigBuilder(RetentionConfigFluent<?> fluent) {
    this(fluent, new RetentionConfig());
  }
  
  public RetentionConfigBuilder(RetentionConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RetentionConfigBuilder(RetentionConfigFluent<?> fluent,RetentionConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RetentionConfig build() {
    RetentionConfig buildable = new RetentionConfig(fluent.getBlockDuration(), fluent.getDeleteDelay(), fluent.getRetentionInLocal(), fluent.getRetentionResolution1h(), fluent.getRetentionResolution5m(), fluent.getRetentionResolutionRaw());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}