package io.fabric8.openshift.api.model.installer.gcp.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QuotaUsageBuilder extends QuotaUsageFluent<QuotaUsageBuilder> implements VisitableBuilder<QuotaUsage,QuotaUsageBuilder>{

  QuotaUsageFluent<?> fluent;

  public QuotaUsageBuilder() {
    this(new QuotaUsage());
  }
  
  public QuotaUsageBuilder(QuotaUsageFluent<?> fluent) {
    this(fluent, new QuotaUsage());
  }
  
  public QuotaUsageBuilder(QuotaUsage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QuotaUsageBuilder(QuotaUsageFluent<?> fluent,QuotaUsage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QuotaUsage build() {
    QuotaUsage buildable = new QuotaUsage(fluent.getAmount(), fluent.getDimensions(), fluent.getLimit(), fluent.getService());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}