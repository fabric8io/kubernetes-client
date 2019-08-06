package io.fabric8.kubernetes.client.utils.informers.cache;

import io.fabric8.zjsonpatch.internal.guava.Strings;

import java.util.List;

/**
 * Lister interface is used to list cached items from a running informer.
 *
 * @param <T> the object type
 */
public class Lister<T> {
  private String namespace;

  private String indexName;

  private Indexer<T> indexer;

  public Lister(Indexer<T> indexer) {
    this(indexer, null, Cache.NAMESPACE_INDEX);
  }

  public Lister(Indexer<T> indexer, String namespace) {
    this(indexer, namespace, Cache.NAMESPACE_INDEX);
  }

  public Lister(Indexer<T> indexer, String namespace, String indexName) {
    this.indexer = indexer;
    this.namespace = namespace;
    this.indexName = indexName;
  }

  public List<T> list() {
    if (Strings.isNullOrEmpty(namespace)) {
      return indexer.list();
    } else {
      return indexer.byIndex(this.indexName, namespace);
    }
  }

  public T get(String name) {
    String key = name;
    if (!Strings.isNullOrEmpty(namespace)) {
      key = namespace + "/" + name;
    }
    return indexer.getByKey(key);
  }

  public Lister<T> namespace(String namespace) {
    return new Lister<T>(this.indexer, namespace, Cache.NAMESPACE_INDEX);
  }
}
