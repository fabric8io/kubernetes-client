
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum EnvoyFilterPatchContext {

    ANY(0),
    SIDECAR_INBOUND(1),
    SIDECAR_OUTBOUND(2),
    GATEWAY(3);
    private final Integer value;
    private final static Map<Integer, EnvoyFilterPatchContext> CONSTANTS = new HashMap<Integer, EnvoyFilterPatchContext>();
    private final static Map<String, EnvoyFilterPatchContext> NAME_CONSTANTS = new HashMap<String, EnvoyFilterPatchContext>();

    static {
        for (EnvoyFilterPatchContext c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (EnvoyFilterPatchContext c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    EnvoyFilterPatchContext(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterPatchContext fromValue(Object value) {
        if (value instanceof String) {
            {
                EnvoyFilterPatchContext constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        EnvoyFilterPatchContext constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
