
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
 * StepResource represents the status of a resource to be tracked by an InstallPlan.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "group",
    "manifest",
    "name",
    "sourceName",
    "sourceNamespace",
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
public class StepResource implements Editable<StepResourceBuilder>, KubernetesResource
{

    @JsonProperty("group")
    private String group;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("manifest")
    private String manifest;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sourceName")
    private String sourceName;
    @JsonProperty("sourceNamespace")
    private String sourceNamespace;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StepResource() {
    }

    public StepResource(String group, String kind, String manifest, String name, String sourceName, String sourceNamespace, String version) {
        super();
        this.group = group;
        this.kind = kind;
        this.manifest = manifest;
        this.name = name;
        this.sourceName = sourceName;
        this.sourceNamespace = sourceNamespace;
        this.version = version;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("manifest")
    public String getManifest() {
        return manifest;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("manifest")
    public void setManifest(String manifest) {
        this.manifest = manifest;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("sourceName")
    public String getSourceName() {
        return sourceName;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("sourceName")
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("sourceNamespace")
    public String getSourceNamespace() {
        return sourceNamespace;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * StepResource represents the status of a resource to be tracked by an InstallPlan.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public StepResourceBuilder edit() {
        return new StepResourceBuilder(this);
    }

    @JsonIgnore
    public StepResourceBuilder toBuilder() {
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
