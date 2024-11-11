
package io.fabric8.certmanager.api.model.acme.v1;

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
    "class",
    "ingressClassName",
    "ingressTemplate",
    "name",
    "podTemplate",
    "serviceType"
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
@Generated("jsonschema2pojo")
public class ACMEChallengeSolverHTTP01Ingress implements Editable<ACMEChallengeSolverHTTP01IngressBuilder> , KubernetesResource
{

    @JsonProperty("class")
    private String className;
    @JsonProperty("ingressClassName")
    private String ingressClassName;
    @JsonProperty("ingressTemplate")
    private ACMEChallengeSolverHTTP01IngressTemplate ingressTemplate;
    @JsonProperty("name")
    private String name;
    @JsonProperty("podTemplate")
    private ACMEChallengeSolverHTTP01IngressPodTemplate podTemplate;
    @JsonProperty("serviceType")
    private String serviceType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ACMEChallengeSolverHTTP01Ingress() {
    }

    public ACMEChallengeSolverHTTP01Ingress(String className, String ingressClassName, ACMEChallengeSolverHTTP01IngressTemplate ingressTemplate, String name, ACMEChallengeSolverHTTP01IngressPodTemplate podTemplate, String serviceType) {
        super();
        this.className = className;
        this.ingressClassName = ingressClassName;
        this.ingressTemplate = ingressTemplate;
        this.name = name;
        this.podTemplate = podTemplate;
        this.serviceType = serviceType;
    }

    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    @JsonProperty("ingressClassName")
    public String getIngressClassName() {
        return ingressClassName;
    }

    @JsonProperty("ingressClassName")
    public void setIngressClassName(String ingressClassName) {
        this.ingressClassName = ingressClassName;
    }

    @JsonProperty("ingressTemplate")
    public ACMEChallengeSolverHTTP01IngressTemplate getIngressTemplate() {
        return ingressTemplate;
    }

    @JsonProperty("ingressTemplate")
    public void setIngressTemplate(ACMEChallengeSolverHTTP01IngressTemplate ingressTemplate) {
        this.ingressTemplate = ingressTemplate;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("podTemplate")
    public ACMEChallengeSolverHTTP01IngressPodTemplate getPodTemplate() {
        return podTemplate;
    }

    @JsonProperty("podTemplate")
    public void setPodTemplate(ACMEChallengeSolverHTTP01IngressPodTemplate podTemplate) {
        this.podTemplate = podTemplate;
    }

    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @JsonIgnore
    public ACMEChallengeSolverHTTP01IngressBuilder edit() {
        return new ACMEChallengeSolverHTTP01IngressBuilder(this);
    }

    @JsonIgnore
    public ACMEChallengeSolverHTTP01IngressBuilder toBuilder() {
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
