
package io.fabric8.istio.api.api.security.v1beta1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum PeerAuthenticationMutualTLSMode 
{
    DISABLE(1),
    PERMISSIVE(2),
    STRICT(3),
    UNSET(0);
    private final int value;
    private PeerAuthenticationMutualTLSMode(int value) {
        this.value = value;
    }

    @JsonCreator
    public static PeerAuthenticationMutualTLSMode fromValue(Object value) {
        if (value instanceof String) {
            for (PeerAuthenticationMutualTLSMode e : PeerAuthenticationMutualTLSMode.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (PeerAuthenticationMutualTLSMode e : PeerAuthenticationMutualTLSMode.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
