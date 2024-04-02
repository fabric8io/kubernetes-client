
package io.fabric8.istio.api.networking.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("jsonschema2pojo")
public enum PluginType {

    UNSPECIFIED_PLUGIN_TYPE(0),
    HTTP(1),
    NETWORK(2);
    private final Integer value;
    private final static Map<Integer, PluginType> CONSTANTS = new HashMap<Integer, PluginType>();
    private final static Map<String, PluginType> NAME_CONSTANTS = new HashMap<String, PluginType>();

    static {
        for (PluginType c: values()) {
            CONSTANTS.put(c.value, c);
        }
        for (PluginType c: values()) {
            NAME_CONSTANTS.put(c.name().toLowerCase(), c);
        }
    }

    PluginType(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static PluginType fromValue(Object value) {
        if (value instanceof String) {
            {
                PluginType constant = NAME_CONSTANTS.get(((String) value).toLowerCase());
                if (constant == null) {
                    throw new IllegalArgumentException((value +""));
                } else {
                    return constant;
                }
            }
        }
        PluginType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException((value +""));
        } else {
            return constant;
        }
    }

}
