<?php
$db_name="uudb";
$mysql_username="root";
$mysql_password="";
$server_name="localhost";

$conn=  mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name);

 //check connection_aborted
 /*if($conn){
	 echo " Successful Connection";
 }
 else{
	 echo "Unsuccessful connection";
 }*/
?>