package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProbeTargetStaticConfigBuilder extends ProbeTargetStaticConfigFluent<ProbeTargetStaticConfigBuilder> implements VisitableBuilder<ProbeTargetStaticConfig,ProbeTargetStaticConfigBuilder>{

  ProbeTargetStaticConfigFluent<?> fluent;

  public ProbeTargetStaticConfigBuilder() {
    this(new ProbeTargetStaticConfig());
  }
  
  public ProbeTargetStaticConfigBuilder(ProbeTargetStaticConfigFluent<?> fluent) {
    this(fluent, new ProbeTargetStaticConfig());
  }
  
  public ProbeTargetStaticConfigBuilder(ProbeTargetStaticConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProbeTargetStaticConfigBuilder(ProbeTargetStaticConfigFluent<?> fluent,ProbeTargetStaticConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProbeTargetStaticConfig build() {
    ProbeTargetStaticConfig buildable = new ProbeTargetStaticConfig(fluent.getLabels(), fluent.buildRelabelingConfigs(), fluent.getStatic());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}