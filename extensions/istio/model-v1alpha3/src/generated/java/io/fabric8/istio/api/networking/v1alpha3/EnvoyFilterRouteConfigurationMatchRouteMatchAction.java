
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum EnvoyFilterRouteConfigurationMatchRouteMatchAction {

    ANY(0),
    ROUTE(1),
    REDIRECT(2),
    DIRECT_RESPONSE(3);
    private final Integer value;
    private final static Map<Integer, EnvoyFilterRouteConfigurationMatchRouteMatchAction> CONSTANTS = new HashMap<Integer, EnvoyFilterRouteConfigurationMatchRouteMatchAction>();
    private final static Map<String, EnvoyFilterRouteConfigurationMatchRouteMatchAction> NAME_CONSTANTS = new HashMap<String, EnvoyFilterRouteConfigurationMatchRouteMatchAction>();

    static {
        for (EnvoyFilterRouteConfigurationMatchRouteMatchAction c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (EnvoyFilterRouteConfigurationMatchRouteMatchAction c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    EnvoyFilterRouteConfigurationMatchRouteMatchAction(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterRouteConfigurationMatchRouteMatchAction fromValue(Object value) {
        if (value instanceof String) {
            {
                EnvoyFilterRouteConfigurationMatchRouteMatchAction constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        EnvoyFilterRouteConfigurationMatchRouteMatchAction constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
