
package io.fabric8.istio.api.networking.v1beta1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum ServerTLSSettingsTLSmode {

    PASSTHROUGH(0),
    SIMPLE(1),
    MUTUAL(2),
    AUTO_PASSTHROUGH(3),
    ISTIO_MUTUAL(4),
    OPTIONAL_MUTUAL(5);
    private final Integer value;
    private final static Map<Integer, ServerTLSSettingsTLSmode> CONSTANTS = new HashMap<Integer, ServerTLSSettingsTLSmode>();
    private final static Map<String, ServerTLSSettingsTLSmode> NAME_CONSTANTS = new HashMap<String, ServerTLSSettingsTLSmode>();

    static {
        for (ServerTLSSettingsTLSmode c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (ServerTLSSettingsTLSmode c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    ServerTLSSettingsTLSmode(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static ServerTLSSettingsTLSmode fromValue(Object value) {
        if (value instanceof String) {
            {
                ServerTLSSettingsTLSmode constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        ServerTLSSettingsTLSmode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
