package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PreferencesBuilder extends PreferencesFluent<PreferencesBuilder> implements VisitableBuilder<Preferences,PreferencesBuilder>{

  PreferencesFluent<?> fluent;

  public PreferencesBuilder() {
    this(new Preferences());
  }
  
  public PreferencesBuilder(PreferencesFluent<?> fluent) {
    this(fluent, new Preferences());
  }
  
  public PreferencesBuilder(Preferences instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PreferencesBuilder(PreferencesFluent<?> fluent,Preferences instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Preferences build() {
    Preferences buildable = new Preferences(fluent.getColors(), fluent.buildExtensions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}