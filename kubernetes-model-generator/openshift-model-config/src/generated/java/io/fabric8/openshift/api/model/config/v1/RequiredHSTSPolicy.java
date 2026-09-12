
package io.fabric8.openshift.api.model.config.v1;

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
    "domainPatterns",
    "includeSubDomainsPolicy",
    "maxAge",
    "namespaceSelector",
    "preloadPolicy"
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
public class RequiredHSTSPolicy implements Editable<RequiredHSTSPolicyBuilder>, KubernetesResource
{

    @JsonProperty("domainPatterns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> domainPatterns = new ArrayList<>();
    @JsonProperty("includeSubDomainsPolicy")
    private String includeSubDomainsPolicy;
    @JsonProperty("maxAge")
    private MaxAgePolicy maxAge;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("preloadPolicy")
    private String preloadPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RequiredHSTSPolicy() {
    }

    public RequiredHSTSPolicy(List<String> domainPatterns, String includeSubDomainsPolicy, MaxAgePolicy maxAge, LabelSelector namespaceSelector, String preloadPolicy) {
        super();
        this.domainPatterns = domainPatterns;
        this.includeSubDomainsPolicy = includeSubDomainsPolicy;
        this.maxAge = maxAge;
        this.namespaceSelector = namespaceSelector;
        this.preloadPolicy = preloadPolicy;
    }

    /**
     * domainPatterns is a list of domains for which the desired HSTS annotations are required. If domainPatterns is specified and a route is created with a spec.host matching one of the domains, the route must specify the HSTS Policy components described in the matching RequiredHSTSPolicy.<br><p> <br><p> The use of wildcards is allowed like this: &#42;.foo.com matches everything under foo.com. foo.com only matches foo.com, so to cover foo.com and everything under it, you must specify &#42;both&#42;.
     */
    @JsonProperty("domainPatterns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDomainPatterns() {
        return domainPatterns;
    }

    /**
     * domainPatterns is a list of domains for which the desired HSTS annotations are required. If domainPatterns is specified and a route is created with a spec.host matching one of the domains, the route must specify the HSTS Policy components described in the matching RequiredHSTSPolicy.<br><p> <br><p> The use of wildcards is allowed like this: &#42;.foo.com matches everything under foo.com. foo.com only matches foo.com, so to cover foo.com and everything under it, you must specify &#42;both&#42;.
     */
    @JsonProperty("domainPatterns")
    public void setDomainPatterns(List<String> domainPatterns) {
        this.domainPatterns = domainPatterns;
    }

    /**
     * includeSubDomainsPolicy means the HSTS Policy should apply to any subdomains of the host's domain name.  Thus, for the host bar.foo.com, if includeSubDomainsPolicy was set to RequireIncludeSubDomains: - the host app.bar.foo.com would inherit the HSTS Policy of bar.foo.com - the host bar.foo.com would inherit the HSTS Policy of bar.foo.com - the host foo.com would NOT inherit the HSTS Policy of bar.foo.com - the host def.foo.com would NOT inherit the HSTS Policy of bar.foo.com
     */
    @JsonProperty("includeSubDomainsPolicy")
    public String getIncludeSubDomainsPolicy() {
        return includeSubDomainsPolicy;
    }

    /**
     * includeSubDomainsPolicy means the HSTS Policy should apply to any subdomains of the host's domain name.  Thus, for the host bar.foo.com, if includeSubDomainsPolicy was set to RequireIncludeSubDomains: - the host app.bar.foo.com would inherit the HSTS Policy of bar.foo.com - the host bar.foo.com would inherit the HSTS Policy of bar.foo.com - the host foo.com would NOT inherit the HSTS Policy of bar.foo.com - the host def.foo.com would NOT inherit the HSTS Policy of bar.foo.com
     */
    @JsonProperty("includeSubDomainsPolicy")
    public void setIncludeSubDomainsPolicy(String includeSubDomainsPolicy) {
        this.includeSubDomainsPolicy = includeSubDomainsPolicy;
    }

    @JsonProperty("maxAge")
    public MaxAgePolicy getMaxAge() {
        return maxAge;
    }

    @JsonProperty("maxAge")
    public void setMaxAge(MaxAgePolicy maxAge) {
        this.maxAge = maxAge;
    }

    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * preloadPolicy directs the client to include hosts in its host preload list so that it never needs to do an initial load to get the HSTS header (note that this is not defined in RFC 6797 and is therefore client implementation-dependent).
     */
    @JsonProperty("preloadPolicy")
    public String getPreloadPolicy() {
        return preloadPolicy;
    }

    /**
     * preloadPolicy directs the client to include hosts in its host preload list so that it never needs to do an initial load to get the HSTS header (note that this is not defined in RFC 6797 and is therefore client implementation-dependent).
     */
    @JsonProperty("preloadPolicy")
    public void setPreloadPolicy(String preloadPolicy) {
        this.preloadPolicy = preloadPolicy;
    }

    @JsonIgnore
    public RequiredHSTSPolicyBuilder edit() {
        return new RequiredHSTSPolicyBuilder(this);
    }

    @JsonIgnore
    public RequiredHSTSPolicyBuilder toBuilder() {
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
        if (!(o instanceof RequiredHSTSPolicy)) {
            return false;
        }
        RequiredHSTSPolicy other = (RequiredHSTSPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$domainPatterns = this.getDomainPatterns();
        Object other$domainPatterns = other.getDomainPatterns();
        if (this$domainPatterns == null ? other$domainPatterns != null : !this$domainPatterns.equals(other$domainPatterns)) {
            return false;
        }
        Object this$includeSubDomainsPolicy = this.getIncludeSubDomainsPolicy();
        Object other$includeSubDomainsPolicy = other.getIncludeSubDomainsPolicy();
        if (this$includeSubDomainsPolicy == null ? other$includeSubDomainsPolicy != null : !this$includeSubDomainsPolicy.equals(other$includeSubDomainsPolicy)) {
            return false;
        }
        Object this$maxAge = this.getMaxAge();
        Object other$maxAge = other.getMaxAge();
        if (this$maxAge == null ? other$maxAge != null : !this$maxAge.equals(other$maxAge)) {
            return false;
        }
        Object this$namespaceSelector = this.getNamespaceSelector();
        Object other$namespaceSelector = other.getNamespaceSelector();
        if (this$namespaceSelector == null ? other$namespaceSelector != null : !this$namespaceSelector.equals(other$namespaceSelector)) {
            return false;
        }
        Object this$preloadPolicy = this.getPreloadPolicy();
        Object other$preloadPolicy = other.getPreloadPolicy();
        if (this$preloadPolicy == null ? other$preloadPolicy != null : !this$preloadPolicy.equals(other$preloadPolicy)) {
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
        return other instanceof RequiredHSTSPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $domainPatterns = this.getDomainPatterns();
        result = result * prime + ($domainPatterns == null ? 43 : $domainPatterns.hashCode());
        Object $includeSubDomainsPolicy = this.getIncludeSubDomainsPolicy();
        result = result * prime + ($includeSubDomainsPolicy == null ? 43 : $includeSubDomainsPolicy.hashCode());
        Object $maxAge = this.getMaxAge();
        result = result * prime + ($maxAge == null ? 43 : $maxAge.hashCode());
        Object $namespaceSelector = this.getNamespaceSelector();
        result = result * prime + ($namespaceSelector == null ? 43 : $namespaceSelector.hashCode());
        Object $preloadPolicy = this.getPreloadPolicy();
        result = result * prime + ($preloadPolicy == null ? 43 : $preloadPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RequiredHSTSPolicy(" + "domainPatterns=" + this.getDomainPatterns() + ", includeSubDomainsPolicy=" + this.getIncludeSubDomainsPolicy() + ", maxAge=" + this.getMaxAge() + ", namespaceSelector=" + this.getNamespaceSelector() + ", preloadPolicy=" + this.getPreloadPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
