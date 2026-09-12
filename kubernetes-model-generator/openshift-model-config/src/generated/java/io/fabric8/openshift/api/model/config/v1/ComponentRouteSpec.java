
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ComponentRouteSpec allows for configuration of a route's hostname and serving certificate.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostname",
    "name",
    "namespace",
    "servingCertKeyPairSecret"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ComponentRouteSpec implements Editable<ComponentRouteSpecBuilder>, KubernetesResource
{

    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("servingCertKeyPairSecret")
    private SecretNameReference servingCertKeyPairSecret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ComponentRouteSpec() {
    }

    public ComponentRouteSpec(String hostname, String name, String namespace, SecretNameReference servingCertKeyPairSecret) {
        super();
        this.hostname = hostname;
        this.name = name;
        this.namespace = namespace;
        this.servingCertKeyPairSecret = servingCertKeyPairSecret;
    }

    /**
     * hostname is the hostname that should be used by the route.
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * hostname is the hostname that should be used by the route.
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * name is the logical name of the route to customize.<br><p> <br><p> The namespace and name of this componentRoute must match a corresponding entry in the list of status.componentRoutes if the route is to be customized.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the logical name of the route to customize.<br><p> <br><p> The namespace and name of this componentRoute must match a corresponding entry in the list of status.componentRoutes if the route is to be customized.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace is the namespace of the route to customize.<br><p> <br><p> The namespace and name of this componentRoute must match a corresponding entry in the list of status.componentRoutes if the route is to be customized.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace is the namespace of the route to customize.<br><p> <br><p> The namespace and name of this componentRoute must match a corresponding entry in the list of status.componentRoutes if the route is to be customized.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * ComponentRouteSpec allows for configuration of a route's hostname and serving certificate.
     */
    @JsonProperty("servingCertKeyPairSecret")
    public SecretNameReference getServingCertKeyPairSecret() {
        return servingCertKeyPairSecret;
    }

    /**
     * ComponentRouteSpec allows for configuration of a route's hostname and serving certificate.
     */
    @JsonProperty("servingCertKeyPairSecret")
    public void setServingCertKeyPairSecret(SecretNameReference servingCertKeyPairSecret) {
        this.servingCertKeyPairSecret = servingCertKeyPairSecret;
    }

    @JsonIgnore
    public ComponentRouteSpecBuilder edit() {
        return new ComponentRouteSpecBuilder(this);
    }

    @JsonIgnore
    public ComponentRouteSpecBuilder toBuilder() {
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
        if (!(o instanceof ComponentRouteSpec)) {
            return false;
        }
        ComponentRouteSpec other = (ComponentRouteSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hostname = this.getHostname();
        Object other$hostname = other.getHostname();
        if (this$hostname == null ? other$hostname != null : !this$hostname.equals(other$hostname)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$servingCertKeyPairSecret = this.getServingCertKeyPairSecret();
        Object other$servingCertKeyPairSecret = other.getServingCertKeyPairSecret();
        if (this$servingCertKeyPairSecret == null ? other$servingCertKeyPairSecret != null : !this$servingCertKeyPairSecret.equals(other$servingCertKeyPairSecret)) {
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
        return other instanceof ComponentRouteSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hostname = this.getHostname();
        result = result * prime + ($hostname == null ? 43 : $hostname.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $servingCertKeyPairSecret = this.getServingCertKeyPairSecret();
        result = result * prime + ($servingCertKeyPairSecret == null ? 43 : $servingCertKeyPairSecret.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ComponentRouteSpec(" + "hostname=" + this.getHostname() + ", name=" + this.getName() + ", namespace=" + this.getNamespace() + ", servingCertKeyPairSecret=" + this.getServingCertKeyPairSecret() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
