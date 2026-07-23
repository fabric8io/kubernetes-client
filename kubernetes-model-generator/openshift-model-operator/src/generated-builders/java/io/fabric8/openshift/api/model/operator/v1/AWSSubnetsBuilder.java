package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSSubnetsBuilder extends AWSSubnetsFluent<AWSSubnetsBuilder> implements VisitableBuilder<AWSSubnets,AWSSubnetsBuilder>{

  AWSSubnetsFluent<?> fluent;

  public AWSSubnetsBuilder() {
    this(new AWSSubnets());
  }
  
  public AWSSubnetsBuilder(AWSSubnetsFluent<?> fluent) {
    this(fluent, new AWSSubnets());
  }
  
  public AWSSubnetsBuilder(AWSSubnets instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSSubnetsBuilder(AWSSubnetsFluent<?> fluent,AWSSubnets instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSSubnets build() {
    AWSSubnets buildable = new AWSSubnets(fluent.getIds(), fluent.getNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}