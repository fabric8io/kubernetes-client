
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Operation denotes how the patch should be applied to the selected configuration.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum EnvoyFilterPatchOperation 
{
    ADD(2),
    INSERT_AFTER(5),
    INSERT_BEFORE(4),
    INSERT_FIRST(6),
    INVALID(0),
    MERGE(1),
    REMOVE(3),
    REPLACE(7);
    private final int value;
    private EnvoyFilterPatchOperation(int value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterPatchOperation fromValue(Object value) {
        if (value instanceof String) {
            for (EnvoyFilterPatchOperation e : EnvoyFilterPatchOperation.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (EnvoyFilterPatchOperation e : EnvoyFilterPatchOperation.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
