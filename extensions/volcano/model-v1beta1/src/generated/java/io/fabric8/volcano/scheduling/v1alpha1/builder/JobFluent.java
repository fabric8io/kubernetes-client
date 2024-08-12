package io.fabric8.volcano.scheduling.v1alpha1.builder;

import io.fabric8.volcano.scheduling.v1alpha1.Job;
import io.fabric8.volcano.scheduling.v1alpha1.JobSpec;
import io.fabric8.volcano.scheduling.v1alpha1.JobStatus;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午5:05
 * @FileName：JobFluent
 * @Description:
 */
public class JobFluent<A extends JobFluent<A>> extends BaseFluent<A> {
    public JobFluent() {
    }

    public JobFluent(Job instance) {
        this.copyInstance(instance);
    }
    private String apiVersion;
    private String kind;
    private ObjectMetaBuilder metadata;
    private JobSpecBuilder spec;
    private JobStatusBuilder status;
    private Map<String,Object> additionalProperties;

    protected void copyInstance(Job instance) {
        instance = (instance != null ? instance : new Job());
        if (instance != null) {
            this.withApiVersion(instance.getApiVersion());
            this.withKind(instance.getKind());
            this.withMetadata(instance.getMetadata());
            this.withSpec(instance.getSpec());
            this.withStatus(instance.getStatus());
            this.withAdditionalProperties(instance.getAdditionalProperties());
        }
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public A withApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return (A) this;
    }

    public boolean hasApiVersion() {
        return this.apiVersion != null;
    }

    public String getKind() {
        return this.kind;
    }

    public A withKind(String kind) {
        this.kind = kind;
        return (A) this;
    }

    public boolean hasKind() {
        return this.kind != null;
    }

    public ObjectMeta buildMetadata() {
        return this.metadata != null ? this.metadata.build() : null;
    }

    public A withMetadata(ObjectMeta metadata) {
        this._visitables.remove("metadata");
        if (metadata != null) {
            this.metadata = new ObjectMetaBuilder(metadata);
            this._visitables.get("metadata").add(this.metadata);
        } else {
            this.metadata = null;
            this._visitables.get("metadata").remove(this.metadata);
        }
        return (A) this;
    }

    public boolean hasMetadata() {
        return this.metadata != null;
    }

    public MetadataNested<A> withNewMetadata() {
        return new MetadataNested(null);
    }

    public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
        return new MetadataNested(item);
    }

    public MetadataNested<A> editMetadata() {
        return withNewMetadataLike(java.util.Optional.ofNullable(buildMetadata()).orElse(null));
    }

    public MetadataNested<A> editOrNewMetadata() {
        return withNewMetadataLike(java.util.Optional.ofNullable(buildMetadata()).orElse(new ObjectMetaBuilder().build()));
    }

    public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
        return withNewMetadataLike(java.util.Optional.ofNullable(buildMetadata()).orElse(item));
    }

    public JobSpec buildSpec() {
        return this.spec != null ? this.spec.build() : null;
    }

    public A withSpec(JobSpec spec) {
        this._visitables.remove("spec");
        if (spec != null) {
            this.spec = new JobSpecBuilder(spec);
            this._visitables.get("spec").add(this.spec);
        } else {
            this.spec = null;
            this._visitables.get("spec").remove(this.spec);
        }
        return (A) this;
    }

    public boolean hasSpec() {
        return this.spec != null;
    }

    public SpecNested<A> withNewSpec() {
        return new SpecNested(null);
    }

    public SpecNested<A> withNewSpecLike(JobSpec item) {
        return new SpecNested(item);
    }

    public SpecNested<A> editSpec() {
        return withNewSpecLike(java.util.Optional.ofNullable(buildSpec()).orElse(null));
    }

    public SpecNested<A> editOrNewSpec() {
        return withNewSpecLike(java.util.Optional.ofNullable(buildSpec()).orElse(new JobSpecBuilder().build()));
    }

    public SpecNested<A> editOrNewSpecLike(JobSpec item) {
        return withNewSpecLike(java.util.Optional.ofNullable(buildSpec()).orElse(item));
    }

    public JobStatus buildStatus() {
        return this.status != null ? this.status.build() : null;
    }

    public A withStatus(JobStatus status) {
        this._visitables.remove("status");
        if (status != null) {
            this.status = new JobStatusBuilder(status);
            this._visitables.get("status").add(this.status);
        } else {
            this.status = null;
            this._visitables.get("status").remove(this.status);
        }
        return (A) this;
    }

    public boolean hasStatus() {
        return this.status != null;
    }

    public A withNewStatus(Integer inJob,Integer pending,Integer running,String state,Integer unknown) {
        return (A)withStatus(new JobStatus(inJob, pending, running, state, unknown));
    }

    public StatusNested<A> withNewStatus() {
        return new StatusNested(null);
    }

    public StatusNested<A> withNewStatusLike(JobStatus item) {
        return new StatusNested(item);
    }

    public StatusNested<A> editStatus() {
        return withNewStatusLike(java.util.Optional.ofNullable(buildStatus()).orElse(null));
    }

    public StatusNested<A> editOrNewStatus() {
        return withNewStatusLike(java.util.Optional.ofNullable(buildStatus()).orElse(new JobStatusBuilder().build()));
    }

    public StatusNested<A> editOrNewStatusLike(JobStatus item) {
        return withNewStatusLike(java.util.Optional.ofNullable(buildStatus()).orElse(item));
    }

    public A addToAdditionalProperties(String key,Object value) {
        if(this.additionalProperties == null && key != null && value != null) { this.additionalProperties = new LinkedHashMap(); }
        if(key != null && value != null) {this.additionalProperties.put(key, value);} return (A)this;
    }

    public A addToAdditionalProperties(Map<String,Object> map) {
        if(this.additionalProperties == null && map != null) { this.additionalProperties = new LinkedHashMap(); }
        if(map != null) { this.additionalProperties.putAll(map);} return (A)this;
    }

    public A removeFromAdditionalProperties(String key) {
        if(this.additionalProperties == null) { return (A) this; }
        if(key != null && this.additionalProperties != null) {this.additionalProperties.remove(key);} return (A)this;
    }

    public A removeFromAdditionalProperties(Map<String,Object> map) {
        if(this.additionalProperties == null) { return (A) this; }
        if(map != null) { for(Object key : map.keySet()) {if (this.additionalProperties != null){this.additionalProperties.remove(key);}}} return (A)this;
    }

    public Map<String,Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
        if (additionalProperties == null) {
            this.additionalProperties = null;
        } else {
            this.additionalProperties = new LinkedHashMap(additionalProperties);
        }
        return (A) this;
    }

    public boolean hasAdditionalProperties() {
        return this.additionalProperties != null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JobFluent that = (JobFluent) o;
        if (!java.util.Objects.equals(apiVersion, that.apiVersion)) return false;
        if (!java.util.Objects.equals(kind, that.kind)) return false;
        if (!java.util.Objects.equals(metadata, that.metadata)) return false;
        if (!java.util.Objects.equals(spec, that.spec)) return false;
        if (!java.util.Objects.equals(status, that.status)) return false;
        if (!java.util.Objects.equals(additionalProperties, that.additionalProperties)) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(apiVersion,  kind,  metadata,  spec,  status,  additionalProperties,  super.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (apiVersion != null) { sb.append("apiVersion:"); sb.append(apiVersion + ","); }
        if (kind != null) { sb.append("kind:"); sb.append(kind + ","); }
        if (metadata != null) { sb.append("metadata:"); sb.append(metadata + ","); }
        if (spec != null) { sb.append("spec:"); sb.append(spec + ","); }
        if (status != null) { sb.append("status:"); sb.append(status + ","); }
        if (additionalProperties != null && !additionalProperties.isEmpty()) { sb.append("additionalProperties:"); sb.append(additionalProperties); }
        sb.append("}");
        return sb.toString();
    }
    public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N> {
        MetadataNested(ObjectMeta item) {
            this.builder = new ObjectMetaBuilder(this, item);
        }
        ObjectMetaBuilder builder;

        public N and() {
            return (N) JobFluent.this.withMetadata(builder.build());
        }

        public N endMetadata() {
            return and();
        }


    }
    public class SpecNested<N> extends JobSpecFluent<SpecNested<N>> implements Nested<N>{
        SpecNested(JobSpec item) {
            this.builder = new JobSpecBuilder(this, item);
        }
        JobSpecBuilder builder;

        public N and() {
            return (N) JobFluent.this.withSpec(builder.build());
        }

        public N endSpec() {
            return and();
        }


    }
    public class StatusNested<N> extends JobStatusFluent<StatusNested<N>> implements Nested<N>{
        StatusNested(JobStatus item) {
            this.builder = new JobStatusBuilder(this, item);
        }
        JobStatusBuilder builder;

        public N and() {
            return (N) JobFluent.this.withStatus(builder.build());
        }

        public N endStatus() {
            return and();
        }


    }

}
