
package io.fabric8.istio.api.api.networking.v1alpha3;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum ServerTLSSettingsTLSProtocol 
{
    TLSV1_0(1),
    TLSV1_1(2),
    TLSV1_2(3),
    TLSV1_3(4),
    TLS_AUTO(0);
    private final int value;
    private ServerTLSSettingsTLSProtocol(int value) {
        this.value = value;
    }

    @JsonCreator
    public static ServerTLSSettingsTLSProtocol fromValue(Object value) {
        if (value instanceof String) {
            for (ServerTLSSettingsTLSProtocol e : ServerTLSSettingsTLSProtocol.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (ServerTLSSettingsTLSProtocol e : ServerTLSSettingsTLSProtocol.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
