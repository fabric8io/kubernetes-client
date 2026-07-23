package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompliancePerClusterStatusBuilder extends CompliancePerClusterStatusFluent<CompliancePerClusterStatusBuilder> implements VisitableBuilder<CompliancePerClusterStatus,CompliancePerClusterStatusBuilder>{

  CompliancePerClusterStatusFluent<?> fluent;

  public CompliancePerClusterStatusBuilder() {
    this(new CompliancePerClusterStatus());
  }
  
  public CompliancePerClusterStatusBuilder(CompliancePerClusterStatusFluent<?> fluent) {
    this(fluent, new CompliancePerClusterStatus());
  }
  
  public CompliancePerClusterStatusBuilder(CompliancePerClusterStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompliancePerClusterStatusBuilder(CompliancePerClusterStatusFluent<?> fluent,CompliancePerClusterStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompliancePerClusterStatus build() {
    CompliancePerClusterStatus buildable = new CompliancePerClusterStatus(fluent.getClustername(), fluent.getClusternamespace(), fluent.getCompliant());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}