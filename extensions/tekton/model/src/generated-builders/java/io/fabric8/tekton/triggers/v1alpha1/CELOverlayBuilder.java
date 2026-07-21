package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CELOverlayBuilder extends CELOverlayFluent<CELOverlayBuilder> implements VisitableBuilder<CELOverlay,CELOverlayBuilder>{

  CELOverlayFluent<?> fluent;

  public CELOverlayBuilder() {
    this(new CELOverlay());
  }
  
  public CELOverlayBuilder(CELOverlayFluent<?> fluent) {
    this(fluent, new CELOverlay());
  }
  
  public CELOverlayBuilder(CELOverlay instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CELOverlayBuilder(CELOverlayFluent<?> fluent,CELOverlay instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CELOverlay build() {
    CELOverlay buildable = new CELOverlay(fluent.getExpression(), fluent.getKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}