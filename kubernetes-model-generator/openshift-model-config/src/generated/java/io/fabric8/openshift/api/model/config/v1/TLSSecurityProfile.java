
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
