
package io.fabric8.kubernetes.api.model.storage.v1beta1;

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
    "attachRequired",
    "fsGroupPolicy",
    "podInfoOnMount",
    "requiresRepublish",
    "seLinuxMount",
    "storageCapacity",
    "tokenRequests",
    "volumeLifecycleModes"
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
public class CSIDriverSpec implements KubernetesResource
{

    @JsonProperty("attachRequired")
    private Boolean attachRequired;
    @JsonProperty("fsGroupPolicy")
    private String fsGroupPolicy;
    @JsonProperty("podInfoOnMount")
    private Boolean podInfoOnMount;
    @JsonProperty("requiresRepublish")
    private Boolean requiresRepublish;
    @JsonProperty("seLinuxMount")
    private Boolean seLinuxMount;
    @JsonProperty("storageCapacity")
    private Boolean storageCapacity;
    @JsonProperty("tokenRequests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TokenRequest> tokenRequests = new ArrayList<TokenRequest>();
    @JsonProperty("volumeLifecycleModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> volumeLifecycleModes = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CSIDriverSpec() {
    }

    public CSIDriverSpec(Boolean attachRequired, String fsGroupPolicy, Boolean podInfoOnMount, Boolean requiresRepublish, Boolean seLinuxMount, Boolean storageCapacity, List<TokenRequest> tokenRequests, List<String> volumeLifecycleModes) {
        super();
        this.attachRequired = attachRequired;
        this.fsGroupPolicy = fsGroupPolicy;
        this.podInfoOnMount = podInfoOnMount;
        this.requiresRepublish = requiresRepublish;
        this.seLinuxMount = seLinuxMount;
        this.storageCapacity = storageCapacity;
        this.tokenRequests = tokenRequests;
        this.volumeLifecycleModes = volumeLifecycleModes;
    }

    @JsonProperty("attachRequired")
    public Boolean getAttachRequired() {
        return attachRequired;
    }

    @JsonProperty("attachRequired")
    public void setAttachRequired(Boolean attachRequired) {
        this.attachRequired = attachRequired;
    }

    @JsonProperty("fsGroupPolicy")
    public String getFsGroupPolicy() {
        return fsGroupPolicy;
    }

    @JsonProperty("fsGroupPolicy")
    public void setFsGroupPolicy(String fsGroupPolicy) {
        this.fsGroupPolicy = fsGroupPolicy;
    }

    @JsonProperty("podInfoOnMount")
    public Boolean getPodInfoOnMount() {
        return podInfoOnMount;
    }

    @JsonProperty("podInfoOnMount")
    public void setPodInfoOnMount(Boolean podInfoOnMount) {
        this.podInfoOnMount = podInfoOnMount;
    }

    @JsonProperty("requiresRepublish")
    public Boolean getRequiresRepublish() {
        return requiresRepublish;
    }

    @JsonProperty("requiresRepublish")
    public void setRequiresRepublish(Boolean requiresRepublish) {
        this.requiresRepublish = requiresRepublish;
    }

    @JsonProperty("seLinuxMount")
    public Boolean getSeLinuxMount() {
        return seLinuxMount;
    }

    @JsonProperty("seLinuxMount")
    public void setSeLinuxMount(Boolean seLinuxMount) {
        this.seLinuxMount = seLinuxMount;
    }

    @JsonProperty("storageCapacity")
    public Boolean getStorageCapacity() {
        return storageCapacity;
    }

    @JsonProperty("storageCapacity")
    public void setStorageCapacity(Boolean storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @JsonProperty("tokenRequests")
    public List<TokenRequest> getTokenRequests() {
        return tokenRequests;
    }

    @JsonProperty("tokenRequests")
    public void setTokenRequests(List<TokenRequest> tokenRequests) {
        this.tokenRequests = tokenRequests;
    }

    @JsonProperty("volumeLifecycleModes")
    public List<String> getVolumeLifecycleModes() {
        return volumeLifecycleModes;
    }

    @JsonProperty("volumeLifecycleModes")
    public void setVolumeLifecycleModes(List<String> volumeLifecycleModes) {
        this.volumeLifecycleModes = volumeLifecycleModes;
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
