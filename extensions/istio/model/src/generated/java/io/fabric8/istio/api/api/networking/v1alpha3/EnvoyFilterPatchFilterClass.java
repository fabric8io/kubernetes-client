
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum EnvoyFilterPatchFilterClass 
{
    AUTHN(1),
    AUTHZ(2),
    STATS(3),
    UNSPECIFIED(0);
    private final int value;
    private EnvoyFilterPatchFilterClass(int value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterPatchFilterClass fromValue(Object value) {
        if (value instanceof String) {
            for (EnvoyFilterPatchFilterClass e : EnvoyFilterPatchFilterClass.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (EnvoyFilterPatchFilterClass e : EnvoyFilterPatchFilterClass.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
