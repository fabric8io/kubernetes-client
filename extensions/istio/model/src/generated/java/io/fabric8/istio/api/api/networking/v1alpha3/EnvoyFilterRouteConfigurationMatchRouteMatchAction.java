
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Action refers to the route action taken by Envoy when a http route matches.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum EnvoyFilterRouteConfigurationMatchRouteMatchAction 
{
    ANY(0),
    DIRECT_RESPONSE(3),
    REDIRECT(2),
    ROUTE(1);
    private final int value;
    private EnvoyFilterRouteConfigurationMatchRouteMatchAction(int value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterRouteConfigurationMatchRouteMatchAction fromValue(Object value) {
        if (value instanceof String) {
            for (EnvoyFilterRouteConfigurationMatchRouteMatchAction e : EnvoyFilterRouteConfigurationMatchRouteMatchAction.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (EnvoyFilterRouteConfigurationMatchRouteMatchAction e : EnvoyFilterRouteConfigurationMatchRouteMatchAction.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
