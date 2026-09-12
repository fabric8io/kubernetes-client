
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configFile",
    "nonReadable",
    "nonWritable",
    "topic"
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
public class KafkaIOSpec implements Editable<KafkaIOSpecBuilder>, KubernetesResource
{

    @JsonProperty("configFile")
    private String configFile;
    @JsonProperty("nonReadable")
    private Boolean nonReadable;
    @JsonProperty("nonWritable")
    private Boolean nonWritable;
    @JsonProperty("topic")
    private String topic;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KafkaIOSpec() {
    }

    public KafkaIOSpec(String configFile, Boolean nonReadable, Boolean nonWritable, String topic) {
        super();
        this.configFile = configFile;
        this.nonReadable = nonReadable;
        this.nonWritable = nonWritable;
        this.topic = topic;
    }

    /**
     * The path of server config
     */
    @JsonProperty("configFile")
    public String getConfigFile() {
        return configFile;
    }

    /**
     * The path of server config
     */
    @JsonProperty("configFile")
    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    /**
     * Make kafka cluster non-readable
     */
    @JsonProperty("nonReadable")
    public Boolean getNonReadable() {
        return nonReadable;
    }

    /**
     * Make kafka cluster non-readable
     */
    @JsonProperty("nonReadable")
    public void setNonReadable(Boolean nonReadable) {
        this.nonReadable = nonReadable;
    }

    /**
     * Make kafka cluster non-writable
     */
    @JsonProperty("nonWritable")
    public Boolean getNonWritable() {
        return nonWritable;
    }

    /**
     * Make kafka cluster non-writable
     */
    @JsonProperty("nonWritable")
    public void setNonWritable(Boolean nonWritable) {
        this.nonWritable = nonWritable;
    }

    /**
     * The topic to attack
     */
    @JsonProperty("topic")
    public String getTopic() {
        return topic;
    }

    /**
     * The topic to attack
     */
    @JsonProperty("topic")
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @JsonIgnore
    public KafkaIOSpecBuilder edit() {
        return new KafkaIOSpecBuilder(this);
    }

    @JsonIgnore
    public KafkaIOSpecBuilder toBuilder() {
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
        if (!(o instanceof KafkaIOSpec)) {
            return false;
        }
        KafkaIOSpec other = (KafkaIOSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configFile = this.getConfigFile();
        Object other$configFile = other.getConfigFile();
        if (this$configFile == null ? other$configFile != null : !this$configFile.equals(other$configFile)) {
            return false;
        }
        Object this$nonReadable = this.getNonReadable();
        Object other$nonReadable = other.getNonReadable();
        if (this$nonReadable == null ? other$nonReadable != null : !this$nonReadable.equals(other$nonReadable)) {
            return false;
        }
        Object this$nonWritable = this.getNonWritable();
        Object other$nonWritable = other.getNonWritable();
        if (this$nonWritable == null ? other$nonWritable != null : !this$nonWritable.equals(other$nonWritable)) {
            return false;
        }
        Object this$topic = this.getTopic();
        Object other$topic = other.getTopic();
        if (this$topic == null ? other$topic != null : !this$topic.equals(other$topic)) {
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
        return other instanceof KafkaIOSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configFile = this.getConfigFile();
        result = result * prime + ($configFile == null ? 43 : $configFile.hashCode());
        Object $nonReadable = this.getNonReadable();
        result = result * prime + ($nonReadable == null ? 43 : $nonReadable.hashCode());
        Object $nonWritable = this.getNonWritable();
        result = result * prime + ($nonWritable == null ? 43 : $nonWritable.hashCode());
        Object $topic = this.getTopic();
        result = result * prime + ($topic == null ? 43 : $topic.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaIOSpec(" + "configFile=" + this.getConfigFile() + ", nonReadable=" + this.getNonReadable() + ", nonWritable=" + this.getNonWritable() + ", topic=" + this.getTopic() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
