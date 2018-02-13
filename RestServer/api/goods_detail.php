<?php
$goods_id = $_GET['goods_id'];
$file_name = "https://raw.githubusercontent.com/jbj88817/ShoppingBo-android/master/RestServer/data/goods_detail_data_$goods_id.json";
$file = file_get_contents($file_name);

echo $file;