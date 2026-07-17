package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CoreV1TopologySpreadConstraintBuilder extends CoreV1TopologySpreadConstraintFluent<CoreV1TopologySpreadConstraintBuilder> implements VisitableBuilder<CoreV1TopologySpreadConstraint,CoreV1TopologySpreadConstraintBuilder>{

  CoreV1TopologySpreadConstraintFluent<?> fluent;

  public CoreV1TopologySpreadConstraintBuilder() {
    this(new CoreV1TopologySpreadConstraint());
  }
  
  public CoreV1TopologySpreadConstraintBuilder(CoreV1TopologySpreadConstraintFluent<?> fluent) {
    this(fluent, new CoreV1TopologySpreadConstraint());
  }
  
  public CoreV1TopologySpreadConstraintBuilder(CoreV1TopologySpreadConstraint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CoreV1TopologySpreadConstraintBuilder(CoreV1TopologySpreadConstraintFluent<?> fluent,CoreV1TopologySpreadConstraint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CoreV1TopologySpreadConstraint build() {
    CoreV1TopologySpreadConstraint buildable = new CoreV1TopologySpreadConstraint(fluent.buildLabelSelector(), fluent.getMatchLabelKeys(), fluent.getMaxSkew(), fluent.getMinDomains(), fluent.getNodeAffinityPolicy(), fluent.getNodeTaintsPolicy(), fluent.getTopologyKey(), fluent.getWhenUnsatisfiable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}