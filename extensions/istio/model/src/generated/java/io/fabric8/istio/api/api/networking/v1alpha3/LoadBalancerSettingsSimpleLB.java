
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum LoadBalancerSettingsSimpleLB 
{
    LEAST_CONN(1),
    LEAST_REQUEST(5),
    PASSTHROUGH(3),
    RANDOM(2),
    ROUND_ROBIN(4),
    UNSPECIFIED(0);
    private final int value;
    private LoadBalancerSettingsSimpleLB(int value) {
        this.value = value;
    }

    @JsonCreator
    public static LoadBalancerSettingsSimpleLB fromValue(Object value) {
        if (value instanceof String) {
            for (LoadBalancerSettingsSimpleLB e : LoadBalancerSettingsSimpleLB.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (LoadBalancerSettingsSimpleLB e : LoadBalancerSettingsSimpleLB.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
