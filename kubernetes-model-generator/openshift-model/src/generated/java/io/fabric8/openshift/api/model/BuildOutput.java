
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
    "imageLabels",
    "pushSecret",
    "to"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BuildOutput implements KubernetesResource
{

    @JsonProperty("imageLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageLabel> imageLabels = new ArrayList<ImageLabel>();
    @JsonProperty("pushSecret")
    private io.fabric8.kubernetes.api.model.LocalObjectReference pushSecret;
    @JsonProperty("to")
    private io.fabric8.kubernetes.api.model.ObjectReference to;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildOutput() {
    }

    public BuildOutput(List<ImageLabel> imageLabels, io.fabric8.kubernetes.api.model.LocalObjectReference pushSecret, io.fabric8.kubernetes.api.model.ObjectReference to) {
        super();
        this.imageLabels = imageLabels;
        this.pushSecret = pushSecret;
        this.to = to;
    }

    @JsonProperty("imageLabels")
    public List<ImageLabel> getImageLabels() {
        return imageLabels;
    }

    @JsonProperty("imageLabels")
    public void setImageLabels(List<ImageLabel> imageLabels) {
        this.imageLabels = imageLabels;
    }

    @JsonProperty("pushSecret")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getPushSecret() {
        return pushSecret;
    }

    @JsonProperty("pushSecret")
    public void setPushSecret(io.fabric8.kubernetes.api.model.LocalObjectReference pushSecret) {
        this.pushSecret = pushSecret;
    }

    @JsonProperty("to")
    public io.fabric8.kubernetes.api.model.ObjectReference getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(io.fabric8.kubernetes.api.model.ObjectReference to) {
        this.to = to;
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
