package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SchemaSettingErrorBuilder extends SchemaSettingErrorFluent<SchemaSettingErrorBuilder> implements VisitableBuilder<SchemaSettingError,SchemaSettingErrorBuilder>{

  SchemaSettingErrorFluent<?> fluent;

  public SchemaSettingErrorBuilder() {
    this(new SchemaSettingError());
  }
  
  public SchemaSettingErrorBuilder(SchemaSettingErrorFluent<?> fluent) {
    this(fluent, new SchemaSettingError());
  }
  
  public SchemaSettingErrorBuilder(SchemaSettingError instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SchemaSettingErrorBuilder(SchemaSettingErrorFluent<?> fluent,SchemaSettingError instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SchemaSettingError build() {
    SchemaSettingError buildable = new SchemaSettingError();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}