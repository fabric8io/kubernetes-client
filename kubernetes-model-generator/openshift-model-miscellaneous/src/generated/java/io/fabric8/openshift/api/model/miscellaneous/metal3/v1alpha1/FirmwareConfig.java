
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.LinkedHashMap;
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
    "simultaneousMultithreadingEnabled",
    "sriovEnabled",
    "virtualizationEnabled"
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
public class FirmwareConfig implements KubernetesResource
{

    @JsonProperty("simultaneousMultithreadingEnabled")
    private Boolean simultaneousMultithreadingEnabled;
    @JsonProperty("sriovEnabled")
    private Boolean sriovEnabled;
    @JsonProperty("virtualizationEnabled")
    private Boolean virtualizationEnabled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FirmwareConfig() {
    }

    public FirmwareConfig(Boolean simultaneousMultithreadingEnabled, Boolean sriovEnabled, Boolean virtualizationEnabled) {
        super();
        this.simultaneousMultithreadingEnabled = simultaneousMultithreadingEnabled;
        this.sriovEnabled = sriovEnabled;
        this.virtualizationEnabled = virtualizationEnabled;
    }

    @JsonProperty("simultaneousMultithreadingEnabled")
    public Boolean getSimultaneousMultithreadingEnabled() {
        return simultaneousMultithreadingEnabled;
    }

    @JsonProperty("simultaneousMultithreadingEnabled")
    public void setSimultaneousMultithreadingEnabled(Boolean simultaneousMultithreadingEnabled) {
        this.simultaneousMultithreadingEnabled = simultaneousMultithreadingEnabled;
    }

    @JsonProperty("sriovEnabled")
    public Boolean getSriovEnabled() {
        return sriovEnabled;
    }

    @JsonProperty("sriovEnabled")
    public void setSriovEnabled(Boolean sriovEnabled) {
        this.sriovEnabled = sriovEnabled;
    }

    @JsonProperty("virtualizationEnabled")
    public Boolean getVirtualizationEnabled() {
        return virtualizationEnabled;
    }

    @JsonProperty("virtualizationEnabled")
    public void setVirtualizationEnabled(Boolean virtualizationEnabled) {
        this.virtualizationEnabled = virtualizationEnabled;
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
