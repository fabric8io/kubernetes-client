
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "defaultNodeSelector",
    "mastersSchedulable",
    "policy",
    "profile",
    "profileCustomizations"
})
@ToString
@EqualsAndHashCode
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class SchedulerSpec implements Editable<SchedulerSpecBuilder> , KubernetesResource
{

    @JsonProperty("defaultNodeSelector")
    private String defaultNodeSelector;
    @JsonProperty("mastersSchedulable")
    private Boolean mastersSchedulable;
    @JsonProperty("policy")
    private ConfigMapNameReference policy;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("profileCustomizations")
    private ProfileCustomizations profileCustomizations;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SchedulerSpec() {
    }

    public SchedulerSpec(String defaultNodeSelector, Boolean mastersSchedulable, ConfigMapNameReference policy, String profile, ProfileCustomizations profileCustomizations) {
        super();
        this.defaultNodeSelector = defaultNodeSelector;
        this.mastersSchedulable = mastersSchedulable;
        this.policy = policy;
        this.profile = profile;
        this.profileCustomizations = profileCustomizations;
    }

    @JsonProperty("defaultNodeSelector")
    public String getDefaultNodeSelector() {
        return defaultNodeSelector;
    }

    @JsonProperty("defaultNodeSelector")
    public void setDefaultNodeSelector(String defaultNodeSelector) {
        this.defaultNodeSelector = defaultNodeSelector;
    }

    @JsonProperty("mastersSchedulable")
    public Boolean getMastersSchedulable() {
        return mastersSchedulable;
    }

    @JsonProperty("mastersSchedulable")
    public void setMastersSchedulable(Boolean mastersSchedulable) {
        this.mastersSchedulable = mastersSchedulable;
    }

    @JsonProperty("policy")
    public ConfigMapNameReference getPolicy() {
        return policy;
    }

    @JsonProperty("policy")
    public void setPolicy(ConfigMapNameReference policy) {
        this.policy = policy;
    }

    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonProperty("profileCustomizations")
    public ProfileCustomizations getProfileCustomizations() {
        return profileCustomizations;
    }

    @JsonProperty("profileCustomizations")
    public void setProfileCustomizations(ProfileCustomizations profileCustomizations) {
        this.profileCustomizations = profileCustomizations;
    }

    @JsonIgnore
    public SchedulerSpecBuilder edit() {
        return new SchedulerSpecBuilder(this);
    }

    @JsonIgnore
    public SchedulerSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
