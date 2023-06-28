
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum EnvoyFilterPatchFilterClass {

    UNSPECIFIED(0),
    AUTHN(1),
    AUTHZ(2),
    STATS(3);
    private final Integer value;
    private final static Map<Integer, EnvoyFilterPatchFilterClass> CONSTANTS = new HashMap<Integer, EnvoyFilterPatchFilterClass>();
    private final static Map<String, EnvoyFilterPatchFilterClass> NAME_CONSTANTS = new HashMap<String, EnvoyFilterPatchFilterClass>();

    static {
        for (EnvoyFilterPatchFilterClass c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (EnvoyFilterPatchFilterClass c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    EnvoyFilterPatchFilterClass(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterPatchFilterClass fromValue(Object value) {
        if (value instanceof String) {
            {
                EnvoyFilterPatchFilterClass constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        EnvoyFilterPatchFilterClass constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
