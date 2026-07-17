package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterInstallConditionBuilder extends ClusterInstallConditionFluent<ClusterInstallConditionBuilder> implements VisitableBuilder<ClusterInstallCondition,ClusterInstallConditionBuilder>{

  ClusterInstallConditionFluent<?> fluent;

  public ClusterInstallConditionBuilder() {
    this(new ClusterInstallCondition());
  }
  
  public ClusterInstallConditionBuilder(ClusterInstallConditionFluent<?> fluent) {
    this(fluent, new ClusterInstallCondition());
  }
  
  public ClusterInstallConditionBuilder(ClusterInstallCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterInstallConditionBuilder(ClusterInstallConditionFluent<?> fluent,ClusterInstallCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterInstallCondition build() {
    ClusterInstallCondition buildable = new ClusterInstallCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}