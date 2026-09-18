
package io.fabric8.tekton.triggers.v1beta1;

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
import io.fabric8.knative.duck.v1.WithPodSpec;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
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
    "replicas",
    "serviceLoadBalancerClass",
    "servicePort",
    "serviceType",
    "spec"
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
public class KubernetesResource implements Editable<KubernetesResourceBuilder>, io.fabric8.kubernetes.api.model.KubernetesResource
{

    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("serviceLoadBalancerClass")
    private String serviceLoadBalancerClass;
    @JsonProperty("servicePort")
    private Integer servicePort;
    @JsonProperty("serviceType")
    private String serviceType;
    @JsonProperty("spec")
    private WithPodSpec spec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KubernetesResource() {
    }

    public KubernetesResource(Integer replicas, String serviceLoadBalancerClass, Integer servicePort, String serviceType, WithPodSpec spec) {
        super();
        this.replicas = replicas;
        this.serviceLoadBalancerClass = serviceLoadBalancerClass;
        this.servicePort = servicePort;
        this.serviceType = serviceType;
        this.spec = spec;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("serviceLoadBalancerClass")
    public String getServiceLoadBalancerClass() {
        return serviceLoadBalancerClass;
    }

    @JsonProperty("serviceLoadBalancerClass")
    public void setServiceLoadBalancerClass(String serviceLoadBalancerClass) {
        this.serviceLoadBalancerClass = serviceLoadBalancerClass;
    }

    @JsonProperty("servicePort")
    public Integer getServicePort() {
        return servicePort;
    }

    @JsonProperty("servicePort")
    public void setServicePort(Integer servicePort) {
        this.servicePort = servicePort;
    }

    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @JsonProperty("spec")
    public WithPodSpec getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(WithPodSpec spec) {
        this.spec = spec;
    }

    @JsonIgnore
    public KubernetesResourceBuilder edit() {
        return new KubernetesResourceBuilder(this);
    }

    @JsonIgnore
    public KubernetesResourceBuilder toBuilder() {
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
        if (!(o instanceof KubernetesResource)) {
            return false;
        }
        KubernetesResource other = (KubernetesResource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$serviceLoadBalancerClass = this.getServiceLoadBalancerClass();
        Object other$serviceLoadBalancerClass = other.getServiceLoadBalancerClass();
        if (this$serviceLoadBalancerClass == null ? other$serviceLoadBalancerClass != null : !this$serviceLoadBalancerClass.equals(other$serviceLoadBalancerClass)) {
            return false;
        }
        Object this$servicePort = this.getServicePort();
        Object other$servicePort = other.getServicePort();
        if (this$servicePort == null ? other$servicePort != null : !this$servicePort.equals(other$servicePort)) {
            return false;
        }
        Object this$serviceType = this.getServiceType();
        Object other$serviceType = other.getServiceType();
        if (this$serviceType == null ? other$serviceType != null : !this$serviceType.equals(other$serviceType)) {
            return false;
        }
        Object this$spec = this.getSpec();
        Object other$spec = other.getSpec();
        if (this$spec == null ? other$spec != null : !this$spec.equals(other$spec)) {
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
        return other instanceof KubernetesResource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $serviceLoadBalancerClass = this.getServiceLoadBalancerClass();
        result = result * prime + ($serviceLoadBalancerClass == null ? 43 : $serviceLoadBalancerClass.hashCode());
        Object $servicePort = this.getServicePort();
        result = result * prime + ($servicePort == null ? 43 : $servicePort.hashCode());
        Object $serviceType = this.getServiceType();
        result = result * prime + ($serviceType == null ? 43 : $serviceType.hashCode());
        Object $spec = this.getSpec();
        result = result * prime + ($spec == null ? 43 : $spec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KubernetesResource(" + "replicas=" + this.getReplicas() + ", serviceLoadBalancerClass=" + this.getServiceLoadBalancerClass() + ", servicePort=" + this.getServicePort() + ", serviceType=" + this.getServiceType() + ", spec=" + this.getSpec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
