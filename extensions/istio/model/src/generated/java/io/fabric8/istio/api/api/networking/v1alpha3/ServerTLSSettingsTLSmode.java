
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * TLS modes enforced by the proxy
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum ServerTLSSettingsTLSmode 
{
    AUTO_PASSTHROUGH(3),
    ISTIO_MUTUAL(4),
    MUTUAL(2),
    OPTIONAL_MUTUAL(5),
    PASSTHROUGH(0),
    SIMPLE(1);
    private final int value;
    private ServerTLSSettingsTLSmode(int value) {
        this.value = value;
    }

    @JsonCreator
    public static ServerTLSSettingsTLSmode fromValue(Object value) {
        if (value instanceof String) {
            for (ServerTLSSettingsTLSmode e : ServerTLSSettingsTLSmode.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (ServerTLSSettingsTLSmode e : ServerTLSSettingsTLSmode.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
