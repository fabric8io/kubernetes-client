
package io.fabric8.istio.api.api.security.v1beta1;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Action specifies the operation to take.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum AuthorizationPolicyAction 
{
    ALLOW(0),
    AUDIT(2),
    CUSTOM(3),
    DENY(1);
    private final int value;
    private AuthorizationPolicyAction(int value) {
        this.value = value;
    }

    @JsonCreator
    public static AuthorizationPolicyAction fromValue(Object value) {
        if (value instanceof String) {
            for (AuthorizationPolicyAction e : AuthorizationPolicyAction.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (AuthorizationPolicyAction e : AuthorizationPolicyAction.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
