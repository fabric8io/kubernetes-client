
package io.fabric8.istio.api.api.extensions.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum PluginType 
{
    HTTP(1),
    NETWORK(2),
    UNSPECIFIED_PLUGIN_TYPE(0);
    private final int value;
    private PluginType(int value) {
        this.value = value;
    }

    @JsonCreator
    public static PluginType fromValue(Object value) {
        if (value instanceof String) {
            for (PluginType e : PluginType.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (PluginType e : PluginType.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
