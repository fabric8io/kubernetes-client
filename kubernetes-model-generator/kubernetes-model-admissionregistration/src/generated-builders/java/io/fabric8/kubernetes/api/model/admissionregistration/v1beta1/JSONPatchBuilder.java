package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JSONPatchBuilder extends JSONPatchFluent<JSONPatchBuilder> implements VisitableBuilder<JSONPatch,JSONPatchBuilder>{

  JSONPatchFluent<?> fluent;

  public JSONPatchBuilder() {
    this(new JSONPatch());
  }
  
  public JSONPatchBuilder(JSONPatchFluent<?> fluent) {
    this(fluent, new JSONPatch());
  }
  
  public JSONPatchBuilder(JSONPatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JSONPatchBuilder(JSONPatchFluent<?> fluent,JSONPatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JSONPatch build() {
    JSONPatch buildable = new JSONPatch(fluent.getExpression());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}