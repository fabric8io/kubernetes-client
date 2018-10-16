#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

echo $SETTINGS_XML | base64 --decode > $HOME/.m2/settings.xml
echo $PUBRING | base64 --decode > $HOME/.gnupg/pubring.gpg
echo $SEC_JENKINS |  base64 --decode > $HOME/.gnupg/sec_jenkins.gpg
echo $SECRING | base64 --decode > $HOME/.gnupg/secring.gpg
echo $TRUSTDB | base64 --decode > $HOME/.gnupg/trustdb.gpg
