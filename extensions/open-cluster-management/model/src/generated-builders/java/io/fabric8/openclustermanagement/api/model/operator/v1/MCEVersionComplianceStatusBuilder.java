package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MCEVersionComplianceStatusBuilder extends MCEVersionComplianceStatusFluent<MCEVersionComplianceStatusBuilder> implements VisitableBuilder<MCEVersionComplianceStatus,MCEVersionComplianceStatusBuilder>{

  MCEVersionComplianceStatusFluent<?> fluent;

  public MCEVersionComplianceStatusBuilder() {
    this(new MCEVersionComplianceStatus());
  }
  
  public MCEVersionComplianceStatusBuilder(MCEVersionComplianceStatusFluent<?> fluent) {
    this(fluent, new MCEVersionComplianceStatus());
  }
  
  public MCEVersionComplianceStatusBuilder(MCEVersionComplianceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MCEVersionComplianceStatusBuilder(MCEVersionComplianceStatusFluent<?> fluent,MCEVersionComplianceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MCEVersionComplianceStatus build() {
    MCEVersionComplianceStatus buildable = new MCEVersionComplianceStatus(fluent.getCurrentVersion(), fluent.getIsCompliant(), fluent.getMessage(), fluent.getRequiredChannel());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}