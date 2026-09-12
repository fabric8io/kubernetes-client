
package io.fabric8.openshift.api.model.tuned.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "managementState",
    "profile",
    "recommend"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class TunedSpec implements Editable<TunedSpecBuilder>, KubernetesResource
{

    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TunedProfile> profile = new ArrayList<>();
    @JsonProperty("recommend")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TunedRecommend> recommend = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TunedSpec() {
    }

    public TunedSpec(String managementState, List<TunedProfile> profile, List<TunedRecommend> recommend) {
        super();
        this.managementState = managementState;
        this.profile = profile;
        this.recommend = recommend;
    }

    /**
     * managementState indicates whether the registry instance represented by this config instance is under operator management or not.  Valid values are Force, Managed, Unmanaged, and Removed.
     */
    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    /**
     * managementState indicates whether the registry instance represented by this config instance is under operator management or not.  Valid values are Force, Managed, Unmanaged, and Removed.
     */
    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    /**
     * Tuned profiles.
     */
    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TunedProfile> getProfile() {
        return profile;
    }

    /**
     * Tuned profiles.
     */
    @JsonProperty("profile")
    public void setProfile(List<TunedProfile> profile) {
        this.profile = profile;
    }

    /**
     * Selection logic for all Tuned profiles.
     */
    @JsonProperty("recommend")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TunedRecommend> getRecommend() {
        return recommend;
    }

    /**
     * Selection logic for all Tuned profiles.
     */
    @JsonProperty("recommend")
    public void setRecommend(List<TunedRecommend> recommend) {
        this.recommend = recommend;
    }

    @JsonIgnore
    public TunedSpecBuilder edit() {
        return new TunedSpecBuilder(this);
    }

    @JsonIgnore
    public TunedSpecBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TunedSpec)) {
            return false;
        }
        TunedSpec other = (TunedSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$managementState = this.getManagementState();
        Object other$managementState = other.getManagementState();
        if (this$managementState == null ? other$managementState != null : !this$managementState.equals(other$managementState)) {
            return false;
        }
        Object this$profile = this.getProfile();
        Object other$profile = other.getProfile();
        if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) {
            return false;
        }
        Object this$recommend = this.getRecommend();
        Object other$recommend = other.getRecommend();
        if (this$recommend == null ? other$recommend != null : !this$recommend.equals(other$recommend)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof TunedSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $managementState = this.getManagementState();
        result = result * prime + ($managementState == null ? 43 : $managementState.hashCode());
        Object $profile = this.getProfile();
        result = result * prime + ($profile == null ? 43 : $profile.hashCode());
        Object $recommend = this.getRecommend();
        result = result * prime + ($recommend == null ? 43 : $recommend.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TunedSpec(" + "managementState=" + this.getManagementState() + ", profile=" + this.getProfile() + ", recommend=" + this.getRecommend() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
