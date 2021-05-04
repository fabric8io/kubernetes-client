
package io.fabric8.openshift.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "dockerImageRepository",
    "publicDockerImageRepository",
    "tags"
})
@ToString
@EqualsAndHashCode
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
public class ImageStreamStatus implements KubernetesResource
{

    @JsonProperty("dockerImageRepository")
    private String dockerImageRepository;
    @JsonProperty("publicDockerImageRepository")
    private String publicDockerImageRepository;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedTagEventList> tags = new ArrayList<NamedTagEventList>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageStreamStatus() {
    }

    /**
     * 
     * @param dockerImageRepository
     * @param publicDockerImageRepository
     * @param tags
     */
    public ImageStreamStatus(String dockerImageRepository, String publicDockerImageRepository, List<NamedTagEventList> tags) {
        super();
        this.dockerImageRepository = dockerImageRepository;
        this.publicDockerImageRepository = publicDockerImageRepository;
        this.tags = tags;
    }

    @JsonProperty("dockerImageRepository")
    public String getDockerImageRepository() {
        return dockerImageRepository;
    }

    @JsonProperty("dockerImageRepository")
    public void setDockerImageRepository(String dockerImageRepository) {
        this.dockerImageRepository = dockerImageRepository;
    }

    @JsonProperty("publicDockerImageRepository")
    public String getPublicDockerImageRepository() {
        return publicDockerImageRepository;
    }

    @JsonProperty("publicDockerImageRepository")
    public void setPublicDockerImageRepository(String publicDockerImageRepository) {
        this.publicDockerImageRepository = publicDockerImageRepository;
    }

    @JsonProperty("tags")
    public List<NamedTagEventList> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<NamedTagEventList> tags) {
        this.tags = tags;
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
