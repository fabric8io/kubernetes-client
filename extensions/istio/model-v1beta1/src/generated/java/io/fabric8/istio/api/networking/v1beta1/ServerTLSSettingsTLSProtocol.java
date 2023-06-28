
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum ServerTLSSettingsTLSProtocol {

    TLS_AUTO(0),
    TLSV1_0(1),
    TLSV1_1(2),
    TLSV1_2(3),
    TLSV1_3(4);
    private final Integer value;
    private final static Map<Integer, ServerTLSSettingsTLSProtocol> CONSTANTS = new HashMap<Integer, ServerTLSSettingsTLSProtocol>();
    private final static Map<String, ServerTLSSettingsTLSProtocol> NAME_CONSTANTS = new HashMap<String, ServerTLSSettingsTLSProtocol>();

    static {
        for (ServerTLSSettingsTLSProtocol c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (ServerTLSSettingsTLSProtocol c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    ServerTLSSettingsTLSProtocol(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static ServerTLSSettingsTLSProtocol fromValue(Object value) {
        if (value instanceof String) {
            {
                ServerTLSSettingsTLSProtocol constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        ServerTLSSettingsTLSProtocol constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
