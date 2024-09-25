package io.fabric8.volcano.scheduling.v1alpha1;

import io.fabric8.volcano.scheduling.v1alpha1.builder.JobListBuilder;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午6:29
 * @FileName：JobList
 * @Description:
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "apiVersion",
        "kind",
        "metadata",
        "items"
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
@Version("v1beta1")
@Group("scheduling.volcano.sh")
@Generated("jsonschema2pojo")

public class JobList implements Editable<JobListBuilder>, KubernetesResource, KubernetesResourceList<Job> {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "scheduling.volcano.sh/v1beta1";
    @JsonProperty("items")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Job> items = new ArrayList<Job>();
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("kind")
    private String kind = "JobList";
    @JsonProperty("metadata")
    private ListMeta metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public JobList() {
    }

    public JobList(String apiVersion, List<Job> items, String kind, ListMeta metadata) {
        super();
        this.apiVersion = apiVersion;
        this.items = items;
        this.kind = kind;
        this.metadata = metadata;
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

    @JsonProperty("items")
    public List<Job> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Job> items) {
        this.items = items;
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
    public ListMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ListMeta metadata) {
        this.metadata = metadata;
    }

    @JsonIgnore
    public io.fabric8.volcano.scheduling.v1alpha1.builder.JobListBuilder edit() {
        return new io.fabric8.volcano.scheduling.v1alpha1.builder.JobListBuilder(this);
    }

    @JsonIgnore
    public JobListBuilder toBuilder() {
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

