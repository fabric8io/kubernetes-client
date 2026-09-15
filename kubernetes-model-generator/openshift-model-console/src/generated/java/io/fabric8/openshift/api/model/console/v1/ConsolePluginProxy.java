
package io.fabric8.openshift.api.model.console.v1;

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
 * ConsolePluginProxy holds information on various service types to which console's backend will proxy the plugin's requests.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alias",
    "authorization",
    "caCertificate",
    "endpoint"
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
public class ConsolePluginProxy implements Editable<ConsolePluginProxyBuilder>, KubernetesResource
{

    @JsonProperty("alias")
    private String alias;
    @JsonProperty("authorization")
    private String authorization;
    @JsonProperty("caCertificate")
    private String caCertificate;
    @JsonProperty("endpoint")
    private ConsolePluginProxyEndpoint endpoint;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsolePluginProxy() {
    }

    public ConsolePluginProxy(String alias, String authorization, String caCertificate, ConsolePluginProxyEndpoint endpoint) {
        super();
        this.alias = alias;
        this.authorization = authorization;
        this.caCertificate = caCertificate;
        this.endpoint = endpoint;
    }

    /**
     * alias is a proxy name that identifies the plugin's proxy. An alias name should be unique per plugin. The console backend exposes following proxy endpoint:<br><p> <br><p> /api/proxy/plugin/&lt;plugin-name&gt;/&lt;proxy-alias&gt;/&lt;request-path&gt;?&lt;optional-query-parameters&gt;<br><p> <br><p> Request example path:<br><p> <br><p> /api/proxy/plugin/acm/search/pods?namespace=openshift-apiserver
     */
    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    /**
     * alias is a proxy name that identifies the plugin's proxy. An alias name should be unique per plugin. The console backend exposes following proxy endpoint:<br><p> <br><p> /api/proxy/plugin/&lt;plugin-name&gt;/&lt;proxy-alias&gt;/&lt;request-path&gt;?&lt;optional-query-parameters&gt;<br><p> <br><p> Request example path:<br><p> <br><p> /api/proxy/plugin/acm/search/pods?namespace=openshift-apiserver
     */
    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * authorization provides information about authorization type, which the proxied request should contain
     */
    @JsonProperty("authorization")
    public String getAuthorization() {
        return authorization;
    }

    /**
     * authorization provides information about authorization type, which the proxied request should contain
     */
    @JsonProperty("authorization")
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    /**
     * caCertificate provides the cert authority certificate contents, in case the proxied Service is using custom service CA. By default, the service CA bundle provided by the service-ca operator is used.
     */
    @JsonProperty("caCertificate")
    public String getCaCertificate() {
        return caCertificate;
    }

    /**
     * caCertificate provides the cert authority certificate contents, in case the proxied Service is using custom service CA. By default, the service CA bundle provided by the service-ca operator is used.
     */
    @JsonProperty("caCertificate")
    public void setCaCertificate(String caCertificate) {
        this.caCertificate = caCertificate;
    }

    /**
     * ConsolePluginProxy holds information on various service types to which console's backend will proxy the plugin's requests.
     */
    @JsonProperty("endpoint")
    public ConsolePluginProxyEndpoint getEndpoint() {
        return endpoint;
    }

    /**
     * ConsolePluginProxy holds information on various service types to which console's backend will proxy the plugin's requests.
     */
    @JsonProperty("endpoint")
    public void setEndpoint(ConsolePluginProxyEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @JsonIgnore
    public ConsolePluginProxyBuilder edit() {
        return new ConsolePluginProxyBuilder(this);
    }

    @JsonIgnore
    public ConsolePluginProxyBuilder toBuilder() {
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
        if (!(o instanceof ConsolePluginProxy)) {
            return false;
        }
        ConsolePluginProxy other = (ConsolePluginProxy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$alias = this.getAlias();
        Object other$alias = other.getAlias();
        if (this$alias == null ? other$alias != null : !this$alias.equals(other$alias)) {
            return false;
        }
        Object this$authorization = this.getAuthorization();
        Object other$authorization = other.getAuthorization();
        if (this$authorization == null ? other$authorization != null : !this$authorization.equals(other$authorization)) {
            return false;
        }
        Object this$caCertificate = this.getCaCertificate();
        Object other$caCertificate = other.getCaCertificate();
        if (this$caCertificate == null ? other$caCertificate != null : !this$caCertificate.equals(other$caCertificate)) {
            return false;
        }
        Object this$endpoint = this.getEndpoint();
        Object other$endpoint = other.getEndpoint();
        if (this$endpoint == null ? other$endpoint != null : !this$endpoint.equals(other$endpoint)) {
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
        return other instanceof ConsolePluginProxy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $alias = this.getAlias();
        result = result * prime + ($alias == null ? 43 : $alias.hashCode());
        Object $authorization = this.getAuthorization();
        result = result * prime + ($authorization == null ? 43 : $authorization.hashCode());
        Object $caCertificate = this.getCaCertificate();
        result = result * prime + ($caCertificate == null ? 43 : $caCertificate.hashCode());
        Object $endpoint = this.getEndpoint();
        result = result * prime + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsolePluginProxy(" + "alias=" + this.getAlias() + ", authorization=" + this.getAuthorization() + ", caCertificate=" + this.getCaCertificate() + ", endpoint=" + this.getEndpoint() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
