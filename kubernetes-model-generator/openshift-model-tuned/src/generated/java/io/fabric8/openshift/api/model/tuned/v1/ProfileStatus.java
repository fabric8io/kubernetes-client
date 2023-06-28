
package io.fabric8.openshift.api.model.tuned.v1;

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
    "bootcmdline",
    "conditions",
    "stalld",
    "tunedProfile"
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
public class ProfileStatus implements KubernetesResource
{

    @JsonProperty("bootcmdline")
    private String bootcmdline;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ProfileStatusCondition> conditions = new ArrayList<ProfileStatusCondition>();
    @JsonProperty("stalld")
    private Boolean stalld;
    @JsonProperty("tunedProfile")
    private String tunedProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProfileStatus() {
    }

    public ProfileStatus(String bootcmdline, List<ProfileStatusCondition> conditions, Boolean stalld, String tunedProfile) {
        super();
        this.bootcmdline = bootcmdline;
        this.conditions = conditions;
        this.stalld = stalld;
        this.tunedProfile = tunedProfile;
    }

    @JsonProperty("bootcmdline")
    public String getBootcmdline() {
        return bootcmdline;
    }

    @JsonProperty("bootcmdline")
    public void setBootcmdline(String bootcmdline) {
        this.bootcmdline = bootcmdline;
    }

    @JsonProperty("conditions")
    public List<ProfileStatusCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ProfileStatusCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("stalld")
    public Boolean getStalld() {
        return stalld;
    }

    @JsonProperty("stalld")
    public void setStalld(Boolean stalld) {
        this.stalld = stalld;
    }

    @JsonProperty("tunedProfile")
    public String getTunedProfile() {
        return tunedProfile;
    }

    @JsonProperty("tunedProfile")
    public void setTunedProfile(String tunedProfile) {
        this.tunedProfile = tunedProfile;
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
