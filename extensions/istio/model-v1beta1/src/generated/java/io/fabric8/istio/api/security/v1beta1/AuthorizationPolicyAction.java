
package io.fabric8.istio.api.security.v1beta1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum AuthorizationPolicyAction {

    ALLOW(0),
    DENY(1),
    AUDIT(2),
    CUSTOM(3);
    private final Integer value;
    private final static Map<Integer, AuthorizationPolicyAction> CONSTANTS = new HashMap<Integer, AuthorizationPolicyAction>();
    private final static Map<String, AuthorizationPolicyAction> NAME_CONSTANTS = new HashMap<String, AuthorizationPolicyAction>();

    static {
        for (AuthorizationPolicyAction c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (AuthorizationPolicyAction c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    AuthorizationPolicyAction(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static AuthorizationPolicyAction fromValue(Object value) {
        if (value instanceof String) {
            {
                AuthorizationPolicyAction constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        AuthorizationPolicyAction constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
