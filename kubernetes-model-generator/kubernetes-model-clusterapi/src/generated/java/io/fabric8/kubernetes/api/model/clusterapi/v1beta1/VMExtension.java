
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * VMExtension specifies the parameters for a custom VM extension.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "protectedSettings",
    "publisher",
    "settings",
    "version"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class VMExtension implements Editable<VMExtensionBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("protectedSettings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> protectedSettings = new LinkedHashMap<>();
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("settings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> settings = new LinkedHashMap<>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VMExtension() {
    }

    public VMExtension(String name, Map<String, String> protectedSettings, String publisher, Map<String, String> settings, String version) {
        super();
        this.name = name;
        this.protectedSettings = protectedSettings;
        this.publisher = publisher;
        this.settings = settings;
        this.version = version;
    }

    /**
     * Name is the name of the extension.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the extension.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ProtectedSettings is a JSON formatted protected settings for the extension.
     */
    @JsonProperty("protectedSettings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getProtectedSettings() {
        return protectedSettings;
    }

    /**
     * ProtectedSettings is a JSON formatted protected settings for the extension.
     */
    @JsonProperty("protectedSettings")
    public void setProtectedSettings(Map<String, String> protectedSettings) {
        this.protectedSettings = protectedSettings;
    }

    /**
     * Publisher is the name of the extension handler publisher.
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     * Publisher is the name of the extension handler publisher.
     */
    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Settings is a JSON formatted public settings for the extension.
     */
    @JsonProperty("settings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSettings() {
        return settings;
    }

    /**
     * Settings is a JSON formatted public settings for the extension.
     */
    @JsonProperty("settings")
    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }

    /**
     * Version specifies the version of the script handler.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version specifies the version of the script handler.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public VMExtensionBuilder edit() {
        return new VMExtensionBuilder(this);
    }

    @JsonIgnore
    public VMExtensionBuilder toBuilder() {
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
