package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class GitInfoFluent<A extends io.fabric8.openshift.api.model.GitInfoFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SourceControlUserBuilder author;
  private String commit;
  private SourceControlUserBuilder committer;
  private String httpProxy;
  private String httpsProxy;
  private String message;
  private String noProxy;
  private String ref;
  private ArrayList<GitRefInfoBuilder> refs = new ArrayList<GitRefInfoBuilder>();
  private String uri;

  public GitInfoFluent() {
  }
  
  public GitInfoFluent(GitInfo instance) {
    this.copyInstance(instance);
  }

  public A addAllToRefs(Collection<GitRefInfo> items) {
    if (this.refs == null) {
      this.refs = new ArrayList();
    }
    for (GitRefInfo item : items) {
        GitRefInfoBuilder builder = new GitRefInfoBuilder(item);
        _visitables.get("refs").add(builder);
        this.refs.add(builder);
    }
    return (A) this;
  }
  
  public RefsNested<A> addNewRef() {
    return new RefsNested(-1, null);
  }
  
  public RefsNested<A> addNewRefLike(GitRefInfo item) {
    return new RefsNested(-1, item);
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
  
  public A addToRefs(GitRefInfo... items) {
    if (this.refs == null) {
      this.refs = new ArrayList();
    }
    for (GitRefInfo item : items) {
        GitRefInfoBuilder builder = new GitRefInfoBuilder(item);
        _visitables.get("refs").add(builder);
        this.refs.add(builder);
    }
    return (A) this;
  }
  
  public A addToRefs(int index,GitRefInfo item) {
    if (this.refs == null) {
      this.refs = new ArrayList();
    }
    GitRefInfoBuilder builder = new GitRefInfoBuilder(item);
    if (index < 0 || index >= refs.size()) {
        _visitables.get("refs").add(builder);
        refs.add(builder);
    } else {
        _visitables.get("refs").add(builder);
        refs.add(index, builder);
    }
    return (A) this;
  }
  
  public SourceControlUser buildAuthor() {
    return this.author != null ? this.author.build() : null;
  }
  
  public SourceControlUser buildCommitter() {
    return this.committer != null ? this.committer.build() : null;
  }
  
  public GitRefInfo buildFirstRef() {
    return this.refs.get(0).build();
  }
  
  public GitRefInfo buildLastRef() {
    return this.refs.get(refs.size() - 1).build();
  }
  
  public GitRefInfo buildMatchingRef(Predicate<GitRefInfoBuilder> predicate) {
      for (GitRefInfoBuilder item : refs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GitRefInfo buildRef(int index) {
    return this.refs.get(index).build();
  }
  
  public List<GitRefInfo> buildRefs() {
    return this.refs != null ? build(refs) : null;
  }
  
  protected void copyInstance(GitInfo instance) {
    instance = instance != null ? instance : new GitInfo();
    if (instance != null) {
        this.withAuthor(instance.getAuthor());
        this.withCommit(instance.getCommit());
        this.withCommitter(instance.getCommitter());
        this.withHttpProxy(instance.getHttpProxy());
        this.withHttpsProxy(instance.getHttpsProxy());
        this.withMessage(instance.getMessage());
        this.withNoProxy(instance.getNoProxy());
        this.withRef(instance.getRef());
        this.withRefs(instance.getRefs());
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
  
  public RefsNested<A> editFirstRef() {
    if (refs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "refs"));
    }
    return this.setNewRefLike(0, this.buildRef(0));
  }
  
  public RefsNested<A> editLastRef() {
    int index = refs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "refs"));
    }
    return this.setNewRefLike(index, this.buildRef(index));
  }
  
  public RefsNested<A> editMatchingRef(Predicate<GitRefInfoBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < refs.size();i++) {
      if (predicate.test(refs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "refs"));
    }
    return this.setNewRefLike(index, this.buildRef(index));
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
  
  public RefsNested<A> editRef(int index) {
    if (refs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "refs"));
    }
    return this.setNewRefLike(index, this.buildRef(index));
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
    GitInfoFluent that = (GitInfoFluent) o;
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
    if (!(Objects.equals(refs, that.refs))) {
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
  
  public boolean hasMatchingRef(Predicate<GitRefInfoBuilder> predicate) {
      for (GitRefInfoBuilder item : refs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
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
  
  public boolean hasRefs() {
    return this.refs != null && !(this.refs.isEmpty());
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public int hashCode() {
    return Objects.hash(author, commit, committer, httpProxy, httpsProxy, message, noProxy, ref, refs, uri, additionalProperties);
  }
  
  public A removeAllFromRefs(Collection<GitRefInfo> items) {
    if (this.refs == null) {
      return (A) this;
    }
    for (GitRefInfo item : items) {
        GitRefInfoBuilder builder = new GitRefInfoBuilder(item);
        _visitables.get("refs").remove(builder);
        this.refs.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromRefs(GitRefInfo... items) {
    if (this.refs == null) {
      return (A) this;
    }
    for (GitRefInfo item : items) {
        GitRefInfoBuilder builder = new GitRefInfoBuilder(item);
        _visitables.get("refs").remove(builder);
        this.refs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRefs(Predicate<GitRefInfoBuilder> predicate) {
    if (refs == null) {
      return (A) this;
    }
    Iterator<GitRefInfoBuilder> each = refs.iterator();
    List visitables = _visitables.get("refs");
    while (each.hasNext()) {
        GitRefInfoBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RefsNested<A> setNewRefLike(int index,GitRefInfo item) {
    return new RefsNested(index, item);
  }
  
  public A setToRefs(int index,GitRefInfo item) {
    if (this.refs == null) {
      this.refs = new ArrayList();
    }
    GitRefInfoBuilder builder = new GitRefInfoBuilder(item);
    if (index < 0 || index >= refs.size()) {
        _visitables.get("refs").add(builder);
        refs.add(builder);
    } else {
        _visitables.get("refs").add(builder);
        refs.set(index, builder);
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
    if (!(refs == null) && !(refs.isEmpty())) {
        sb.append("refs:");
        sb.append(refs);
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
  
  public A withRefs(List<GitRefInfo> refs) {
    if (this.refs != null) {
      this._visitables.get("refs").clear();
    }
    if (refs != null) {
        this.refs = new ArrayList();
        for (GitRefInfo item : refs) {
          this.addToRefs(item);
        }
    } else {
      this.refs = null;
    }
    return (A) this;
  }
  
  public A withRefs(GitRefInfo... refs) {
    if (this.refs != null) {
        this.refs.clear();
        _visitables.remove("refs");
    }
    if (refs != null) {
      for (GitRefInfo item : refs) {
        this.addToRefs(item);
      }
    }
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
      return (N) GitInfoFluent.this.withAuthor(builder.build());
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
      return (N) GitInfoFluent.this.withCommitter(builder.build());
    }
    
    public N endCommitter() {
      return and();
    }
    
  }
  public class RefsNested<N> extends GitRefInfoFluent<RefsNested<N>> implements Nested<N>{
  
    GitRefInfoBuilder builder;
    int index;
  
    RefsNested(int index,GitRefInfo item) {
      this.index = index;
      this.builder = new GitRefInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) GitInfoFluent.this.setToRefs(index, builder.build());
    }
    
    public N endRef() {
      return and();
    }
    
  }
}