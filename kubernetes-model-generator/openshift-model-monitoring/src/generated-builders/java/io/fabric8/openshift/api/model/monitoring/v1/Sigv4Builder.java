package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Sigv4Builder extends Sigv4Fluent<Sigv4Builder> implements VisitableBuilder<Sigv4,Sigv4Builder>{

  Sigv4Fluent<?> fluent;

  public Sigv4Builder() {
    this(new Sigv4());
  }
  
  public Sigv4Builder(Sigv4Fluent<?> fluent) {
    this(fluent, new Sigv4());
  }
  
  public Sigv4Builder(Sigv4 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Sigv4Builder(Sigv4Fluent<?> fluent,Sigv4 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Sigv4 build() {
    Sigv4 buildable = new Sigv4(fluent.getAccessKey(), fluent.getExternalId(), fluent.getProfile(), fluent.getRegion(), fluent.getRoleArn(), fluent.getSecretKey(), fluent.getUseFIPSSTSEndpoint());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}