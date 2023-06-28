
package io.fabric8.istio.api.security.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.istio.api.type.v1beta1.WorkloadSelector;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "mtls",
    "portLevelMtls",
    "selector"
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
@Generated("jsonschema2pojo")
public class PeerAuthenticationSpec implements KubernetesResource
{

    @JsonProperty("mtls")
    private io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS mtls;
    @JsonProperty("portLevelMtls")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<Long, io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS> portLevelMtls = new LinkedHashMap<Long, io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS>();
    @JsonProperty("selector")
    private WorkloadSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PeerAuthenticationSpec() {
    }

    public PeerAuthenticationSpec(io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS mtls, Map<Long, io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS> portLevelMtls, WorkloadSelector selector) {
        super();
        this.mtls = mtls;
        this.portLevelMtls = portLevelMtls;
        this.selector = selector;
    }

    @JsonProperty("mtls")
    public io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS getMtls() {
        return mtls;
    }

    @JsonProperty("mtls")
    public void setMtls(io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS mtls) {
        this.mtls = mtls;
    }

    @JsonProperty("portLevelMtls")
    public Map<Long, io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS> getPortLevelMtls() {
        return portLevelMtls;
    }

    @JsonProperty("portLevelMtls")
    public void setPortLevelMtls(Map<Long, io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS> portLevelMtls) {
        this.portLevelMtls = portLevelMtls;
    }

    @JsonProperty("selector")
    public WorkloadSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(WorkloadSelector selector) {
        this.selector = selector;
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
