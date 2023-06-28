
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum ServiceEntryResolution {

    NONE(0),
    STATIC(1),
    DNS(2),
    DNS_ROUND_ROBIN(3);
    private final Integer value;
    private final static Map<Integer, ServiceEntryResolution> CONSTANTS = new HashMap<Integer, ServiceEntryResolution>();
    private final static Map<String, ServiceEntryResolution> NAME_CONSTANTS = new HashMap<String, ServiceEntryResolution>();

    static {
        for (ServiceEntryResolution c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (ServiceEntryResolution c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    ServiceEntryResolution(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static ServiceEntryResolution fromValue(Object value) {
        if (value instanceof String) {
            {
                ServiceEntryResolution constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        ServiceEntryResolution constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
