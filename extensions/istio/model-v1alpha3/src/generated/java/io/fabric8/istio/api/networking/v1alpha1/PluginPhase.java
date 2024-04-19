
package io.fabric8.istio.api.networking.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum PluginPhase {

    UNSPECIFIED_PHASE(0),
    AUTHN(1),
    AUTHZ(2),
    STATS(3);
    private final Integer value;
    private final static Map<Integer, PluginPhase> CONSTANTS = new HashMap<Integer, PluginPhase>();
    private final static Map<String, PluginPhase> NAME_CONSTANTS = new HashMap<String, PluginPhase>();

    static {
        for (PluginPhase c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (PluginPhase c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    PluginPhase(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static PluginPhase fromValue(Object value) {
        if (value instanceof String) {
            {
                PluginPhase constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        PluginPhase constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
