
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum ClientTLSSettingsTLSmode 
{
    DISABLE(0),
    ISTIO_MUTUAL(3),
    MUTUAL(2),
    SIMPLE(1);
    private final int value;
    private ClientTLSSettingsTLSmode(int value) {
        this.value = value;
    }

    @JsonCreator
    public static ClientTLSSettingsTLSmode fromValue(Object value) {
        if (value instanceof String) {
            for (ClientTLSSettingsTLSmode e : ClientTLSSettingsTLSmode.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (ClientTLSSettingsTLSmode e : ClientTLSSettingsTLSmode.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
