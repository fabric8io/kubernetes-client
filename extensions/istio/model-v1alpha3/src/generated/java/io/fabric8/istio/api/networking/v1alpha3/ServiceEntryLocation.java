
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum ServiceEntryLocation {

    MESH_EXTERNAL(0),
    MESH_INTERNAL(1);
    private final Integer value;
    private final static Map<Integer, ServiceEntryLocation> CONSTANTS = new HashMap<Integer, ServiceEntryLocation>();
    private final static Map<String, ServiceEntryLocation> NAME_CONSTANTS = new HashMap<String, ServiceEntryLocation>();

    static {
        for (ServiceEntryLocation c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (ServiceEntryLocation c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    ServiceEntryLocation(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static ServiceEntryLocation fromValue(Object value) {
        if (value instanceof String) {
            {
                ServiceEntryLocation constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        ServiceEntryLocation constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
