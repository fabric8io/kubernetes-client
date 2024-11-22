
package io.fabric8.istio.api.api.extensions.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum PullPolicy 
{
    Always(2),
    IfNotPresent(1),
    UNSPECIFIED_POLICY(0);
    private final int value;
    private PullPolicy(int value) {
        this.value = value;
    }

    @JsonCreator
    public static PullPolicy fromValue(Object value) {
        if (value instanceof String) {
            for (PullPolicy e : PullPolicy.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (PullPolicy e : PullPolicy.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
