
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServerTLSSettingsTLSProtocol {

    TLS_AUTO("TLS_AUTO"),
    TLSV1_0("TLSV1_0"),
    TLSV1_1("TLSV1_1"),
    TLSV1_2("TLSV1_2"),
    TLSV1_3("TLSV1_3");
    private final String value;
    private final static Map<String, ServerTLSSettingsTLSProtocol> CONSTANTS = new HashMap<String, ServerTLSSettingsTLSProtocol>();

    static {
        for (ServerTLSSettingsTLSProtocol c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private ServerTLSSettingsTLSProtocol(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static ServerTLSSettingsTLSProtocol fromValue(String value) {
        ServerTLSSettingsTLSProtocol constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
