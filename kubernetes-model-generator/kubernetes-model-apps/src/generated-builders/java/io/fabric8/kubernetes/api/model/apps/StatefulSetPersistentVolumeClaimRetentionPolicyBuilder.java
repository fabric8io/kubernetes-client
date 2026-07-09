package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatefulSetPersistentVolumeClaimRetentionPolicyBuilder extends StatefulSetPersistentVolumeClaimRetentionPolicyFluent<StatefulSetPersistentVolumeClaimRetentionPolicyBuilder> implements VisitableBuilder<StatefulSetPersistentVolumeClaimRetentionPolicy,StatefulSetPersistentVolumeClaimRetentionPolicyBuilder>{

  StatefulSetPersistentVolumeClaimRetentionPolicyFluent<?> fluent;

  public StatefulSetPersistentVolumeClaimRetentionPolicyBuilder() {
    this(new StatefulSetPersistentVolumeClaimRetentionPolicy());
  }
  
  public StatefulSetPersistentVolumeClaimRetentionPolicyBuilder(StatefulSetPersistentVolumeClaimRetentionPolicyFluent<?> fluent) {
    this(fluent, new StatefulSetPersistentVolumeClaimRetentionPolicy());
  }
  
  public StatefulSetPersistentVolumeClaimRetentionPolicyBuilder(StatefulSetPersistentVolumeClaimRetentionPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatefulSetPersistentVolumeClaimRetentionPolicyBuilder(StatefulSetPersistentVolumeClaimRetentionPolicyFluent<?> fluent,StatefulSetPersistentVolumeClaimRetentionPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatefulSetPersistentVolumeClaimRetentionPolicy build() {
    StatefulSetPersistentVolumeClaimRetentionPolicy buildable = new StatefulSetPersistentVolumeClaimRetentionPolicy(fluent.getWhenDeleted(), fluent.getWhenScaled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}