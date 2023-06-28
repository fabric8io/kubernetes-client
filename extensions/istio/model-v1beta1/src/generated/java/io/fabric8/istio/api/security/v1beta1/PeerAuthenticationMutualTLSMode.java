
package io.fabric8.istio.api.security.v1beta1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum PeerAuthenticationMutualTLSMode {

    UNSET(0),
    DISABLE(1),
    PERMISSIVE(2),
    STRICT(3);
    private final Integer value;
    private final static Map<Integer, PeerAuthenticationMutualTLSMode> CONSTANTS = new HashMap<Integer, PeerAuthenticationMutualTLSMode>();
    private final static Map<String, PeerAuthenticationMutualTLSMode> NAME_CONSTANTS = new HashMap<String, PeerAuthenticationMutualTLSMode>();

    static {
        for (PeerAuthenticationMutualTLSMode c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (PeerAuthenticationMutualTLSMode c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    PeerAuthenticationMutualTLSMode(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static PeerAuthenticationMutualTLSMode fromValue(Object value) {
        if (value instanceof String) {
            {
                PeerAuthenticationMutualTLSMode constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        PeerAuthenticationMutualTLSMode constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
