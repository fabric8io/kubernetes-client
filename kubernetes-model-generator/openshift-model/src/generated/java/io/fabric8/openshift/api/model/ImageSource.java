
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
    "as",
    "from",
    "paths",
    "pullSecret"
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
public class ImageSource implements KubernetesResource
{

    @JsonProperty("as")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> as = new ArrayList<String>();
    @JsonProperty("from")
    private io.fabric8.kubernetes.api.model.ObjectReference from;
    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageSourcePath> paths = new ArrayList<ImageSourcePath>();
    @JsonProperty("pullSecret")
    private io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageSource() {
    }

    public ImageSource(List<String> as, io.fabric8.kubernetes.api.model.ObjectReference from, List<ImageSourcePath> paths, io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret) {
        super();
        this.as = as;
        this.from = from;
        this.paths = paths;
        this.pullSecret = pullSecret;
    }

    @JsonProperty("as")
    public List<String> getAs() {
        return as;
    }

    @JsonProperty("as")
    public void setAs(List<String> as) {
        this.as = as;
    }

    @JsonProperty("from")
    public io.fabric8.kubernetes.api.model.ObjectReference getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(io.fabric8.kubernetes.api.model.ObjectReference from) {
        this.from = from;
    }

    @JsonProperty("paths")
    public List<ImageSourcePath> getPaths() {
        return paths;
    }

    @JsonProperty("paths")
    public void setPaths(List<ImageSourcePath> paths) {
        this.paths = paths;
    }

    @JsonProperty("pullSecret")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getPullSecret() {
        return pullSecret;
    }

    @JsonProperty("pullSecret")
    public void setPullSecret(io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret) {
        this.pullSecret = pullSecret;
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
