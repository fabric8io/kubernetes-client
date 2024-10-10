# CRD-Generator CLI

Generate Custom Resource Definitions (CRD) for Kubernetes from Java classes.

## Install

The CRD-Generator CLI is available for download on Sonatype at the link:

```
https://oss.sonatype.org/content/repositories/releases/io/fabric8/crd-generator-cli/<version>/crd-generator-cli-<version>.sh
```

Download the latest version with the following commands:

```bash
export VERSION=$(wget -q -O - https://github.com/fabric8io/kubernetes-client/releases/latest --header "Accept: application/json" | jq -r '.tag_name' | cut -c 2-)
wget -O crd-gen https://oss.sonatype.org/content/repositories/releases/io/fabric8/crd-generator-cli/$VERSION/crd-generator-cli-$VERSION.sh
chmod a+x crd-gen
./crd-gen --version
```

Alternatively, if you already have [jbang](https://www.jbang.dev/) installed, you can run the CLI by using the following command:

```bash
jbang io.fabric8:crd-generator-cli:<version>
```

## Usage

```
crd-gen [-hVv] [--force-index] [--force-scan] [--implicit-preserve-unknown-fields] [--no-parallel]
        [-o=<outputDirectory>] [-cp=<classpathElement>]... [--exclude-package=<package>]...
        [--include-package=<package>]... <source>...

Description:

Fabric8 CRD-Generator
Generate Custom Resource Definitions (CRD) for Kubernetes from Java classes.

Parameters:
      <source>...     A directory or JAR file to scan for Custom Resource classes, or a full qualified Custom Resource
                        class name.

Options:
  -o, --output-dir=<outputDirectory>
                      The output directory where the CRDs are emitted.
                        Default: .
      -cp, --classpath=<classpathElement>
                      Additional classpath element, e.g. a dependency packaged as JAR file or a directory of class
                        files.
      --force-index   Create Jandex index even if the directory or JAR file contains an existing index.
      --force-scan    Scan directories and JAR files even if Custom Resource classes are given.
      --no-parallel   Disable parallel generation of CRDs.
      --implicit-preserve-unknown-fields
                      `x-kubernetes-preserve-unknown-fields: true` will be added on objects which contain an any-setter
                        or any-getter.
      --include-package=<package>
                      Filter Custom Resource classes after scanning by package inclusions.
      --exclude-package=<package>
                      Filter Custom Resource classes after scanning by package exclusions.
  -v                  Verbose mode. Helpful for troubleshooting.
                      Multiple -v options increase the verbosity.
  -h, --help          Show this help message and exit.
  -V, --version       Print version information and exit.

Exit Codes:
   0   Successful execution
   1   Unexpected error
   2   Invalid input
  70   Custom Resource class loading failed
  80   No Custom Resource classes retained after filtering
```

### Examples

**Generate CRDs for Custom Resource classes in a directory:**

```bash
crd-gen target/classes/
```

**Generate CRDs for Custom Resource classes in a JAR file:**

```bash
crd-gen my-jar-with-custom-resources.jar
```

**Generate CRD by using a single class only:**

```bash
crd-gen -cp target/classes/ com.example.MyCustomResource
```

**Generate CRD(s) by using multiple classes:**

```bash
crd-gen -cp target/classes/ com.example.v1.MyCustomResource com.example.v2.MyCustomResource
```
