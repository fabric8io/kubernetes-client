# Using KubernetesClient with IPv6 based Kubernetes Clusters

Right now Fabric8 Kubernetes Client doesn't work with IPv6 based Kubernetes Clusters due to an issue in OkHttp [square/okhttp#5889](https://github.com/square/okhttp/pull/5889). The issue is solved for OkHttp 4, but Fabric8 Kubernetes Client depends on OkHttp 3.x.

We have decided **not** to upgrade to OkHttp 4.x, because it's based on Kotlin ([square/okhttp#4723](https://github.com/square/okhttp/issues/4723)) and this might be an issue for downstream and dependent projects .

We're still discussing a proper replacement for OkHttp ([#2764](https://github.com/fabric8io/kubernetes-client/issues/2764), [#2632](https://github.com/fabric8io/kubernetes-client/issues/2632)). In the meantime you can switch to use OkHttp 4.x in your project by configuring 3.x exclusions and adding your own direct 4.x OkHttp dependencies ([since it's binary compatible](https://github.com/fabric8io/kubernetes-client/issues/2632#issuecomment-748434878)):
```xml
<properties>
    <fabric8.version>5.5.0</fabric8.version>
    <okhttp.version>4.9.0</okhttp.version>
</properties>

<dependencies>
    <dependency>
        <groupId>io.fabric8</groupId>
        <artifactId>kubernetes-client</artifactId>
        <version>${fabric8.version}</version>
        <exclusions>
            <exclusion>
                <groupId>com.squareup.okhttp3</groupId>
                <artifactId>okhttp</artifactId>
            </exclusion>
            <exclusion>
                <groupId>com.squareup.okhttp3</groupId>
                <artifactId>logging-interceptor</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>${okhttp.version}</version>
    </dependency>
    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>logging-interceptor</artifactId>
        <version>${okhttp.version}</version>
    </dependency>
</dependencies>
```

You can find an example demo project [here](https://github.com/rohankanojia-forks/fabric8-okhttp-ipv6-k8s-cluster-bug-reproducer).
