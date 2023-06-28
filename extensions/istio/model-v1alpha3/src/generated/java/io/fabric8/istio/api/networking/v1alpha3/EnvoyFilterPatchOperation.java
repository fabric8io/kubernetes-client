
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum EnvoyFilterPatchOperation {

    INVALID(0),
    MERGE(1),
    ADD(2),
    REMOVE(3),
    INSERT_BEFORE(4),
    INSERT_AFTER(5),
    INSERT_FIRST(6),
    REPLACE(7);
    private final Integer value;
    private final static Map<Integer, EnvoyFilterPatchOperation> CONSTANTS = new HashMap<Integer, EnvoyFilterPatchOperation>();
    private final static Map<String, EnvoyFilterPatchOperation> NAME_CONSTANTS = new HashMap<String, EnvoyFilterPatchOperation>();

    static {
        for (EnvoyFilterPatchOperation c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (EnvoyFilterPatchOperation c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    EnvoyFilterPatchOperation(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterPatchOperation fromValue(Object value) {
        if (value instanceof String) {
            {
                EnvoyFilterPatchOperation constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        EnvoyFilterPatchOperation constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
