
package io.fabric8.istio.api.api.extensions.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The phase in the filter chain where the plugin will be injected.
 */
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public enum PluginPhase 
{
    AUTHN(1),
    AUTHZ(2),
    STATS(3),
    UNSPECIFIED_PHASE(0);
    private final int value;
    private PluginPhase(int value) {
        this.value = value;
    }

    @JsonCreator
    public static PluginPhase fromValue(Object value) {
        if (value instanceof String) {
            for (PluginPhase e : PluginPhase.values()) {
                if (e.name().equalsIgnoreCase(value.toString())) {
                    return e;
                }
            }
        } else if (value instanceof Integer) {
            for (PluginPhase e : PluginPhase.values()) {
                if (value.equals(e.value)) {
                    return e;
                }
            }
        }
        return null;
    }



}
