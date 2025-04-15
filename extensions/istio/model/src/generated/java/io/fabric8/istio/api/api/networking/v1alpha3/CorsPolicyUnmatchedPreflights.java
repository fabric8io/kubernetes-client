
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum CorsPolicyUnmatchedPreflights 
{
    FORWARD(1),
    IGNORE(2),
    UNSPECIFIED(0);
    private final int value;
    private CorsPolicyUnmatchedPreflights(int value) {
        this.value = value;
    }

    @JsonCreator
    public static CorsPolicyUnmatchedPreflights fromValue(Object value) {
        if (value instanceof String) {
            for (CorsPolicyUnmatchedPreflights e : CorsPolicyUnmatchedPreflights.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (CorsPolicyUnmatchedPreflights e : CorsPolicyUnmatchedPreflights.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
