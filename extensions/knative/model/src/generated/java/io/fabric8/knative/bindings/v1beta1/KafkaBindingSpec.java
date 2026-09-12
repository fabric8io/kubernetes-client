
package io.fabric8.knative.bindings.v1beta1;

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
import io.fabric8.knative.pkg.tracker.Reference;
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
 * KafkaBindingSpec defines the desired state of the KafkaBinding.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bootstrapServers",
    "net",
    "subject"
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
public class KafkaBindingSpec implements Editable<KafkaBindingSpecBuilder>, KubernetesResource
{

    @JsonProperty("bootstrapServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bootstrapServers = new ArrayList<>();
    @JsonProperty("net")
    private KafkaNetSpec net;
    @JsonProperty("subject")
    private Reference subject;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KafkaBindingSpec() {
    }

    public KafkaBindingSpec(List<String> bootstrapServers, KafkaNetSpec net, Reference subject) {
        super();
        this.bootstrapServers = bootstrapServers;
        this.net = net;
        this.subject = subject;
    }

    /**
     * Bootstrap servers are the Kafka servers the consumer will connect to.
     */
    @JsonProperty("bootstrapServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBootstrapServers() {
        return bootstrapServers;
    }

    /**
     * Bootstrap servers are the Kafka servers the consumer will connect to.
     */
    @JsonProperty("bootstrapServers")
    public void setBootstrapServers(List<String> bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    /**
     * KafkaBindingSpec defines the desired state of the KafkaBinding.
     */
    @JsonProperty("net")
    public KafkaNetSpec getNet() {
        return net;
    }

    /**
     * KafkaBindingSpec defines the desired state of the KafkaBinding.
     */
    @JsonProperty("net")
    public void setNet(KafkaNetSpec net) {
        this.net = net;
    }

    /**
     * KafkaBindingSpec defines the desired state of the KafkaBinding.
     */
    @JsonProperty("subject")
    public Reference getSubject() {
        return subject;
    }

    /**
     * KafkaBindingSpec defines the desired state of the KafkaBinding.
     */
    @JsonProperty("subject")
    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    @JsonIgnore
    public KafkaBindingSpecBuilder edit() {
        return new KafkaBindingSpecBuilder(this);
    }

    @JsonIgnore
    public KafkaBindingSpecBuilder toBuilder() {
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
        if (!(o instanceof KafkaBindingSpec)) {
            return false;
        }
        KafkaBindingSpec other = (KafkaBindingSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bootstrapServers = this.getBootstrapServers();
        Object other$bootstrapServers = other.getBootstrapServers();
        if (this$bootstrapServers == null ? other$bootstrapServers != null : !this$bootstrapServers.equals(other$bootstrapServers)) {
            return false;
        }
        Object this$net = this.getNet();
        Object other$net = other.getNet();
        if (this$net == null ? other$net != null : !this$net.equals(other$net)) {
            return false;
        }
        Object this$subject = this.getSubject();
        Object other$subject = other.getSubject();
        if (this$subject == null ? other$subject != null : !this$subject.equals(other$subject)) {
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
        return other instanceof KafkaBindingSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bootstrapServers = this.getBootstrapServers();
        result = result * prime + ($bootstrapServers == null ? 43 : $bootstrapServers.hashCode());
        Object $net = this.getNet();
        result = result * prime + ($net == null ? 43 : $net.hashCode());
        Object $subject = this.getSubject();
        result = result * prime + ($subject == null ? 43 : $subject.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaBindingSpec(" + "bootstrapServers=" + this.getBootstrapServers() + ", net=" + this.getNet() + ", subject=" + this.getSubject() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
