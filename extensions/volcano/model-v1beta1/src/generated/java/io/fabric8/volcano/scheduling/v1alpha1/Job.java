package io.fabric8.volcano.scheduling.v1alpha1;

import io.fabric8.volcano.scheduling.v1alpha1.builder.JobBuilder;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "apiVersion",
        "kind",
        "metadata",
        "spec",
        "status"
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
        @BuildableReference(PersistentVolumeClaim.class),
        @BuildableReference(EnvVar.class),
        @BuildableReference(ContainerPort.class),
        @BuildableReference(Volume.class),
        @BuildableReference(VolumeMount.class)
})
@Version("v1alpha1")
@Group("batch.volcano.sh")
@Generated("jsonschema2pojo")
public class Job implements Editable<io.fabric8.volcano.scheduling.v1alpha1.builder.JobBuilder>, HasMetadata {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "batch.volcano.sh/v1alpha1";

    @JsonProperty("kind")
    private String kind = "Job";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private JobSpec spec;
    @JsonProperty("status")
    private JobStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Job() {
    }

    public Job(String apiVersion, String kind, ObjectMeta metadata, JobSpec spec, JobStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("spec")
    public JobSpec getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(JobSpec spec) {
        this.spec = spec;
    }

    @JsonProperty("status")
    public JobStatus getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(JobStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public io.fabric8.volcano.scheduling.v1alpha1.builder.JobBuilder edit() {
        return new io.fabric8.volcano.scheduling.v1alpha1.builder.JobBuilder(this);
    }

    @JsonIgnore
    public JobBuilder toBuilder() {
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
