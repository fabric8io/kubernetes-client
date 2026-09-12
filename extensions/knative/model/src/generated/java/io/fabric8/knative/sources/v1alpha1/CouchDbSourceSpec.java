
package io.fabric8.knative.sources.v1alpha1;

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
import io.fabric8.knative.duck.v1.Destination;
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
 * CouchDbSourceSpec defines the desired state of CouchDbSource
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "credentials",
    "database",
    "feed",
    "serviceAccountName",
    "sink"
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
public class CouchDbSourceSpec implements Editable<CouchDbSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("credentials")
    private ObjectReference credentials;
    @JsonProperty("database")
    private String database;
    @JsonProperty("feed")
    private String feed;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sink")
    private Destination sink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CouchDbSourceSpec() {
    }

    public CouchDbSourceSpec(ObjectReference credentials, String database, String feed, String serviceAccountName, Destination sink) {
        super();
        this.credentials = credentials;
        this.database = database;
        this.feed = feed;
        this.serviceAccountName = serviceAccountName;
        this.sink = sink;
    }

    /**
     * CouchDbSourceSpec defines the desired state of CouchDbSource
     */
    @JsonProperty("credentials")
    public ObjectReference getCredentials() {
        return credentials;
    }

    /**
     * CouchDbSourceSpec defines the desired state of CouchDbSource
     */
    @JsonProperty("credentials")
    public void setCredentials(ObjectReference credentials) {
        this.credentials = credentials;
    }

    /**
     * Database is the database to watch for changes
     */
    @JsonProperty("database")
    public String getDatabase() {
        return database;
    }

    /**
     * Database is the database to watch for changes
     */
    @JsonProperty("database")
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * Feed changes how CouchDB sends the response. More information: https://docs.couchdb.org/en/stable/api/database/changes.html#changes-feeds
     */
    @JsonProperty("feed")
    public String getFeed() {
        return feed;
    }

    /**
     * Feed changes how CouchDB sends the response. More information: https://docs.couchdb.org/en/stable/api/database/changes.html#changes-feeds
     */
    @JsonProperty("feed")
    public void setFeed(String feed) {
        this.feed = feed;
    }

    /**
     * ServiceAccountName holds the name of the Kubernetes service account as which the underlying K8s resources should be run. If unspecified this will default to the "default" service account for the namespace in which the CouchDbSource exists.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName holds the name of the Kubernetes service account as which the underlying K8s resources should be run. If unspecified this will default to the "default" service account for the namespace in which the CouchDbSource exists.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * CouchDbSourceSpec defines the desired state of CouchDbSource
     */
    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    /**
     * CouchDbSourceSpec defines the desired state of CouchDbSource
     */
    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    @JsonIgnore
    public CouchDbSourceSpecBuilder edit() {
        return new CouchDbSourceSpecBuilder(this);
    }

    @JsonIgnore
    public CouchDbSourceSpecBuilder toBuilder() {
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
        if (!(o instanceof CouchDbSourceSpec)) {
            return false;
        }
        CouchDbSourceSpec other = (CouchDbSourceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$credentials = this.getCredentials();
        Object other$credentials = other.getCredentials();
        if (this$credentials == null ? other$credentials != null : !this$credentials.equals(other$credentials)) {
            return false;
        }
        Object this$database = this.getDatabase();
        Object other$database = other.getDatabase();
        if (this$database == null ? other$database != null : !this$database.equals(other$database)) {
            return false;
        }
        Object this$feed = this.getFeed();
        Object other$feed = other.getFeed();
        if (this$feed == null ? other$feed != null : !this$feed.equals(other$feed)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
            return false;
        }
        Object this$sink = this.getSink();
        Object other$sink = other.getSink();
        if (this$sink == null ? other$sink != null : !this$sink.equals(other$sink)) {
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
        return other instanceof CouchDbSourceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $credentials = this.getCredentials();
        result = result * prime + ($credentials == null ? 43 : $credentials.hashCode());
        Object $database = this.getDatabase();
        result = result * prime + ($database == null ? 43 : $database.hashCode());
        Object $feed = this.getFeed();
        result = result * prime + ($feed == null ? 43 : $feed.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $sink = this.getSink();
        result = result * prime + ($sink == null ? 43 : $sink.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CouchDbSourceSpec(" + "credentials=" + this.getCredentials() + ", database=" + this.getDatabase() + ", feed=" + this.getFeed() + ", serviceAccountName=" + this.getServiceAccountName() + ", sink=" + this.getSink() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
