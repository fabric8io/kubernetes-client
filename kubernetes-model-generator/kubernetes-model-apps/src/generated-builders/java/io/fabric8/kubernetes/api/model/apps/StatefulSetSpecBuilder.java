package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatefulSetSpecBuilder extends StatefulSetSpecFluent<StatefulSetSpecBuilder> implements VisitableBuilder<StatefulSetSpec,StatefulSetSpecBuilder>{

  StatefulSetSpecFluent<?> fluent;

  public StatefulSetSpecBuilder() {
    this(new StatefulSetSpec());
  }
  
  public StatefulSetSpecBuilder(StatefulSetSpecFluent<?> fluent) {
    this(fluent, new StatefulSetSpec());
  }
  
  public StatefulSetSpecBuilder(StatefulSetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatefulSetSpecBuilder(StatefulSetSpecFluent<?> fluent,StatefulSetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatefulSetSpec build() {
    StatefulSetSpec buildable = new StatefulSetSpec(fluent.getMinReadySeconds(), fluent.buildOrdinals(), fluent.buildPersistentVolumeClaimRetentionPolicy(), fluent.getPodManagementPolicy(), fluent.getReplicas(), fluent.getRevisionHistoryLimit(), fluent.buildSelector(), fluent.getServiceName(), fluent.buildTemplate(), fluent.buildUpdateStrategy(), fluent.buildVolumeClaimTemplates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}