
package io.fabric8.openclustermanagement.api.model.apps.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "lastposthookjob",
    "lastprehookjob",
    "posthookjobshistory",
    "prehookjobshistory"
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
public class AnsibleJobsStatus implements Editable<AnsibleJobsStatusBuilder> , KubernetesResource
{

    @JsonProperty("lastposthookjob")
    private String lastposthookjob;
    @JsonProperty("lastprehookjob")
    private String lastprehookjob;
    @JsonProperty("posthookjobshistory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> posthookjobshistory = new ArrayList<>();
    @JsonProperty("prehookjobshistory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> prehookjobshistory = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AnsibleJobsStatus() {
    }

    public AnsibleJobsStatus(String lastposthookjob, String lastprehookjob, List<String> posthookjobshistory, List<String> prehookjobshistory) {
        super();
        this.lastposthookjob = lastposthookjob;
        this.lastprehookjob = lastprehookjob;
        this.posthookjobshistory = posthookjobshistory;
        this.prehookjobshistory = prehookjobshistory;
    }

    @JsonProperty("lastposthookjob")
    public String getLastposthookjob() {
        return lastposthookjob;
    }

    @JsonProperty("lastposthookjob")
    public void setLastposthookjob(String lastposthookjob) {
        this.lastposthookjob = lastposthookjob;
    }

    @JsonProperty("lastprehookjob")
    public String getLastprehookjob() {
        return lastprehookjob;
    }

    @JsonProperty("lastprehookjob")
    public void setLastprehookjob(String lastprehookjob) {
        this.lastprehookjob = lastprehookjob;
    }

    @JsonProperty("posthookjobshistory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPosthookjobshistory() {
        return posthookjobshistory;
    }

    @JsonProperty("posthookjobshistory")
    public void setPosthookjobshistory(List<String> posthookjobshistory) {
        this.posthookjobshistory = posthookjobshistory;
    }

    @JsonProperty("prehookjobshistory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPrehookjobshistory() {
        return prehookjobshistory;
    }

    @JsonProperty("prehookjobshistory")
    public void setPrehookjobshistory(List<String> prehookjobshistory) {
        this.prehookjobshistory = prehookjobshistory;
    }

    @JsonIgnore
    public AnsibleJobsStatusBuilder edit() {
        return new AnsibleJobsStatusBuilder(this);
    }

    @JsonIgnore
    public AnsibleJobsStatusBuilder toBuilder() {
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
