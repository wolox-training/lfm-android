#!/bin/sh
if [ -f app/keystore.gradle ]; then
    echo "/Users/facundomontesanto/git/lfm-android/Bootstrap/app/keystore.gradle file already exists!"
    exit 1
fi
cat > /Users/facundomontesanto/git/lfm-android/Bootstrap/app/keystore.gradle << EOF
ext.release_keystore=file('keystore/debug.keystore')
ext.key_alias='androiddebugkey'
ext.key_password='android'
ext.store_password='android'
EOF
