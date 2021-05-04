
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "endpoints",
    "endpointsNamespace",
    "path",
    "readOnly"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class GlusterfsPersistentVolumeSource implements KubernetesResource
{

    @JsonProperty("endpoints")
    private String endpoints;
    @JsonProperty("endpointsNamespace")
    private String endpointsNamespace;
    @JsonProperty("path")
    private String path;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GlusterfsPersistentVolumeSource() {
    }

    /**
     * 
     * @param path
     * @param endpoints
     * @param readOnly
     * @param endpointsNamespace
     */
    public GlusterfsPersistentVolumeSource(String endpoints, String endpointsNamespace, String path, Boolean readOnly) {
        super();
        this.endpoints = endpoints;
        this.endpointsNamespace = endpointsNamespace;
        this.path = path;
        this.readOnly = readOnly;
    }

    @JsonProperty("endpoints")
    public String getEndpoints() {
        return endpoints;
    }

    @JsonProperty("endpoints")
    public void setEndpoints(String endpoints) {
        this.endpoints = endpoints;
    }

    @JsonProperty("endpointsNamespace")
    public String getEndpointsNamespace() {
        return endpointsNamespace;
    }

    @JsonProperty("endpointsNamespace")
    public void setEndpointsNamespace(String endpointsNamespace) {
        this.endpointsNamespace = endpointsNamespace;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
