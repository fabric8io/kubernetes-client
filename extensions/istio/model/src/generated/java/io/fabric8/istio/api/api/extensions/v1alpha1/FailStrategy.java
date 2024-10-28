
package io.fabric8.istio.api.api.extensions.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum FailStrategy 
{
    FAIL_CLOSE(0),
    FAIL_OPEN(1);
    private final int value;
    private FailStrategy(int value) {
        this.value = value;
    }

    @JsonCreator
    public static FailStrategy fromValue(Object value) {
        if (value instanceof String) {
            for (FailStrategy e : FailStrategy.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (FailStrategy e : FailStrategy.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
