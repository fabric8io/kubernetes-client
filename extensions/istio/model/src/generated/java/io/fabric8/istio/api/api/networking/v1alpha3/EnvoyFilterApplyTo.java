
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * `ApplyTo` specifies where in the Envoy configuration, the given patch should be applied.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum EnvoyFilterApplyTo 
{
    BOOTSTRAP(10),
    CLUSTER(8),
    EXTENSION_CONFIG(9),
    FILTER_CHAIN(2),
    HTTP_FILTER(4),
    HTTP_ROUTE(7),
    INVALID(0),
    LISTENER(1),
    LISTENER_FILTER(11),
    NETWORK_FILTER(3),
    ROUTE_CONFIGURATION(5),
    VIRTUAL_HOST(6);
    private final int value;
    private EnvoyFilterApplyTo(int value) {
        this.value = value;
    }

    @JsonCreator
    public static EnvoyFilterApplyTo fromValue(Object value) {
        if (value instanceof String) {
            for (EnvoyFilterApplyTo e : EnvoyFilterApplyTo.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (EnvoyFilterApplyTo e : EnvoyFilterApplyTo.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
