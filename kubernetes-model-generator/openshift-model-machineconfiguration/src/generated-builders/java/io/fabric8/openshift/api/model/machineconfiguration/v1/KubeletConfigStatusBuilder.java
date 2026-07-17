package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeletConfigStatusBuilder extends KubeletConfigStatusFluent<KubeletConfigStatusBuilder> implements VisitableBuilder<KubeletConfigStatus,KubeletConfigStatusBuilder>{

  KubeletConfigStatusFluent<?> fluent;

  public KubeletConfigStatusBuilder() {
    this(new KubeletConfigStatus());
  }
  
  public KubeletConfigStatusBuilder(KubeletConfigStatusFluent<?> fluent) {
    this(fluent, new KubeletConfigStatus());
  }
  
  public KubeletConfigStatusBuilder(KubeletConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeletConfigStatusBuilder(KubeletConfigStatusFluent<?> fluent,KubeletConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeletConfigStatus build() {
    KubeletConfigStatus buildable = new KubeletConfigStatus(fluent.buildConditions(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}