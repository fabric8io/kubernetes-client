package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HibernationConfigBuilder extends HibernationConfigFluent<HibernationConfigBuilder> implements VisitableBuilder<HibernationConfig,HibernationConfigBuilder>{

  HibernationConfigFluent<?> fluent;

  public HibernationConfigBuilder() {
    this(new HibernationConfig());
  }
  
  public HibernationConfigBuilder(HibernationConfigFluent<?> fluent) {
    this(fluent, new HibernationConfig());
  }
  
  public HibernationConfigBuilder(HibernationConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HibernationConfigBuilder(HibernationConfigFluent<?> fluent,HibernationConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HibernationConfig build() {
    HibernationConfig buildable = new HibernationConfig(fluent.getResumeTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}