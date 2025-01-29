
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * `CaptureMode` describes how traffic to a listener is expected to be captured. Applicable only when the listener is bound to an IP.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum CaptureMode 
{
    DEFAULT(0),
    IPTABLES(1),
    NONE(2);
    private final int value;
    private CaptureMode(int value) {
        this.value = value;
    }

    @JsonCreator
    public static CaptureMode fromValue(Object value) {
        if (value instanceof String) {
            for (CaptureMode e : CaptureMode.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (CaptureMode e : CaptureMode.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
