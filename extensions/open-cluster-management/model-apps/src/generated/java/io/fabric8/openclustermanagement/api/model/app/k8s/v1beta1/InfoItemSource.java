
package io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    "configMapKeyRef",
    "ingressRef",
    "secretKeyRef",
    "serviceRef",
    "type"
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
public class InfoItemSource implements KubernetesResource
{

    @JsonProperty("configMapKeyRef")
    private ConfigMapKeySelector configMapKeyRef;
    @JsonProperty("ingressRef")
    private IngressSelector ingressRef;
    @JsonProperty("secretKeyRef")
    private SecretKeySelector secretKeyRef;
    @JsonProperty("serviceRef")
    private ServiceSelector serviceRef;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InfoItemSource() {
    }

    /**
     * 
     * @param secretKeyRef
     * @param ingressRef
     * @param configMapKeyRef
     * @param serviceRef
     * @param type
     */
    public InfoItemSource(ConfigMapKeySelector configMapKeyRef, IngressSelector ingressRef, SecretKeySelector secretKeyRef, ServiceSelector serviceRef, String type) {
        super();
        this.configMapKeyRef = configMapKeyRef;
        this.ingressRef = ingressRef;
        this.secretKeyRef = secretKeyRef;
        this.serviceRef = serviceRef;
        this.type = type;
    }

    @JsonProperty("configMapKeyRef")
    public ConfigMapKeySelector getConfigMapKeyRef() {
        return configMapKeyRef;
    }

    @JsonProperty("configMapKeyRef")
    public void setConfigMapKeyRef(ConfigMapKeySelector configMapKeyRef) {
        this.configMapKeyRef = configMapKeyRef;
    }

    @JsonProperty("ingressRef")
    public IngressSelector getIngressRef() {
        return ingressRef;
    }

    @JsonProperty("ingressRef")
    public void setIngressRef(IngressSelector ingressRef) {
        this.ingressRef = ingressRef;
    }

    @JsonProperty("secretKeyRef")
    public SecretKeySelector getSecretKeyRef() {
        return secretKeyRef;
    }

    @JsonProperty("secretKeyRef")
    public void setSecretKeyRef(SecretKeySelector secretKeyRef) {
        this.secretKeyRef = secretKeyRef;
    }

    @JsonProperty("serviceRef")
    public ServiceSelector getServiceRef() {
        return serviceRef;
    }

    @JsonProperty("serviceRef")
    public void setServiceRef(ServiceSelector serviceRef) {
        this.serviceRef = serviceRef;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
