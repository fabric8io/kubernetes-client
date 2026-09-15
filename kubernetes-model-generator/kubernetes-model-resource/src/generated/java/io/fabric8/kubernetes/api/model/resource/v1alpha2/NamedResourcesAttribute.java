
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * NamedResourcesAttribute is a combination of an attribute name and its value.
 */
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
public class NamedResourcesAttribute implements Editable<NamedResourcesAttributeBuilder>, KubernetesResource
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

    /**
     * BoolValue is a true/false value.
     */
    @JsonProperty("bool")
    public Boolean getBool() {
        return bool;
    }

    /**
     * BoolValue is a true/false value.
     */
    @JsonProperty("bool")
    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    /**
     * IntValue is a 64-bit integer.
     */
    @JsonProperty("int")
    public Long getInt() {
        return _int;
    }

    /**
     * IntValue is a 64-bit integer.
     */
    @JsonProperty("int")
    public void setInt(Long _int) {
        this._int = _int;
    }

    /**
     * NamedResourcesAttribute is a combination of an attribute name and its value.
     */
    @JsonProperty("intSlice")
    public NamedResourcesIntSlice getIntSlice() {
        return intSlice;
    }

    /**
     * NamedResourcesAttribute is a combination of an attribute name and its value.
     */
    @JsonProperty("intSlice")
    public void setIntSlice(NamedResourcesIntSlice intSlice) {
        this.intSlice = intSlice;
    }

    /**
     * Name is unique identifier among all resource instances managed by the driver on the node. It must be a DNS subdomain.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is unique identifier among all resource instances managed by the driver on the node. It must be a DNS subdomain.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * NamedResourcesAttribute is a combination of an attribute name and its value.
     */
    @JsonProperty("quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    /**
     * NamedResourcesAttribute is a combination of an attribute name and its value.
     */
    @JsonProperty("quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    /**
     * StringValue is a string.
     */
    @JsonProperty("string")
    public String getString() {
        return string;
    }

    /**
     * StringValue is a string.
     */
    @JsonProperty("string")
    public void setString(String string) {
        this.string = string;
    }

    /**
     * NamedResourcesAttribute is a combination of an attribute name and its value.
     */
    @JsonProperty("stringSlice")
    public NamedResourcesStringSlice getStringSlice() {
        return stringSlice;
    }

    /**
     * NamedResourcesAttribute is a combination of an attribute name and its value.
     */
    @JsonProperty("stringSlice")
    public void setStringSlice(NamedResourcesStringSlice stringSlice) {
        this.stringSlice = stringSlice;
    }

    /**
     * VersionValue is a semantic version according to semver.org spec 2.0.0.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * VersionValue is a semantic version according to semver.org spec 2.0.0.
     */
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
        if (!(o instanceof NamedResourcesAttribute)) {
            return false;
        }
        NamedResourcesAttribute other = (NamedResourcesAttribute) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bool = this.getBool();
        Object other$bool = other.getBool();
        if (this$bool == null ? other$bool != null : !this$bool.equals(other$bool)) {
            return false;
        }
        Object this$_int = this.getInt();
        Object other$_int = other.getInt();
        if (this$_int == null ? other$_int != null : !this$_int.equals(other$_int)) {
            return false;
        }
        Object this$intSlice = this.getIntSlice();
        Object other$intSlice = other.getIntSlice();
        if (this$intSlice == null ? other$intSlice != null : !this$intSlice.equals(other$intSlice)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$quantity = this.getQuantity();
        Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) {
            return false;
        }
        Object this$string = this.getString();
        Object other$string = other.getString();
        if (this$string == null ? other$string != null : !this$string.equals(other$string)) {
            return false;
        }
        Object this$stringSlice = this.getStringSlice();
        Object other$stringSlice = other.getStringSlice();
        if (this$stringSlice == null ? other$stringSlice != null : !this$stringSlice.equals(other$stringSlice)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof NamedResourcesAttribute;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bool = this.getBool();
        result = result * prime + ($bool == null ? 43 : $bool.hashCode());
        Object $_int = this.getInt();
        result = result * prime + ($_int == null ? 43 : $_int.hashCode());
        Object $intSlice = this.getIntSlice();
        result = result * prime + ($intSlice == null ? 43 : $intSlice.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $quantity = this.getQuantity();
        result = result * prime + ($quantity == null ? 43 : $quantity.hashCode());
        Object $string = this.getString();
        result = result * prime + ($string == null ? 43 : $string.hashCode());
        Object $stringSlice = this.getStringSlice();
        result = result * prime + ($stringSlice == null ? 43 : $stringSlice.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NamedResourcesAttribute(" + "bool=" + this.getBool() + ", _int=" + this.getInt() + ", intSlice=" + this.getIntSlice() + ", name=" + this.getName() + ", quantity=" + this.getQuantity() + ", string=" + this.getString() + ", stringSlice=" + this.getStringSlice() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
