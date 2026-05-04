
package io.fabric8.kubernetes.api.model.resource.v1beta2;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
