
package io.fabric8.istio.api.api.extensions.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * LuaConfig configures a Lua filter.<br><p> <br><p> Lua filters provide a lightweight alternative to WebAssembly for simple request/response transformations. The Lua code is executed inline within the Envoy proxy.<br><p> <br><p> Example: Simple header manipulation<br><p> <br><p> ```yaml lua:<br><p> <br><p> 	inlineCode: |<br><p> 	  function envoy_on_request(request_handle)<br><p> 	    request_handle:headers():add("x-custom-header", "custom-value")<br><p> 	  end<br><p> <br><p> ```<br><p> <br><p> The Lua script must define one or both of the following functions: - `envoy_on_request(request_handle)`: Called when a request is received - `envoy_on_response(response_handle)`: Called when a response is received<br><p> <br><p> The request_handle and response_handle provide access to headers, body, metadata, and other request/response attributes. See the Envoy Lua filter documentation for the complete API: https://www.envoyproxy.io/docs/envoy/latest/configuration/http/http_filters/lua_filter
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "inlineCode"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LuaConfig implements Editable<LuaConfigBuilder>, KubernetesResource
{

    @JsonProperty("inlineCode")
    private String inlineCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LuaConfig() {
    }

    public LuaConfig(String inlineCode) {
        super();
        this.inlineCode = inlineCode;
    }

    /**
     * The inline Lua code to be executed. The code must be a valid Lua script that defines the appropriate callback functions (`envoy_on_request` and/or `envoy_on_response`).<br><p> <br><p> The maximum size is 64KB. For larger or more complex filters, use a WebAssembly filter instead.
     */
    @JsonProperty("inlineCode")
    public String getInlineCode() {
        return inlineCode;
    }

    /**
     * The inline Lua code to be executed. The code must be a valid Lua script that defines the appropriate callback functions (`envoy_on_request` and/or `envoy_on_response`).<br><p> <br><p> The maximum size is 64KB. For larger or more complex filters, use a WebAssembly filter instead.
     */
    @JsonProperty("inlineCode")
    public void setInlineCode(String inlineCode) {
        this.inlineCode = inlineCode;
    }

    @JsonIgnore
    public LuaConfigBuilder edit() {
        return new LuaConfigBuilder(this);
    }

    @JsonIgnore
    public LuaConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
