package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CELDeviceSelectorBuilder extends CELDeviceSelectorFluent<CELDeviceSelectorBuilder> implements VisitableBuilder<CELDeviceSelector,CELDeviceSelectorBuilder>{

  CELDeviceSelectorFluent<?> fluent;

  public CELDeviceSelectorBuilder() {
    this(new CELDeviceSelector());
  }
  
  public CELDeviceSelectorBuilder(CELDeviceSelectorFluent<?> fluent) {
    this(fluent, new CELDeviceSelector());
  }
  
  public CELDeviceSelectorBuilder(CELDeviceSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CELDeviceSelectorBuilder(CELDeviceSelectorFluent<?> fluent,CELDeviceSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CELDeviceSelector build() {
    CELDeviceSelector buildable = new CELDeviceSelector(fluent.getExpression());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}