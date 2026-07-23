package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeletConfigConditionBuilder extends KubeletConfigConditionFluent<KubeletConfigConditionBuilder> implements VisitableBuilder<KubeletConfigCondition,KubeletConfigConditionBuilder>{

  KubeletConfigConditionFluent<?> fluent;

  public KubeletConfigConditionBuilder() {
    this(new KubeletConfigCondition());
  }
  
  public KubeletConfigConditionBuilder(KubeletConfigConditionFluent<?> fluent) {
    this(fluent, new KubeletConfigCondition());
  }
  
  public KubeletConfigConditionBuilder(KubeletConfigCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeletConfigConditionBuilder(KubeletConfigConditionFluent<?> fluent,KubeletConfigCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeletConfigCondition build() {
    KubeletConfigCondition buildable = new KubeletConfigCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}