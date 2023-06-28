
package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.config.v1.SecretNameReference;
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
    "sourcePod",
    "targetEndpoint",
    "tlsClientCert"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PodNetworkConnectivityCheckSpec implements KubernetesResource
{

    @JsonProperty("sourcePod")
    private String sourcePod;
    @JsonProperty("targetEndpoint")
    private String targetEndpoint;
    @JsonProperty("tlsClientCert")
    private SecretNameReference tlsClientCert;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodNetworkConnectivityCheckSpec() {
    }

    public PodNetworkConnectivityCheckSpec(String sourcePod, String targetEndpoint, SecretNameReference tlsClientCert) {
        super();
        this.sourcePod = sourcePod;
        this.targetEndpoint = targetEndpoint;
        this.tlsClientCert = tlsClientCert;
    }

    @JsonProperty("sourcePod")
    public String getSourcePod() {
        return sourcePod;
    }

    @JsonProperty("sourcePod")
    public void setSourcePod(String sourcePod) {
        this.sourcePod = sourcePod;
    }

    @JsonProperty("targetEndpoint")
    public String getTargetEndpoint() {
        return targetEndpoint;
    }

    @JsonProperty("targetEndpoint")
    public void setTargetEndpoint(String targetEndpoint) {
        this.targetEndpoint = targetEndpoint;
    }

    @JsonProperty("tlsClientCert")
    public SecretNameReference getTlsClientCert() {
        return tlsClientCert;
    }

    @JsonProperty("tlsClientCert")
    public void setTlsClientCert(SecretNameReference tlsClientCert) {
        this.tlsClientCert = tlsClientCert;
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
