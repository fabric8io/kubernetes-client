
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
    "labelSelectorPath",
    "specReplicasPath",
    "statusReplicasPath"
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
public class CustomResourceSubresourceScale implements KubernetesResource
{

    @JsonProperty("labelSelectorPath")
    private String labelSelectorPath;
    @JsonProperty("specReplicasPath")
    private String specReplicasPath;
    @JsonProperty("statusReplicasPath")
    private String statusReplicasPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomResourceSubresourceScale() {
    }

    public CustomResourceSubresourceScale(String labelSelectorPath, String specReplicasPath, String statusReplicasPath) {
        super();
        this.labelSelectorPath = labelSelectorPath;
        this.specReplicasPath = specReplicasPath;
        this.statusReplicasPath = statusReplicasPath;
    }

    @JsonProperty("labelSelectorPath")
    public String getLabelSelectorPath() {
        return labelSelectorPath;
    }

    @JsonProperty("labelSelectorPath")
    public void setLabelSelectorPath(String labelSelectorPath) {
        this.labelSelectorPath = labelSelectorPath;
    }

    @JsonProperty("specReplicasPath")
    public String getSpecReplicasPath() {
        return specReplicasPath;
    }

    @JsonProperty("specReplicasPath")
    public void setSpecReplicasPath(String specReplicasPath) {
        this.specReplicasPath = specReplicasPath;
    }

    @JsonProperty("statusReplicasPath")
    public String getStatusReplicasPath() {
        return statusReplicasPath;
    }

    @JsonProperty("statusReplicasPath")
    public void setStatusReplicasPath(String statusReplicasPath) {
        this.statusReplicasPath = statusReplicasPath;
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
