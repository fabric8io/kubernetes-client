package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReferenceGrantFromBuilder extends ReferenceGrantFromFluent<ReferenceGrantFromBuilder> implements VisitableBuilder<ReferenceGrantFrom,ReferenceGrantFromBuilder>{

  ReferenceGrantFromFluent<?> fluent;

  public ReferenceGrantFromBuilder() {
    this(new ReferenceGrantFrom());
  }
  
  public ReferenceGrantFromBuilder(ReferenceGrantFromFluent<?> fluent) {
    this(fluent, new ReferenceGrantFrom());
  }
  
  public ReferenceGrantFromBuilder(ReferenceGrantFrom instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReferenceGrantFromBuilder(ReferenceGrantFromFluent<?> fluent,ReferenceGrantFrom instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReferenceGrantFrom build() {
    ReferenceGrantFrom buildable = new ReferenceGrantFrom(fluent.getGroup(), fluent.getKind(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}