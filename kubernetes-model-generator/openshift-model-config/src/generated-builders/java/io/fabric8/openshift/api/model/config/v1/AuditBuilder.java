package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuditBuilder extends AuditFluent<AuditBuilder> implements VisitableBuilder<Audit,AuditBuilder>{

  AuditFluent<?> fluent;

  public AuditBuilder() {
    this(new Audit());
  }
  
  public AuditBuilder(AuditFluent<?> fluent) {
    this(fluent, new Audit());
  }
  
  public AuditBuilder(Audit instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuditBuilder(AuditFluent<?> fluent,Audit instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Audit build() {
    Audit buildable = new Audit(fluent.buildCustomRules(), fluent.getProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}