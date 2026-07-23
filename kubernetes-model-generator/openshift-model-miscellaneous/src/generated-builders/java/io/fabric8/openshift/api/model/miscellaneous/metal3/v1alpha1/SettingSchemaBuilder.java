package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SettingSchemaBuilder extends SettingSchemaFluent<SettingSchemaBuilder> implements VisitableBuilder<SettingSchema,SettingSchemaBuilder>{

  SettingSchemaFluent<?> fluent;

  public SettingSchemaBuilder() {
    this(new SettingSchema());
  }
  
  public SettingSchemaBuilder(SettingSchemaFluent<?> fluent) {
    this(fluent, new SettingSchema());
  }
  
  public SettingSchemaBuilder(SettingSchema instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SettingSchemaBuilder(SettingSchemaFluent<?> fluent,SettingSchema instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SettingSchema build() {
    SettingSchema buildable = new SettingSchema(fluent.getAllowableValues(), fluent.getAttributeType(), fluent.getLowerBound(), fluent.getMaxLength(), fluent.getMinLength(), fluent.getReadOnly(), fluent.getUnique(), fluent.getUpperBound());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}