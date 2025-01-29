
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * FilterClass determines the filter insertion point in the filter chain relative to the filters implicitly inserted by the control plane. It is used in conjunction with the `ADD` operation. This is the preferred insertion mechanism for adding filters over the `INSERT_&#42;` operations since those operations rely on potentially unstable filter names. Filter ordering is important if your filter depends on or affects the functioning of a another filter in the filter chain. Within a filter class, filters are inserted in the order of processing.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
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
