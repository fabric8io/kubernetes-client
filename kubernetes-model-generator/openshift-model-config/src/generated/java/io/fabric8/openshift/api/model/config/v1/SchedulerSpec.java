
package io.fabric8.openshift.api.model.config.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SchedulerSpec implements Editable<SchedulerSpecBuilder>, KubernetesResource
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

    /**
     * defaultNodeSelector helps set the cluster-wide default node selector to restrict pod placement to specific nodes. This is applied to the pods created in all namespaces and creates an intersection with any existing nodeSelectors already set on a pod, additionally constraining that pod's selector. For example, defaultNodeSelector: "type=user-node,region=east" would set nodeSelector field in pod spec to "type=user-node,region=east" to all pods created in all namespaces. Namespaces having project-wide node selectors won't be impacted even if this field is set. This adds an annotation section to the namespace. For example, if a new namespace is created with node-selector='type=user-node,region=east', the annotation openshift.io/node-selector: type=user-node,region=east gets added to the project. When the openshift.io/node-selector annotation is set on the project the value is used in preference to the value we are setting for defaultNodeSelector field. For instance, openshift.io/node-selector: "type=user-node,region=west" means that the default of "type=user-node,region=east" set in defaultNodeSelector would not be applied.
     */
    @JsonProperty("defaultNodeSelector")
    public String getDefaultNodeSelector() {
        return defaultNodeSelector;
    }

    /**
     * defaultNodeSelector helps set the cluster-wide default node selector to restrict pod placement to specific nodes. This is applied to the pods created in all namespaces and creates an intersection with any existing nodeSelectors already set on a pod, additionally constraining that pod's selector. For example, defaultNodeSelector: "type=user-node,region=east" would set nodeSelector field in pod spec to "type=user-node,region=east" to all pods created in all namespaces. Namespaces having project-wide node selectors won't be impacted even if this field is set. This adds an annotation section to the namespace. For example, if a new namespace is created with node-selector='type=user-node,region=east', the annotation openshift.io/node-selector: type=user-node,region=east gets added to the project. When the openshift.io/node-selector annotation is set on the project the value is used in preference to the value we are setting for defaultNodeSelector field. For instance, openshift.io/node-selector: "type=user-node,region=west" means that the default of "type=user-node,region=east" set in defaultNodeSelector would not be applied.
     */
    @JsonProperty("defaultNodeSelector")
    public void setDefaultNodeSelector(String defaultNodeSelector) {
        this.defaultNodeSelector = defaultNodeSelector;
    }

    /**
     * MastersSchedulable allows masters nodes to be schedulable. When this flag is turned on, all the master nodes in the cluster will be made schedulable, so that workload pods can run on them. The default value for this field is false, meaning none of the master nodes are schedulable. Important Note: Once the workload pods start running on the master nodes, extreme care must be taken to ensure that cluster-critical control plane components are not impacted. Please turn on this field after doing due diligence.
     */
    @JsonProperty("mastersSchedulable")
    public Boolean getMastersSchedulable() {
        return mastersSchedulable;
    }

    /**
     * MastersSchedulable allows masters nodes to be schedulable. When this flag is turned on, all the master nodes in the cluster will be made schedulable, so that workload pods can run on them. The default value for this field is false, meaning none of the master nodes are schedulable. Important Note: Once the workload pods start running on the master nodes, extreme care must be taken to ensure that cluster-critical control plane components are not impacted. Please turn on this field after doing due diligence.
     */
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

    /**
     * profile sets which scheduling profile should be set in order to configure scheduling decisions for new pods.<br><p> <br><p> Valid values are "LowNodeUtilization", "HighNodeUtilization", "NoScoring" Defaults to "LowNodeUtilization"
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * profile sets which scheduling profile should be set in order to configure scheduling decisions for new pods.<br><p> <br><p> Valid values are "LowNodeUtilization", "HighNodeUtilization", "NoScoring" Defaults to "LowNodeUtilization"
     */
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
    @JsonIgnore
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
