
package io.fabric8.openshift.api.model.machineconfig.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "config",
    "extensions",
    "fips",
    "kernelArguments",
    "kernelType",
    "osImageURL"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MachineConfigSpec implements KubernetesResource
{

    @JsonProperty("config")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> config = new LinkedHashMap<String, Object>();
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> extensions = new ArrayList<java.lang.String>();
    @JsonProperty("fips")
    private Boolean fips;
    @JsonProperty("kernelArguments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> kernelArguments = new ArrayList<java.lang.String>();
    @JsonProperty("kernelType")
    private java.lang.String kernelType;
    @JsonProperty("osImageURL")
    private java.lang.String osImageURL;
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new LinkedHashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineConfigSpec() {
    }

    public MachineConfigSpec(Map<String, Object> config, List<java.lang.String> extensions, Boolean fips, List<java.lang.String> kernelArguments, java.lang.String kernelType, java.lang.String osImageURL) {
        super();
        this.config = config;
        this.extensions = extensions;
        this.fips = fips;
        this.kernelArguments = kernelArguments;
        this.kernelType = kernelType;
        this.osImageURL = osImageURL;
    }

    @JsonProperty("config")
    public Map<String, Object> getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(Map<String, Object> config) {
        this.config = config;
    }

    @JsonProperty("extensions")
    public List<java.lang.String> getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    public void setExtensions(List<java.lang.String> extensions) {
        this.extensions = extensions;
    }

    @JsonProperty("fips")
    public Boolean getFips() {
        return fips;
    }

    @JsonProperty("fips")
    public void setFips(Boolean fips) {
        this.fips = fips;
    }

    @JsonProperty("kernelArguments")
    public List<java.lang.String> getKernelArguments() {
        return kernelArguments;
    }

    @JsonProperty("kernelArguments")
    public void setKernelArguments(List<java.lang.String> kernelArguments) {
        this.kernelArguments = kernelArguments;
    }

    @JsonProperty("kernelType")
    public java.lang.String getKernelType() {
        return kernelType;
    }

    @JsonProperty("kernelType")
    public void setKernelType(java.lang.String kernelType) {
        this.kernelType = kernelType;
    }

    @JsonProperty("osImageURL")
    public java.lang.String getOsImageURL() {
        return osImageURL;
    }

    @JsonProperty("osImageURL")
    public void setOsImageURL(java.lang.String osImageURL) {
        this.osImageURL = osImageURL;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
