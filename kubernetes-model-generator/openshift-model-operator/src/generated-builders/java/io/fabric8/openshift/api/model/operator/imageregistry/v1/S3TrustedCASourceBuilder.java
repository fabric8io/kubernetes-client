package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class S3TrustedCASourceBuilder extends S3TrustedCASourceFluent<S3TrustedCASourceBuilder> implements VisitableBuilder<S3TrustedCASource,S3TrustedCASourceBuilder>{

  S3TrustedCASourceFluent<?> fluent;

  public S3TrustedCASourceBuilder() {
    this(new S3TrustedCASource());
  }
  
  public S3TrustedCASourceBuilder(S3TrustedCASourceFluent<?> fluent) {
    this(fluent, new S3TrustedCASource());
  }
  
  public S3TrustedCASourceBuilder(S3TrustedCASource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public S3TrustedCASourceBuilder(S3TrustedCASourceFluent<?> fluent,S3TrustedCASource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public S3TrustedCASource build() {
    S3TrustedCASource buildable = new S3TrustedCASource(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}