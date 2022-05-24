
package io.fabric8.istio.api.security.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AuthorizationPolicyAction {

    ALLOW("ALLOW"),
    DENY("DENY"),
    AUDIT("AUDIT"),
    CUSTOM("CUSTOM");
    private final String value;
    private final static Map<String, AuthorizationPolicyAction> CONSTANTS = new HashMap<String, AuthorizationPolicyAction>();

    static {
        for (AuthorizationPolicyAction c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private AuthorizationPolicyAction(String value) {
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
    public static AuthorizationPolicyAction fromValue(String value) {
        AuthorizationPolicyAction constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
