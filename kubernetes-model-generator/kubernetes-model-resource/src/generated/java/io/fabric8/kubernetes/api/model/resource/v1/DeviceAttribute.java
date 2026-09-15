
package io.fabric8.kubernetes.api.model.resource.v1;

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

/**
 * DeviceAttribute must have exactly one field set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bool",
    "bools",
    "int",
    "ints",
    "string",
    "strings",
    "version",
    "versions"
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
public class DeviceAttribute implements Editable<DeviceAttributeBuilder>, KubernetesResource
{

    @JsonProperty("bool")
    private Boolean bool;
    @JsonProperty("bools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Boolean> bools = new ArrayList<>();
    @JsonProperty("int")
    private Long _int;
    @JsonProperty("ints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Long> ints = new ArrayList<>();
    @JsonProperty("string")
    private String string;
    @JsonProperty("strings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> strings = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonProperty("versions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> versions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceAttribute() {
    }

    public DeviceAttribute(Boolean bool, List<Boolean> bools, Long _int, List<Long> ints, String string, List<String> strings, String version, List<String> versions) {
        super();
        this.bool = bool;
        this.bools = bools;
        this._int = _int;
        this.ints = ints;
        this.string = string;
        this.strings = strings;
        this.version = version;
        this.versions = versions;
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
     * BoolValues is a non-empty list of true/false values.
     */
    @JsonProperty("bools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Boolean> getBools() {
        return bools;
    }

    /**
     * BoolValues is a non-empty list of true/false values.
     */
    @JsonProperty("bools")
    public void setBools(List<Boolean> bools) {
        this.bools = bools;
    }

    /**
     * IntValue is a number.
     */
    @JsonProperty("int")
    public Long getInt() {
        return _int;
    }

    /**
     * IntValue is a number.
     */
    @JsonProperty("int")
    public void setInt(Long _int) {
        this._int = _int;
    }

    /**
     * IntValues is a non-empty list of numbers.<br><p> <br><p> This is an alpha field and requires enabling the DRAListTypeAttributes feature gate.
     */
    @JsonProperty("ints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Long> getInts() {
        return ints;
    }

    /**
     * IntValues is a non-empty list of numbers.<br><p> <br><p> This is an alpha field and requires enabling the DRAListTypeAttributes feature gate.
     */
    @JsonProperty("ints")
    public void setInts(List<Long> ints) {
        this.ints = ints;
    }

    /**
     * StringValue is a string. Must not be longer than 64 characters.
     */
    @JsonProperty("string")
    public String getString() {
        return string;
    }

    /**
     * StringValue is a string. Must not be longer than 64 characters.
     */
    @JsonProperty("string")
    public void setString(String string) {
        this.string = string;
    }

    /**
     * StringValues is a non-empty list of strings. Each string must not be longer than 64 characters.<br><p> <br><p> This is an alpha field and requires enabling the DRAListTypeAttributes feature gate.
     */
    @JsonProperty("strings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getStrings() {
        return strings;
    }

    /**
     * StringValues is a non-empty list of strings. Each string must not be longer than 64 characters.<br><p> <br><p> This is an alpha field and requires enabling the DRAListTypeAttributes feature gate.
     */
    @JsonProperty("strings")
    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    /**
     * VersionValue is a semantic version according to semver.org spec 2.0.0. Must not be longer than 64 characters.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * VersionValue is a semantic version according to semver.org spec 2.0.0. Must not be longer than 64 characters.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * VersionValues is a non-empty list of semantic versions according to semver.org spec 2.0.0. Each version string must not be longer than 64 characters.<br><p> <br><p> This is an alpha field and requires enabling the DRAListTypeAttributes feature gate.
     */
    @JsonProperty("versions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getVersions() {
        return versions;
    }

    /**
     * VersionValues is a non-empty list of semantic versions according to semver.org spec 2.0.0. Each version string must not be longer than 64 characters.<br><p> <br><p> This is an alpha field and requires enabling the DRAListTypeAttributes feature gate.
     */
    @JsonProperty("versions")
    public void setVersions(List<String> versions) {
        this.versions = versions;
    }

    @JsonIgnore
    public DeviceAttributeBuilder edit() {
        return new DeviceAttributeBuilder(this);
    }

    @JsonIgnore
    public DeviceAttributeBuilder toBuilder() {
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
        if (!(o instanceof DeviceAttribute)) {
            return false;
        }
        DeviceAttribute other = (DeviceAttribute) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bool = this.getBool();
        Object other$bool = other.getBool();
        if (this$bool == null ? other$bool != null : !this$bool.equals(other$bool)) {
            return false;
        }
        Object this$bools = this.getBools();
        Object other$bools = other.getBools();
        if (this$bools == null ? other$bools != null : !this$bools.equals(other$bools)) {
            return false;
        }
        Object this$_int = this.getInt();
        Object other$_int = other.getInt();
        if (this$_int == null ? other$_int != null : !this$_int.equals(other$_int)) {
            return false;
        }
        Object this$ints = this.getInts();
        Object other$ints = other.getInts();
        if (this$ints == null ? other$ints != null : !this$ints.equals(other$ints)) {
            return false;
        }
        Object this$string = this.getString();
        Object other$string = other.getString();
        if (this$string == null ? other$string != null : !this$string.equals(other$string)) {
            return false;
        }
        Object this$strings = this.getStrings();
        Object other$strings = other.getStrings();
        if (this$strings == null ? other$strings != null : !this$strings.equals(other$strings)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
            return false;
        }
        Object this$versions = this.getVersions();
        Object other$versions = other.getVersions();
        if (this$versions == null ? other$versions != null : !this$versions.equals(other$versions)) {
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
        return other instanceof DeviceAttribute;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bool = this.getBool();
        result = result * prime + ($bool == null ? 43 : $bool.hashCode());
        Object $bools = this.getBools();
        result = result * prime + ($bools == null ? 43 : $bools.hashCode());
        Object $_int = this.getInt();
        result = result * prime + ($_int == null ? 43 : $_int.hashCode());
        Object $ints = this.getInts();
        result = result * prime + ($ints == null ? 43 : $ints.hashCode());
        Object $string = this.getString();
        result = result * prime + ($string == null ? 43 : $string.hashCode());
        Object $strings = this.getStrings();
        result = result * prime + ($strings == null ? 43 : $strings.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $versions = this.getVersions();
        result = result * prime + ($versions == null ? 43 : $versions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DeviceAttribute(" + "bool=" + this.getBool() + ", bools=" + this.getBools() + ", _int=" + this.getInt() + ", ints=" + this.getInts() + ", string=" + this.getString() + ", strings=" + this.getStrings() + ", version=" + this.getVersion() + ", versions=" + this.getVersions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
