
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum HTTPRedirectRedirectPortSelection 
{
    FROM_PROTOCOL_DEFAULT(0),
    FROM_REQUEST_PORT(1);
    private final int value;
    private HTTPRedirectRedirectPortSelection(int value) {
        this.value = value;
    }

    @JsonCreator
    public static HTTPRedirectRedirectPortSelection fromValue(Object value) {
        if (value instanceof String) {
            for (HTTPRedirectRedirectPortSelection e : HTTPRedirectRedirectPortSelection.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (HTTPRedirectRedirectPortSelection e : HTTPRedirectRedirectPortSelection.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
