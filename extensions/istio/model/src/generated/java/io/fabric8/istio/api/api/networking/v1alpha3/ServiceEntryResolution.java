
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum ServiceEntryResolution 
{
    DNS(2),
    DNS_ROUND_ROBIN(3),
    NONE(0),
    STATIC(1);
    private final int value;
    private ServiceEntryResolution(int value) {
        this.value = value;
    }

    @JsonCreator
    public static ServiceEntryResolution fromValue(Object value) {
        if (value instanceof String) {
            for (ServiceEntryResolution e : ServiceEntryResolution.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (ServiceEntryResolution e : ServiceEntryResolution.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
