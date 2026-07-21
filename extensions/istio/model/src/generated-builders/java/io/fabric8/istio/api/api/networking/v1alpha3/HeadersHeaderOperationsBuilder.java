package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HeadersHeaderOperationsBuilder extends HeadersHeaderOperationsFluent<HeadersHeaderOperationsBuilder> implements VisitableBuilder<HeadersHeaderOperations,HeadersHeaderOperationsBuilder>{

  HeadersHeaderOperationsFluent<?> fluent;

  public HeadersHeaderOperationsBuilder() {
    this(new HeadersHeaderOperations());
  }
  
  public HeadersHeaderOperationsBuilder(HeadersHeaderOperationsFluent<?> fluent) {
    this(fluent, new HeadersHeaderOperations());
  }
  
  public HeadersHeaderOperationsBuilder(HeadersHeaderOperations instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HeadersHeaderOperationsBuilder(HeadersHeaderOperationsFluent<?> fluent,HeadersHeaderOperations instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HeadersHeaderOperations build() {
    HeadersHeaderOperations buildable = new HeadersHeaderOperations(fluent.getAdd(), fluent.getRemove(), fluent.getSet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}