
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

/**
 * TLSSecurityProfile defines the schema for a TLS security profile. This object is used by operators to apply TLS security settings to operands.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "custom",
    "intermediate",
    "modern",
    "old",
    "type"
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
public class TLSSecurityProfile implements Editable<TLSSecurityProfileBuilder>, KubernetesResource
{

    @JsonProperty("custom")
    private CustomTLSProfile custom;
    @JsonProperty("intermediate")
    private IntermediateTLSProfile intermediate;
    @JsonProperty("modern")
    private ModernTLSProfile modern;
    @JsonProperty("old")
    private OldTLSProfile old;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TLSSecurityProfile() {
    }

    public TLSSecurityProfile(CustomTLSProfile custom, IntermediateTLSProfile intermediate, ModernTLSProfile modern, OldTLSProfile old, String type) {
        super();
        this.custom = custom;
        this.intermediate = intermediate;
        this.modern = modern;
        this.old = old;
        this.type = type;
    }

    /**
     * TLSSecurityProfile defines the schema for a TLS security profile. This object is used by operators to apply TLS security settings to operands.
     */
    @JsonProperty("custom")
    public CustomTLSProfile getCustom() {
        return custom;
    }

    /**
     * TLSSecurityProfile defines the schema for a TLS security profile. This object is used by operators to apply TLS security settings to operands.
     */
    @JsonProperty("custom")
    public void setCustom(CustomTLSProfile custom) {
        this.custom = custom;
    }

    /**
     * TLSSecurityProfile defines the schema for a TLS security profile. This object is used by operators to apply TLS security settings to operands.
     */
    @JsonProperty("intermediate")
    public IntermediateTLSProfile getIntermediate() {
        return intermediate;
    }

    /**
     * TLSSecurityProfile defines the schema for a TLS security profile. This object is used by operators to apply TLS security settings to operands.
     */
    @JsonProperty("intermediate")
    public void setIntermediate(IntermediateTLSProfile intermediate) {
        this.intermediate = intermediate;
    }

    /**
     * TLSSecurityProfile defines the schema for a TLS security profile. This object is used by operators to apply TLS security settings to operands.
     */
    @JsonProperty("modern")
    public ModernTLSProfile getModern() {
        return modern;
    }

    /**
     * TLSSecurityProfile defines the schema for a TLS security profile. This object is used by operators to apply TLS security settings to operands.
     */
    @JsonProperty("modern")
    public void setModern(ModernTLSProfile modern) {
        this.modern = modern;
    }

    /**
     * TLSSecurityProfile defines the schema for a TLS security profile. This object is used by operators to apply TLS security settings to operands.
     */
    @JsonProperty("old")
    public OldTLSProfile getOld() {
        return old;
    }

    /**
     * TLSSecurityProfile defines the schema for a TLS security profile. This object is used by operators to apply TLS security settings to operands.
     */
    @JsonProperty("old")
    public void setOld(OldTLSProfile old) {
        this.old = old;
    }

    /**
     * type is one of Old, Intermediate, Modern or Custom. Custom provides the ability to specify individual TLS security profile parameters. Old, Intermediate and Modern are TLS security profiles based on:<br><p> <br><p> https://wiki.mozilla.org/Security/Server_Side_TLS#Recommended_configurations<br><p> <br><p> The profiles are intent based, so they may change over time as new ciphers are developed and existing ciphers are found to be insecure.  Depending on precisely which ciphers are available to a process, the list may be reduced.<br><p> <br><p> Note that the Modern profile is currently not supported because it is not yet well adopted by common software libraries.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is one of Old, Intermediate, Modern or Custom. Custom provides the ability to specify individual TLS security profile parameters. Old, Intermediate and Modern are TLS security profiles based on:<br><p> <br><p> https://wiki.mozilla.org/Security/Server_Side_TLS#Recommended_configurations<br><p> <br><p> The profiles are intent based, so they may change over time as new ciphers are developed and existing ciphers are found to be insecure.  Depending on precisely which ciphers are available to a process, the list may be reduced.<br><p> <br><p> Note that the Modern profile is currently not supported because it is not yet well adopted by common software libraries.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public TLSSecurityProfileBuilder edit() {
        return new TLSSecurityProfileBuilder(this);
    }

    @JsonIgnore
    public TLSSecurityProfileBuilder toBuilder() {
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
        if (!(o instanceof TLSSecurityProfile)) {
            return false;
        }
        TLSSecurityProfile other = (TLSSecurityProfile) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$custom = this.getCustom();
        Object other$custom = other.getCustom();
        if (this$custom == null ? other$custom != null : !this$custom.equals(other$custom)) {
            return false;
        }
        Object this$intermediate = this.getIntermediate();
        Object other$intermediate = other.getIntermediate();
        if (this$intermediate == null ? other$intermediate != null : !this$intermediate.equals(other$intermediate)) {
            return false;
        }
        Object this$modern = this.getModern();
        Object other$modern = other.getModern();
        if (this$modern == null ? other$modern != null : !this$modern.equals(other$modern)) {
            return false;
        }
        Object this$old = this.getOld();
        Object other$old = other.getOld();
        if (this$old == null ? other$old != null : !this$old.equals(other$old)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof TLSSecurityProfile;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $custom = this.getCustom();
        result = result * prime + ($custom == null ? 43 : $custom.hashCode());
        Object $intermediate = this.getIntermediate();
        result = result * prime + ($intermediate == null ? 43 : $intermediate.hashCode());
        Object $modern = this.getModern();
        result = result * prime + ($modern == null ? 43 : $modern.hashCode());
        Object $old = this.getOld();
        result = result * prime + ($old == null ? 43 : $old.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TLSSecurityProfile(" + "custom=" + this.getCustom() + ", intermediate=" + this.getIntermediate() + ", modern=" + this.getModern() + ", old=" + this.getOld() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
