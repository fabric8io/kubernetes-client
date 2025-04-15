
package io.fabric8.istio.api.api.extensions.v1alpha1;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum EnvValueSource 
{
    HOST(1),
    INLINE(0);
    private final int value;
    private EnvValueSource(int value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvValueSource fromValue(Object value) {
        if (value instanceof String) {
            for (EnvValueSource e : EnvValueSource.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (EnvValueSource e : EnvValueSource.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
