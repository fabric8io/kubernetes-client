package io.fabric8.openshift.api.model.operator.ingress.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSRecordSpecBuilder extends DNSRecordSpecFluent<DNSRecordSpecBuilder> implements VisitableBuilder<DNSRecordSpec,DNSRecordSpecBuilder>{

  DNSRecordSpecFluent<?> fluent;

  public DNSRecordSpecBuilder() {
    this(new DNSRecordSpec());
  }
  
  public DNSRecordSpecBuilder(DNSRecordSpecFluent<?> fluent) {
    this(fluent, new DNSRecordSpec());
  }
  
  public DNSRecordSpecBuilder(DNSRecordSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSRecordSpecBuilder(DNSRecordSpecFluent<?> fluent,DNSRecordSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSRecordSpec build() {
    DNSRecordSpec buildable = new DNSRecordSpec(fluent.getDnsManagementPolicy(), fluent.getDnsName(), fluent.getRecordTTL(), fluent.getRecordType(), fluent.getTargets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}