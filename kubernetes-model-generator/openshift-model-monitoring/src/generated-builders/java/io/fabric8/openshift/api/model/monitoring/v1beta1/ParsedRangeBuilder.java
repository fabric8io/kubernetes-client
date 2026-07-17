package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParsedRangeBuilder extends ParsedRangeFluent<ParsedRangeBuilder> implements VisitableBuilder<ParsedRange,ParsedRangeBuilder>{

  ParsedRangeFluent<?> fluent;

  public ParsedRangeBuilder() {
    this(new ParsedRange());
  }
  
  public ParsedRangeBuilder(ParsedRangeFluent<?> fluent) {
    this(fluent, new ParsedRange());
  }
  
  public ParsedRangeBuilder(ParsedRange instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParsedRangeBuilder(ParsedRangeFluent<?> fluent,ParsedRange instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParsedRange build() {
    ParsedRange buildable = new ParsedRange(fluent.getEnd(), fluent.getStart());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}