
package io.fabric8.istio.api.api.extensions.v1alpha1;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * PluginType indicates the type of Wasm extension to be used. There are two types of extensions: `HTTP` and `NETWORK`.<br><p> <br><p> The `HTTP` extension works at Layer 7 (for example, as an HTTP filter in Envoy). The detailed HTTP interface can be found here: - [C++](https://github.com/proxy-wasm/proxy-wasm-cpp-host/blob/b7e690703c7f26707438a2f1ebd7c197bc8f0296/include/proxy-wasm/context_interface.h#L199) - [Rust](https://github.com/proxy-wasm/proxy-wasm-rust-sdk/blob/6b47aec926bc29971c727471d6f4c972ec407c7f/src/traits.rs#L309)<br><p> <br><p> The `NETWORK` extension works at Layer 4 (for example, as a network filter in Envoy). The detailed `NETWORK` interface can be found here: - [C++](https://github.com/proxy-wasm/proxy-wasm-cpp-host/blob/b7e690703c7f26707438a2f1ebd7c197bc8f0296/include/proxy-wasm/context_interface.h#L257) - [Rust](https://github.com/proxy-wasm/proxy-wasm-rust-sdk/blob/6b47aec926bc29971c727471d6f4c972ec407c7f/src/traits.rs#L257)<br><p> <br><p> The `NETWORK` extension can be applied to HTTP traffic as well.
 */
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
