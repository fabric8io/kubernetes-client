
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

/**
 * ACMEChallengeSolverHTTP01 contains configuration detailing how to solve HTTP01 challenges within a Kubernetes cluster. Typically this is accomplished through creating 'routes' of some description that configure ingress controllers to direct traffic to 'solver pods', which are responsible for responding to the ACME server's HTTP requests. Only one of Ingress / Gateway can be specified.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gatewayHTTPRoute",
    "ingress"
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
public class ACMEChallengeSolverHTTP01 implements Editable<ACMEChallengeSolverHTTP01Builder>, KubernetesResource
{

    @JsonProperty("gatewayHTTPRoute")
    private ACMEChallengeSolverHTTP01GatewayHTTPRoute gatewayHTTPRoute;
    @JsonProperty("ingress")
    private ACMEChallengeSolverHTTP01Ingress ingress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEChallengeSolverHTTP01() {
    }

    public ACMEChallengeSolverHTTP01(ACMEChallengeSolverHTTP01GatewayHTTPRoute gatewayHTTPRoute, ACMEChallengeSolverHTTP01Ingress ingress) {
        super();
        this.gatewayHTTPRoute = gatewayHTTPRoute;
        this.ingress = ingress;
    }

    /**
     * ACMEChallengeSolverHTTP01 contains configuration detailing how to solve HTTP01 challenges within a Kubernetes cluster. Typically this is accomplished through creating 'routes' of some description that configure ingress controllers to direct traffic to 'solver pods', which are responsible for responding to the ACME server's HTTP requests. Only one of Ingress / Gateway can be specified.
     */
    @JsonProperty("gatewayHTTPRoute")
    public ACMEChallengeSolverHTTP01GatewayHTTPRoute getGatewayHTTPRoute() {
        return gatewayHTTPRoute;
    }

    /**
     * ACMEChallengeSolverHTTP01 contains configuration detailing how to solve HTTP01 challenges within a Kubernetes cluster. Typically this is accomplished through creating 'routes' of some description that configure ingress controllers to direct traffic to 'solver pods', which are responsible for responding to the ACME server's HTTP requests. Only one of Ingress / Gateway can be specified.
     */
    @JsonProperty("gatewayHTTPRoute")
    public void setGatewayHTTPRoute(ACMEChallengeSolverHTTP01GatewayHTTPRoute gatewayHTTPRoute) {
        this.gatewayHTTPRoute = gatewayHTTPRoute;
    }

    /**
     * ACMEChallengeSolverHTTP01 contains configuration detailing how to solve HTTP01 challenges within a Kubernetes cluster. Typically this is accomplished through creating 'routes' of some description that configure ingress controllers to direct traffic to 'solver pods', which are responsible for responding to the ACME server's HTTP requests. Only one of Ingress / Gateway can be specified.
     */
    @JsonProperty("ingress")
    public ACMEChallengeSolverHTTP01Ingress getIngress() {
        return ingress;
    }

    /**
     * ACMEChallengeSolverHTTP01 contains configuration detailing how to solve HTTP01 challenges within a Kubernetes cluster. Typically this is accomplished through creating 'routes' of some description that configure ingress controllers to direct traffic to 'solver pods', which are responsible for responding to the ACME server's HTTP requests. Only one of Ingress / Gateway can be specified.
     */
    @JsonProperty("ingress")
    public void setIngress(ACMEChallengeSolverHTTP01Ingress ingress) {
        this.ingress = ingress;
    }

    @JsonIgnore
    public ACMEChallengeSolverHTTP01Builder edit() {
        return new ACMEChallengeSolverHTTP01Builder(this);
    }

    @JsonIgnore
    public ACMEChallengeSolverHTTP01Builder toBuilder() {
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
        if (!(o instanceof ACMEChallengeSolverHTTP01)) {
            return false;
        }
        ACMEChallengeSolverHTTP01 other = (ACMEChallengeSolverHTTP01) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$gatewayHTTPRoute = this.getGatewayHTTPRoute();
        Object other$gatewayHTTPRoute = other.getGatewayHTTPRoute();
        if (this$gatewayHTTPRoute == null ? other$gatewayHTTPRoute != null : !this$gatewayHTTPRoute.equals(other$gatewayHTTPRoute)) {
            return false;
        }
        Object this$ingress = this.getIngress();
        Object other$ingress = other.getIngress();
        if (this$ingress == null ? other$ingress != null : !this$ingress.equals(other$ingress)) {
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
        return other instanceof ACMEChallengeSolverHTTP01;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $gatewayHTTPRoute = this.getGatewayHTTPRoute();
        result = result * prime + ($gatewayHTTPRoute == null ? 43 : $gatewayHTTPRoute.hashCode());
        Object $ingress = this.getIngress();
        result = result * prime + ($ingress == null ? 43 : $ingress.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ACMEChallengeSolverHTTP01(" + "gatewayHTTPRoute=" + this.getGatewayHTTPRoute() + ", ingress=" + this.getIngress() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
