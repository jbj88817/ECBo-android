<?php
$file_name = 'https://raw.githubusercontent.com/jbj88817/ShoppingBo-android/master/RestServer/data/user_profile.json';
$file = file_get_contents($file_name);

echo $file;