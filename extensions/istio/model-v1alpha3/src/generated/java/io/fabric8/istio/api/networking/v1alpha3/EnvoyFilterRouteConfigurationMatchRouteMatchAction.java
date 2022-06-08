
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnvoyFilterRouteConfigurationMatchRouteMatchAction {

    ANY("ANY"),
    ROUTE("ROUTE"),
    REDIRECT("REDIRECT"),
    DIRECT_RESPONSE("DIRECT_RESPONSE");
    private final String value;
    private final static Map<String, EnvoyFilterRouteConfigurationMatchRouteMatchAction> CONSTANTS = new HashMap<String, EnvoyFilterRouteConfigurationMatchRouteMatchAction>();

    static {
        for (EnvoyFilterRouteConfigurationMatchRouteMatchAction c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private EnvoyFilterRouteConfigurationMatchRouteMatchAction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static EnvoyFilterRouteConfigurationMatchRouteMatchAction fromValue(String value) {
        EnvoyFilterRouteConfigurationMatchRouteMatchAction constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
