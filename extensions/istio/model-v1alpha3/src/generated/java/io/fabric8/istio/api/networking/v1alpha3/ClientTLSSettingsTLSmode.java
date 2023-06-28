
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum ClientTLSSettingsTLSmode {

    DISABLE(0),
    SIMPLE(1),
    MUTUAL(2),
    ISTIO_MUTUAL(3);
    private final Integer value;
    private final static Map<Integer, ClientTLSSettingsTLSmode> CONSTANTS = new HashMap<Integer, ClientTLSSettingsTLSmode>();
    private final static Map<String, ClientTLSSettingsTLSmode> NAME_CONSTANTS = new HashMap<String, ClientTLSSettingsTLSmode>();

    static {
        for (ClientTLSSettingsTLSmode c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (ClientTLSSettingsTLSmode c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    ClientTLSSettingsTLSmode(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static ClientTLSSettingsTLSmode fromValue(Object value) {
        if (value instanceof String) {
            {
                ClientTLSSettingsTLSmode constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        ClientTLSSettingsTLSmode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
