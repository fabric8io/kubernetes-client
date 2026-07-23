package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class GitRefInfoFluent<A extends io.fabric8.openshift.api.model.GitRefInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SourceControlUserBuilder author;
  private String commit;
  private SourceControlUserBuilder committer;
  private String httpProxy;
  private String httpsProxy;
  private String message;
  private String noProxy;
  private String ref;
  private String uri;

  public GitRefInfoFluent() {
  }
  
  public GitRefInfoFluent(GitRefInfo instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public SourceControlUser buildAuthor() {
    return this.author != null ? this.author.build() : null;
  }
  
  public SourceControlUser buildCommitter() {
    return this.committer != null ? this.committer.build() : null;
  }
  
  protected void copyInstance(GitRefInfo instance) {
    instance = instance != null ? instance : new GitRefInfo();
    if (instance != null) {
        this.withAuthor(instance.getAuthor());
        this.withCommit(instance.getCommit());
        this.withCommitter(instance.getCommitter());
        this.withHttpProxy(instance.getHttpProxy());
        this.withHttpsProxy(instance.getHttpsProxy());
        this.withMessage(instance.getMessage());
        this.withNoProxy(instance.getNoProxy());
        this.withRef(instance.getRef());
        this.withUri(instance.getUri());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthorNested<A> editAuthor() {
    return this.withNewAuthorLike(Optional.ofNullable(this.buildAuthor()).orElse(null));
  }
  
  public CommitterNested<A> editCommitter() {
    return this.withNewCommitterLike(Optional.ofNullable(this.buildCommitter()).orElse(null));
  }
  
  public AuthorNested<A> editOrNewAuthor() {
    return this.withNewAuthorLike(Optional.ofNullable(this.buildAuthor()).orElse(new SourceControlUserBuilder().build()));
  }
  
  public AuthorNested<A> editOrNewAuthorLike(SourceControlUser item) {
    return this.withNewAuthorLike(Optional.ofNullable(this.buildAuthor()).orElse(item));
  }
  
  public CommitterNested<A> editOrNewCommitter() {
    return this.withNewCommitterLike(Optional.ofNullable(this.buildCommitter()).orElse(new SourceControlUserBuilder().build()));
  }
  
  public CommitterNested<A> editOrNewCommitterLike(SourceControlUser item) {
    return this.withNewCommitterLike(Optional.ofNullable(this.buildCommitter()).orElse(item));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    GitRefInfoFluent that = (GitRefInfoFluent) o;
    if (!(Objects.equals(author, that.author))) {
      return false;
    }
    if (!(Objects.equals(commit, that.commit))) {
      return false;
    }
    if (!(Objects.equals(committer, that.committer))) {
      return false;
    }
    if (!(Objects.equals(httpProxy, that.httpProxy))) {
      return false;
    }
    if (!(Objects.equals(httpsProxy, that.httpsProxy))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(ref, that.ref))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getCommit() {
    return this.commit;
  }
  
  public String getHttpProxy() {
    return this.httpProxy;
  }
  
  public String getHttpsProxy() {
    return this.httpsProxy;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getNoProxy() {
    return this.noProxy;
  }
  
  public String getRef() {
    return this.ref;
  }
  
  public String getUri() {
    return this.uri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthor() {
    return this.author != null;
  }
  
  public boolean hasCommit() {
    return this.commit != null;
  }
  
  public boolean hasCommitter() {
    return this.committer != null;
  }
  
  public boolean hasHttpProxy() {
    return this.httpProxy != null;
  }
  
  public boolean hasHttpsProxy() {
    return this.httpsProxy != null;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasRef() {
    return this.ref != null;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public int hashCode() {
    return Objects.hash(author, commit, committer, httpProxy, httpsProxy, message, noProxy, ref, uri, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(author == null)) {
        sb.append("author:");
        sb.append(author);
        sb.append(",");
    }
    if (!(commit == null)) {
        sb.append("commit:");
        sb.append(commit);
        sb.append(",");
    }
    if (!(committer == null)) {
        sb.append("committer:");
        sb.append(committer);
        sb.append(",");
    }
    if (!(httpProxy == null)) {
        sb.append("httpProxy:");
        sb.append(httpProxy);
        sb.append(",");
    }
    if (!(httpsProxy == null)) {
        sb.append("httpsProxy:");
        sb.append(httpsProxy);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(noProxy == null)) {
        sb.append("noProxy:");
        sb.append(noProxy);
        sb.append(",");
    }
    if (!(ref == null)) {
        sb.append("ref:");
        sb.append(ref);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAuthor(SourceControlUser author) {
    this._visitables.remove("author");
    if (author != null) {
        this.author = new SourceControlUserBuilder(author);
        this._visitables.get("author").add(this.author);
    } else {
        this.author = null;
        this._visitables.get("author").remove(this.author);
    }
    return (A) this;
  }
  
  public A withCommit(String commit) {
    this.commit = commit;
    return (A) this;
  }
  
  public A withCommitter(SourceControlUser committer) {
    this._visitables.remove("committer");
    if (committer != null) {
        this.committer = new SourceControlUserBuilder(committer);
        this._visitables.get("committer").add(this.committer);
    } else {
        this.committer = null;
        this._visitables.get("committer").remove(this.committer);
    }
    return (A) this;
  }
  
  public A withHttpProxy(String httpProxy) {
    this.httpProxy = httpProxy;
    return (A) this;
  }
  
  public A withHttpsProxy(String httpsProxy) {
    this.httpsProxy = httpsProxy;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public AuthorNested<A> withNewAuthor() {
    return new AuthorNested(null);
  }
  
  public A withNewAuthor(String email,String name) {
    return (A) this.withAuthor(new SourceControlUser(email, name));
  }
  
  public AuthorNested<A> withNewAuthorLike(SourceControlUser item) {
    return new AuthorNested(item);
  }
  
  public CommitterNested<A> withNewCommitter() {
    return new CommitterNested(null);
  }
  
  public A withNewCommitter(String email,String name) {
    return (A) this.withCommitter(new SourceControlUser(email, name));
  }
  
  public CommitterNested<A> withNewCommitterLike(SourceControlUser item) {
    return new CommitterNested(item);
  }
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
    return (A) this;
  }
  
  public A withRef(String ref) {
    this.ref = ref;
    return (A) this;
  }
  
  public A withUri(String uri) {
    this.uri = uri;
    return (A) this;
  }
  public class AuthorNested<N> extends SourceControlUserFluent<AuthorNested<N>> implements Nested<N>{
  
    SourceControlUserBuilder builder;
  
    AuthorNested(SourceControlUser item) {
      this.builder = new SourceControlUserBuilder(this, item);
    }
  
    public N and() {
      return (N) GitRefInfoFluent.this.withAuthor(builder.build());
    }
    
    public N endAuthor() {
      return and();
    }
    
  }
  public class CommitterNested<N> extends SourceControlUserFluent<CommitterNested<N>> implements Nested<N>{
  
    SourceControlUserBuilder builder;
  
    CommitterNested(SourceControlUser item) {
      this.builder = new SourceControlUserBuilder(this, item);
    }
  
    public N and() {
      return (N) GitRefInfoFluent.this.withCommitter(builder.build());
    }
    
    public N endCommitter() {
      return and();
    }
    
  }
}