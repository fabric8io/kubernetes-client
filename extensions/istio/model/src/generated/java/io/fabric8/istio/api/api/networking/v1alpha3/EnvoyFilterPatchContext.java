
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum EnvoyFilterPatchContext 
{
    ANY(0),
    GATEWAY(3),
    SIDECAR_INBOUND(1),
    SIDECAR_OUTBOUND(2);
    private final int value;
    private EnvoyFilterPatchContext(int value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterPatchContext fromValue(Object value) {
        if (value instanceof String) {
            for (EnvoyFilterPatchContext e : EnvoyFilterPatchContext.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (EnvoyFilterPatchContext e : EnvoyFilterPatchContext.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
