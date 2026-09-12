
package io.fabric8.openshift.api.model.hive.v1;

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
import io.fabric8.openshift.api.model.config.v1.ConfigMapNameReference;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterIngress contains the configurable pieces for any ClusterIngress objects that should exist on the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "domain",
    "httpErrorCodePages",
    "name",
    "namespaceSelector",
    "routeSelector",
    "servingCertificate"
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
public class ClusterIngress implements Editable<ClusterIngressBuilder>, KubernetesResource
{

    @JsonProperty("domain")
    private String domain;
    @JsonProperty("httpErrorCodePages")
    private ConfigMapNameReference httpErrorCodePages;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("routeSelector")
    private LabelSelector routeSelector;
    @JsonProperty("servingCertificate")
    private String servingCertificate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterIngress() {
    }

    public ClusterIngress(String domain, ConfigMapNameReference httpErrorCodePages, String name, LabelSelector namespaceSelector, LabelSelector routeSelector, String servingCertificate) {
        super();
        this.domain = domain;
        this.httpErrorCodePages = httpErrorCodePages;
        this.name = name;
        this.namespaceSelector = namespaceSelector;
        this.routeSelector = routeSelector;
        this.servingCertificate = servingCertificate;
    }

    /**
     * Domain (sometimes referred to as shard) is the full DNS suffix that the resulting IngressController object will service (eg abcd.mycluster.mydomain.com).
     */
    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    /**
     * Domain (sometimes referred to as shard) is the full DNS suffix that the resulting IngressController object will service (eg abcd.mycluster.mydomain.com).
     */
    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * ClusterIngress contains the configurable pieces for any ClusterIngress objects that should exist on the cluster.
     */
    @JsonProperty("httpErrorCodePages")
    public ConfigMapNameReference getHttpErrorCodePages() {
        return httpErrorCodePages;
    }

    /**
     * ClusterIngress contains the configurable pieces for any ClusterIngress objects that should exist on the cluster.
     */
    @JsonProperty("httpErrorCodePages")
    public void setHttpErrorCodePages(ConfigMapNameReference httpErrorCodePages) {
        this.httpErrorCodePages = httpErrorCodePages;
    }

    /**
     * Name of the ClusterIngress object to create.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the ClusterIngress object to create.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ClusterIngress contains the configurable pieces for any ClusterIngress objects that should exist on the cluster.
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * ClusterIngress contains the configurable pieces for any ClusterIngress objects that should exist on the cluster.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * ClusterIngress contains the configurable pieces for any ClusterIngress objects that should exist on the cluster.
     */
    @JsonProperty("routeSelector")
    public LabelSelector getRouteSelector() {
        return routeSelector;
    }

    /**
     * ClusterIngress contains the configurable pieces for any ClusterIngress objects that should exist on the cluster.
     */
    @JsonProperty("routeSelector")
    public void setRouteSelector(LabelSelector routeSelector) {
        this.routeSelector = routeSelector;
    }

    /**
     * ServingCertificate references a CertificateBundle in the ClusterDeployment.Spec that should be used for this Ingress
     */
    @JsonProperty("servingCertificate")
    public String getServingCertificate() {
        return servingCertificate;
    }

    /**
     * ServingCertificate references a CertificateBundle in the ClusterDeployment.Spec that should be used for this Ingress
     */
    @JsonProperty("servingCertificate")
    public void setServingCertificate(String servingCertificate) {
        this.servingCertificate = servingCertificate;
    }

    @JsonIgnore
    public ClusterIngressBuilder edit() {
        return new ClusterIngressBuilder(this);
    }

    @JsonIgnore
    public ClusterIngressBuilder toBuilder() {
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
        if (!(o instanceof ClusterIngress)) {
            return false;
        }
        ClusterIngress other = (ClusterIngress) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$domain = this.getDomain();
        Object other$domain = other.getDomain();
        if (this$domain == null ? other$domain != null : !this$domain.equals(other$domain)) {
            return false;
        }
        Object this$httpErrorCodePages = this.getHttpErrorCodePages();
        Object other$httpErrorCodePages = other.getHttpErrorCodePages();
        if (this$httpErrorCodePages == null ? other$httpErrorCodePages != null : !this$httpErrorCodePages.equals(other$httpErrorCodePages)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespaceSelector = this.getNamespaceSelector();
        Object other$namespaceSelector = other.getNamespaceSelector();
        if (this$namespaceSelector == null ? other$namespaceSelector != null : !this$namespaceSelector.equals(other$namespaceSelector)) {
            return false;
        }
        Object this$routeSelector = this.getRouteSelector();
        Object other$routeSelector = other.getRouteSelector();
        if (this$routeSelector == null ? other$routeSelector != null : !this$routeSelector.equals(other$routeSelector)) {
            return false;
        }
        Object this$servingCertificate = this.getServingCertificate();
        Object other$servingCertificate = other.getServingCertificate();
        if (this$servingCertificate == null ? other$servingCertificate != null : !this$servingCertificate.equals(other$servingCertificate)) {
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
        return other instanceof ClusterIngress;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $domain = this.getDomain();
        result = result * prime + ($domain == null ? 43 : $domain.hashCode());
        Object $httpErrorCodePages = this.getHttpErrorCodePages();
        result = result * prime + ($httpErrorCodePages == null ? 43 : $httpErrorCodePages.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespaceSelector = this.getNamespaceSelector();
        result = result * prime + ($namespaceSelector == null ? 43 : $namespaceSelector.hashCode());
        Object $routeSelector = this.getRouteSelector();
        result = result * prime + ($routeSelector == null ? 43 : $routeSelector.hashCode());
        Object $servingCertificate = this.getServingCertificate();
        result = result * prime + ($servingCertificate == null ? 43 : $servingCertificate.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterIngress(" + "domain=" + this.getDomain() + ", httpErrorCodePages=" + this.getHttpErrorCodePages() + ", name=" + this.getName() + ", namespaceSelector=" + this.getNamespaceSelector() + ", routeSelector=" + this.getRouteSelector() + ", servingCertificate=" + this.getServingCertificate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
