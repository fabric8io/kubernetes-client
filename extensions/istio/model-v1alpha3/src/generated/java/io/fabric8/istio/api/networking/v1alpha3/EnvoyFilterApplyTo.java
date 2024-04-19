
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum EnvoyFilterApplyTo {

    INVALID(0),
    LISTENER(1),
    FILTER_CHAIN(2),
    NETWORK_FILTER(3),
    HTTP_FILTER(4),
    ROUTE_CONFIGURATION(5),
    VIRTUAL_HOST(6),
    HTTP_ROUTE(7),
    CLUSTER(8),
    EXTENSION_CONFIG(9),
    BOOTSTRAP(10),
    LISTENER_FILTER(11);
    private final Integer value;
    private final static Map<Integer, EnvoyFilterApplyTo> CONSTANTS = new HashMap<Integer, EnvoyFilterApplyTo>();
    private final static Map<String, EnvoyFilterApplyTo> NAME_CONSTANTS = new HashMap<String, EnvoyFilterApplyTo>();

    static {
        for (EnvoyFilterApplyTo c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (EnvoyFilterApplyTo c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    EnvoyFilterApplyTo(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterApplyTo fromValue(Object value) {
        if (value instanceof String) {
            {
                EnvoyFilterApplyTo constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        EnvoyFilterApplyTo constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
