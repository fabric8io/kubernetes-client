
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum ServiceEntryLocation 
{
    MESH_EXTERNAL(0),
    MESH_INTERNAL(1);
    private final int value;
    private ServiceEntryLocation(int value) {
        this.value = value;
    }

    @JsonCreator
    public static ServiceEntryLocation fromValue(Object value) {
        if (value instanceof String) {
            for (ServiceEntryLocation e : ServiceEntryLocation.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (ServiceEntryLocation e : ServiceEntryLocation.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
