package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RelabelConfigBuilder extends RelabelConfigFluent<RelabelConfigBuilder> implements VisitableBuilder<RelabelConfig,RelabelConfigBuilder>{

  RelabelConfigFluent<?> fluent;

  public RelabelConfigBuilder() {
    this(new RelabelConfig());
  }
  
  public RelabelConfigBuilder(RelabelConfigFluent<?> fluent) {
    this(fluent, new RelabelConfig());
  }
  
  public RelabelConfigBuilder(RelabelConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RelabelConfigBuilder(RelabelConfigFluent<?> fluent,RelabelConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RelabelConfig build() {
    RelabelConfig buildable = new RelabelConfig(fluent.getAction(), fluent.getModulus(), fluent.getRegex(), fluent.getReplacement(), fluent.getSeparator(), fluent.getSourceLabels(), fluent.getTargetLabel());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}