
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * NodeDaemonEndpoints lists ports opened by daemons running on the Node.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kubeletEndpoint"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeDaemonEndpoints implements Editable<NodeDaemonEndpointsBuilder>, KubernetesResource
{

    @JsonProperty("kubeletEndpoint")
    private DaemonEndpoint kubeletEndpoint;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeDaemonEndpoints() {
    }

    public NodeDaemonEndpoints(DaemonEndpoint kubeletEndpoint) {
        super();
        this.kubeletEndpoint = kubeletEndpoint;
    }

    /**
     * NodeDaemonEndpoints lists ports opened by daemons running on the Node.
     */
    @JsonProperty("kubeletEndpoint")
    public DaemonEndpoint getKubeletEndpoint() {
        return kubeletEndpoint;
    }

    /**
     * NodeDaemonEndpoints lists ports opened by daemons running on the Node.
     */
    @JsonProperty("kubeletEndpoint")
    public void setKubeletEndpoint(DaemonEndpoint kubeletEndpoint) {
        this.kubeletEndpoint = kubeletEndpoint;
    }

    @JsonIgnore
    public NodeDaemonEndpointsBuilder edit() {
        return new NodeDaemonEndpointsBuilder(this);
    }

    @JsonIgnore
    public NodeDaemonEndpointsBuilder toBuilder() {
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
