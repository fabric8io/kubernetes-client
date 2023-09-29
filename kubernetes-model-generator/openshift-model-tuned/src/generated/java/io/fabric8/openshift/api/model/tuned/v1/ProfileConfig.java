
package io.fabric8.openshift.api.model.tuned.v1;

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
    "debug",
    "providerName",
    "tunedConfig",
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
public class ProfileConfig implements Editable<ProfileConfigBuilder> , KubernetesResource
{

    @JsonProperty("debug")
    private Boolean debug;
    @JsonProperty("providerName")
    private String providerName;
    @JsonProperty("tunedConfig")
    private TuneDConfig tunedConfig;
    @JsonProperty("tunedProfile")
    private String tunedProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProfileConfig() {
    }

    public ProfileConfig(Boolean debug, String providerName, TuneDConfig tunedConfig, String tunedProfile) {
        super();
        this.debug = debug;
        this.providerName = providerName;
        this.tunedConfig = tunedConfig;
        this.tunedProfile = tunedProfile;
    }

    @JsonProperty("debug")
    public Boolean getDebug() {
        return debug;
    }

    @JsonProperty("debug")
    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    @JsonProperty("providerName")
    public String getProviderName() {
        return providerName;
    }

    @JsonProperty("providerName")
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @JsonProperty("tunedConfig")
    public TuneDConfig getTunedConfig() {
        return tunedConfig;
    }

    @JsonProperty("tunedConfig")
    public void setTunedConfig(TuneDConfig tunedConfig) {
        this.tunedConfig = tunedConfig;
    }

    @JsonProperty("tunedProfile")
    public String getTunedProfile() {
        return tunedProfile;
    }

    @JsonProperty("tunedProfile")
    public void setTunedProfile(String tunedProfile) {
        this.tunedProfile = tunedProfile;
    }

    @JsonIgnore
    public ProfileConfigBuilder edit() {
        return new ProfileConfigBuilder(this);
    }

    @JsonIgnore
    public ProfileConfigBuilder toBuilder() {
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

}
