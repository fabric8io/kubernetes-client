package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyAuditConfigBuilder extends PolicyAuditConfigFluent<PolicyAuditConfigBuilder> implements VisitableBuilder<PolicyAuditConfig,PolicyAuditConfigBuilder>{

  PolicyAuditConfigFluent<?> fluent;

  public PolicyAuditConfigBuilder() {
    this(new PolicyAuditConfig());
  }
  
  public PolicyAuditConfigBuilder(PolicyAuditConfigFluent<?> fluent) {
    this(fluent, new PolicyAuditConfig());
  }
  
  public PolicyAuditConfigBuilder(PolicyAuditConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyAuditConfigBuilder(PolicyAuditConfigFluent<?> fluent,PolicyAuditConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyAuditConfig build() {
    PolicyAuditConfig buildable = new PolicyAuditConfig(fluent.getDestination(), fluent.getMaxFileSize(), fluent.getMaxLogFiles(), fluent.getRateLimit(), fluent.getSyslogFacility());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}