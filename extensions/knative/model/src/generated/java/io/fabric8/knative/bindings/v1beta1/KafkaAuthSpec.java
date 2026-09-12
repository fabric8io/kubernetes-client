
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
    "bootstrapServers",
    "net"
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
public class KafkaAuthSpec implements Editable<KafkaAuthSpecBuilder>, KubernetesResource
{

    @JsonProperty("bootstrapServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bootstrapServers = new ArrayList<>();
    @JsonProperty("net")
    private KafkaNetSpec net;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KafkaAuthSpec() {
    }

    public KafkaAuthSpec(List<String> bootstrapServers, KafkaNetSpec net) {
        super();
        this.bootstrapServers = bootstrapServers;
        this.net = net;
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

    @JsonProperty("net")
    public KafkaNetSpec getNet() {
        return net;
    }

    @JsonProperty("net")
    public void setNet(KafkaNetSpec net) {
        this.net = net;
    }

    @JsonIgnore
    public KafkaAuthSpecBuilder edit() {
        return new KafkaAuthSpecBuilder(this);
    }

    @JsonIgnore
    public KafkaAuthSpecBuilder toBuilder() {
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
        if (!(o instanceof KafkaAuthSpec)) {
            return false;
        }
        KafkaAuthSpec other = (KafkaAuthSpec) o;
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof KafkaAuthSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bootstrapServers = this.getBootstrapServers();
        result = result * prime + ($bootstrapServers == null ? 43 : $bootstrapServers.hashCode());
        Object $net = this.getNet();
        result = result * prime + ($net == null ? 43 : $net.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaAuthSpec(" + "bootstrapServers=" + this.getBootstrapServers() + ", net=" + this.getNet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
