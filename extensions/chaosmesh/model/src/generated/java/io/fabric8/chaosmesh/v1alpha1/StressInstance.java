
package io.fabric8.chaosmesh.v1alpha1;

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
 * StressInstance is an instance generates stresses
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "memoryStartTime",
    "memoryUid",
    "startTime",
    "uid"
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
public class StressInstance implements Editable<StressInstanceBuilder>, KubernetesResource
{

    @JsonProperty("memoryStartTime")
    private String memoryStartTime;
    @JsonProperty("memoryUid")
    private String memoryUid;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StressInstance() {
    }

    public StressInstance(String memoryStartTime, String memoryUid, String startTime, String uid) {
        super();
        this.memoryStartTime = memoryStartTime;
        this.memoryUid = memoryUid;
        this.startTime = startTime;
        this.uid = uid;
    }

    /**
     * StressInstance is an instance generates stresses
     */
    @JsonProperty("memoryStartTime")
    public String getMemoryStartTime() {
        return memoryStartTime;
    }

    /**
     * StressInstance is an instance generates stresses
     */
    @JsonProperty("memoryStartTime")
    public void setMemoryStartTime(String memoryStartTime) {
        this.memoryStartTime = memoryStartTime;
    }

    /**
     * MemoryUID is the memStress identifier
     */
    @JsonProperty("memoryUid")
    public String getMemoryUid() {
        return memoryUid;
    }

    /**
     * MemoryUID is the memStress identifier
     */
    @JsonProperty("memoryUid")
    public void setMemoryUid(String memoryUid) {
        this.memoryUid = memoryUid;
    }

    /**
     * StressInstance is an instance generates stresses
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * StressInstance is an instance generates stresses
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * UID is the stress-ng identifier
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * UID is the stress-ng identifier
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public StressInstanceBuilder edit() {
        return new StressInstanceBuilder(this);
    }

    @JsonIgnore
    public StressInstanceBuilder toBuilder() {
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
