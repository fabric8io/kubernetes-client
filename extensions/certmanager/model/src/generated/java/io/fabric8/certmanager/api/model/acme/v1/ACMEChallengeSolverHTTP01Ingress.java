
package io.fabric8.certmanager.api.model.acme.v1;

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
    "class",
    "ingressClassName",
    "ingressTemplate",
    "name",
    "podTemplate",
    "serviceType"
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
public class ACMEChallengeSolverHTTP01Ingress implements Editable<ACMEChallengeSolverHTTP01IngressBuilder>, KubernetesResource
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

    /**
     * This field configures the annotation `kubernetes.io/ingress.class` when creating Ingress resources to solve ACME challenges that use this challenge solver. Only one of `class`, `name` or `ingressClassName` may be specified.
     */
    @JsonProperty("class")
    public String getClassName() {
        return className;
    }

    /**
     * This field configures the annotation `kubernetes.io/ingress.class` when creating Ingress resources to solve ACME challenges that use this challenge solver. Only one of `class`, `name` or `ingressClassName` may be specified.
     */
    @JsonProperty("class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * This field configures the field `ingressClassName` on the created Ingress resources used to solve ACME challenges that use this challenge solver. This is the recommended way of configuring the ingress class. Only one of `class`, `name` or `ingressClassName` may be specified.
     */
    @JsonProperty("ingressClassName")
    public String getIngressClassName() {
        return ingressClassName;
    }

    /**
     * This field configures the field `ingressClassName` on the created Ingress resources used to solve ACME challenges that use this challenge solver. This is the recommended way of configuring the ingress class. Only one of `class`, `name` or `ingressClassName` may be specified.
     */
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

    /**
     * The name of the ingress resource that should have ACME challenge solving routes inserted into it in order to solve HTTP01 challenges. This is typically used in conjunction with ingress controllers like ingress-gce, which maintains a 1:1 mapping between external IPs and ingress resources. Only one of `class`, `name` or `ingressClassName` may be specified.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of the ingress resource that should have ACME challenge solving routes inserted into it in order to solve HTTP01 challenges. This is typically used in conjunction with ingress controllers like ingress-gce, which maintains a 1:1 mapping between external IPs and ingress resources. Only one of `class`, `name` or `ingressClassName` may be specified.
     */
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

    /**
     * Optional service type for Kubernetes solver service. Supported values are NodePort or ClusterIP. If unset, defaults to NodePort.
     */
    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Optional service type for Kubernetes solver service. Supported values are NodePort or ClusterIP. If unset, defaults to NodePort.
     */
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
        if (!(o instanceof ACMEChallengeSolverHTTP01Ingress)) {
            return false;
        }
        ACMEChallengeSolverHTTP01Ingress other = (ACMEChallengeSolverHTTP01Ingress) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$className = this.getClassName();
        Object other$className = other.getClassName();
        if (this$className == null ? other$className != null : !this$className.equals(other$className)) {
            return false;
        }
        Object this$ingressClassName = this.getIngressClassName();
        Object other$ingressClassName = other.getIngressClassName();
        if (this$ingressClassName == null ? other$ingressClassName != null : !this$ingressClassName.equals(other$ingressClassName)) {
            return false;
        }
        Object this$ingressTemplate = this.getIngressTemplate();
        Object other$ingressTemplate = other.getIngressTemplate();
        if (this$ingressTemplate == null ? other$ingressTemplate != null : !this$ingressTemplate.equals(other$ingressTemplate)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$podTemplate = this.getPodTemplate();
        Object other$podTemplate = other.getPodTemplate();
        if (this$podTemplate == null ? other$podTemplate != null : !this$podTemplate.equals(other$podTemplate)) {
            return false;
        }
        Object this$serviceType = this.getServiceType();
        Object other$serviceType = other.getServiceType();
        if (this$serviceType == null ? other$serviceType != null : !this$serviceType.equals(other$serviceType)) {
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
        return other instanceof ACMEChallengeSolverHTTP01Ingress;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $className = this.getClassName();
        result = result * prime + ($className == null ? 43 : $className.hashCode());
        Object $ingressClassName = this.getIngressClassName();
        result = result * prime + ($ingressClassName == null ? 43 : $ingressClassName.hashCode());
        Object $ingressTemplate = this.getIngressTemplate();
        result = result * prime + ($ingressTemplate == null ? 43 : $ingressTemplate.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $podTemplate = this.getPodTemplate();
        result = result * prime + ($podTemplate == null ? 43 : $podTemplate.hashCode());
        Object $serviceType = this.getServiceType();
        result = result * prime + ($serviceType == null ? 43 : $serviceType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEChallengeSolverHTTP01Ingress(" + "className=" + this.getClassName() + ", ingressClassName=" + this.getIngressClassName() + ", ingressTemplate=" + this.getIngressTemplate() + ", name=" + this.getName() + ", podTemplate=" + this.getPodTemplate() + ", serviceType=" + this.getServiceType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
