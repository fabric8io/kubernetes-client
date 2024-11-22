
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
import io.fabric8.kubernetes.api.model.Quantity;
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
    "bool",
    "int",
    "intSlice",
    "name",
    "quantity",
    "string",
    "stringSlice",
    "version"
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
public class NamedResourcesAttribute implements Editable<NamedResourcesAttributeBuilder> , KubernetesResource
{

    @JsonProperty("bool")
    private Boolean bool;
    @JsonProperty("int")
    private Long _int;
    @JsonProperty("intSlice")
    private NamedResourcesIntSlice intSlice;
    @JsonProperty("name")
    private String name;
    @JsonProperty("quantity")
    private Quantity quantity;
    @JsonProperty("string")
    private String string;
    @JsonProperty("stringSlice")
    private NamedResourcesStringSlice stringSlice;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NamedResourcesAttribute() {
    }

    public NamedResourcesAttribute(Boolean bool, Long _int, NamedResourcesIntSlice intSlice, String name, Quantity quantity, String string, NamedResourcesStringSlice stringSlice, String version) {
        super();
        this.bool = bool;
        this._int = _int;
        this.intSlice = intSlice;
        this.name = name;
        this.quantity = quantity;
        this.string = string;
        this.stringSlice = stringSlice;
        this.version = version;
    }

    @JsonProperty("bool")
    public Boolean getBool() {
        return bool;
    }

    @JsonProperty("bool")
    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    @JsonProperty("int")
    public Long getInt() {
        return _int;
    }

    @JsonProperty("int")
    public void setInt(Long _int) {
        this._int = _int;
    }

    @JsonProperty("intSlice")
    public NamedResourcesIntSlice getIntSlice() {
        return intSlice;
    }

    @JsonProperty("intSlice")
    public void setIntSlice(NamedResourcesIntSlice intSlice) {
        this.intSlice = intSlice;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("string")
    public String getString() {
        return string;
    }

    @JsonProperty("string")
    public void setString(String string) {
        this.string = string;
    }

    @JsonProperty("stringSlice")
    public NamedResourcesStringSlice getStringSlice() {
        return stringSlice;
    }

    @JsonProperty("stringSlice")
    public void setStringSlice(NamedResourcesStringSlice stringSlice) {
        this.stringSlice = stringSlice;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public NamedResourcesAttributeBuilder edit() {
        return new NamedResourcesAttributeBuilder(this);
    }

    @JsonIgnore
    public NamedResourcesAttributeBuilder toBuilder() {
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
