echo $SETTINGS_XML | base64 --decode > $HOME/.m2/settings.xml
echo $PUBRING | base64 --decode > $HOME/.gnupg/pubring.gpg
echo $SEC_JENKINS |  base64 --decode > $HOME/.gnupg/sec_jenkins.gpg
echo $SECRING | base64 --decode > $HOME/.gnupg/secring.gpg
echo $TRUSTDB | base64 --decode > $HOME/.gnupg/trustdb.gpg
